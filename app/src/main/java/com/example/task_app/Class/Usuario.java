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

    public void Cargar_usuario(){
        try {
            
        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cargar usuario."+e);
        }
    }

    public void cerrar_sesion(){
        try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cerrar sesion."+e);
        }
    }
    
    public void cambiar_correo(String correo){
        try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar correo."+e);
        }
    }

    public void cambiar_telefono(int numtelefono){
        try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar telefono."+e);
        }
    }

    public void cambiar_nombre(String nombre){
                try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar nombre."+e);
        }
    }
    
    public void cambiar_apellido(String apellido){
        try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar apellido."+e);
        }
    }

    public void cambiar_imagen(Image imagen){
        try {

        } catch (Exception e) {
            throw new Exception("Ocurrio un error al cambiar imagen."+e);
        }
    }

    //CAMBIAR CONTRASEÑA NO ES UN METODO 100% A HACER.
    //--------------------------------------------------------------------------------
    public void cambiar_contraseña(String contraseña){
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
