package com.example.task_app.Vistas.Categorias;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.task_app.Modelos.Categories;
import com.example.task_app.R;
import com.example.task_app.Vistas.Categorias.Adapter.AdapterCategory;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class CategoryList extends AppCompatActivity {

    private ImageButton Salir;
    private RecyclerView Lista;
    private FloatingActionButton AñadirCategoria;
    private BottomSheetDialog BottomShetAñadir;
    private EditText nombre;
    private Spinner spinner;
    private String[] colores = {"Color 1", "Color 2", "Color 3", "Color 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_categories);

        ListItemsCategorys.llenarArreglo();
        AñadirCategoria = findViewById(R.id.Categories_6);
        Lista = findViewById(R.id.Categories_5);
        Salir = findViewById(R.id.Categories_1);


        AdapterCategory adapterCategory = new AdapterCategory(this, ListItemsCategorys.listCategorias);
        Lista.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Lista.setAdapter(adapterCategory);

        // eliminar una categoria
        new ItemTouchHelper(EliminarCategoria).attachToRecyclerView(Lista);
        // editar una categoria
        new ItemTouchHelper(EditarCategoria).attachToRecyclerView(Lista);


        // Ventana flotante para añadir una nueva lista
        AñadirCategoria.setOnClickListener(view -> ShetAñadirCategoria());
        Salir.setOnClickListener(view -> FinalizarActivity());

    }

    private Categories Datoeliminado;

    ItemTouchHelper.SimpleCallback EliminarCategoria = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            ShowEliminarCategoria(viewHolder.getAdapterPosition());
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addCornerRadius(1, 10)
                    .addBackgroundColor(ContextCompat.getColor(CategoryList.this, R.color.Color_Primario))
                    .addActionIcon(R.drawable.ic_baseline_delete_24)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };


    ItemTouchHelper.SimpleCallback EditarCategoria = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            ShetEditarCategoria(viewHolder.getAdapterPosition());
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addCornerRadius(1, 10)
                    .addBackgroundColor(ContextCompat .getColor(CategoryList.this, R.color.Color_Cuaternario))
                    .addActionIcon(R.drawable.ic_baseline_edit_24)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };

    private void ShetAñadirCategoria() {
        BottomShetAñadir = new BottomSheetDialog(CategoryList.this);
        BottomShetAñadir.setContentView(R.layout.bottom_sheet_add_category);
        BottomShetAñadir.setCancelable(false);
        BottomShetAñadir.show();

        spinner = BottomShetAñadir.findViewById(R.id.bottom_sheet_add_category_4);
        nombre = BottomShetAñadir.findViewById(R.id.bottom_sheet_add_category_2);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                CategoryList.this, android.R.layout.simple_spinner_item, colores
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        // Boton de guardar
        BottomShetAñadir.findViewById(R.id.bottom_sheet_add_category_5).setOnClickListener(view -> {
            Lista.getAdapter().notifyDataSetChanged();
            BottomShetAñadir.dismiss();
        });
        BottomShetAñadir.findViewById(R.id.bottom_sheet_add_category_6).setOnClickListener(view -> {
            if (nombre.getText().toString().isEmpty()) {
                BottomShetAñadir.dismiss();
            } else {
                ListItemsCategorys.listCategorias.add(new Categories(nombre.getText().toString(), spinner.getSelectedItemPosition() + 1,new ArrayList<>()));
                Lista.getAdapter().notifyDataSetChanged();
                BottomShetAñadir.dismiss();
            }
        });
    }

    private void ShetEditarCategoria(int posicion) {
        BottomShetAñadir = new BottomSheetDialog(CategoryList.this);
        BottomShetAñadir.setContentView(R.layout.bottom_sheet_edit_category);
        BottomShetAñadir.setCancelable(false);
        BottomShetAñadir.show();
        Categories objeto = ListItemsCategorys.listCategorias.get(posicion);
        spinner = BottomShetAñadir.findViewById(R.id.bottom_sheet_edit_category_4);
        nombre = BottomShetAñadir.findViewById(R.id.bottom_sheet_edit_category_2);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                CategoryList.this, android.R.layout.simple_spinner_item, colores
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        nombre.setText(objeto.getNombre());
        spinner.setSelection(objeto.getColor() - 1);

        BottomShetAñadir.findViewById(R.id.bottom_sheet_edit_category_5).setOnClickListener(view -> {
            Lista.getAdapter().notifyDataSetChanged();
            BottomShetAñadir.dismiss();
        });
        BottomShetAñadir.findViewById(R.id.bottom_sheet_edit_category_6).setOnClickListener(view -> {
            if (nombre.getText().toString().isEmpty()) {
                BottomShetAñadir.dismiss();
            } else {
                objeto.setNombre(nombre.getText().toString());
                objeto.setColor(spinner.getSelectedItemPosition() + 1);
                Lista.getAdapter().notifyDataSetChanged();
                BottomShetAñadir.dismiss();
            }
        });
    }

    private void ShowEliminarCategoria(int posicion) {
        // condicional para ver si elimina la Categoria
        AlertDialog.Builder MensajeConfirmacion = new AlertDialog.Builder(CategoryList.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alertdialog_delete_category, null);
        MensajeConfirmacion.setView(view);
        MensajeConfirmacion.setCancelable(false);

        final AlertDialog dialog = MensajeConfirmacion.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        view.findViewById(R.id.alertdialog_delete_category_2).setOnClickListener(view12 -> {
            Lista.getAdapter().notifyDataSetChanged();
            dialog.dismiss();

        });
        view.findViewById(R.id.alertdialog_delete_category_3).setOnClickListener(view1 -> {
            Datoeliminado = ListItemsCategorys.listCategorias.get(posicion);
            ListItemsCategorys.listCategorias.remove(Datoeliminado);
            dialog.dismiss();
            Lista.getAdapter().notifyDataSetChanged();
        });
        dialog.show();
    }

    private void FinalizarActivity() {
        finish();
    }

}