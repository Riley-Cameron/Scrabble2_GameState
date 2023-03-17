package com.example.scrabble2_gamestate;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Riley Cameron
 * @author Alexx Blake
 * @author Nick Tabra
 * @author Jacob Arnez
 * @author David Leon
 */
public class GameState {
    //Establishing variables to be used in the Game State.
    private ScrabbleDictionary dictionary;
    public boolean gameRunning;
    public int playerTurn;
    public ArrayList<Tile> player1Tiles;
    public ArrayList<Tile> player2Tiles;
    public boolean isDoubleLetter;
    public boolean isDoubleWord;
    public Tile[][] board;
    public int p1Score;
    public int p2Score;
    public int iqLevel;
    public ArrayList<Tile> bag;
    public char letterInPlay;
    public String hintWord;
    public boolean isPlayed;
    //HashMap for assigning and calculating letter scores
    public HashMap<Character, Integer> letterScore = new HashMap<>();
    public boolean validMove;
    public int playerId;

    public boolean p1HandVisible;

    public boolean p2HandVisible;


    /**
     * GameState is the Constructor that establishes and defines the needed variables & parameters that will be used for the game.
     */
    public GameState(BufferedReader reader) {
        dictionary = new ScrabbleDictionary(reader);
        playerTurn = 1;


        isDoubleLetter = false;
        isDoubleWord = false;

        //init board to null (represents empty tile)
        board = new Tile[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = new Tile(' ');
            }
        }
        p1Score = 0;
        p2Score = 0;
        iqLevel = 0;
        letterInPlay = ' ';
        hintWord = " ";
        p1HandVisible = true;
        p2HandVisible = false;

        //Assigning score values for each letter in the HashMap
        //Letters that are valued at 1
        letterScore.put('A', 1);
        letterScore.put('E', 1);
        letterScore.put('I', 1);
        letterScore.put('L', 1);
        letterScore.put('O', 1);
        letterScore.put('N', 1);
        letterScore.put('R', 1);
        letterScore.put('T', 1);
        letterScore.put('S', 1);
        letterScore.put('U', 1);

        //Letters that are valued at 2
        letterScore.put('D', 2);
        letterScore.put('G', 2);

        //Letters that are valued at 3
        letterScore.put('B', 3);
        letterScore.put('C', 3);
        letterScore.put('M', 3);
        letterScore.put('P', 3);

        //Letters that are valued at 4
        letterScore.put('F', 4);
        letterScore.put('H', 4);
        letterScore.put('V', 4);
        letterScore.put('W', 4);
        letterScore.put('Y', 4);

        //Letters that are valued at 5
        letterScore.put('K', 5);

        //Letters that are valued at 8
        letterScore.put('J', 8);
        letterScore.put('X', 8);

        //Letters that are valued at 10
        letterScore.put('Q', 10);
        letterScore.put('Z', 10);

        bag = new ArrayList<Tile>();
        makeBag(bag);
        validMove = true;
        playerId = 1;

