package com.team2.mtglifetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class PlayerSelectActivity extends AppCompatActivity {
    int startingLife = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this removes the title bar from the activity
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // hide's the title bar
        getSupportActionBar().hide();

        // enable full screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // get starting life
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            startingLife = extras.getInt("startingLife");
        }

        setContentView(R.layout.activity_player_select);

        // get buttons
        ImageButton select2PBtn = findViewById(R.id.twoPlayerBtn);
        ImageButton select3PBtn = findViewById(R.id.threePlayerBtn);
        ImageButton select4PBtn = findViewById(R.id.fourPlayerBtn);

        // TODO: get life start selection from previous activity

        select2PBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on click, send user to two player layout selection screen and store choice
                // v.getContext() tip comes from:
                // https://stackoverflow.com/questions/20241857/android-intent-cannot-resolve-constructor
                Intent layoutSelectIntent = new Intent(v.getContext(), LayoutSelectActivity.class );
                layoutSelectIntent.putExtra("playerCount", 2);
                layoutSelectIntent.putExtra("startingLife", startingLife);
                startActivity(layoutSelectIntent);

            }
        });

        select3PBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on click, send user to two player layout selection screen and store choice
                // v.getContext() tip comes from:
                // https://stackoverflow.com/questions/20241857/android-intent-cannot-resolve-constructor
                Intent layoutSelectIntent = new Intent(v.getContext(), GameActivity.class );
                layoutSelectIntent.putExtra("playerCount", 3);
                layoutSelectIntent.putExtra("startingLife", startingLife);
                startActivity(layoutSelectIntent);

            }
        });

        select4PBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on click, send user to two player layout selection screen and store choice
                Intent layoutSelectIntent = new Intent(v.getContext(), LayoutSelectActivity.class );
                layoutSelectIntent.putExtra("playerCount", 4);
                layoutSelectIntent.putExtra("startingLife", startingLife);
                startActivity(layoutSelectIntent);

            }
        });
    }
}
