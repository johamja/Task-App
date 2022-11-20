package com.example.task_app.Vistas.Categorias.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.task_app.Modelos.Categories;
import com.example.task_app.R;
import com.example.task_app.Vistas.Categorias.CategoryList;
import com.example.task_app.Vistas.Categorias.ListItemsCategorys;
import com.example.task_app.Vistas.Tareas.TaskList;


import java.io.Serializable;
import java.util.List;


public class AdapterCategory extends RecyclerView.Adapter<ViewHolderCategory> {

    private Context context;
    private List<Categories> list;

    public AdapterCategory(Context context, List<Categories> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * esta funcion devuelve al view holder el item el layout que va poder modificar
     */
    @NonNull
    @Override
    public ViewHolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ViewHolderCategory(layoutInflater.inflate(R.layout.item_category, parent, false));
    }

    /**
     * @return pasa por cada uno de los items y llama al  VMCategoriesViewHolder
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategory holder, int position) {
        holder.Render(context,list.get(position));
        holder.itemView.findViewById(R.id.item_category_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TaskList.class);
                intent.putExtra("Categoria",position);
                context.startActivity(intent);
            }
        });
    }

    /**
     * @return devolver el tamaño de la lista
     */
    @Override
    public int getItemCount() {

        return list.size();
    }
}
