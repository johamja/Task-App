package com.example.task_app.Vistas.Tareas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.task_app.Modelos.Task;
import com.example.task_app.R;
import com.example.task_app.Vistas.Categorias.ListItemsCategorys;

import java.text.MessageFormat;
import java.util.Calendar;

public class AddTask extends AppCompatActivity {

    private Bundle bundle;
    private Task task;
    private Button calendario;
    private TextView fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        //bundle = getIntent().getExtras();
        //task = ListItemsCategorys.listCategorias.get(bundle.getInt("Categoria")).getTareas().get(bundle.getInt("Tarea"));

        calendario = findViewById(R.id.activity_add_task_10);
        fecha = findViewById(R.id.activity_add_task_9);


        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddTask.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fecha.setText(MessageFormat.format("{0} / {1} / {2}", dayOfMonth, month+1, String.valueOf(year)));
                    }
                },year,mes,dia);
                datePickerDialog.show();
            }
        });

    }



}