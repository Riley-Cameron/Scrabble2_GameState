package com.example.scrabble2_gamestate;

import androidx.annotation.NonNull;

import java.util.ArrayList;

/**
 * @author Riley Cameron
 * @author Alexx Blake
 * @author Nick Tabra
 * @author Jacob Arnez
 * @author David Leon
 */
public class GameState {
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
    public char[][] board;
    public int p1Score;
    public int p2Score;
    public int iqLevel;
    public ArrayList<Tile> bag;
    public char letterInPlay;
    public String hintWord;
    public boolean isPlayed;
    public boolean validMove;
    public int playerId;




    public GameState() {
        dictionary = new ScrabbleDictionary();
        isSwap = false;
        playerTurn = 1;
        player1Tiles = null;//TODO: create player starting hands from the bag
        player2Tiles = null;
        isHint = false;
        isSkip = false;
        isDoubleLetter = false;
        isDoubleWord = false;
        this.board = board;
        p1Score = 0;
        p2Score = 0;
        iqLevel = 0;
        bag = makeBag();//TODO: implement makeBag method
        letterInPlay = ' ';
        hintWord = " ";
        isPlayed = false;
        validMove = true;
        playerId = 1;
    }


    public boolean swapPressed(int playerId, char letterPlay){
    if(validMove) {

     return true;
    }


else{
    return false;
    }
    }

    public boolean startGame(boolean pressed){
        if(iqLevel != 0){
            gameRunning = true;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean playWord(int playerId, String wordPlayed) {
        if (validMove) {

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

    public boolean skipper(int playId){
        if(validMove) {
            if (playId == 0) {
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

    public boolean swapper(int playId, char playTile){
        if(validMove){

            return true;
        }
        else{
            return false;
        }
    }

    public boolean hinter(int playId){
        if(validMove){
        hintWord = "No hint available.";
            return true;
        }
        else{
            hintWord = "No hint available.";
            return false;
        }
    }


    public ArrayList<Tile> makeBag() {
        return null;
    }

    @NonNull
    @Override
    public String toString() {
        return null;
    }
}
