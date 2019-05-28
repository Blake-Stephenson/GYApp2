package com.example.gyapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.Random;

public class Main3Activity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "Main3Activity";

    private SensorManager sensorManager;
    Sensor accelerometer;


    int[][] board = new int[4][9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Log.d(TAG, " Starts Sensor");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(Main3Activity.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
}

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: "+ sensorEvent.values[0]+ "Y: "+ sensorEvent.values[1]+ "Z: "+ sensorEvent.values[2]);

        board[randInt(0,3)][randInt(0,9)] = 1;
        board[randInt(0,3)][randInt(0,9)] = 0;
        Log.d(TAG,"LMAO");
        printBoard();
        Log.d(TAG,"ROFL");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void printBoard(){
        for(int i = 0;i <4;i++) {
            for(int j = 0;j<9;j++) {
                if(board[i][j]==1) {
                    printCell(i,j,1);
                }else {
                    printCell(i,j,0);
                }
            }

        }
    }

    public void printCell(int i,int j,int c){
        Button button;
        button = findViewById(R.id.button00);
        if(i==0){
            if(j==0) {
                button = findViewById(R.id.button00);
            }
            if(j==1) {
                button = findViewById(R.id.button01);
            }
            if(j==2) {
                button = findViewById(R.id.button02);
            }
            if(j==3) {
                button = findViewById(R.id.button03);
            }
            if(j==4) {
                button = findViewById(R.id.button04);
            }
            if(j==5) {
                button = findViewById(R.id.button05);
            }
            if(j==6) {
                button = findViewById(R.id.button06);
            }
            if(j==7) {
                button = findViewById(R.id.button07);
            }
            if(j==8) {
                button = findViewById(R.id.button08);
            }
            if(j==9) {
                button = findViewById(R.id.button09);
            }
        }else if(i==1){
            if(j==0) {
                button = findViewById(R.id.button10);
            }
            if(j==1) {
                button = findViewById(R.id.button11);
            }
            if(j==2) {
                button = findViewById(R.id.button12);
            }
            if(j==3) {
                button = findViewById(R.id.button13);
            }
            if(j==4) {
                button = findViewById(R.id.button14);
            }
            if(j==5) {
                button = findViewById(R.id.button15);
            }
            if(j==6) {
                button = findViewById(R.id.button16);
            }
            if(j==7) {
                button = findViewById(R.id.button17);
            }
            if(j==8) {
                button = findViewById(R.id.button18);
            }
            if(j==9) {
                button = findViewById(R.id.button19);
            }
        }else if(i==2){
            if(j==0) {
                button = findViewById(R.id.button20);
            }
            if(j==1) {
                button = findViewById(R.id.button21);
            }
            if(j==2) {
                button = findViewById(R.id.button22);
            }
            if(j==3) {
                button = findViewById(R.id.button23);
            }
            if(j==4) {
                button = findViewById(R.id.button24);
            }
            if(j==5) {
                button = findViewById(R.id.button25);
            }
            if(j==6) {
                button = findViewById(R.id.button26);
            }
            if(j==7) {
                button = findViewById(R.id.button27);
            }
            if(j==8) {
                button = findViewById(R.id.button28);
            }
            if(j==9) {
                button = findViewById(R.id.button29);
            }
        }else{
            if(j==0) {
                button = findViewById(R.id.button30);
            }
            if(j==1) {
                button = findViewById(R.id.button31);
            }
            if(j==2) {
                button = findViewById(R.id.button32);
            }
            if(j==3) {
                button = findViewById(R.id.button33);
            }
            if(j==4) {
                button = findViewById(R.id.button34);
            }
            if(j==5) {
                button = findViewById(R.id.button35);
            }
            if(j==6) {
                button = findViewById(R.id.button36);
            }
            if(j==7) {
                button = findViewById(R.id.button37);
            }
            if(j==8) {
                button = findViewById(R.id.button38);
            }
            if(j==9) {
                button = findViewById(R.id.button39);
            }
        }
        if(c==1) {
            button.setBackgroundColor(0xFF005500);
        }else{
            button.setBackgroundColor(0xAA000000);
        }

    }

    public static int randInt(int min, int max) {
        Random r;
        int randomNum = r.nextInt((max - min) + 1) + min;
        return randomNum;

    }
}


