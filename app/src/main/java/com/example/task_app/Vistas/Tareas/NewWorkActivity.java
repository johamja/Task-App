package com.example.task_app.Vistas.Tareas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.task_app.Modelos.Work;
import com.example.task_app.R;

import java.util.ArrayList;

public class NewWorkActivity extends AppCompatActivity {
    ImageView back;
    ArrayList<String> tarea, fecha, desc;
    EditText etTarea, etDia, etMes, etAnio, etDesc;
    LinearLayout btnGuardar;
    Work objwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_work);

        tarea = new ArrayList<String>();
        fecha = new ArrayList<String>();
        desc = new ArrayList<String>();

        etTarea = (EditText) findViewById(R.id.et_work);
        etDia = (EditText) findViewById(R.id.et_dia);
        etMes = (EditText) findViewById(R.id.et_mes);
        etAnio = (EditText) findViewById(R.id.et_anio);
        etDesc = (EditText) findViewById(R.id.et_desc);

        btnGuardar = (LinearLayout) findViewById(R.id.btn_guardartarea);

        back = (ImageView) findViewById(R.id.back_anw);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                guardarDatos();

            }
        });
    }

    public void guardarDatos(){
        String work;
        String date;
        String descripcion;

        work = etTarea.getText().toString();
        date = etDia.getText().toString() + "/" + etMes.getText().toString() + "/" + etAnio.getText().toString();
        descripcion = etDesc.getText().toString();
        /*
        tarea.add(work);
        fecha.add(date);
        desc.add(descripcion);*/
        objwork = new Work(work,date,descripcion);
    }

}