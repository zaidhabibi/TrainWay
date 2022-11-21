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
        Button buy, next;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_create);
        next = findViewById(R.id.nextButton);
        buy=findViewById(R.id.createTix);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                goToMyTickets2();
            }
                                });


        buy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                createTicket(view);
            }
        });
    }
    private void goToMyTickets2() {
        Intent intent = new Intent(this, MyTicketPage.class);
        startActivity(intent);
    }

    public void createTicket(View view)
    {

        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
        // Write Ticket to Database
        EditText Id = findViewById(R.id.idText);
        EditText route = findViewById(R.id.routeText);

        // Copies user input into ticket creator
        EditText price = findViewById(R.id.priceText);
        String priced = price.getText().toString();
        double finalPrice= Double.parseDouble(priced);
        EditText time = findViewById(R.id.timeText);
        EditText date = findViewById(R.id.dateText);
        EditText count = findViewById(R.id.countText);
        String tCount= count.getText().toString();
        int finalCounter = Integer.parseInt(tCount);
        TicketMain.Ticket test = new TicketMain.Ticket();
        //test.newTicket("test",10,"Dallas","11/23","10:30",50);
        test.newTicket(Id.getText().toString(),finalPrice,route.getText().toString(),date.getText().toString(),time.getText().toString(),finalCounter);

    }
}
