package com.example.task_app.Vistas.Cuadernos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_app.Modelos.Cuaderno;
import com.example.task_app.Modelos.Nota;
import com.example.task_app.Modelos.na_AdapterCuadernos;
import com.example.task_app.R;
import com.example.task_app.Vistas.Notas.NotasMenu;

import java.util.ArrayList;

public class BooksMenu extends AppCompatActivity {

    ArrayList<Cuaderno> listcuadernos;
    RecyclerView recyclercuadernos;
    ImageView bck,menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_menu);

        listcuadernos = new ArrayList<>();
        recyclercuadernos = findViewById(R.id.an_recyclerid);
        recyclercuadernos.setLayoutManager(new LinearLayoutManager(this));

        try {
            llenar_cuadernos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        na_AdapterCuadernos adaptador = new na_AdapterCuadernos(this,listcuadernos);
        recyclercuadernos.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cuaderno cuaderno = listcuadernos.get(recyclercuadernos.getChildAdapterPosition(view));
                Intent intent = new Intent(BooksMenu.this, NotasMenu.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Cuaderno",cuaderno);
                intent.putExtras(bundle);
                //Toast.makeText(getApplicationContext(), String.valueOf(listcuadernos.get(recyclercuadernos.getChildAdapterPosition(view)).getTema()), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


        //Salir
        bck = findViewById(R.id.bm_backbutton);
        bck.setOnClickListener(view -> FinalizarActivity());

    }

    //Metodo de pruebas
    private void llenar_cuadernos() throws Exception {
        ArrayList<Nota> listadenotas1 = new ArrayList<>();
        listadenotas1.add(new Nota("Nota a del cuaderno 1",1));
        ArrayList<Nota> listadenotas2 = new ArrayList<>();
        listadenotas2.add(new Nota("Nota A del cuaderno 2",3));
        listadenotas2.add(new Nota("Nota B del cuaderno 2",4));
        listcuadernos.add(new Cuaderno("Cuaderno1","Este es el cuaderno 1 jijija",2,listadenotas1));
        listcuadernos.add(new Cuaderno("Cuaderno2","Este es el cuaderno 2 jijija",5,listadenotas2));
        listcuadernos.add(new Cuaderno("Cuaderno3","Este es el cuaderno 3 jijija",3,new ArrayList<>()));
        listcuadernos.add(new Cuaderno("Cuaderno tareas 4","Este es el cuaderno 4 jijija",1,new ArrayList<>()));
        listcuadernos.add(new Cuaderno("Cuaderno deudores 5","Los que me deben billullo",4,new ArrayList<>()));
        listcuadernos.add(new Cuaderno("No se como llamar este cuaderno","No se como llamarlo, ahora voy a saber que poner aqui apue",3,new ArrayList<>()));
        listcuadernos.add(new Cuaderno("Calculo integral","Ps es de calculo integral\n\n\n\n\n\n\n",5,new ArrayList<>()));
    }

    private void FinalizarActivity() {
        finish();
    }
}
