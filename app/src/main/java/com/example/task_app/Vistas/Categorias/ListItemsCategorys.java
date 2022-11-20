package com.example.task_app.Vistas.Categorias;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.task_app.Modelos.Categories;
import com.example.task_app.Modelos.Task;
import com.example.task_app.R;

import java.util.ArrayList;
import java.util.List;

public class ListItemsCategorys {

    public static List<Categories> listCategorias = new ArrayList<>();

    public static void llenarArreglo(){
        List<Task> tareas1 = new ArrayList<>();
        tareas1.add(new Task("tarea 1"));
        tareas1.add(new Task("tarea 1"));
        tareas1.add(new Task("tarea 1"));
        tareas1.add(new Task("tarea 1"));

        List<Task> tareas2 = new ArrayList<>();
        tareas2.add(new Task("tarea 1"));
        tareas2.add(new Task("tarea 1"));

        List<Task> tareas3 = new ArrayList<>();
        tareas3.add(new Task("tarea 1"));
        tareas3.add(new Task("tarea 1"));
        tareas3.add(new Task("tarea 1"));
        tareas3.add(new Task("tarea 1"));
        tareas3.add(new Task("tarea 1"));
        tareas3.add(new Task("tarea 1"));

        List<Task> tareas4 = new ArrayList<>();
        tareas4.add(new Task("tarea 1"));
        tareas4.add(new Task("tarea 1"));
        tareas4.add(new Task("tarea 1"));

        List<Task> tareas5 = new ArrayList<>();
        tareas5.add(new Task("tarea 1"));
        tareas5.add(new Task("tarea 1"));
        tareas5.add(new Task("tarea 1"));
        tareas5.add(new Task("tarea 1"));
        tareas5.add(new Task("tarea 1"));
        tareas5.add(new Task("tarea 1"));
        tareas5.add(new Task("tarea 1"));
        tareas5.add(new Task("tarea 1"));
        tareas5.add(new Task("tarea 1"));

        List<Task> tareas6 = new ArrayList<>();
        tareas6.add(new Task("tarea 1"));
        tareas6.add(new Task("tarea 1"));
        tareas6.add(new Task("tarea 1"));
        tareas6.add(new Task("tarea 1"));
        tareas6.add(new Task("tarea 1"));
        tareas6.add(new Task("tarea 1"));
        tareas6.add(new Task("tarea 1"));


        listCategorias.add(new Categories("Tareas de matematicas",1,tareas1));
        listCategorias.add(new Categories("Tareas de la casa",2,tareas2));
        listCategorias.add(new Categories("Tareas de de la universidad",3,tareas3));
        listCategorias.add(new Categories("Tareas de la junta",4,tareas4));
        listCategorias.add(new Categories("Tareas de DevOps",2,tareas5));
        listCategorias.add(new Categories("Tareas de Sociales",3,tareas6));
    }

}
