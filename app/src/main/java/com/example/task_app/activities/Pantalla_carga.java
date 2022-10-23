<<<<<<< HEAD:app/src/main/java/com/example/task_app/activities/Pantalla_carga.java
package com.example.task_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.task_app.MainActivity;
import com.example.task_app.R;

public class Pantalla_carga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);

        int Tiempo = 1000;

        /**
         * Pantalla de carga de la aplicacion
         * */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Pantalla_carga.this, MainActivity.class));
                finish();
            }
        },Tiempo);
    }
=======
package com.example.task_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.task_app.MainActivity;
import com.example.task_app.R;

public class Pantalla_carga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);

        int Tiempo = 1000;

        /**
         * Pantalla de carga de la aplicacion
         * */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Pantalla_carga.this, MainActivity.class));
                finish();
            }
        },Tiempo);
    }
>>>>>>> 495f00fd4447177c7d6f6ce7e9ed54e18e8de8cb:app/src/main/java/com/example/task_app/Pantalla_carga.java
}