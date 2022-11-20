package com.example.task_app.Vistas.Inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.task_app.Vistas.Autenticacion.LogIn;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    final private String TAGE = "1-MainActivity-Error";
    final private String TAGA = "1-MainActivity-Accion";
    final private String TAGI = "1-MainActivity-Informacion";
    final private String TAGC = "1-MainActivity-Confirmacion";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.v(TAGC,"Iniciando Actividad");
        super.onCreate(savedInstanceState);

        // Start FirebaseAuth api
        // Inicia la api de FirebaseAuth
        Log.w(TAGA,"Iniciando la api de FirebaseAuth");
        mAuth = FirebaseAuth.getInstance();

        // Getting the user object from FirebaseAuth
        // Obteniendo el objeto usuario de FirebaseAuth
        Log.w(TAGA,"Obteniendo el objeto usuario de FirebaseAuth");
        FirebaseUser currentUser = mAuth.getCurrentUser();


        /**
         * @apiNote Check if the user is saved on the device.
         * If it is saved, the Log.i prints the characteristics
         * of the message and redirects to the HomeApp activity.
         * If it is not registered, it redirects to the LogIn activity.
         *
         * @Español Verificar si el usuario se encuentra guardado en el dispositivo.
         * Si se encuentra guardado los Log.i imprimen las caracteristicas
         * del mensaje y redirije a la actividad HomeApp. Si no se encuentra
         * registrado redirije a la actividad de LogIn.
         * */
        // Check if user is signed in (non-null) and update UI accordingly.
        if(currentUser != null){
            Log.i(TAGI,"El usuario esta reguistrado");
            Log.w(TAGA,"Abriendo la activity HomeApp");
            startActivity(new Intent(MainActivity.this, HomeApp.class ));
            finish();
            Log.i(TAGI,"Email ->          "+currentUser.getEmail());
            Log.i(TAGI,"Uid ->            "+currentUser.getUid());
            Log.i(TAGI,"IdToken  True ->  "+currentUser.getIdToken(true));
            Log.i(TAGI,"IdToken  False -> "+currentUser.getIdToken(false));
            Log.i(TAGI,"Name ->           "+currentUser.getDisplayName());
            Log.i(TAGI,"Number ->         "+currentUser.getPhoneNumber());
            Log.i(TAGI,"ProvedorID ->     "+currentUser.getProviderId());
            Log.i(TAGI,"TenantId ->       "+currentUser.getTenantId());
            Log.i(TAGI,"TenantId ->       "+currentUser.getMetadata().getCreationTimestamp());
            Log.i(TAGI,"TenantId ->       "+currentUser.getMetadata().getLastSignInTimestamp());
            Log.i(TAGI,"TenantId ->       "+currentUser.getMultiFactor());
            Log.i(TAGI,"TenantId ->       "+currentUser.getPhotoUrl());
        } else {
            Log.e(TAGE,"El usuario no esta reguistrado");
            Log.i(TAGA,"Abriendo la activity Login");
            startActivity(new Intent(MainActivity.this, LogIn.class ));
            finish();
        }

    }
}