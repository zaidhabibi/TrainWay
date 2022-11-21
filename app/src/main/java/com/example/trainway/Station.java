package com.example.trainway;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class Station extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);

        ImageView images = findViewById(R.id.slides);
        AnimationDrawable animationElement = (AnimationDrawable) images.getDrawable();
        animationElement.start();
    }
}