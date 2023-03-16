package com.example.scrabble2_gamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        //GameState gs = new GameState();

        //Sets the onClickListener to the button object
        runTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Changes text box text based on the toString method's result
                gsInfo.getText().clear();
                GameState firstInstance = new GameState();
                //GameState secondInstance = new GameState(firstInstance);
                //gsInfo.setText(gs.toString());
            }
        });
    }
}