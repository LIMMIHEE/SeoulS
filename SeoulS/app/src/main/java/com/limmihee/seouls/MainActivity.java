package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        {
//            databaseReference.child("육상").child("테니스").push().setValue("테니스");
//            databaseReference.child("육상").child("테니스").push().setValue("라켓스포츠");
//            databaseReference.child("육상").child("테니스").push().setValue("원 바운드 또는 노 바운드로 공을 쳐 득점 양으로 승부를 가르는 운동");
//            databaseReference.child("육상").child("테니스").push().setValue("두 가지의 게임 방식이 있다, 1:1 단식과 2:2 복식으로 구분된다. " +
//                    "심리전 게임이라고 불릴 만큼 정신적인 부분도 상강히 중요한 스포츠 이다. ");
//
//            databaseReference.child("육상").child("배드민턴").push().setValue("배드민턴");
//            databaseReference.child("육상").child("배드민턴").push().setValue("라켓스포츠");
//            databaseReference.child("육상").child("배드민턴").push().setValue("네트를 사이에 두고 라켓으로 셔틀콕을 쳐서 주고받는 운동");
//            databaseReference.child("육상").child("배드민턴").push().setValue("바람이 불면 경기가 제대로 진행 되지 않기 때문에 실내 운동이며, " +
//                    "콕의 속도 또한 상당히 빨라 구속이 빠른 경기로 기네스북에 등제되어 있는 스포츠이기도 하다.  ");
//
//            databaseReference.child("육상").child("양궁").push().setValue("양궁");
//            databaseReference.child("육상").child("양궁").push().setValue("궁술");
//            databaseReference.child("육상").child("양궁").push().setValue("일정 거리 이상 떨어진 과녁에 화살을 맞히는 운동");
//            databaseReference.child("육상").child("양궁").push().setValue("현재 올핌픽에는 남녀 잔체전, 개인전 4가지 이며 전 세계적으로 민족의" +
//                    " 풍토나 풍습에 따라 다양하게 변형되어 있다.");
//
//            databaseReference.child("육상").child("야구").push().setValue("야구");
//            databaseReference.child("육상").child("야구").push().setValue("구기 종목");
//            databaseReference.child("육상").child("야구").push().setValue("9명씩 이룬 두 팀이 9회씩 공격과 수비를 번갈아 하며 승패를 겨루는 구기 경기");
//            databaseReference.child("육상").child("야구").push().setValue("두 침이 방망이와 공과 글러브를 사용해 겨루는 구기 종목이며, 공격과 수비가 완전히" +
//                    "분이 되어 있는 스포츠 이다.");
//
//            databaseReference.child("육상").child("배구").push().setValue("배구");
//            databaseReference.child("육상").child("배구").push().setValue("구기 종목");
//            databaseReference.child("육상").child("배구").push().setValue("6명 또는 9명으로 구성괸 두 팀이 네트가 있는 코트에서 공을 쳐가며 겨루는 운동");
//            databaseReference.child("육상").child("배구").push().setValue(" 두 팀간에 네트를 사이에 두고 볼을 바닥에 떨어트리지 않고 서로 받아쳐 마지막엔 상대의" +
//                    "팀 코트에 떨어트릴 경우 점수를 얻게 된다. ");
//
//            databaseReference.child("육상").child("족구").push().setValue("족구");
//            databaseReference.child("육상").child("족구").push().setValue("구기 종목");
//            databaseReference.child("육상").child("족구").push().setValue("각팀 4명이 네트를 사이에 두고 발과 머리를 사용해 수비 공격을 하는 스포츠.");
//            databaseReference.child("육상").child("족구").push().setValue("한국에서 만들어진 스포츠이며 각 팀 4명이 포지션을 담당해 네트를 사이에 두고" +
//                    "발과 머리 만 사용해 공격과 수비를 주고 받는 스포츠이다.");
//
//            databaseReference.child("육상").child("축구").push().setValue("축구");
//            databaseReference.child("육상").child("축구").push().setValue("구기 종목");
//            databaseReference.child("육상").child("축구").push().setValue("11명의 선수들이 각각 한 팀을 이루어 두 팀이 겨루는 구기 스포츠");
//            databaseReference.child("육상").child("축구").push().setValue("경기장 양 끝의 골대에 공을 통과시키면 득점이다. 선수 중 골키퍼만 팔과 손으로도 공을 건드릴 수 있지만," +
//                    "활동 구역이 제한되어 있으며. 다른 선수들은 경기장안에서 공을 고의로 만지면 핸드볼 반칙이 된다.");
//
//            databaseReference.child("육상").child("농구").push().setValue("농구");
//            databaseReference.child("육상").child("농구").push().setValue("구기 종목");
//            databaseReference.child("육상").child("농구").push().setValue("손을 주로 사용하며 다리를 제외한 신체부위 접촉이 허용되는 스포츠");
//            databaseReference.child("육상").child("농구").push().setValue("실내에서 즐기는 스포츠이며, 양팀의 5명[기본적으로]의 선수가 한 개의 공을" +
//                    "다른 팀의 바구니 안에 던져 넣는 스포츠 이다.");
//
//
//            databaseReference.child("육상").child("인라인").push().setValue("인라인");
//            databaseReference.child("육상").child("인라인").push().setValue("_");
//            databaseReference.child("육상").child("인라인").push().setValue("손을 주로 사용하며 다리를 제외한 신체부위 접촉이 허용되는 스포츠");
//            databaseReference.child("육상").child("인라인").push().setValue("해당 장소에서 즐길 수 있는 인라인은 일반적인 스케이트 입니다. ");
//
//
//        }
//

        Button aqua_main_btn = (Button) findViewById(R.id.aqua_sports_btn);
        aqua_main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, AquaticSports.class);
                startActivity(intent);
            }
        });

        Button Arhletics_main_btn = (Button) findViewById(R.id.athletics_sports_btn);
        Arhletics_main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Athletics_sports.class);
                startActivity(intent);
            }
        });

        Button ALLBtn = (Button) findViewById(R.id.park_sports_btn);
        ALLBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Exercise_page.class);
                startActivity(intent);
            }
        });


    }





//    ImageView imageView = (ImageView) findViewById(R.id.CardImage);
//    GradientDrawable drawable= (GradientDrawable) getApplicationContext().getDrawable(R.drawable.card_corner_radius);
//    imageView.setBackground(drawable);
//    imageView.setClipToOutline(true);

}
