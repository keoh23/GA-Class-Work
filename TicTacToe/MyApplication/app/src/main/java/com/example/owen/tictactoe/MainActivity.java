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
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void winnerWinner() {
        boolean chickenDinner = false;
        boolean chickenDinner2 = false;


        if (space1.getText().toString().equals("O")) {
            if (space1.getText().toString().equals("O") && space2.getText().toString().equals("O") && space3.getText().toString().equals("O"))
                chickenDinner = true;
            if (space1.getText().toString().equals("O") && space5.getText().toString().equals("O") && space9.getText().toString().equals("O"))
                chickenDinner = true;
            if (space1.getText().toString().equals("O") && space4.getText().toString().equals("O") && space7.getText().toString().equals("O"))
                chickenDinner = true;
        }

        if (space2.getText().toString().equals("O")) {
            if (space2.getText().toString().equals("O") && space5.getText().toString().equals("O") && space8.getText().toString().equals("O"))
                chickenDinner = true;
        }

        if (space3.getText().toString().equals("O")) {
            if (space3.getText().toString().equals("O") && space5.getText().toString().equals("O") && space7.getText().toString().equals("O"))
                chickenDinner = true;
            if (space3.getText().toString().equals("O") && space6.getText().toString().equals("O") && space9.getText().toString().equals("O"))
                chickenDinner = true;
        }

        else if (space1.getText().toString().equals("X")) {
            if (space1.getText().toString().equals("X") && space2.getText().toString().equals("X") && space3.getText().toString().equals("X"))
                chickenDinner2 = true;
            if (space1.getText().toString().equals("X") && space5.getText().toString().equals("X") && space9.getText().toString().equals("X"))
                chickenDinner2 = true;
            if (space1.getText().toString().equals("X") && space4.getText().toString().equals("X") && space7.getText().toString().equals("X"))
                chickenDinner2 = true;
        }

        else if (space2.getText().toString().equals("X")) {
            if (space2.getText().toString().equals("X") && space5.getText().toString().equals("X") && space8.getText().toString().equals("X"))
                chickenDinner2 = true;
        }

        else if (space3.getText().toString().equals("X")) {
            if (space3.getText().toString().equals("X") && space5.getText().toString().equals("X") && space7.getText().toString().equals("X"))
                chickenDinner2 = true;
            if (space3.getText().toString().equals("X") && space6.getText().toString().equals("X") && space9.getText().toString().equals("X"))
                chickenDinner2 = true;
        }

        if (chickenDinner ) {               //== true)
            toasty("O is Winner!");
        } else if (chickenDinner2) {
            toasty("X is Winner!");
        }
    }

}