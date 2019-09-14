package com.example.donoralert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.firebase.auth.*;


//role activity is now the login page
public class RoleSelection extends AppCompatActivity {

    Button signUp;
    Button logIn;
    RoleSelection selfRef;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_selection);
        getSupportActionBar().setTitle("Log In");
        signUp = findViewById(R.id.signUp);
        logIn = findViewById(R.id.login);
        selfRef = this;

        //initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selfRef.signUp();
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selfRef.logIn();
            }
        });
    }

    @Override
    public void onStart () {
        super.onStart();
        //Check if user signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null)
        {
            //go to the next page
        }
    }

    protected void signUp () {

    }

    protected void logIn () {

    }

}
