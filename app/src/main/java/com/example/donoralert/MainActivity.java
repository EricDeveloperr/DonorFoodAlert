package com.example.donoralert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.*;

import com.google.firebase.firestore.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map <String, Object> user = new HashMap<>();
    }

}
