package com.example.task_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.task_app.R;


public class LogIn extends AppCompatActivity { // implementar el extends para que funcionen los layouts tambien en el XML


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final Button button2 = findViewById(R.id.Log_in);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(v.getContext(), SyncUp.class);
                startActivity(intent);
            }
        });

        final Button button = findViewById(R.id.Create_account);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(v.getContext(), CreateAccount.class);
                startActivity(intent);
            }
        });

    }

}
