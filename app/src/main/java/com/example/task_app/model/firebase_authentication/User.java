package com.example.task_app.model.firebase_authentication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class User {

    private static FirebaseAuth mAuth;

    public static String Email(){
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        assert user != null;
        return user.getEmail();
    }

    public static Boolean UserExists(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        return currentUser != null;
    }
}
