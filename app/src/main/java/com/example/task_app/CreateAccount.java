package com.example.task_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.task_app.databinding.ActivityCreateAccountBinding;
import com.example.task_app.databinding.ActivitySignInBinding;

public class CreateAccount extends AppCompatActivity {

    private ActivityCreateAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}