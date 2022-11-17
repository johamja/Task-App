package com.example.task_app.Modelos;

import androidx.core.content.ContextCompat;

import java.util.List;

public class Categories {

    private String nombre;
    private int color;
    private List<Task> tareas;


    public Categories(String nombre, int color, List<Task> tareas) {
        this.nombre = nombre;
        this.color = color;
        this.tareas = tareas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public List<Task> getTareas() {
        return tareas;
    }

    public void setTareas(List<Task> tareas) {
        this.tareas = tareas;
    }
}