        //initialize player hands:
        player1Tiles = new ArrayList<>();
        player2Tiles = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            player1Tiles.add(drawFromBag());
            player2Tiles.add(drawFromBag());
        }

    }

    /**
     * This method places a tile on the board at the given position
     *
     * @param playerId
     * @param t
     * @param row
     * @param col
     */
    public void placeTile(int playerId, Tile t, int row, int col) {
        if (playerId != playerTurn) {return;}//if its not this player's turn, don't place the tile

        //place the tile *if* the board position is empty
        if (board[row][col].getLetter() == ' ') {
            board[row][col] = t;
        }
        //remove the placed tile from the player's hand
        if (playerId == 0) {
            player1Tiles.remove(t);
        } else {
            player2Tiles.remove(t);
        }
    }



    public GameState(GameState g) {
        dictionary = g.dictionary;
        gameRunning = g.gameRunning;
        playerTurn = g.playerTurn;

        if (g.playerTurn == 0) {
            p1HandVisible = true;
            p2HandVisible = false;
        } else {
            p1HandVisible = false;
            p2HandVisible = true;
        }

       player1Tiles = g.player1Tiles;
        player2Tiles = g.player2Tiles;


        isDoubleLetter = g.isDoubleLetter;
        isDoubleWord = g.isDoubleWord;
        this.board = g.board;
        p1Score = g.p1Score;
        p2Score = g.p2Score;
        iqLevel = g.iqLevel;
        bag = new ArrayList<Tile>();
    for(int i = 0; i < bag.size(); i++ ){
            Tile temp = new Tile(g.bag.get(i));
            bag.add(temp);
        }
        letterInPlay = g.letterInPlay;
        hintWord = g.hintWord;
        validMove = g.validMove;



    }

    /**
     * This method starts and establishes the game.
     *
     * @param pressed Checks if the button has been pressed to start the Method
     * @return Returns either a true or false value
     */
    public boolean startGame(boolean pressed){
        if(iqLevel != 0){
            gameRunning = true;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method checks the turn of the player and checks the word that is played to validate that it works
     *
     * @param playerId Checks which player is playing
     * @return Returns either a true or false response after the method has completed
     */
    public boolean playWord(int playerId) {
        if (playerId == playerTurn) {
            String wordPlayed = "BICYCLE";//test word

            //Checks if the word has been played and assigns value based on play.
            boolean wordChecker = dictionary.checkWord(wordPlayed);
            if (wordChecker) {
                //wait for hashmap
                if (playerId == 0) {
                    Log.d("TEST", "Player 0 has played the word " + wordPlayed);
                    playerTurn = 1;
                    p1Score++;
                } else {
                    Log.d("TEST", "Player 1 has played the word " + wordPlayed);
                    playerTurn = 0;
                    p2Score++;
                }
                return true;
            }
            else {
                return false;
            }
        }
        else{
            Log.d("TAG", "Invalid Move for player " + playerId );
            return false;
        }
    }

    /**
     * Establishes a skip method in order for the player to change over their turn
     *
     * @param playerId the Player that is current in control
     * @return returns whether the operation was true or false
     */
    public boolean skipper(int playerId){
        if(validMove) {
            if (playerId == 0) {
                Log.d("TEST", "Player 0 has skipped their turn");
                playerTurn = 1;
            } else {
                Log.d("TEST", "Player 1 has skipped their turn");
                playerTurn = 0;
            }
            return true;
        }
        else{
            Log.d("TAG", "Invalid Move for player " + playerId );

            return false;
        }
    }

    /**
     * Swaps a tile from the bag to be added
     *
     * @param playerId Checks which player is currently active
     * @param playTile Checks the tile that they are swapping
     * @return returns whether action was true or false
     */
    public boolean swapper(int playerId, Tile playTile){
        if(playerId == playerTurn){
            bag.add(playTile);//put swapped out tile back in the bag

            //remove the swapped out tile from the correct player's hand and give them a new tile
            if (playerId == 0) {
                player1Tiles.remove(playTile);
                player1Tiles.add(drawFromBag());
                Log.d("TEST", "Player 0 has swapped their one of their tiles");
            } else if (playerId == 1) {
                player2Tiles.remove(playTile);
                player2Tiles.add(drawFromBag());
                Log.d("TEST", "Player 1 has swapped their one of their tiles");
            }
            return true;
        }
        else{
            Log.d("TAG", "Invalid Move for player " + playerId );
            return false;
        }
    }

    /**
     * Gives a hint towards the using player when method is active
     *
     * @param playerId checks which player is currently using the method
     * @return Returns whether there is a hint available or no hint available
     */
    public boolean hinter(int playerId){
        if(validMove){
            hintWord = "No hint available.";
            Log.d("TEST", "Player " + playerId + " has asked for a hint");
            return true;
        }
        else{
            hintWord = "No hint available.";
            Log.d("TAG", "Invalid Move for player " + playerId );

            return false;
        }
    }

    /**
     * This method fills the bag array list with the correct amount of each letter Tile
     * @param bag carries the amount of tiles and what tiles that it is valued at
     */
    public void makeBag(ArrayList<Tile> bag) {
        //two arrays make a key for how many of each letter Tile are needed
        Character[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int[] numLetters = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};

        //loop through each letter
        for (int i = 0; i < 26; i++) {
            //loop as many times as the given letter is needed
            for (int j = 0; j < numLetters[i]; j++) {
                Tile t = new Tile(letters[i]);//create a new tile and pass in the letter
                Integer score  = letterScore.get(letters[i]);//set the tile score based on the hashmap
                t.setScore(score);
                bag.add(t);//add it to the bag
            }
        }
    }

    /**
     * This method removes a Tile from the bag and returns that tile
     * @return random tile
     */
    public Tile drawFromBag() {
        Collections.shuffle(bag);
        return bag.remove(0);
    }

    /**
     * This method describes the state of the game as a string.
     * Prints the values of all the variables in the game state.
     */

    @NonNull
    @Override
    public String toString() {
        //print player 1 tiles
        String test = "";
        test = test.concat("Player1 tiles: ");
        for (int i = 0; i < player1Tiles.size(); i++) {
            test = test.concat("[" + player1Tiles.get(i).getLetter() + "]");
        }

        //print player 2 tiles
        test = test.concat("\nPlayer2 tiles: ");
        for (int i = 0; i < player2Tiles.size(); i++) {
            test = test.concat("[" + player2Tiles.get(i).getLetter() + "]");
        }

        //print the board:
        test = test.concat("\nBoard: \n");

        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++) {
                test = test.concat("[" + board[i][j].getLetter() + "]");
            }
            test = test.concat("\n");
        }
        //print letters in bag
        test = test.concat("\n Letters in the Bag: ");
        for (int i = 0; i< bag.size(); i++) {
            test = test.concat(bag.get(i).getLetter() + " ");
        }
        //print the player's turn
       test = test.concat("\n Player turn: ");
        String playerTurnString = String.valueOf(playerTurn);
        test = test.concat(playerTurnString);

        //print the game running state (boolean value)
        test = test.concat("\n Game running: ");
        String gameStateString = String.valueOf(gameRunning);
        test = test.concat(gameStateString);

        //print double letters (boolean value)
        test = test.concat("\n Double letter: ");
        String isDoubleLetterString = String.valueOf(isDoubleLetter);
        test = test.concat(isDoubleLetterString);

        //print double words (boolean value)
        test = test.concat("\n Double word: ");
        String isDoubleWordString = String.valueOf(isDoubleWord);
        test = test.concat(isDoubleWordString);

        //print player 1 score
        test = test.concat("\n Player 1 score: ");
        String player1ScoreString = String.valueOf(p1Score);
        test = test.concat(player1ScoreString);

        //print player 2 score
        test = test.concat("\n Player 2 score: ");
        String player2ScoreString = String.valueOf(p2Score);
        test = test.concat(player2ScoreString);

        //print Iq Level
        test = test.concat("\n Iq Level: ");
        String iqLevelString = String.valueOf(iqLevel);
        test = test.concat(iqLevelString);

        //print the letter in play
        test = test.concat("\n Letter in play: ");
        String letterInPlayString = String.valueOf(letterInPlay);
        test = test.concat(letterInPlayString);

        //print the hint word
        test = test.concat("\n HintWord: ");
        test = test.concat(hintWord);

        //print move played (boolean value)
        test = test.concat("\n Move played: ");
        String isPlayedString = String.valueOf(isPlayed);
        test = test.concat(isPlayedString);

        //print valid move (boolean value)
        test = test.concat("\n Valid move: ");
        String validMoveString = String.valueOf(validMove);
        test = test.concat(validMoveString);

        //print the player id
        test = test.concat("\n Player Id: ");
        String playerIdString = String.valueOf(playerId);
        test = test.concat(playerIdString);

        //print player 1 hand visibility (boolean value)
        test = test.concat("\n Player 1 hand visible: ");
        String player1HandVisibleString = String.valueOf(p1HandVisible);
        test = test.concat(player1HandVisibleString);

        //print player 2 hand visibility (boolean value)
        test = test.concat("\n Player 2 hand visible: ");
        String player2HandVisibleString = String.valueOf(p2HandVisible);
        test = test.concat(player2HandVisibleString);

        Log.d("STRING", test);
        return test;
    }
}
