package com.example.scrabble2_gamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Riley Cameron
 * @author Alexx Blake
 * @author Nick Tabra
 * @author Jacob Arnez
 * @author David Leon
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button runTest = findViewById(R.id.run_test);
        EditText gsInfo = findViewById(R.id.game_state_info);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("dictionary.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameState gs = new GameState(reader);

        //Sets the onClickListener to the button object
        runTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Changes text box text based on the toString method's result
                gsInfo.setText(gs.toString());
                gs.placeTile(1,gs.player2Tiles.get(3), 8, 8);
                gs.placeTile(1,gs.player2Tiles.get(3), 7, 8);
                gs.playWord(1);
                gs.placeTile(0,gs.player2Tiles.get(1), 6, 8);
            }
        });
    }
}