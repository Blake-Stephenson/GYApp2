package com.example.gyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;



public class Main2Activity extends AppCompatActivity {


   // MediaPlayer mdx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        VideoView videoView;
        videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.think);
        videoView.start();
        play_music(true);

        Button button = findViewById(R.id.button2);
        button.setText("Play again");
    }
    public void onButtonTapEnd(View view){
        play_music(false);
        startActivity(new Intent(Main2Activity.this , MainActivity.class));
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