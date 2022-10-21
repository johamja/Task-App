package com.example.task_app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.task_app.databinding.ActivityMainBinding;

public class Loguin extends AppCompatActivity { // implementar el extends para que funcionen los layouts tambien en el XML

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // inicia el layout

    }

}
