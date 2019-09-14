package com.example.donoralert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import com.google.firebase.auth.*;
import com.google.firebase.firestore.*;
import com.google.firebase.*;
import android.widget.*;
import java.util.*;

public class FoodConfirmation extends AppCompatActivity {

    EditText foodName;
    EditText description;

    Button confirm;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_confirmation);

        foodName = findViewById(R.id.foodNameInputBox);
        description = findViewById(R.id.descriptionInputBox);

        mAuth = FirebaseAuth.getInstance();

        confirm = findViewById(R.id.confirmButton);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
            }
        });

        db = FirebaseFirestore.getInstance();
        Map <String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put ("last", "Lovelace");
        user.put("born", 1815);
    }

    public void uploadData () {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            Toast.makeText(FoodConfirmation.this, "Upload Failed", Toast.LENGTH_LONG).show();
            return;
        }
        String id = user.getUid();
        Map <String, Object> content = new HashMap<>();
        String name = foodName.getText().toString().trim();
        String descr = description.getText().toString().trim();
        content.put("name", name);
        content.put("description", description);
        db.collection(id).add(content);

        foodName.setText("");
        description.setText("");
    }
}
