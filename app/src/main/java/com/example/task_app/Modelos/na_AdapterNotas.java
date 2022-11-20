package com.example.task_app.Modelos;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import androidx.recyclerview.widget.RecyclerView;

import com.example.task_app.R;

import java.util.ArrayList;

public class na_AdapterNotas extends RecyclerView.Adapter<na_AdapterNotas.ViewHolderNotas> implements View.OnClickListener{

    ArrayList<Nota> listnotas;
    Context context;

    public na_AdapterNotas(Context context, ArrayList<Nota> listnotas) {
        this.context = context;
        this.listnotas = listnotas;
    }

    @NonNull
    @Override
    public na_AdapterNotas.ViewHolderNotas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.an_item_list,null,false);
        view.setOnClickListener(this);
        return new na_AdapterNotas.ViewHolderNotas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull na_AdapterNotas.ViewHolderNotas holder, int position) {

        holder.texto.setText(listnotas.get(position).getTexto());
        holder.fecha.setText(listnotas.get(position).getFecha_modificacion().toString());
        int color = 0;
        switch (listnotas.get(position).getTema()){
            case 1: color = ContextCompat.getColor(context,R.color.Color_Primario); break;
            case 2: color = ContextCompat.getColor(context,R.color.Color_Secundario); break;
            case 3: color = ContextCompat.getColor(context,R.color.Color_Terciario); break;
            case 4: color = ContextCompat.getColor(context,R.color.Color_Cuaternario); break;
            default: color = ContextCompat.getColor(context,R.color.Color_Primario); break;
        }
        holder.tema.getBackground().setTint(color);
    }

    @Override
    public int getItemCount() {
        return listnotas.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolderNotas extends RecyclerView.ViewHolder {
        TextView texto,fecha;
        ImageView tema;

        public ViewHolderNotas(@NonNull View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.an_textos);
            fecha = itemView.findViewById(R.id.an_fecha);
            tema = itemView.findViewById(R.id.an_tema);

        }
    }
}
