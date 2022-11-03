package com.example.task_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.task_app.R;

public class HomeApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app);

        final Button b_notas = findViewById(R.id.ahp_b_notebooks);

        b_notas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeApp.this, BooksMenu.class);
                startActivity(intent);
                finish();
            }
        });
    }
}