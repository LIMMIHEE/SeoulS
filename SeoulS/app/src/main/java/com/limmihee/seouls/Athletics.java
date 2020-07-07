package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Athletics extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;

    LinearLayout layout;
    Context context;


    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletics);

        context=this;
        layout = (LinearLayout) findViewById(R.id.athletics_list);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        CreateAthletics_sports("테니스","라켓 스포츠","원 바운드 또는 노 바운드로 공을 쳐 득점 양으로 승부를 가르는 구기 경기","tennis");
        CreateAthletics_sports("배드민턴","라켓 스포츠","네트를 사이에 두고 라켓으로 셔틀콕을 쳐서 주고받는 운동","badminton");
        CreateAthletics_sports("양궁","궁술","일정 거리 이상 떨어진 과녁에 화살을 맞히는 운동","archery");
        CreateAthletics_sports("야구","구기 종목","9명씩 이룬 두 팀이 9회씩 공격과 수비를 번갈아 하며 승패를 겨루는 구기 경기","baseball");
        CreateAthletics_sports("배구","구기 종목","6명 또는 9명으로 구성괸 두 팀이 네트가 있는 코트에서 공을 쳐가며 겨루는 운동","volleyball");
        CreateAthletics_sports("족구","구기 종목","각팀 4명이 네트를 사이에 두고 발과 머리를 사용해 수비 공격을 하는 운동","foot_volleyball");
        CreateAthletics_sports("축구","구기 종목","11명의 선수들이 각각 한 팀을 이루어 두 팀이 겨루는 구기 운동","soccer");
        CreateAthletics_sports("농구","구기 종목","손을 주로 사용하며 다리를 제외한 신체부위 접촉이 허용되는 운동","basketball");
        CreateAthletics_sports("인라인","-","한 줄로 이루어진 바퀴가 밑 창에 있는 신발을 이용해 즐기는 운동","inline");

    }

    private void CreateAthletics_sports(final String name, String info, String info_l,String img_String){
        layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.activity_ani_test,null);

        CardView cardView ;
        TextView name_text= view.findViewById(R.id.name);
        TextView info_text= view.findViewById(R.id.info_s);
        TextView time_text= view.findViewById(R.id.info_l);
        ImageView imageView = view.findViewById(R.id.imageView7);

        name_text.setText(name);
        info_text.setText(info);
        time_text.setText(info_l);
        imageView.setImageResource(getResources().getIdentifier("com.limmihee.seouls:drawable/"+img_String,null,null));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("현재운동").setValue(name);
                Intent intent = new Intent(Athletics.this,Details_info.class);
                startActivity(intent);
            }
        });

        layout.addView(view);

    }
}
