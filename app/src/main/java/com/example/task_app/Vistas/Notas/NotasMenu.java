package com.example.task_app.Vistas.Notas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.task_app.Modelos.Cuaderno;
import com.example.task_app.Modelos.Nota;
import com.example.task_app.Modelos.na_AdapterNotas;
import com.example.task_app.R;
import com.example.task_app.Vistas.Categorias.CategoryList;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class NotasMenu extends AppCompatActivity {

    public ArrayList<Nota> listnotas = new ArrayList<>();
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


        // editar una nota
        new ItemTouchHelper(EditarNota).attachToRecyclerView(recycler);

        //Toast.makeText(getApplicationContext(), String.valueOf(cuaderno.getListadenotas().isEmpty()), Toast.LENGTH_SHORT).show();
        na_AdapterNotas adaptador = new na_AdapterNotas(this,listnotas);
        recycler.setAdapter(adaptador);

        //Salir
        bck = findViewById(R.id.nm_backbutton);
        bck.setOnClickListener(view -> FinalizarActivity());
    }

    ItemTouchHelper.SimpleCallback EditarNota = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Nota nota = listnotas.get(viewHolder.getAbsoluteAdapterPosition());
            Intent intent = new Intent(NotasMenu.this,nota_edit.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("nota",nota);
            intent.putExtras(bundle);
            startActivity(intent);
            recycler.getAdapter().notifyDataSetChanged();
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addCornerRadius(1, 10)
                    .addBackgroundColor(ContextCompat.getColor(NotasMenu.this, R.color.Color_Cuaternario))
                    .addActionIcon(R.drawable.ic_baseline_edit_24)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };

    private void FinalizarActivity() {
        finish();
    }
}