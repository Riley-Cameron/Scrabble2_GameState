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

    public GameState(String test) {
        this.test = test;
    }

    @NonNull
    @Override
    public String toString() {
        return test;
    }
}
