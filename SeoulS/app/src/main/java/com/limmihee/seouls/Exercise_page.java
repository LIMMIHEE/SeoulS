package com.limmihee.seouls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Exercise_page extends AppCompatActivity {
    private static final float FONT_SIZE = 19;
     LinearLayout container;

     int Get_this_id=0;


    String Now_sports;

    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;

    String sports_Field_Fire;
    String sports_name_Fire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_page);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.child("현재운동").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                sports_name_Fire=dataSnapshot.getValue(String.class);

                databaseReference.child("현재운동분야").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        sports_Field_Fire = dataSnapshot.getValue(String.class);
                        Now_sports = dataSnapshot.getValue(String.class);
                        databaseReference.child(sports_Field_Fire).child(sports_name_Fire).child("체험장소").child("companies_Name").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                GenericTypeIndicator<List<String>> t = new GenericTypeIndicator<List<String>>() {};
                                List<String> Companies = dataSnapshot.getValue(t);
                                int i = Companies.size();
                                for(int j=0; j<i; j++){
                                    textview(Companies.get(j));

                                }
                                Get_this_id++;
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        container=(LinearLayout) findViewById(R.id.Park_info);



//        textview(companies_Name.get(2));
        //textview("마포?");

        Button BackBtn = (Button) findViewById(R.id.BackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onBackPressed();
            }
        });
        Button menu_btn = (Button) findViewById(R.id.Menu_btn);
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Now_sports=="육상"){
                    Intent intent = new Intent(Exercise_page.this, Athletics_sports.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(Exercise_page.this, AquaticSports.class);
                    startActivity(intent);
                }
            }
        });
        Button main_btn = (Button) findViewById(R.id.main_btn);
        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(Exercise_page.this, MainActivity.class);
                    startActivity(intent);
            }
        });

    }

    public void textview(String AName){
        final String Name=AName;
        //TextView 생성
        TextView view1 = new TextView(this);
        view1.setId(Get_this_id);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("현재체험장소").setValue(Name);
                Intent intent = new Intent(Exercise_page.this, experience_companys.class);
                startActivity(intent);
            }
        });
        view1.setText(AName);
        view1.setBackgroundResource(R.drawable.btn_re_mian_red);
        view1.setTextSize(FONT_SIZE);
        view1.setPadding(20, 20, 20, 20);
        view1.setTypeface(null, Typeface.BOLD);
        view1.setLetterSpacing(0.2f);
        view1.setGravity(Gravity.CENTER);


        //layout_width, layout_height, gravity 설정
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.topMargin= 60;

        lp.width=660; lp.height=300;
        lp.setMarginStart(52);

        view1.setLayoutParams(lp);

        //부모 뷰에 추가
        container.addView(view1);
    }

//
//
}

