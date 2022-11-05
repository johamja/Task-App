package com.example.task_app.Vistas.Autenticacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.EditText;
import android.widget.Toast;

import com.example.task_app.R;
import com.example.task_app.Vistas.Inicio.HomeApp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class CreateAccount extends AppCompatActivity {

    private EditText Name, Surname, Phone, Email, Password;
    private Button CreateAccount;
    private CheckBox Privacy_policies;
    private FirebaseAuth mAuth;
    final private String TAGE = "3-CreateAccount-Error";
    final private String TAGA = "3-CreateAccount-Accion";
    final private String TAGI = "3-CreateAccount-Informacion";
    final private String TAGC = "3-CreateAccount-Confirmacion";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAGC, "Iniciando Actividad");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Name = findViewById(R.id.CreateAccount_EditText_name);
        Surname = findViewById(R.id.CreateAccount_EditText_surname);
        Phone = findViewById(R.id.CreateAccount_EditText_phone);
        Email = findViewById(R.id.CreateAccount_EditText_email);
        Password = findViewById(R.id.CreateAccount_EditText_password);
        CreateAccount = findViewById(R.id.CreateAccountcreate_Button_create_account);
        Privacy_policies = findViewById(R.id.CreateAccount_CheckBox_privacy_policies);
        mAuth = FirebaseAuth.getInstance();


        CreateAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.w(TAGA, "Creando usuario con el metodo CrearUsuario");
                CrearUsuario();
            }
        });
    }


    private void CrearUsuario() {
        try {
            String EmailS = Email.getText().toString();
            String PasswordS = Password.getText().toString();

            if (EmailS.isEmpty()) {
                Email.setError(getString(R.string.Loguin_6));
                Email.requestFocus();
            } else if (PasswordS.isEmpty()) {
                Password.setError(getString(R.string.Loguin_7));
                Password.requestFocus();
            } else if (!Privacy_policies.isChecked()) {
                Privacy_policies.setError(getString(R.string.Loguin_8));
                Privacy_policies.requestFocus();
            } else {
                mAuth.createUserWithEmailAndPassword(EmailS, PasswordS).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i(TAGI, "Usuario creado con email");
                            Log.w(TAGA, "Iniciar la actividad de HomeApp");
                            Intent intent = new Intent(CreateAccount.getContext(), HomeApp.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.e(TAGE, "Usuario no creado", task.getException());
                            Toast.makeText(CreateAccount.this, getString(R.string.Create_Account_6), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        } catch (Exception e) {
            Log.e(TAGE, "Error del metodo CrearUsuario");
        }
    }
}