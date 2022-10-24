package com.example.task_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.task_app.activities.LogIn;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /** 
         if si exte retorne al HomeApp
         else Login iniciar sesion
         */

        Usuario usuario = new Usuario();
        usuario.Cargar_usuario();

        // buscar el usuario
        

        super.onCreate(savedInstanceState);
        startActivity(new Intent(MainActivity.this, LogIn.class ));
        finish();

    }
}