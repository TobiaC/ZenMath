package com.example.tobia.sumgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.menu);

        mediaPlayer.start();

        Button rules = (Button) findViewById(R.id.RulesButton);
        rules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ActivityRules.class);
                startActivityForResult(myIntent, 0);
                mediaPlayer.pause();
            }
        });

        Button play = (Button) findViewById(R.id.PlayButton);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), PlayActivity.class);
                startActivityForResult(myIntent, 0);
                mediaPlayer.stop();
            }
        });

        Button credits = findViewById(R.id.CreditsButton);
        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), CreditsActivity.class);
                startActivityForResult(myIntent, 0);
                mediaPlayer.pause();
            }
        });

    }

}
