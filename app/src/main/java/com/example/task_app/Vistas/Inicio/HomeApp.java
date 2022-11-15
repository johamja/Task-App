package com.example.task_app.Vistas.Inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.task_app.Vistas.Categorias.CategoryList;
import com.example.task_app.Vistas.Configuracion.Settings;
import com.example.task_app.R;
import com.example.task_app.Vistas.Cuadernos.BooksMenu;

public class HomeApp extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app);

        final CardView Cuadernos = findViewById(R.id.cardView3);
        final CardView Categorias = findViewById(R.id.cardView2);
        final ImageButton Configuracion = findViewById(R.id.imageButton5);



        Configuracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeApp.this, Settings.class);
                startActivity(intent);
            }
        });

        Cuadernos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeApp.this, BooksMenu.class);
                startActivity(intent);
            }
        });

        Categorias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeApp.this, CategoryList.class);
                startActivity(intent);
            }
        });
    }
}