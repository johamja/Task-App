package com.example.task_app.Modelos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

public class Nota implements Comparable, Serializable {
    private String ID;
    private int tema;
    private String texto;
    private Date fecha_creacion;
    private Date fecha_modificacion;

    //Constructores

    public Nota(String id, int tema, String texto, Date fecha_creacion) throws Exception {
        setID(id);
        setTema(tema);
        setFecha_creacion(fecha_creacion);
    }

    public Nota(String id, int tema, String texto, Date fecha_creacion, Date fecha_modificacion) throws Exception {
        setID(id);
        setTema(tema);
        setFecha_creacion(fecha_creacion);
        setFecha_modificacion(fecha_modificacion);
    }


    //Constructor de prueba
    public Nota(String texto,int tema) throws Exception {
        setFecha_modificacion(new Date(1220227200));
        setTema(tema);
        setTexto(texto);
    }

    //Metodos
    public void Eliminar(){
        //? LLamar a estatico del cuaderno contenedor??
    }


    public void Modificar_tema(int tema) throws Exception {

        setTema(tema);
    }
    public void Modificar_Fmodificacion(Date fecha) throws Exception {
        setFecha_modificacion(fecha);
    }
    public void Modificar_texto(String texto) throws Exception {
        setTexto(texto);
    }

    //Getters
    public String getID() {
        return ID;
    }

    public int getTema() {
        return tema;
    }
    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }
    public String getTexto() {
        return texto;
    }


    //Setters
    public void setID(String ID) {
        //Establecer reglas para el ID.
        this.ID = ID;
    }
    public void setTexto(String texto) throws Exception {
        if(texto.length()>=1) this.texto = texto;
        else throw new Exception("La nota debe contener al menos un caracter.");
    }
    public void setTema(int tema) throws Exception {
        this.tema = tema;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    public void setFecha_modificacion(Date fecha_modificacion) throws Exception {
        this.fecha_modificacion = fecha_modificacion;
        /*
        if(fecha_modificacion.compareTo(fecha_creacion)>=0) this.fecha_modificacion = fecha_modificacion;
        else throw new Exception("La fecha de modificacion no puede ser menor a la fecha de creacion.");
         */

    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
