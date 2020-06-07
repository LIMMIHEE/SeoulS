package com.limmihee.seouls;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Todo_list extends AppCompatActivity {

    Button todo_add_btn;
    LinearLayout layout;

    private LayoutInflater layoutInflater;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        layout = (LinearLayout) findViewById(R.id.Todo_list);
        todo_add_btn = (Button) findViewById(R.id.Todo_print);

        CreateTODO("f","f","2");



        todo_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Todo_list.this,todo_add.class);
                startActivity(intent);
            }
        });

    }
    private void CreateTODO(String name, String info, String time){
        layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.todo_item,null);

        CardView cardView ;
        TextView name_text= view.findViewById(R.id.name);
        TextView info_text= view.findViewById(R.id.info_todo);
        TextView time_text= view.findViewById(R.id.time_todo);

        name_text.setText(name);
        info_text.setText(info);
        time_text.setText(time);

        layout.addView(view);

    }
}
