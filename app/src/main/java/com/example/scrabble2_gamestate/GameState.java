package com.example.scrabble2_gamestate;

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
    private String test;
    private ScrabbleDictionary dictionary;
    public boolean gameRunning;
    public boolean isSwap;
    public int playerTurn;
    public ArrayList<Tile> player1Tiles;
    public ArrayList<Tile> player2Tiles;
    public boolean isHint;
    public boolean isSkip;
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
        isSwap = false;
        playerTurn = 1;

        isHint = false;
        isSkip = false;
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

        player1Tiles = null;//TODO: create player starting hands from the bag
        player2Tiles = null;


        isDoubleLetter = g.isDoubleLetter;
        isDoubleWord = g.isDoubleWord;
        this.board = g.board;
        p1Score = g.p1Score;
        p2Score = g.p2Score;
        iqLevel = g.iqLevel;
        bag = g.bag;
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
                    playerTurn = 1;
                    p1Score++;
                } else {
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
                playerTurn = 1;
            } else {
                playerTurn = 0;
            }
            return true;
        }
        else{
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
            } else if (playerId == 1) {
                player2Tiles.remove(playTile);
                player2Tiles.add(drawFromBag());
            }
            return true;
        }
        else{
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
            return true;
        }
        else{
            hintWord = "No hint available.";
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

    @NonNull
    @Override
    public String toString() {
        //Temporary toString to print out player tiles, feel free to change or get rid of in a merge - Riley
        String test = "";
        test = test.concat("Player1 Hand: ");
        for (int i = 0; i < player1Tiles.size(); i++) {
            test = test.concat("" + player1Tiles.get(i).getLetter());
        }

        test = test.concat("\nPlayer2 Hand: ");
        for (int i = 0; i < player2Tiles.size(); i++) {
            test = test.concat("" + player2Tiles.get(i).getLetter());
        }

        return test;
    }
}
