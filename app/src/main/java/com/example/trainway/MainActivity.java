package com.example.trainway;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register, forgotPassword;
    private EditText editTextEmail, editTextPassword;
    private Button signIn;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    private String url = "https://trainway-9a85a-default-rtdb.firebaseio.com";  // URL for firebase database
    private static final String TAG = "MyActivity";
    private FirebaseDatabase database = FirebaseDatabase.getInstance(url);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);

        signIn = (Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.register:
                startActivity(new Intent(this, RegisterUser.class));
                break;
            case R.id.signIn:
                userLogin();
                break;

            case R.id.forgotPassword:
                startActivity(new Intent(this, ForgotPassword.class));
                break;

        }
    }



    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()){
            editTextEmail.setError("E-mail is required.");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a VALID E-mail.");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextPassword.setError("Password is required.");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6){
            editTextPassword.setError("Password needs to be more than 6 characters.");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if (user.isEmailVerified()){
                        // REDIRECT TO USER PROFILE
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                    }

                    else {
                        user.sendEmailVerification();
                        Toast.makeText(MainActivity.this, "Check your e-mail for account verification", Toast.LENGTH_LONG).show();
                    }

                }

                else {
                    Toast.makeText(MainActivity.this, "Failed to log-in, please check your credentials.", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

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
        test.newTicket("test",10,"Dallas","11/23","10:30",50);
        test.newTicket(Id.getText().toString(),finalPrice,route.getText().toString(),date.getText().toString(),time.getText().toString(),finalCounter);

    }

    public void deleteTicket(){

    }
    public void buyTicket(){

        FirebaseUser user;
        DatabaseReference reference;
        String userID;
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {

                    TicketMain.Ticket tix = new TicketMain.Ticket();
                    tix.addTicket("test",userProfile);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

    }

    public void refundTicket(){

    }
}