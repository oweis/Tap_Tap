package com.example.user.taptap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonEasy,buttonNormal,buttonHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEasy = (Button) findViewById(R.id.buttonEasy);
        buttonNormal = (Button) findViewById(R.id.buttonNormal);
        buttonHard = (Button) findViewById(R.id.buttonHard);

        buttonEasy.setOnClickListener(this);
        buttonNormal.setOnClickListener(this);
        buttonHard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEasy :
                createTapTapAndPassLevel(3000);
                break;
            case R.id.buttonNormal :
                createTapTapAndPassLevel(2000);
                break;
            case R.id.buttonHard :
                createTapTapAndPassLevel(1000);
                break;
        }

    }

    public void createTapTapAndPassLevel(int millis){
        Intent intent = new Intent(MainActivity.this, TapTap.class);
        intent.putExtra("millis",millis);
        startActivity(intent);
    }
}
