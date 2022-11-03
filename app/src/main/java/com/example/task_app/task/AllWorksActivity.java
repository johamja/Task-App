package com.example.task_app.task;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_works);

        nombre_tareas = new ArrayList<String>();
        if (getIntent().getSerializableExtra("tareas_arreglo") == null){
            nombre_tareas.add("No hay tareas disponibles");
        }
        else {
            nombre_tareas = (ArrayList<String>) getIntent().getSerializableExtra("tareas_arreglo");
        }
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
}