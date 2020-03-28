package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AquaticSports extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquatic_sports);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        Button Arhletics_main_btn = (Button) findViewById(R.id.BackButton);
        Arhletics_main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(AquaticSports.this, MainActivity.class);
                startActivity(intent);
            }
        });


        View Card_View = (View) findViewById(R.id.Apuar_sports);
        Card_View.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("잠실 한강공원");
                Intent intent = new Intent(AquaticSports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_1 = (View) findViewById(R.id.Apuar_sports_1);
        Card_View_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("뚝섬 한강공원");
                Intent intent = new Intent(AquaticSports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_2 = (View) findViewById(R.id.Apuar_sports_3);
        Card_View_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("반포 한강공원");
                Intent intent = new Intent(AquaticSports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_3 = (View) findViewById(R.id.Apuar_sports_4);
        Card_View_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("이촌 한강공원");
                Intent intent = new Intent(AquaticSports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_4 = (View) findViewById(R.id.Apuar_sports_5);
        Card_View_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("여의도 한강공원");
                Intent intent = new Intent(AquaticSports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_5 = (View) findViewById(R.id.Apuar_sports_6);
        Card_View_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("양화 한강공원");
                Intent intent = new Intent(AquaticSports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_6 = (View) findViewById(R.id.Apuar_sports_7);
        Card_View_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("망원 한강공원");
                Intent intent = new Intent(AquaticSports.this, Details_info.class);
                startActivity(intent);
            }
        });
    }
}
