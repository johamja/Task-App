package com.example.task_app.Modelos;

public class Task {

    private String Nombre;

    public Task(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
