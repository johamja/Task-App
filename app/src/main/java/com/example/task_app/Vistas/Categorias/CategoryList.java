package com.example.task_app.Vistas.Categorias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.task_app.Modelos.Categories;
import com.example.task_app.R;
import com.example.task_app.Vistas.Categorias.Adapter.AdapterCategory;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class CategoryList extends AppCompatActivity {


    private RecyclerView Lista;
    private FloatingActionButton AñadirCategoria;
    private BottomSheetDialog BottomShetAñadir;
    private EditText nombre;
    private Spinner spinner;
    private String[] colores = {"Color 1","Color 2","Color 3","Color 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_categories);

        ListItemsCategorys.llenarArreglo();

        AñadirCategoria = findViewById(R.id.Categories_6);
        AdapterCategory adapterCategory = new AdapterCategory(this,ListItemsCategorys.listCategorias);
        Lista = findViewById(R.id.Categories_5);
        Lista.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Lista.setAdapter(adapterCategory);

        new ItemTouchHelper(EliminarCategoria).attachToRecyclerView(Lista);
        new ItemTouchHelper(EditarCategoria).attachToRecyclerView(Lista);


        /**
         * Ventana flotante para añadir una nueva lista
         * */
        AñadirCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

    private Categories Datoeliminado;

    ItemTouchHelper.SimpleCallback EliminarCategoria = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int posicion = viewHolder.getAdapterPosition();
            Datoeliminado = ListItemsCategorys.listCategorias.get(posicion);
            ListItemsCategorys.listCategorias.remove(Datoeliminado);
            Lista.getAdapter().notifyDataSetChanged();

            // condicional para ver si elimina la Categoria
        }
        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addCornerRadius(1,10)
                    .addBackgroundColor(ContextCompat.getColor(CategoryList.this, R.color.Eliminar))
                    .addActionIcon(R.drawable.ic_baseline_delete_24)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };


    ItemTouchHelper.SimpleCallback EditarCategoria = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Toast.makeText(CategoryList.this,"editar",Toast.LENGTH_SHORT).show();
            Lista.getAdapter().notifyDataSetChanged();
            // condicional para ver si elimina la Categoria
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addCornerRadius(1,10)
                    .addBackgroundColor(ContextCompat.getColor(CategoryList.this, R.color.Editar))
                    .addActionIcon(R.drawable.ic_baseline_edit_24)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };

}