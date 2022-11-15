package com.example.task_app.Vistas.Categorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;

import com.example.task_app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CategoryList extends AppCompatActivity {

    private FloatingActionButton AñadirCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_categories);

        AñadirCategoria = findViewById(R.id.Categories_6);


        AñadirCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(CategoryList.this, Addcategory.class));
                BottomSheetDialog AñadirCategoria = new BottomSheetDialog(CategoryList.this);
                AñadirCategoria.setContentView(R.layout.activity_addcategory);
                AñadirCategoria.show();
            }
        });
    }
}