package com.limmihee.seouls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Details_info extends AppCompatActivity {
    Current_usage_sports usage_sports;

    String sports_name_Fire;

    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;



    TextView Sports_name;
    TextView Spl_name;
    TextView Spl_info;
    TextView Details_info_;

    String name;
    String photo;
    String simple_info;
    String event;
    String detail_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info);

        Sports_name = (TextView) findViewById(R.id.Sports_Name);
        Spl_name = (TextView) findViewById(R.id.simple_name);
        Spl_info = (TextView) findViewById(R.id.simple_info);
        Details_info_ = (TextView) findViewById(R.id.Detalis_info);


        firebaseDatabase = FirebaseDatabase.getInstance();
          databaseReference = firebaseDatabase.getReference();
          databaseReference.child("현재운동").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                sports_name_Fire=dataSnapshot.getValue(String.class);

                databaseReference=firebaseDatabase.getReference().child("육상").child(sports_name_Fire);
                databaseReference.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        name=dataSnapshot.child("name").getValue().toString();
                        photo=dataSnapshot.child("photo_name").getValue().toString();
                        simple_info=dataSnapshot.child("simple_info").getValue().toString();
                        event=dataSnapshot.child("event").getValue().toString();
                        detail_info=dataSnapshot.child("detail_info").getValue().toString();


                        Sports_name.setText(name);
                        Spl_name.setText(event);
                        Spl_info.setText(simple_info);
                        Details_info_.setText(detail_info);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



//        Spl_name.setText(sp_name);
//        Spl_info.setText(info);
//        Details_info_.setText(D_info);
    }


}
