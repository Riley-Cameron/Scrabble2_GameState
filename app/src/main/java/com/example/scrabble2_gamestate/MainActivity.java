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
 *
 * @Version 3/16/2023
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

        //Sets the onClickListener to the button object
        runTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(getAssets().open("dictionary.txt")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Clear any previous text before next test run
                gsInfo.getText().clear();
                GameState firstInstance = new GameState(reader);
                GameState secondInstance = new GameState(firstInstance);
                //Changes text box text based on the toString method's result

                //Calling all methods
                //firstInstance.placeTile(1,firstInstance.player2Tiles.get(3), 8, 8);
                firstInstance.placeTile(1,firstInstance.player2Tiles.get(3), 7, 8);
                firstInstance.playWord(1);
                //firstInstance.placeTile(0,firstInstance.player1Tiles.get(1), 6, 8);
                firstInstance.drawFromBag();
                firstInstance.hinter(1);
                firstInstance.swapper(0, firstInstance.player1Tiles.get(1));
                firstInstance.skipper(1);
                gsInfo.setText(firstInstance.toString());

                GameState thirdInstance = new GameState(reader);
                GameState fourthInstance = new GameState(thirdInstance);

                secondInstance.toString();
                fourthInstance.toString();


            }
        });
    }
}