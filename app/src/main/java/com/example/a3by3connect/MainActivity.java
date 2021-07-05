package com.example.a3by3connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String GREEN = "green";
    private final String PURPLE = "purple";
    boolean gameActive = true;
    int activePlayer = 0;
    int[] gamePosition = {9, 9, 9, 9, 9, 9, 9, 9, 9};
    int[][] winningLocations = {{0, 1, 2}, {3, 4, 5},
            {6, 7, 8}, {0, 3, 6}, {1, 4, 7},
            {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    //8*possible_states
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void execution(View view) {
        ImageView tappedView = (ImageView) view;
        //
        int tappedLocation = Integer.parseInt(view.getTag().toString());
        if (gamePosition[tappedLocation] == 9 && gameActive) {
            gamePosition[tappedLocation] = activePlayer;
            tappedView.setTranslationY(-3000f);
            if (activePlayer == 0) {
                tappedView.setImageResource(R.drawable.green);
                activePlayer = 1;
            } else if (activePlayer == 1) {
                tappedView.setImageResource(R.drawable.purple);
                activePlayer = 0;
            }
            tappedView.animate().translationYBy(3000f).setDuration(500);
        }
        for (int[] winningPosition : winningLocations) {
            if (!(gamePosition[winningPosition[0]] != gamePosition[winningPosition[1]])
                    && !(gamePosition[winningPosition[1]] != gamePosition[winningPosition[2]])
                    && !(gamePosition[winningPosition[0]] == 9)) {
                gameActive = false;

                String winner = PURPLE;

                if (gamePosition[winningPosition[0]] == 0) {
                    winner = GREEN;
                }
                TextView winnerMessage = (TextView) findViewById(R.id.winnerTextView1);
                winnerMessage.setText(winner + " has won!");
                startActivity(new Intent(getApplicationContext(), Win.class).putExtra("win", winnerMessage.getText().toString()));
                finish();
            } else {
                boolean gameIsOver = true;
                for (int counterState : gamePosition) {
                    if (counterState == 9) gameIsOver = false;
                }
                if (gameIsOver) {
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerTextView1);
                    winnerMessage.setText("It's a draw");
                    startActivity(new Intent(getApplicationContext(), Win.class).putExtra("win", winnerMessage.getText().toString()));
                    finish();
                }
            }
        }
    }
}