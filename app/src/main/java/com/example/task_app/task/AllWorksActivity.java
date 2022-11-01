package com.example.task_app.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.task_app.R;

public class AllWorksActivity extends AppCompatActivity {
    Button btn_newtask;
    ListView listWorks;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_works);

        btn_newtask = (Button) findViewById(R.id.btn_newtask);

        btn_newtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewWorkActivity.class);
                startActivity(intent);
            }
        });

        listWorks = (ListView) findViewById(R.id.list_works);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listWorks.setAdapter(adapter);
    }
}