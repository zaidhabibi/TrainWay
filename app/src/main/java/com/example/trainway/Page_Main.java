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
            myTickets;

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

        temp_profileButton = findViewById(R.id.temp_profileButton);
        temp_settingsButton = findViewById(R.id.temp_settingButton);

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
                goToRoute();
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNotification();
            }
        });

        myTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Page_Main.this, "My Tickets Button", Toast.LENGTH_SHORT).show();
                goToMyTickets();
            }
        });

        //variable functions for Button
        temp_profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfile();
            }
        });

        temp_settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSettings();
            }
        });

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

    //go to routes
    private void goToRoute() {
        Intent intent = new Intent(this, RoutesActivity.class);
        startActivity(intent);
    }

    //go to notifications
    private void goToNotification() {
        Intent intent = new Intent(this, NotificationsActivity.class);
        startActivity(intent);
    }


    //goToMyTickets
    private void goToMyTickets() {
        Intent intent = new Intent(this, TicketCreator.class);
        startActivity(intent);
    }

}


