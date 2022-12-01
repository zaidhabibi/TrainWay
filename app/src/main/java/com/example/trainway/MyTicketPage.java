package com.example.trainway;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyTicketPage extends AppCompatActivity {
    public static int x10=1;
    protected void onCreate(Bundle savedInstanceState) {
        Button buy;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myticket);
        // buy button
        buy = findViewById(R.id.ticketBuy);

        // destination spinner
        Spinner spinnerDestination = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_String_Destination, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerDestination.setAdapter(adapter);
        // time spinner
        Spinner spinnerTime = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner_Times, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerTime.setAdapter(adapter2);

        //buy ticket
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTicket(view);
            }
        });
    }

        public void createTicket(View view)
        {
            // Write Ticket to Database

            Spinner route =(Spinner)findViewById(R.id.spinner);
            Spinner time =(Spinner)findViewById(R.id.spinner2);

            // Copies user selection into ticket creator
            TicketMain.Ticket test = new TicketMain.Ticket();
            //test.newTicket("test",10,"Dallas","11/23","10:30",50);
            test.newTicket(String.valueOf(x10),"10",route.getSelectedItem().toString(),"11/30",time.getSelectedItem().toString(),1);
            x10++;
        }

}
