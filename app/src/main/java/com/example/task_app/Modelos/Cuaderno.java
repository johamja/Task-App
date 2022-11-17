package com.example.task_app.Modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Cuaderno implements Serializable {
    private String ID;
    private String nombre;
    private String descripcion;
    private int tema; //El color en Hexadecimal.
    private ArrayList<Nota> listadenotas;

    //Constructores
    public Cuaderno(String ID,String nombre, String descripcion, int tema) throws Exception {
        setID(ID);
        setNombre(nombre);
        setDescripcion(descripcion);
        setTema(tema);
    }
    public Cuaderno(String ID,String nombre, String descripcion, int tema,ArrayList<Nota> lista) throws Exception {
        setID(ID);
        setNombre(nombre);
        setDescripcion(descripcion);
        setTema(tema);
        setListadenotas(lista);
    }
    //Constructor de prueba
    public Cuaderno(String nombre, String descripcion, int tema, ArrayList<Nota> notas) throws Exception {
        setNombre(nombre);
        setDescripcion(descripcion);
        setTema(tema);
        setListadenotas(notas);
    }

    //Metodos
    public void Organizar(String orden){
        //AAAA
    }
    public void Eliminar(){

    }
    public void Eliminar_nota(){
        //NO SE CONOCE LA IMPLEMENTACION AL COMPLETO.
    }
    public void Cargar(String url) throws Exception {
        try{
            ArrayList<Nota> Ntemp = new ArrayList<>();
            //Hacer operaciones de lectura de lineas e ingresar en el arrayList.
            /*
             */

            setListadenotas(Ntemp);
        }
        catch(Exception ex){
            throw new Exception("Ocurrio un error al cargar las notas en el cuaderno "+nombre+": "+ex);
        }
    }


    public void Modificar_nombre(String nombre) throws Exception {
        setNombre(nombre);
    }
    public void Modificar_descripcion(String descripcion) throws Exception {
        setDescripcion(descripcion);
    }
    public void Modificar_tema(int tema) throws Exception {
        setTema(tema);
    }



    //Getters
    public String getID() {
        return ID;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getTema() {
        return tema;
    }
    public ArrayList<Nota> getListadenotas() {
        return listadenotas;
    }


    //Setters
    public void setID(String ID) {
        //Establecer reglas para el ID del cuaderno.
        this.ID = ID;
    }
    public void setNombre(String nombre) throws Exception {
        if(nombre.length()>=1)this.nombre = nombre;
        else throw new Exception("El nombre debe tener al menos un caracter.");
    }
    public void setDescripcion(String descripcion) throws Exception {
        if(descripcion.length()>0) this.descripcion = descripcion;
        else throw new Exception("La descripcion no puede estar vacia.");
    }
    public void setTema(int tema) throws Exception {
        if(tema>=0) this.tema = tema;
        else throw new Exception("El tema seleccionado es invalido.");
    }
    public void setListadenotas(ArrayList<Nota> listadenotas) {
        //Normalmente no deberia de haber ningun problema al setear la lista.
        this.listadenotas = listadenotas;
    }
}
