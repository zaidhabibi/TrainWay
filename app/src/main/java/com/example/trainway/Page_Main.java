package com.example.trainway;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class Page_Main extends AppCompatActivity {

    //initializing variables
    ImageButton mapButton,
            routeButton,
            notificationButton,
            myTickets,
            homeButton,
            profileButton,
            settingsButton;

    Button temp_profileButton,
            temp_settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        //Assigning variables
        mapButton = findViewById(R.id.mapButton);
        routeButton = findViewById(R.id.routeButton);
        notificationButton = findViewById(R.id.notificationButton);
        myTickets = findViewById(R.id.myTickets);
        homeButton = findViewById(R.id.home_button);
        profileButton = findViewById(R.id.profile_button);
        settingsButton = findViewById(R.id.settings_button);



        //variable functions for Image Button
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Page_Main.this, "Map Button", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Page_Main.this, Station.class));
            }
        });

        routeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Page_Main.this, "Route Button", Toast.LENGTH_SHORT).show();
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Page_Main.this, "Notification Button", Toast.LENGTH_SHORT).show();
            }
        });

        myTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Page_Main.this, "My Tickets Button", Toast.LENGTH_SHORT).show();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page_Main.this, MainActivity.class);
                startActivity(intent);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page_Main.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page_Main.this, Settings.class);
                startActivity(intent);
            }
        });

//        //variable functions for Button
//        temp_profileButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goToProfile();
//            }
//        });
//
//        temp_settingsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                goToSettings();
//            }
//        });

    }

    //function for Button
    private void goToProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void goToSettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    //function for Imagebutton
    /*
    //go to map
    private void goToMap() {
        Intent intent = new Intent(this, Page_Map.class);
        startActivity(intent);
    }*/

    /*
    //go to route
    private void goToRoute() {
        Intent intent = new Intent(this, Page_Route.class);
        startActivity(intent);
    }*/

    /*
    //goToNotification
    private void goToNotification() {
        Intent intent = new Intent(this, Page_Notification.class);
        startActivity(intent);
     */

    /*
    //goToMyTickets
    private void goToMyTickets() {
        Intent intent = new Intent(this, Page_MyTickets.class);
        startActivity(intent);
     */
}


