package com.example.task_app.Class;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class na_AdapterDatos extends RecyclerView.Adapter<na_AdapterDatos.ViewHolderDatos> {

    ArrayList<Nota> listnotas;

    public na_AdapterDatos(ArrayList<Nota> listUsuarios) {
        this.listnotas = listUsuarios;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listnotas.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
        }
    }
}
