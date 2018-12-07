package com.example.tobia.sumgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final ImageView image = findViewById(R.id.startuplogo);

        final Animation animatioStart = AnimationUtils.loadAnimation(this, R.anim.fadein);
        final Button startButton = findViewById(R.id.startButton);
        final TextView pressToStart = findViewById(R.id.pressToStart);


        CountDownTimer my = new CountDownTimer(3500, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                pressToStart.setText(R.string.presstostart);
                startButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                        startActivityForResult(myIntent, 0);
                    }
                });

            }

        };

        my.start();

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.intro);
        mediaPlayer.start();
        image.startAnimation(animatioStart);

    }
}
