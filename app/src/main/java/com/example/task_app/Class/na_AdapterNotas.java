package com.example.task_app.Class;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_app.R;

import java.util.ArrayList;

public class na_AdapterNotas extends RecyclerView.Adapter<na_AdapterNotas.ViewHolderNotas>{

    ArrayList<Cuaderno> listcuadernos;

    public na_AdapterNotas(ArrayList<Cuaderno> listcuadernos) {
        this.listcuadernos = listcuadernos;
    }

    @Override
    public na_AdapterNotas.ViewHolderNotas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.an_item_list,null,false);
        return new ViewHolderNotas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull na_AdapterNotas.ViewHolderNotas holder, int position) {
        holder.nombre.setText(listcuadernos.get(position).getNombre());
        holder.descripcion.setText(listcuadernos.get(position).getDescripcion());
        holder.bkk.setBackgroundColor(listcuadernos.get(position).getTema());

    }

    @Override
    public int getItemCount() {
        return listcuadernos.size();
    }

    public class ViewHolderNotas extends RecyclerView.ViewHolder {

        TextView nombre,descripcion;
        Button bkk;

        public ViewHolderNotas(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.an_idtxt);
            descripcion = itemView.findViewById(R.id.an_idscrpt);
            bkk = itemView.findViewById(R.id.an_idbkk);
        }
    }
}
