package com.example.task_app.Vistas.Tareas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_app.Modelos.Categories;
import com.example.task_app.Modelos.Task;
import com.example.task_app.R;

import java.util.List;

public class AdapterTask extends RecyclerView.Adapter<ViewHolderTask> {
    private Context context;
    private List<Task> list;
    private int color;

    public AdapterTask(Context context, List<Task> list, int color) {
        this.context = context;
        this.list = list;
        this.color = color;
    }

    @NonNull
    @Override
    public ViewHolderTask onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ViewHolderTask(layoutInflater.inflate(R.layout.item_task,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTask holder, int position) {
        holder.Render(context,list.get(position),color);
        holder.itemView.findViewById(R.id.item_task_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Hola",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
