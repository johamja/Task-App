package com.example.task_app.Class;

import android.media.Image;

public class Usuario {
    private String Correo;
    private int NumeroTelefono;
    private String Apellido;
    private String Nombre;
    private String Contraseña; 
    private Image imagen;

    public Usuario(String correo, int numeroTelefono, String apellido, String nombre, String contraseña, Image imagen) {
        Correo = correo;
        NumeroTelefono = numeroTelefono;
        Apellido = apellido;
        Nombre = nombre;
        Contraseña = contraseña;
        this.imagen = imagen;

    }

    public void Crear_usuario() {
        
    }

    public void Cargar_usuario() throws Exception{
        try {
            // cargar de un archivo temporal 
        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cargar usuario."+e);
        }
    }

    public void cerrar_sesion() throws Exception{
        try {

            // bucaria el temporal 
            // lo elimina 
            // retorna a login
            // realiza finish() para que no pueda retroceder a la paginas abiertas antes
            // borren los datos ?? 

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cerrar sesion."+e);
        }
    }
    
    public void cambiar_correo(String correo)throws Exception{
        try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar correo."+e);
        }
    }

    public void cambiar_telefono(int numtelefono)throws Exception{
        try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar telefono."+e);
        }
    }

    public void cambiar_nombre(String nombre)throws Exception{
                try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar nombre."+e);
        }
    }
    
    public void cambiar_apellido(String apellido)throws Exception{
        try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar apellido."+e);
        }
    }

    public void cambiar_imagen(Image imagen)throws Exception{
        try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar imagen."+e);
        }
    }

    //CAMBIAR CONTRASEÑA NO ES UN METODO 100% A HACER.
    //--------------------------------------------------------------------------------
    public void cambiar_contraseña(String contraseña)throws Exception{
                try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar contraseña."+e);
        }
    }
    //--------------------------------------------------------------------------------

    public String getCorreo() {
        return Correo;
    }

    public int getNumeroTelefono() {
        return NumeroTelefono;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public Image getImagen() {
        return imagen;
    }

}
