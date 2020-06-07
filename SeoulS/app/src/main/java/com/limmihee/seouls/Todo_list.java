package com.limmihee.seouls;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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
        View view = layoutInflater.inflate(R.layout.item, container, false);

        CardView cardView ;
        TextView name_text;
        TextView info_text;
        TextView time_text;


    }
}
