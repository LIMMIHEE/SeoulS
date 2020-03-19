package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.MapView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Athletics_sports extends AppCompatActivity implements AthleticsSports {
    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;

//    private OnItamClickListener mListner;
//    public interface OnItamClickListener{
//        void OnItamListener(int position);
//    }
//    public void setOnItamClickListener(OnItamClickListener listener){
//        mListner = listener;
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletics_sports);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        Button Arhletics_main_btn = (Button) findViewById(R.id.BackButton);
        Arhletics_main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               Intent intent = new Intent(Athletics_sports.this, MainActivity.class);
                startActivity(intent);
            }
        });


        View Card_View = (View) findViewById(R.id.Apuar_sports);
        Card_View.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("테니스");
                Intent intent = new Intent(Athletics_sports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_1 = (View) findViewById(R.id.Apuar_sports_1);
        Card_View_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("배드민턴");
                Intent intent = new Intent(Athletics_sports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_2 = (View) findViewById(R.id.Apuar_sports_3);
        Card_View_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("양궁");
                Intent intent = new Intent(Athletics_sports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_3 = (View) findViewById(R.id.Apuar_sports_4);
        Card_View_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("야구");
                Intent intent = new Intent(Athletics_sports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_4 = (View) findViewById(R.id.Apuar_sports_5);
        Card_View_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("배구");
                Intent intent = new Intent(Athletics_sports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_5 = (View) findViewById(R.id.Apuar_sports_6);
        Card_View_5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("족구");
                Intent intent = new Intent(Athletics_sports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_6 = (View) findViewById(R.id.Apuar_sports_7);
        Card_View_6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("축구");
                Intent intent = new Intent(Athletics_sports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_7 = (View) findViewById(R.id.Apuar_sports_8);
        Card_View_7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("농구");
                Intent intent = new Intent(Athletics_sports.this, Details_info.class);
                startActivity(intent);
            }
        });
        View Card_View_8 = (View) findViewById(R.id.Apuar_sports_9);
        Card_View_8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동").setValue("인라인");
                Intent intent = new Intent(Athletics_sports.this, Details_info.class);
                startActivity(intent);
            }
        });
    }



}
