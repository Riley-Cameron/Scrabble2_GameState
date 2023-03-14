package com.example.scrabble2_gamestate;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

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

    public HashMap<Character, Integer> letterScore = new HashMap<>();

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
        makeBag(bag);//TODO: implement makeBag method
        letterInPlay = ' ';
        hintWord = " ";
        isPlayed = false;

    }

    //A-9, B-2, C-2, D-4, E-12, F-2, G-3, H-2, I-9, J-1, K-1, L-4, M-2, N-6, O-8, P-2, Q-1, R-6, S-4, T-6, U-4, V-2, W-2, X-1, Y-2, Z-1
    public void makeBag(ArrayList<Tile> bag) {
        char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int[] numLetters = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};

        for (int i = 0;i<26;i++) {
            for (int j = 0;j<numLetters[i];j++) {
                Tile t = new Tile(letters[i]);
                t.setScore(letterScore.get(letters[i]));
                bag.add(t);
            }
        }
    }

    @NonNull
    @Override
    public String toString() {
        return null;
    }
}
