package com.example.task_app.Vistas.Autenticacion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.task_app.Vistas.Precarga.SyncUp;
import com.example.task_app.R;
import com.google.firebase.auth.FirebaseAuth;


public class LogIn extends AppCompatActivity { // implementar el extends para que funcionen los layouts tambien en el XML

    private FirebaseAuth mAuth;
    private EditText email, password;
    private CheckBox privacy_policies;
    final private String TAGE = "2-LogIn-Error";
    final private String TAGA = "2-LogIn-Accion";
    final private String TAGI = "2-LogIn-Informacion";
    final private String TAGC = "2-LogIn-Confirmacion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.v(TAGC, "Iniciando Actividad");


        // Assigning layout elements to activity variables
        // Asignando elementos del layout a las variables de la actividad
        final Button Log_in = findViewById(R.id.Login_11);
        final Button Create_Account = findViewById(R.id.Login_12);


        email = findViewById(R.id.Login_5);
        password = findViewById(R.id.Login_7);
        privacy_policies = findViewById(R.id.Login_8);


        // Named Layout Button Action Login
        // Acción del botón del layout con nombre Iniciar sesión
        Log_in.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAGI, " Acción del botón Iniciar sesión");
                String email_s = email.getText().toString();
                String password_s = password.getText().toString();
                Log.w(TAGA, "Enviando contraseña y password al metodo Log_in");
                Log_in(email_s, password_s);
            }
        });


        // Start the CreateAccount activity
        // Inicia la activity de CreateAccount
        Create_Account.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAGI, " Acción del botón Crear una cuenta");
                Intent intent = new Intent(v.getContext(), CreateAccount.class);
                startActivity(intent);
                Log.w(TAGA, "Iniciar la actividad de CreateAccount");
            }
        });
    }


    private void Log_in(String email_s, String password_s) {
        try {
            if (email_s.isEmpty()) {
                email.setError(getString(R.string.Login_Error_1));
                email.requestFocus();
            } else if (password_s.isEmpty()) {
                password.setError(getString(R.string.Login_Error_2));
                password.requestFocus();
            } else if (!privacy_policies.isChecked()) {
                privacy_policies.setError(getString(R.string.Login_Error_3));
                privacy_policies.requestFocus();
            } else {
                Log.w(TAGA, "Iniciando la api de FirebaseAuth");
                mAuth = FirebaseAuth.getInstance();
                Log.w(TAGA, "Autenticando el usuario en FirebaseAuth");
                mAuth.signInWithEmailAndPassword(email_s, password_s).addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.i(TAGI, "Inicio de sesión con correo electrónico: éxito");
                        Log.w(TAGA, "Iniciar la actividad de SyncUp");
                        Intent intent = new Intent(LogIn.this, SyncUp.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Log.i(TAGI, email_s + " ---- " + password_s);
                        Log.e(TAGE, "Inicio de sesión con correo electrónico: error", task.getException());
                        Toast.makeText(LogIn.this, getString(R.string.Login_Toast_1), Toast.LENGTH_LONG).show();
                    }
                });
            }
        } catch (Exception e) {
            Log.e(TAGE, "Error del metodo Log_in");
        }
    }
}
