package com.limmihee.seouls;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Todo_list extends AppCompatActivity {

    Button todo_add_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        todo_add_btn = (Button) findViewById(R.id.Todo_print);
        todo_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Todo_list.this,todo_add.class);
                startActivity(intent);
            }
        });

    }
}
