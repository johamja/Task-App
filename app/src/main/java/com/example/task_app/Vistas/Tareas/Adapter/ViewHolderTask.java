package com.example.task_app.Vistas.Tareas.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_app.Modelos.Task;
import com.example.task_app.R;

public class ViewHolderTask extends RecyclerView.ViewHolder {

    private TextView nombre;
    private ImageView imagen;

    public ViewHolderTask(@NonNull View itemView) {
        super(itemView);
        nombre = itemView.findViewById(R.id.item_task_3);
        imagen = itemView.findViewById(R.id.item_task_4);
    }

    public void Render(Context context, Task task, int color) {

        nombre.setText(task.getNombre());
        imagen.getBackground().setTint(color);
    }
}
