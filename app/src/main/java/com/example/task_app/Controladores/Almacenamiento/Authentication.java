package com.example.task_app.Controladores.Almacenamiento;

import com.google.firebase.auth.FirebaseAuth;

public class Authentication {



    /**
     * Cerrar la sesión de un usuario
     * */
    public static boolean signOut(){
        try {
            FirebaseAuth.getInstance().signOut();
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
