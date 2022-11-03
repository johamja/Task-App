package com.example.task_app.Class;

import java.util.Comparator;
import java.util.Date;

public class Nota implements Comparable {
    private String ID;
    private String tema;
    private String texto;
    private Date fecha_creacion;
    private Date fecha_modificacion;

    //Constructores
    public Nota(String id, String tema, String texto, Date fecha_creacion) throws Exception {
        setID(id);
        setTema(tema);
        setFecha_creacion(fecha_creacion);
    }
    public Nota(String id, String tema, String texto, Date fecha_creacion, Date fecha_modificacion) throws Exception {
        setID(id);
        setTema(tema);
        setFecha_creacion(fecha_creacion);
        setFecha_modificacion(fecha_modificacion);
    }

    //Metodos
    public void Eliminar(){
        //? LLamar a estatico del cuaderno contenedor??
    }

    public void Modificar_tema(String tema) throws Exception {
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
    public String getTema() {
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
    public void setTema(String tema) throws Exception {
        if(tema.charAt(0)=='#'&&tema.length()>=2)this.tema = tema;
        else throw new Exception("El tema seleccionado es invalido.");
    }
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    public void setFecha_modificacion(Date fecha_modificacion) throws Exception {
        if(fecha_modificacion.compareTo(fecha_creacion)>=0) this.fecha_modificacion = fecha_modificacion;
        else throw new Exception("La fecha de modificacion no puede ser menor a la fecha de creacion.");
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
