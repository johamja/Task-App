package com.example.task_app.Vistas.Categorias;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.task_app.Modelos.Categories;
import com.example.task_app.R;

import java.util.ArrayList;
import java.util.List;

public class ListItemsCategorys {

    public static List<Categories> listCategorias = new ArrayList<>();

    public static void llenarArreglo(){
        listCategorias.add(new Categories("Tareas de matematicas",1));
        listCategorias.add(new Categories("Tareas de la casa",2));
        listCategorias.add(new Categories("Tareas de de la universidad",3));
        listCategorias.add(new Categories("Tareas de la junta",4));
        listCategorias.add(new Categories("Tareas de DevOps",2));
        listCategorias.add(new Categories("Tareas de Sociales",3));
    }

}
