package com.example.trainway;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class TicketCreator extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button next;
        super.onCreate(savedInstanceState);

        next = findViewById(R.id.nextButton);

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                goToMyTickets2();
            }
        });

    }
    private void goToMyTickets2() {
        Intent intent = new Intent(this, MyTicketPage.class);
        startActivity(intent);
    }


}
