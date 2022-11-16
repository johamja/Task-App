package com.example.task_app.Modelos;

import androidx.core.content.ContextCompat;

public class Categories {

    private String nombre;
    private int color;


    public Categories(String nombre, int color) {
        this.nombre = nombre;
        this.color = color;
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
}
