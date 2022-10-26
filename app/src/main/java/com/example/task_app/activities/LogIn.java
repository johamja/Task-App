package com.example.task_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
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
        setContentView(R.layout.activity_log_in);
        Log.v(TAGC, "Iniciando Actividad");


        // Assigning layout elements to activity variables
        // Asignando elementos del layout a las variables de la actividad
        final Button Log_in = findViewById(R.id.LogIn_Button_login);
        final Button Create_Account = findViewById(R.id.LogIn_Button_create_account);


        email = findViewById(R.id.LogIn_EditText_email);
        password = findViewById(R.id.LogIn_EditText_password);
        privacy_policies = findViewById(R.id.LogIn_CheckBox_privacy_policies);


        // Named Layout Button Action Login
        // Acción del botón del layout con nombre Iniciar sesión
        Log_in.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAGI, " Acción del botón Iniciar sesión");
                String email_s = email.getText().toString();
                String password_s = password.getText().toString();
                Log.i(TAGI, email_s + "  " + password_s + " contraseñas");
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
                email.setError(getString(R.string.Loguin_6));
            } else if (password_s.isEmpty()) {
                password.setError(getString(R.string.Loguin_7));
            } else if (!privacy_policies.isChecked()) {
                privacy_policies.setError(getString(R.string.Loguin_8));
            } else {
                Log.w(TAGA, "Iniciando la api de FirebaseAuth");
                mAuth = FirebaseAuth.getInstance();
                Log.w(TAGA, "Autenticando el usuario en FirebaseAuth");
                mAuth.signInWithEmailAndPassword(email_s, password_s)
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.i(TAGI, "Inicio de sesión con correo electrónico: éxito");
                                Log.w(TAGA, "Iniciar la actividad de SyncUp");
                                Intent intent = new Intent(LogIn.this, SyncUp.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.i(TAGI, email_s + " ---- " + password_s);
                                Log.i(TAGE, "Inicio de sesión con correo electrónico: error", task.getException());
                                Toast.makeText(LogIn.this, getString(R.string.Loguin_9), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        } catch (Exception e) {
            Log.e(TAGE, "Error del metodo Log_in");
        }
    }
}
