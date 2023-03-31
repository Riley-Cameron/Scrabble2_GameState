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
                String toPrint = "";
                GameState firstInstance = new GameState(reader);
                GameState secondInstance = new GameState(firstInstance);
                //Changes text box text based on the toString method's result

                //Calling all methods
                //firstInstance.placeTile(1,firstInstance.player2Tiles.get(3), 8, 8);
                firstInstance.player2Tiles.clear();
                firstInstance.player2Tiles.add(0, new Tile ('D'));
                firstInstance.player2Tiles.add(1, new Tile ('O'));
                firstInstance.player2Tiles.add(2, new Tile ('G'));
                firstInstance.player2Tiles.add(3, new Tile ('S'));
                firstInstance.player2Tiles.add(4, new Tile ('C'));
                firstInstance.player2Tiles.add(5, new Tile ('A'));
                firstInstance.player2Tiles.add(6, new Tile ('N'));

                firstInstance.player1Tiles.clear();
                firstInstance.player1Tiles.add(0, new Tile ('O'));
                firstInstance.player1Tiles.add(1, new Tile ('L'));
                firstInstance.player1Tiles.add(2, new Tile ('F'));
                firstInstance.player1Tiles.add(3, new Tile ('E'));
                firstInstance.player1Tiles.add(4, new Tile ('R'));
                firstInstance.player1Tiles.add(5, new Tile ('K'));
                firstInstance.player1Tiles.add(6, new Tile ('I'));

                firstInstance.placeTile(1,firstInstance.player2Tiles.get(0), 0, 6);
                firstInstance.placeTile(1,firstInstance.player2Tiles.get(0), 1, 6);
                firstInstance.placeTile(1,firstInstance.player2Tiles.get(0), 2, 6);
                firstInstance.placeTile(1,firstInstance.player2Tiles.get(0), 3, 6);
                firstInstance.playWord(1);
                toPrint = toPrint.concat(firstInstance.toString());
                gsInfo.setText(toPrint);

                firstInstance.hinter(1);
                firstInstance.skipper(1);
                firstInstance.placeTile(0, firstInstance.player1Tiles.get(0), 2, 7);
                firstInstance.placeTile(0, firstInstance.player1Tiles.get(0), 2, 8);
                firstInstance.placeTile(0, firstInstance.player1Tiles.get(0), 2, 9);
                firstInstance.placeTile(0, firstInstance.player1Tiles.get(0), 2, 10);
                firstInstance.placeTile(0, firstInstance.player1Tiles.get(0), 2, 11);

                firstInstance.playWord(0);
                toPrint = toPrint.concat("\n\n" + firstInstance.toString() + "\n");
                gsInfo.setText(toPrint);

                firstInstance.skipper(1);
                firstInstance.placeTile(0, firstInstance.player1Tiles.get(0), 3, 7);
                firstInstance.placeTile(0, firstInstance.player1Tiles.get(0), 3, 8);
                firstInstance.playWord(0);
                toPrint = toPrint.concat("\n\n" + firstInstance.toString() + "\n");
                gsInfo.setText(toPrint);


                GameState thirdInstance = new GameState(reader);
                GameState fourthInstance = new GameState(thirdInstance);

                secondInstance.toString();
                fourthInstance.toString();


            }
        });
    }
}