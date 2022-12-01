package com.example.trainway;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
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


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class TicketCreator extends MainActivity  {
    private String url = "https://trainway-9a85a-default-rtdb.firebaseio.com";  // URL for firebase database
    private DatabaseReference reference;
    ArrayList<String> strings = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // strings.clear();
        // list of tickets
        Button next;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_create);
        listView = findViewById(R.id.list);
        // next button
        next = findViewById(R.id.nextButton);
        next.setOnClickListener(view -> goToMyTickets2());
        reference = FirebaseDatabase.getInstance(url).getReference();
        reference.child("tickets").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //retrieves children
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                // shakes hand with all children


                for(DataSnapshot child: children){
                    TicketMain.Ticket value = child.getValue(TicketMain.Ticket.class);
                    //tickets.add(value);
                    Log.e("TAG", value.getRoute());
                    strings.add(value.getRoute()+"          "+value.getTime() );
                    if(true){
                        workAround();
                    }
                    //stringTime[z] = value.getTime();

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }



        });

    }

    public void workAround() {
        String[] array = strings.toArray(new String[strings.size()]);
        // Log.e("TAG", strings.get(0));

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                array);
        listView.setAdapter(adapter);
    }

    public void goToMyTickets2() {
        Intent intent = new Intent(this, MyTicketPage.class);
        startActivity(intent);
    }


}



