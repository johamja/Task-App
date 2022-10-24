
package com.example.task_app.activities;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.task_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateAccount extends AppCompatActivity {

    EditText Email,Password;
    Button CreateAccount;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Email = findViewById(R.id.EditTextEmail);
        Password = findViewById(R.id.EditTextPassword);
        CreateAccount = findViewById(R.id.Create_account_2);
        mAuth = FirebaseAuth.getInstance();

        final Button button = findViewById(R.id.Create_account_2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent intent = new Intent(v.getContext(), HomeApp.class);
                startActivity(intent);
            }
        });
    }

     private void CrearUsuario(){
         String EmailS = Email.getText().toString();
         String PasswordS = Password.getText().toString();

         if (EmailS.isEmpty()){
             Email.setError("Necesita un correo");
             Email.requestFocus();
         } else if (PasswordS.isEmpty()){
             Password.setError("Necesita una contraseña");
             Password.requestFocus();
         } else {
             mAuth.createUserWithEmailAndPassword(EmailS, PasswordS)
                     .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             if (task.isSuccessful()) {

                                 FirebaseUser user = mAuth.getCurrentUser();

                                 Intent intent = new Intent(CreateAccount.getContext(), HomeApp.class);

                                 startActivity(intent);

                                 finish();
                             } else {
                                 Toast.makeText(CreateAccount.this, "Authentication failed.",
                                         Toast.LENGTH_SHORT).show();
                             }
                         }
                     });

             // crea el usuario con la contraseña 

             // enviar datos como el nombre, apellido y telefono 
             // la base de datos 
         }
    }

}