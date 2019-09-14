package com.example.donoralert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import com.google.firebase.auth.*;
import com.google.firebase.firestore.*;
import com.google.firebase.*;
import android.widget.*;
import java.util.*;
import android.content.*;

public class FoodConfirmation extends AppCompatActivity {

    private Button button;

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
                openFoodWaitList();
            }
        });
        db = FirebaseFirestore.getInstance();
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
        content.put("description", descr);
        db.collection(id).add(content);

        foodName.setText("");
        description.setText("");
    }

    public void openFoodWaitList () {
        Intent intent = new Intent (this, FoodWaitList.class);
        startActivity(intent);
    }
}