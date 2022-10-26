package com.example.task_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.task_app.MainActivity;
import com.example.task_app.R;

public class ChargingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charging_screen);

        int Tiempo = 1000;

        /**
         * Pantalla de carga de la aplicacion
         * */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ChargingScreen.this, MainActivity.class));
                finish();
            }
        },Tiempo);
    }

}