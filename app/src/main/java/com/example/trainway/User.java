package com.example.trainway;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class User {
    private DatabaseReference ref;
    public String fullName, age, email;
    public String[] tickets;
    public int index = 0;
    public double money= 1000;

    public User() {

    }

    public User(String fullName, String age, String email) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }





}