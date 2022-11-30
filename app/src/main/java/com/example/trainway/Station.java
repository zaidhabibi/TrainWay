package com.example.trainway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Station extends AppCompatActivity {
    ImageButton homeButton,
    profileButton,
    settingsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);

        ImageView images = findViewById(R.id.slides);
        AnimationDrawable animationElement = (AnimationDrawable) images.getDrawable();
        animationElement.start();

        homeButton = findViewById(R.id.home_button);
        profileButton = findViewById(R.id.profile_button);
        settingsButton = findViewById(R.id.settings_button);



        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Station.this, MainActivity.class);
                startActivity(intent);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Station.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Station.this, Settings.class);
                startActivity(intent);
            }
        });

    }
}