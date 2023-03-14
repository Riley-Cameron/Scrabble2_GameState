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
    private boolean isSwap;
    private int playerTurn;
    private String[] player1Tiles;
    private String[] player2Tiles;
    private boolean isHint;
    private boolean isSkip;
    private boolean isDoubleLetter;
    private boolean isDoubleWord;
    private char[][] board;
    private int p1Score;
    private int p2Score;
    private boolean isTitleScreen;
    private int iqLevel;
    private String[] bag;
    private char letterInPlay;
    private String hintWord;
    private boolean isPlayed

    public GameState(String[] p1TilesInit, String[] p2TilesInit, char[][] b, String[] b) {
        isSwap = false;
        playerTurn = 1;
        player1Tiles = p1TilesInit;
        player2Tiles = p2TilesInit;
        isHint = false;
        isSkip = false;
        isDoubleLetter = false;
        isDoubleWord = false;
        board = b;
        p1Score = 0;
        p2Score = 0;
        isTitleScreen = false;
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
