package com.example.a3by3connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        String winner = getIntent().getStringExtra("win");
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView2);
        winnerTextView.setText(winner + "\uD83D\uDE03");


        winnerTextView.setVisibility(View.VISIBLE);
        Button playAgainButton = (Button) findViewById(R.id.playAgainButtonL);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity( new Intent(Win.this,MainActivity.class));
            }
        });
    }

    }
