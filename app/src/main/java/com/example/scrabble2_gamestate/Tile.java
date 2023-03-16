package com.example.scrabble2_gamestate;


/**
 * class Tile
 *
 * Is the tile class used to represent the letter tiles in the game
 */

public class Tile {


    /**
     * Private Variable for tile class include:
     * letter - to represent the letter of the tile using the Character Object
     * onBoard - Boolean variable to check if the tile is onBoard in a valid position when the player end their turn
     * score - represents the score of the tiles letter using the Integer Object
     */

    //Retrieves letter when called
    public Character getLetter() {
        return letter;
    }
    //Establishes variable for letter
    private Character letter;
    //Checks value of the onBoard variable
    public boolean isOnBoard() {
        return onBoard;
    }
    //Sets the onBoard variable to the object's onBoard
    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }
    //Establishes the onBoard variable
    private boolean onBoard;
    //Gets the current score
    public Integer getScore() {
        return score;
    }
    //Sets the current score when updated
    public void setScore(Integer score) {
        this.score = score;
    }
    //Establishes the Score Variable
    private Integer score;
    //Configures the tile based on the character
    public Tile(Character l){
        letter = l;
    }
}
