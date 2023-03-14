package com.example.scrabble2_gamestate;

import androidx.annotation.NonNull;

/**
 * @author Riley Cameron
 * @author Alexx Blake
 * @author Nick Tabra
 * @author Jacob Arnez
 * @author David Leon
 */
public class GameState {
    private String test;
    public boolean isSwap;
    public int playerTurn;
    public String[] player1Tiles;
    public String[] player2Tiles;
    public boolean isHint;
    public boolean isSkip;
    public boolean isDoubleLetter;
    public boolean isDoubleWord;
    public char[][] board;
    public int p1Score;
    public int p2Score;
    public int iqLevel;
    public String[] bag;
    public char letterInPlay;
    public String hintWord;
    public boolean isPlayed;

    public GameState(String[] p1TilesInit, String[] p2TilesInit, char[][] board, String[] b) {
        isSwap = false;
        playerTurn = 1;
        player1Tiles = p1TilesInit;
        player2Tiles = p2TilesInit;
        isHint = false;
        isSkip = false;
        isDoubleLetter = false;
        isDoubleWord = false;
        this.board = board;
        p1Score = 0;
        p2Score = 0;
        iqLevel = 0;
        bag = b;
        letterInPlay = ' ';
        hintWord = " ";
        isPlayed = false;
    }

    @NonNull
    @Override
    public String toString() {
        return test;
    }
}
