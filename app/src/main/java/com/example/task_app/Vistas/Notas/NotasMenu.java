package com.example.task_app.Vistas.Notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.task_app.Modelos.Cuaderno;
import com.example.task_app.Modelos.Nota;
import com.example.task_app.Modelos.na_AdapterNotas;
import com.example.task_app.R;

import java.util.ArrayList;

public class NotasMenu extends AppCompatActivity {

    ArrayList<Nota> listnotas = new ArrayList<>();
    RecyclerView recycler;
    TextView title,cantnotas,descripcion;
    ImageView bck,menu;
    CardView crdview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_menu);
        cantnotas = findViewById(R.id.bn_cantnot);
        descripcion = findViewById(R.id.bn_descripciones);

        Bundle objetoenviado = getIntent().getExtras();
        Cuaderno cuaderno=null;
        if(objetoenviado!=null){
            cuaderno = (Cuaderno) objetoenviado.getSerializable("Cuaderno");
            listnotas = cuaderno.getListadenotas();
        }
        title = findViewById(R.id.nm_titlecuaderno2);
        title.setText(cuaderno.getNombre().toCharArray(),0,cuaderno.getNombre().length());
        cantnotas.setText("Cantidad de notas: "+ String.valueOf(cuaderno.getListadenotas().size()));
        descripcion.setText(cuaderno.getDescripcion());
        crdview = findViewById(R.id.bn_cardView4);
        int color = 0;
        switch (cuaderno.getTema()){
            case 1: color = ContextCompat.getColor(this,R.color.Color_Primario); break;
            case 2: color = ContextCompat.getColor(this,R.color.Color_Secundario); break;
            case 3: color = ContextCompat.getColor(this,R.color.Color_Terciario); break;
            case 4: color = ContextCompat.getColor(this,R.color.Color_Cuaternario); break;
            default: color = ContextCompat.getColor(this,R.color.Color_Primario); break;
        }

        crdview.setCardBackgroundColor(color);

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