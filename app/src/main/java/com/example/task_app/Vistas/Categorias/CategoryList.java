package com.example.task_app.Vistas.Categorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.task_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CategoryList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        FloatingActionButton addCategory = findViewById(R.id.Categories_6);


        addCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryList.this, Addcategory.class));
            }
        });
    }
}