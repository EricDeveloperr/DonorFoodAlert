package com.example.donoralert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodConfirmation extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_confirmation);

        button = findViewById(R.id.confirmButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openFoodWaitList();
            }
        });
    }

    public void openFoodWaitList(){
        Intent intent = new Intent(this, FoodWaitList.class);
        startActivity(intent);
    }
}
