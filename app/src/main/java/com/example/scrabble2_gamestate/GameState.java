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
    //HashMap for assigning and calculating letter scores
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

        //Assigning score values for each letter in the HashMap
        letterScore.put('A', 1);
        letterScore.put('E', 1);
        letterScore.put('I', 1);
        letterScore.put('O', 1);
        letterScore.put('N', 1);
        letterScore.put('R', 1);
        letterScore.put('T', 1);
        letterScore.put('S', 1);
        letterScore.put('U', 1);

        letterScore.put('D', 2);
        letterScore.put('G', 2);

        letterScore.put('B', 3);
        letterScore.put('C', 3);
        letterScore.put('M', 3);
        letterScore.put('P', 3);

        letterScore.put('F', 4);
        letterScore.put('H', 4);
        letterScore.put('V', 4);
        letterScore.put('W', 4);
        letterScore.put('Y', 4);

        letterScore.put('K', 5);

        letterScore.put('J', 8);
        letterScore.put('X', 8);

        letterScore.put('Q', 10);
        letterScore.put('Z', 10);






    }

    //A-9, B-2, C-2, D-4, E-12, F-2, G-3, H-2, I-9, J-1, K-1, L-4, M-2, N-6, O-8, P-2, Q-1, R-6, S-4, T-6, U-4, V-2, W-2, X-1, Y-2, Z-1
    public void makeBag(ArrayList<Tile> bag) {

    }

    @NonNull
    @Override
    public String toString() {
        return null;
    }
}
