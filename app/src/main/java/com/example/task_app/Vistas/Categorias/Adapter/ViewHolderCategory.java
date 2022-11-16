package com.example.task_app.Vistas.Categorias.Adapter;

import android.content.Context;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_app.Modelos.Categories;
import com.example.task_app.R;

public class ViewHolderCategory extends RecyclerView.ViewHolder {
    private TextView nombre;
    private ImageView imagen;

    public ViewHolderCategory(@NonNull View itemView) {
        super(itemView);
        nombre = itemView.findViewById(R.id.item_category_2);
        imagen = itemView.findViewById(R.id.item_category_3);
    }

    public void Render(Context context, Categories categories) {
        nombre.setText(categories.getNombre());
        int color = 0;
        switch (categories.getColor()){
            case 1: color = ContextCompat.getColor(context,R.color.Color_Primario); break;
            case 2: color = ContextCompat.getColor(context,R.color.Color_Secundario); break;
            case 3: color = ContextCompat.getColor(context,R.color.Color_Terciario); break;
            case 4: color = ContextCompat.getColor(context,R.color.Color_Cuaternario); break;
            default: color = ContextCompat.getColor(context,R.color.Color_Primario); break;
        }
        imagen.getBackground().setTint(color);
    }
}
