<<<<<<< HEAD:app/src/main/java/com/example/task_app/activities/SyncUp.java
package com.example.task_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.task_app.R;

public class SyncUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_up);

        int Tiempo = 1000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SyncUp.this, LogIn.class));
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

import com.example.task_app.R;

public class SyncUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_up);

        int Tiempo = 1000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SyncUp.this, LogIn.class));
                finish();
            }
        },Tiempo);

    }
>>>>>>> 495f00fd4447177c7d6f6ce7e9ed54e18e8de8cb:app/src/main/java/com/example/task_app/SyncUp.java
}