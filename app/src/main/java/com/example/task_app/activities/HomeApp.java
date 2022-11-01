package com.example.task_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.task_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app);




        Button intoCategory = findViewById(R.id.button2);

        intoCategory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(HomeApp.this,CategoryList.class);
                startActivity(intent);
            }
        });


    }
}