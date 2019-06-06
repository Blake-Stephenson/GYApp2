package com.example.gyapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 *This is the title/ start screen
 */
public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "1";
    NotificationCompat.Builder builder;

    /**
     * initializes the activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * When the button in the bottom left is pressed a toast is displayed, a notification is given, and a sound is played
     *
     * @param v
     */
    public void onButtonTapNotification(View v){
        Toast myToast = Toast.makeText(getApplicationContext(), "Jeeez", Toast.LENGTH_LONG);
        myToast.show();

        final MediaPlayer death_sound = MediaPlayer.create(this, R.raw.death_sound);

        death_sound.start();

        createNotificationChannel();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);


        // notificationId is a unique int for each notification that you must define
        int notificationId = 1;
        buildNotification("Hey!", "Makes sure to keep playing!!");
        notificationManager.notify(notificationId, builder.build());
    }

    /**
     * When the start button is pressed move to next activity
     *
     * @param view
     */
    public void onButtonTapStart(View view){
        startActivity(new Intent(MainActivity.this , Main3Activity.class));
    }

    /**
     * Builds a notification from a given head and body
     *
     * @param head
     * @param sub
     */
    public void buildNotification(String head, String sub) {
        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(head)
                .setContentText(sub)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }

    /**
     * Builds the channel for the notification
     */
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
