package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class todo_add extends AppCompatActivity {
    TODO todo;

    Button Close_btn;
    Button todo_send_btn;

    EditText name;
    EditText info;
    EditText time;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_add);

        name = (EditText) this.findViewById(R.id.editText2);
        info = (EditText) this.findViewById(R.id.editText4);
        time = (EditText) this.findViewById(R.id.editText5);

        Close_btn = (Button) findViewById(R.id.Close_btn);
        Close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        todo_send_btn = (Button) findViewById(R.id.todo_send);
        todo_send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().length() <= 0 || info.getText().toString().length() <= 0
                        || time.getText().toString().length() <= 0){
                    Toast.makeText(todo_add.this, "모든 칸을 입력하세요.", Toast.LENGTH_SHORT).show();
                }else{
                    todo = new TODO(name.getText().toString(),info.getText().toString(),Integer.parseInt(time.getText().toString()));
                    databaseReference.child("TODO").child(name.getText().toString()).setValue(todo);

                    Intent intent = new Intent(todo_add.this, Todo_list.class);
                    startActivity(intent);
                }
            }
        });
    }
}
