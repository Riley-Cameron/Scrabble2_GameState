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
        bag = makeBag();//TODO: implement makeBag method
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

    public ArrayList<Tile> makeBag() {
        return null;
    }

    @NonNull
    @Override
    public String toString() {
        return null;
    }
}
