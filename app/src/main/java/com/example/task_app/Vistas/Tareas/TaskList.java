package com.example.task_app.Vistas.Tareas;


import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_app.Modelos.Categories;
import com.example.task_app.Modelos.Task;
import com.example.task_app.R;
import com.example.task_app.Vistas.Categorias.ListItemsCategorys;
import com.example.task_app.Vistas.Tareas.Adapter.AdapterTask;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.Objects;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class TaskList extends AppCompatActivity {

    private Bundle bundle;
    private Categories categoria;
    private TextView Nombre;
    private ImageView Color;
    private RecyclerView Lista;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_task);

        bundle = getIntent().getExtras();
        categoria = ListItemsCategorys.listCategorias.get(bundle.getInt("Categoria"));
        Color = findViewById(R.id.list_task_1);
        Nombre = findViewById(R.id.list_task_6);
        floatingActionButton = findViewById(R.id.list_task_9);
        Lista = findViewById(R.id.list_task_7);

        int color = 0;
        switch (categoria.getColor()){
            case 1: color = ContextCompat.getColor(this,R.color.Color_Primario); break;
            case 2: color = ContextCompat.getColor(this,R.color.Color_Secundario); break;
            case 3: color = ContextCompat.getColor(this,R.color.Color_Terciario); break;
            case 4: color = ContextCompat.getColor(this,R.color.Color_Cuaternario); break;
            default: color = ContextCompat.getColor(this,R.color.Color_Primario); break;
        }

        AdapterTask adapterTask = new AdapterTask(this,categoria.getTareas(),color);
        Lista.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Lista.setAdapter(adapterTask);

        // eliminar una categoria
        new ItemTouchHelper(EliminarTarea).attachToRecyclerView(Lista);
        // editar una categoria
        new ItemTouchHelper(EditarTarea).attachToRecyclerView(Lista);

        Color.getBackground().setTint(color);
        Nombre.setText(categoria.getNombre());
        Objects.requireNonNull(floatingActionButton.getContentBackground()).setTint(color);
        Window window = this.getWindow();
        window.setStatusBarColor(color);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskList.this, AddTask.class);
                startActivity(intent);
            }
        });

    }


    ItemTouchHelper.SimpleCallback EliminarTarea = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
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
                    .addBackgroundColor(ContextCompat.getColor(TaskList.this, R.color.Color_Primario))
                    .addActionIcon(R.drawable.ic_baseline_delete_24)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };


    final ItemTouchHelper.SimpleCallback EditarTarea = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Intent intent = new Intent(TaskList.this, EditTask.class);
            intent.putExtra("Categoria", bundle.getInt("Categoria"));
            intent.putExtra("Tarea", viewHolder.getAdapterPosition());
            startActivity(intent);
            Lista.getAdapter().notifyDataSetChanged();
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addCornerRadius(1, 10)
                    .addBackgroundColor(ContextCompat.getColor(TaskList.this, R.color.Color_Cuaternario))
                    .addActionIcon(R.drawable.ic_baseline_edit_24)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };

    private Task Datoeliminado;

    private void ShowEliminarCategoria(int posicion) {
        // condicional para ver si elimina la Categoria

        AlertDialog.Builder MensajeConfirmacion = new AlertDialog.Builder(TaskList.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alertdialog_delete_task, null);
        MensajeConfirmacion.setView(view);
        MensajeConfirmacion.setCancelable(false);

        final AlertDialog dialog = MensajeConfirmacion.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        view.findViewById(R.id.alertdialog_delete_task_2).setOnClickListener(view12 -> {
            Lista.getAdapter().notifyDataSetChanged();
            dialog.dismiss();

        });
        view.findViewById(R.id.alertdialog_delete_task_3).setOnClickListener(view1 -> {
            Datoeliminado = categoria.getTareas().get(posicion);
            categoria.getTareas().remove(Datoeliminado);
            dialog.dismiss();
            Lista.getAdapter().notifyDataSetChanged();
        });
        dialog.show();
    }
}