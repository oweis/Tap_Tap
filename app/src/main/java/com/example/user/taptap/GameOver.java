package com.example.user.taptap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        int score =  getIntent().getExtras().getInt("score");
        String message = getIntent().getExtras().getString("message");

        TextView textViewScore = (TextView) findViewById(R.id.textViewScore);
        TextView textViewMessage = (TextView) findViewById(R.id.textViewMessage);

        textViewScore.setText(Integer.toString(score));
        textViewMessage.setText(message);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameOver.this,TapTap.class));
            }
        });
    }
}
