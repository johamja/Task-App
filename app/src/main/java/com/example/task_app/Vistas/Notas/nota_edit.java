package com.example.task_app.Vistas.Notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.task_app.Modelos.Cuaderno;
import com.example.task_app.Modelos.Nota;
import com.example.task_app.R;
import com.google.android.material.textfield.TextInputEditText;

public class nota_edit extends AppCompatActivity {

    ImageButton b_atras;
    TextInputEditText txt;
    Nota nota = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_edit);

        b_atras = findViewById(R.id.bm_backbutton2);
        txt = findViewById(R.id.bn_txtedition);
        Bundle objetoenviado = getIntent().getExtras();
        if(objetoenviado!=null){
            nota = (Nota) objetoenviado.getSerializable("nota");
        }

        txt.setText(nota.getTexto());

        //Terminado
        b_atras.setOnClickListener(view -> {finalizar();});
        this.setFinishOnTouchOutside(true);
        if(this.isFinishing()){
            finalizar();
        }
    }

    private void finalizar(){
        finish();
    }
}