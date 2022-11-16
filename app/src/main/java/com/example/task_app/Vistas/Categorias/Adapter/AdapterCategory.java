package com.example.task_app.Vistas.Categorias.Adapter;

import android.content.Context;
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
        LayoutInflater layoutItemCategorie = LayoutInflater.from(parent.getContext());
        return new ViewHolderCategory(layoutItemCategorie.inflate(R.layout.item_category, parent, false));
    }

    /**
     * @return pasa por cada uno de los items y llama al  VMCategoriesViewHolder
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategory holder, int position) {
        holder.Render(context,list.get(position));
        holder.itemView.findViewById(R.id.item_category_1).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                list.remove(position);
                notifyDataSetChanged();
                return false;
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
