package com.example.task_app.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_app.Class.Cuaderno;
import com.example.task_app.Class.na_AdapterNotas;
import com.example.task_app.R;

import java.util.ArrayList;

public class BooksMenu extends AppCompatActivity {

    ArrayList<Cuaderno> listcuadernos;
    RecyclerView recyclercuadernos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_menu);

        listcuadernos = new ArrayList<>();
        recyclercuadernos = findViewById(R.id.an_recyclerid);
        recyclercuadernos.setLayoutManager(new LinearLayoutManager(this));

        try {
            llenar_cuadernos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        na_AdapterNotas adaptador = new na_AdapterNotas(listcuadernos);
        recyclercuadernos.setAdapter(adaptador);
    }

    private void llenar_cuadernos() throws Exception {
        listcuadernos.add(new Cuaderno("Cuaderno1","Este es el cuaderno 1 jijija",2));
        listcuadernos.add(new Cuaderno("Cuaderno2","Este es el cuaderno 2 jijija",5));
        listcuadernos.add(new Cuaderno("Cuaderno3","Este es el cuaderno 3 jijija",6));
    }
}
