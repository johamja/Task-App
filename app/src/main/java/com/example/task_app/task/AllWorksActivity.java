package com.example.task_app.task;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.task_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AllWorksActivity extends AppCompatActivity {
    FloatingActionButton btn_newtask;
    ListView listWorks;
    ArrayAdapter<String> adapter;
    ArrayList<String> nombre_tareas;
    ImageView back;
    DataBaseWorks dataBaseWorks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_works);
        dataBaseWorks = new DataBaseWorks(this);
        nombre_tareas = new ArrayList<String>();
        llenaArreglo();
        btn_newtask = (FloatingActionButton) findViewById(R.id.btn_newtask);
        btn_newtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewWorkActivity.class);
                startActivity(intent);
            }
        });
        listWorks = (ListView) findViewById(R.id.list_works);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombre_tareas);
        back = (ImageView) findViewById(R.id.back_anw);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        listWorks.setAdapter(adapter);
    }

    @SuppressLint("Range")
    //obtener datos de la base de datos

    public ArrayList<Work> obtenDatos(){
        Cursor datos = dataBaseWorks.getTareas();
        ArrayList<Work> tareas = new ArrayList<Work>();
        String name, date, desc;
        int id;
        while(datos.moveToNext()) {
            id = datos.getInt(datos.getColumnIndex("id_tarea"));
            name = datos.getString(datos.getColumnIndex("nombre"));
            date = datos.getString(datos.getColumnIndex("fecha"));
            desc = datos.getString(datos.getColumnIndex("descripcion"));

            Work work = new Work(id, name, date, desc);
            tareas.add(work);
        }
        return  tareas;
    }
    public void llenaArreglo(){
        ArrayList<Work>tareas = obtenDatos();
        for (int i=0; i< tareas.size(); i++){
            nombre_tareas.add(tareas.get(i).getNombre());
        }
    }
}