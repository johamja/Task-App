package com.example.task_app.Modelos;

public class Work {
   private String nombre;
   private String fecha;
   private String desc;

   public Work(){


   }
   public Work(String nom, String fec, String des){
        this.nombre = nom;
        this.fecha = fec;
        this.desc = des;
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
