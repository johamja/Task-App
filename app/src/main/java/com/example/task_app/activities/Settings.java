package com.example.task_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task_app.MainActivity;
import com.example.task_app.R;
import com.example.task_app.model.firebase_authentication.Authentication;
import com.example.task_app.model.firebase_authentication.User;

public class Settings extends AppCompatActivity {

    private TextView email;
    private Button signoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        email = findViewById(R.id.Settings_TextView_email);
        signoff = findViewById(R.id.Settings_Button_sign_off);

        email.setText(User.Email());

        signoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Authentication.signOut()){
                    Intent intent = new Intent(Settings.this,LogIn.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Settings.this,"Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}