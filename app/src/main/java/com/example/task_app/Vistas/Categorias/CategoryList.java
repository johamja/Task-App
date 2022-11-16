package com.example.task_app.Vistas.Categorias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task_app.Modelos.Categories;
import com.example.task_app.R;
import com.example.task_app.Vistas.Categorias.Adapter.AdapterCategory;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CategoryList extends AppCompatActivity {


    private RecyclerView Lista;
    private FloatingActionButton AñadirCategoria;
    private BottomSheetDialog BottomShetAñadir;
    private EditText nombre;
    private Spinner spinner;
    private String[] colores = {"Rojo","verde","azul","Amarillo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_categories);

        AñadirCategoria = findViewById(R.id.Categories_6);

        AdapterCategory adapterCategory = new AdapterCategory(this,ListItemsCategorys.listCategorias);
        Lista = findViewById(R.id.Categories_5);
        Lista.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Lista.setAdapter(adapterCategory);


        /**
         * Ventana flotante para añadir una nueva lista
         * */
        AñadirCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(CategoryList.this, Addcategory.class));
                BottomShetAñadir = new BottomSheetDialog(CategoryList.this);
                BottomShetAñadir.setContentView(R.layout.activity_addcategory);
                BottomShetAñadir.show();

                spinner = BottomShetAñadir.findViewById(R.id.spinner);
                nombre = BottomShetAñadir.findViewById(R.id.editTextTextPersonName);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        CategoryList.this, android.R.layout.simple_spinner_item, colores
                );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);


                // Boton de guardar
                BottomShetAñadir.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (nombre.getText().toString().isEmpty()){
                            BottomShetAñadir.dismiss();
                        } else {
                            ListItemsCategorys.listCategorias.add(new Categories(nombre.getText().toString(),spinner.getSelectedItemPosition()+1));
                            Lista.getAdapter().notifyDataSetChanged();
                            BottomShetAñadir.dismiss();
                        }
                    }
                });

            }
        });
    }



}