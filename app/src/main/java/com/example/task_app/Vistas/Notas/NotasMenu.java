package com.example.task_app.Vistas.Notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task_app.Modelos.Cuaderno;
import com.example.task_app.Modelos.Nota;
import com.example.task_app.Modelos.na_AdapterCuadernos;
import com.example.task_app.Modelos.na_AdapterNotas;
import com.example.task_app.R;

import java.util.ArrayList;

public class NotasMenu extends AppCompatActivity {

    ArrayList<Nota> listnotas = new ArrayList<>();
    RecyclerView recycler;
    TextView title;
    ImageView bck,menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_menu);

        Bundle objetoenviado = getIntent().getExtras();
        Cuaderno cuaderno=null;
        if(objetoenviado!=null){
            cuaderno = (Cuaderno) objetoenviado.getSerializable("Cuaderno");
            listnotas = cuaderno.getListadenotas();
        }
        title = findViewById(R.id.nm_titlecuaderno2);
        title.setText(cuaderno.getNombre().toCharArray(),0,cuaderno.getNombre().length());

        recycler = findViewById(R.id.an_recyclerv);
        recycler.setLayoutManager(new LinearLayoutManager(this));


        //Toast.makeText(getApplicationContext(), String.valueOf(cuaderno.getListadenotas().isEmpty()), Toast.LENGTH_SHORT).show();
        na_AdapterNotas adaptador = new na_AdapterNotas(this,listnotas);
        recycler.setAdapter(adaptador);

        //Salir
        bck = findViewById(R.id.nm_backbutton);
        bck.setOnClickListener(view -> FinalizarActivity());


    }

    private void FinalizarActivity() {
        finish();
    }
}