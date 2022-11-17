package com.example.task_app.Modelos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_app.R;

import java.util.ArrayList;

public class na_AdapterCuadernos extends RecyclerView.Adapter<na_AdapterCuadernos.ViewHolderNotas> implements View.OnClickListener{

    ArrayList<Cuaderno> listcuadernos;
    private View.OnClickListener listener;

    public na_AdapterCuadernos(ArrayList<Cuaderno> listcuadernos) {
        this.listcuadernos = listcuadernos;
    }

    @Override
    public na_AdapterCuadernos.ViewHolderNotas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ab_item_list,null,false);
        view.setOnClickListener(this);
        return new ViewHolderNotas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull na_AdapterCuadernos.ViewHolderNotas holder, int position) {
        holder.nombre.setText(listcuadernos.get(position).getNombre());
        holder.descripcion.setText(listcuadernos.get(position).getDescripcion());
        holder.bkk.setBackgroundColor(listcuadernos.get(position).getTema());

    }

    @Override
    public int getItemCount() {
        return listcuadernos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderNotas extends RecyclerView.ViewHolder {

        TextView nombre,descripcion;
        ImageView bkk;

        public ViewHolderNotas(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.an_idtxt);
            descripcion = itemView.findViewById(R.id.an_idscrpt);
            bkk = itemView.findViewById(R.id.ait_img);
        }
    }
}
