package com.example.task_app.Vistas.Inicio;

import androidx.appcompat.app.AppCompatActivity;

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

    private ImageButton settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app);

        final Button b_notas = findViewById(R.id.ahp_b_notebooks);
        settings = findViewById(R.id.HomeApp_Button_settings);
        final Button Categorias = findViewById(R.id.Home_Categorias);


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeApp.this, Settings.class);
                startActivity(intent);
            }
        });

        b_notas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeApp.this, BooksMenu.class);
                startActivity(intent);
                finish();
            }
        });

        Categorias.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeApp.this, CategoryList.class);
                startActivity(intent);
                finish();
            }
        });
    }
}