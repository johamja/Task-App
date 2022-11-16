
package com.example.task_app.Vistas.Precarga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.task_app.R;
import com.example.task_app.Vistas.Inicio.HomeApp;

public class SyncUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_up);

        int Tiempo = 1000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SyncUp.this, HomeApp.class));
                finish();
            }
        },Tiempo);

    }
}