package com.example.donoralert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
import java.util.*;
import android.content.*;


//role activity is now the login page
public class RoleSelection extends AppCompatActivity {

    Button signUp;
    Button logIn;
    EditText email;
    EditText password;
    RoleSelection selfRef;
    Intent i;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_selection);
        getSupportActionBar().setTitle("Log In");
        signUp = findViewById(R.id.signUp);
        logIn = findViewById(R.id.login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        i = new Intent(this, SignUpScreen.class);
        preferences = this.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        editor = preferences.edit();

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

    //goes to the next view
    public void toNextView() {
        startActivity(i);
    }

    //for those without an account
    protected void signUp () {
        final String useremail = email.getText().toString().trim();
        final String userpassword = email.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(useremail, userpassword)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    editor.putString("password", userpassword);
                    editor.putString("email", useremail);
                    //Sign in success, update UI with the signed-in user's information
                    Toast.makeText(RoleSelection.this, "Sign Up Was Successful", Toast.LENGTH_LONG).show();
                    toNextView ();
                } else {
                    Toast.makeText(RoleSelection.this, "Sign Up Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void logIn () {
        mAuth.signInWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString().trim())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RoleSelection.this, "Signed In", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(RoleSelection.this, "Sign In Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}