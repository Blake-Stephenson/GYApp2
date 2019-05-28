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

public class Main3Activity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "Main3Activity";

    private SensorManager sensorManager;
    Sensor accelerometer;

    int[][] board = new int[3][9];

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

        printBoard();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void printBoard(){
        for(int i = 0;i <=3;i++) {
            for(int j = 0;j<=9;j++){
                if(board[i][j]==1) {
                    String cell_button = "button"+i+j;
                    int btest = -1000055;
                   /* Button button = findViewById(R.id.btest);
                    button.setBackgroundColor(0xFF005500);*/
                }
            }

        }
    }
}


