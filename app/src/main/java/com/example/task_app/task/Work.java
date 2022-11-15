package com.example.task_app.task;

public class Work {
   private  int id_work;
   private String nombre;
   private String fecha;
   private String desc;

   public Work(){


   }
   public Work(int id, String nom, String fec, String des){
        this.id_work=id;
        this.nombre = nom;
        this.fecha = fec;
        this.desc = des;
   }

    public int getId_work() {
        return id_work;
    }

    public void setId_work(int id_work) {
        this.id_work = id_work;
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
