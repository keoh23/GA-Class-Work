package com.example.owen.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView space1, space2, space3, space4, space5, space6, space7, space8, space9;
    TextView[] sArray;
    boolean ttTurn = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        space1 = (TextView) findViewById(R.id.space1);
        space2 = (TextView) findViewById(R.id.space2);
        space3 = (TextView) findViewById(R.id.space3);
        space4 = (TextView) findViewById(R.id.space4);
        space5 = (TextView) findViewById(R.id.space5);
        space6 = (TextView) findViewById(R.id.space6);
        space7 = (TextView) findViewById(R.id.space7);
        space8 = (TextView) findViewById(R.id.space8);
        space9 = (TextView) findViewById(R.id.space9);

        sArray = new TextView[]{space1, space2, space3, space4, space5, space6, space7, space8, space9};
        for (TextView move : sArray) {
            move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView move = (TextView) v;
                    moveMade(move);
                }
            });
        }
    }

    public void moveMade(TextView move) {
        if (ttTurn) {
            move.setText("O");
        } else {
            move.setText("X");
        }
        move.setTextSize(75);
        move.setTextColor(Color.WHITE);
        move.setClickable(false);
        ttTurn = !ttTurn;
        winnerWinner();
    }

    public void toasty(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private void winnerWinner() {
        boolean chickenDinner = false;

        if (space1.equals("O"))
            if (space1.equals("O") && space2.equals("O") && space3.equals("O"))
            chickenDinner = true;
            if (space1.equals("O") && space5.equals("O") && space9.equals("O"))
            chickenDinner = true;
            if (space1.equals("O") && space4.equals("O") && space7.equals("O"))
            chickenDinner = true;

        if (space2.equals("O"))
            if (space2.equals("O") && space5.equals("O") && space8.equals("O"))
                chickenDinner = true;

        if (space3.equals("O"))
            if (space3.equals("O") && space5.equals("O") && space7.equals("O"))
                chickenDinner = true;
            if (space3.equals("O") && space6.equals("O") && space9.equals("O"))
                chickenDinner = true;

        else if (space1.equals("X"))
            if (space1.equals("X") && space2.equals("X") && space3.equals("X"))
                chickenDinner = false;
            if (space1.equals("X") && space5.equals("X") && space9.equals("X"))
                chickenDinner = false ;
            if (space1.equals("X") && space4.equals("X") && space7.equals("X"))
                chickenDinner = false;

        else if (space2.equals("X"))
            if (space2.equals("X") && space5.equals("X") && space8.equals("X"))
                chickenDinner = false;

        else if (space3.equals("X"))
            if (space3.equals("X") && space5.equals("X") && space7.equals("X"))
                chickenDinner = false;
            if (space3.equals("X") && space6.equals("X") && space9.equals("X"))
                chickenDinner = false;

        if (chickenDinner = true) {
                toasty("Player 0 Wins!");
            } else {
                toasty("Player X Wins!");
            }

        }

}