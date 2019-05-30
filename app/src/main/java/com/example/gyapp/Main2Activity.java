package com.example.gyapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;



public class Main2Activity extends AppCompatActivity {

int score;
   // MediaPlayer mdx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        VideoView videoView;
        videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.thanos_vid);
        videoView.start();
        play_music(true);
        Bundle extras = getIntent().getExtras();
        score= extras.getInt("key");
        Button button = findViewById(R.id.button2);
        String Score = String.valueOf(score);
        button.setText("Score: "+Score);
        //mdx = MediaPlayer.create(MainActivity.this,R.raw.pump);
    }


    public void onButtonTapEnd(View view){
        play_music(false);
        finish();
    }

    public void play_music(boolean b) {
        final MediaPlayer pump_music = MediaPlayer.create(this, R.raw.pump);
        if (b == true) {
            pump_music.start();
        } else {
            pump_music.stop();
        }
    }
}
