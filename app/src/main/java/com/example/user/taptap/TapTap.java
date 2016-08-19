package com.example.user.taptap;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Random;

public class TapTap extends AppCompatActivity implements View.OnClickListener {


    private int whiteButtonNumber = 1;
    private CountDownTimer mCountDown = null;
    private int score = 0;
    private int millis;
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tap_tap);

         millis =  getIntent().getExtras().getInt("millis");

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);

        button1.setBackgroundColor(Color.WHITE);
        button2.setBackgroundColor(Color.BLACK);
        button3.setBackgroundColor(Color.BLACK);
        button4.setBackgroundColor(Color.BLACK);
        button5.setBackgroundColor(Color.BLACK);
        button6.setBackgroundColor(Color.BLACK);
        button7.setBackgroundColor(Color.BLACK);
        button8.setBackgroundColor(Color.BLACK);
        button9.setBackgroundColor(Color.BLACK);
        button10.setBackgroundColor(Color.BLACK);
        button11.setBackgroundColor(Color.BLACK);
        button12.setBackgroundColor(Color.BLACK);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                makeThisButtonBlackMakeAnotherButtonWhite(1);
                break;
            case R.id.button2:
                makeThisButtonBlackMakeAnotherButtonWhite(2);
                break;
            case R.id.button3:
                makeThisButtonBlackMakeAnotherButtonWhite(3);
                break;
            case R.id.button4:
                makeThisButtonBlackMakeAnotherButtonWhite(4);
                break;
            case R.id.button5:
                makeThisButtonBlackMakeAnotherButtonWhite(5);
                break;
            case R.id.button6:
                makeThisButtonBlackMakeAnotherButtonWhite(6);
                break;
            case R.id.button7:
                makeThisButtonBlackMakeAnotherButtonWhite(7);
                break;
            case R.id.button8:
                makeThisButtonBlackMakeAnotherButtonWhite(8);
                break;
            case R.id.button9:
                makeThisButtonBlackMakeAnotherButtonWhite(9);
                break;
            case R.id.button10:
                makeThisButtonBlackMakeAnotherButtonWhite(10);
                break;
            case R.id.button11:
                makeThisButtonBlackMakeAnotherButtonWhite(11);
                break;
            case R.id.button12:
                makeThisButtonBlackMakeAnotherButtonWhite(12);
                break;
            default:
                break;
        }
    }

    public void makeThisButtonBlackMakeAnotherButtonWhite(int buttonNumber) {
        makeButtonBlack(buttonNumber);
            if (assertButtonWhite(buttonNumber)) {
             whiteButtonNumber = randomNumber();
             makeButtonWhite(whiteButtonNumber);
             restartmCountDown();
                score++;
            }
            else {
                if(mCountDown != null){mCountDown.cancel();}
                Intent intent = new Intent(TapTap.this, GameOver.class);
                intent.putExtra("score",score);
                intent.putExtra("message","Excuse me sir, but are you blind or something?");
                startActivity(intent);
            }
    }

    public void restartmCountDown(){
        if(mCountDown != null){mCountDown.cancel();}
        mCountDown = new CountDownTimer(millis, 100) {

        @Override
        public void onFinish() {
            Intent intent = new Intent(TapTap.this, GameOver.class);
            intent.putExtra("score",score);
            intent.putExtra("message","My grandma can do better than you!");
            startActivity(intent);        }

        @Override
        public void onTick(long millisUntilFinished) {
        }
    }.start();}

    public Boolean assertButtonWhite(int buttonNumero) {
        return buttonNumero == whiteButtonNumber;
    }

    public void makeButtonWhite(int buttonNumero) {
        Button btn = findButton(buttonNumero);
        btn.setBackgroundColor(Color.WHITE);
    }

    public void makeButtonBlack(int buttonNumero) {
        Button btn = findButton(buttonNumero);
        btn.setBackgroundColor(Color.BLACK);
    }

    public int randomNumber() {
        int randomNumber = new Random().nextInt(9) + 1;
        if (randomNumber == whiteButtonNumber) {
            randomNumber();
        }
        return randomNumber;
    }


    public Button findButton(int buttonNumero) {
        Button btn = null;

        switch (buttonNumero) {
            case 1:
                btn = button1;
                break;
            case 2:
                btn = button2;
                break;
            case 3:
                btn = button3;
                break;
            case 4:
                btn = button4;
                break;
            case 5:
                btn = button5;
                break;
            case 6:
                btn = button6;
                break;
            case 7:
                btn = button7;
                break;
            case 8:
                btn = button8;
                break;
            case 9:
                btn = button9;
                break;
            case 10:
                btn = button10;
                break;
            case 11:
                btn = button11;
                break;
            case 12:
                btn = button12;
                break;
            default:
                break;
        }

        return btn;
    }


}


