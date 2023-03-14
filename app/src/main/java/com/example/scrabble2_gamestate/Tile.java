package com.example.scrabble2_gamestate;


/**
 * class Tile
 *
 * Is the tile class used to represent the letter tiles in the game
 */

public class Tile {


    /**
     * Private Variable for tile class include:
     * letter - to represent the letter of the tile
     * onBoard - Boolean variable to check if the tile is onBoard in a valid position when the player end their turn
     * score - represents the score of the tiles letter
     */
    public char getLetter() {
        return letter;
    }
    private char letter;

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    private boolean onBoard;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;


    public Tile(char l){

        letter = l;
    }
}
