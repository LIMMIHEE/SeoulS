package com.limmihee.seouls;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Todo_list extends AppCompatActivity {

    Button todo_add_btn;
    LinearLayout layout;
    Context context;

    ArrayList<TODO> todo_list = new ArrayList<TODO>();

    private LayoutInflater layoutInflater;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("TODO");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        context=this;
        layout = (LinearLayout) findViewById(R.id.Todo_list);
        todo_add_btn = (Button) findViewById(R.id.Todo_print);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    CreateTODO(dataSnapshot1.child("info").getValue().toString(),
                            dataSnapshot1.child("name").getValue().toString(),
                            dataSnapshot1.child("time").getValue().toString());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




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
