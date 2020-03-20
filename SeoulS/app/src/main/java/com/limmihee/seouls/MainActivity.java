package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Sports_DB sports_db;
    experience_point experience_point;
    public companies companies_DB;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //databaseReference.child("현재운동").setValue("테니스");
        {
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("테니스");
//            experience_point = new experience_point();
//            experience_point.setName("");
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("테니스").child("체험장소");
//            companies_DB= new companies();
//            ArrayList <String> C_Name = new ArrayList<String>();
//            C_Name.add("뚝섬 한강공원");C_Name.add("잠원 한강공원");C_Name.add("이촌 한강공원");
//            C_Name.add("망원 한강공원");C_Name.add("광나루 한강공원");
//            companies_DB.setCompanies_Name(C_Name);
//            databaseReference.setValue(companies_DB);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("테니스");
//        sports_db= new Sports_DB();
//        sports_db.setName("테니스");
//        sports_db.setEvent("라켓스포츠");
//        sports_db.setPhoto_name("tennis");
//        sports_db.setSimple_info("원 바운드 또는 노 바운드로 공을 쳐 득점 양으로 승부를 가르는 운동");
//        sports_db.setDetail_info("두 가지의 게임 방식이 있다, 1:1 단식과 2:2 복식으로 구분된다. " +
//                    "심리전 게임이라고 불릴 만큼 정신적인 부분도 상강히 중요한 스포츠 이다. ");
//        databaseReference.setValue(sports_db);
//
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배드민턴").child("체험장소");
//            companies_DB= new companies();
//            ArrayList <String> C_Name = new ArrayList<String>();
//            C_Name.add("뚝섬 한강공원");C_Name.add("반포 한강공원");C_Name.add("이촌 한강공원");
//            companies_DB.setCompanies_Name(C_Name);
//            databaseReference.setValue(companies_DB);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배드민턴");
//        sports_db= new Sports_DB();
//        sports_db.setName("배드민턴");
//        sports_db.setEvent("라켓스포츠");
//        sports_db.setPhoto_name("badminton");
//        sports_db.setSimple_info("네트를 사이에 두고 라켓으로 셔틀콕을 쳐서 주고받는 운동");
//        sports_db.setDetail_info("바람이 불면 경기가 제대로 진행 되지 않기 때문에 실내 운동이며, " +
//           "콕의 속도 또한 상당히 빨라 구속이 빠른 경기로 기네스북에 등제되어 있는 스포츠이기도 하다.  ");
//            databaseReference.setValue(sports_db);
//
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("양궁").child("체험장소");
//            companies_DB= new companies();
//            C_Name = new ArrayList<String>();
//            C_Name.add("난지 한강공원");
//            companies_DB.setCompanies_Name(C_Name);
//            databaseReference.setValue(companies_DB);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("양궁");
//        sports_db= new Sports_DB();
//        sports_db.setName("양궁");
//        sports_db.setEvent("궁술");
//        sports_db.setPhoto_name("archery");
//        sports_db.setSimple_info("일정 거리 이상 떨어진 과녁에 화살을 맞히는 운동");
//        sports_db.setDetail_info("현재 올핌픽에는 남녀 잔체전, 개인전 4가지 이며 전 세계적으로 민족의" +
//                " 풍토나 풍습에 따라 다양하게 변형되어 있다.");
//            databaseReference.setValue(sports_db);
//
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("야구").child("체험장소");
//            companies_DB= new companies();
//            C_Name = new ArrayList<String>();
//            C_Name.add("망원 한강공원");C_Name.add("난지 한강공원");C_Name.add("광나루 한강공원");
//            companies_DB.setCompanies_Name(C_Name);
//            databaseReference.setValue(companies_DB);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("야구");
//        sports_db= new Sports_DB();
//        sports_db.setName("야구");
//        sports_db.setEvent("구기 종목");
//        sports_db.setPhoto_name("baseball");
//        sports_db.setSimple_info("9명씩 이룬 두 팀이 9회씩 공격과 수비를 번갈아 하며 승패를 겨루는 구기 경기");
//        sports_db.setDetail_info("두 침이 방망이와 공과 글러브를 사용해 겨루는 구기 종목이며, 공격과 수비가 완전히" +
//                "분이 되어 있는 스포츠 이다.");
//            databaseReference.setValue(sports_db);
//
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배구").child("체험장소");
//            companies_DB= new companies();
//            C_Name = new ArrayList<String>();
//            C_Name.add("잠실 한강공원");C_Name.add("잠원 한강공원");C_Name.add("이촌 한강공원");
//            C_Name.add("양화 한강공원");C_Name.add("망원 한강공원");C_Name.add("광나루 한강공원");
//            companies_DB.setCompanies_Name(C_Name);
//            databaseReference.setValue(companies_DB);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배구");
//        sports_db= new Sports_DB();
//        sports_db.setName("배구");
//        sports_db.setEvent("구기 종목");
//        sports_db.setPhoto_name("volleyball");
//        sports_db.setSimple_info("6명 또는 9명으로 구성괸 두 팀이 네트가 있는 코트에서 공을 쳐가며 겨루는 운동");
//        sports_db.setDetail_info(" 두 팀간에 네트를 사이에 두고 볼을 바닥에 떨어트리지 않고 서로 받아쳐 마지막엔 상대의" +
//                "팀 코트에 떨어트릴 경우 점수를 얻게 된다. ");
//            databaseReference.setValue(sports_db);
//
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("족구").child("체험장소");
//            companies_DB= new companies();
//            C_Name = new ArrayList<String>();
//            C_Name.add("잠실 한강공원");C_Name.add("뚝섬 한강공원");C_Name.add("이촌 한강공원");
//            C_Name.add("난지 한강공원");C_Name.add("강서 한강공원");C_Name.add("광나루 한강공원");
//            companies_DB.setCompanies_Name(C_Name);
//            databaseReference.setValue(companies_DB);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("족구");
//        sports_db= new Sports_DB();
//        sports_db.setName("족구");
//        sports_db.setEvent("구기 종목");
//        sports_db.setPhoto_name("foot_volleyball");
//        sports_db.setSimple_info("각팀 4명이 네트를 사이에 두고 발과 머리를 사용해 수비 공격을 하는 스포츠.");
//        sports_db.setDetail_info("한국에서 만들어진 스포츠이며 각 팀 4명이 포지션을 담당해 네트를 사이에 두고" +
//                "발과 머리 만 사용해 공격과 수비를 주고 받는 스포츠이다.");
//            databaseReference.setValue(sports_db);
//
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("축구").child("체험장소");
//            companies_DB= new companies();
//            C_Name = new ArrayList<String>();
//            C_Name.add("잠원 한강공원");C_Name.add("뚝섬 한강공원");C_Name.add("반포 한강공원");
//            C_Name.add("양화 한강공원");
//            C_Name.add("이촌 한강공원");C_Name.add("망원 한강공원");C_Name.add("광나루 한강공원");
//            companies_DB.setCompanies_Name(C_Name);
//            databaseReference.setValue(companies_DB);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("축구");
//        sports_db= new Sports_DB();
//        sports_db.setName("축구");
//        sports_db.setEvent("구기 종목");
//        sports_db.setPhoto_name("soccer");
//        sports_db.setSimple_info("11명의 선수들이 각각 한 팀을 이루어 두 팀이 겨루는 구기 스포츠.");
//        sports_db.setDetail_info("경기장 양 끝의 골대에 공을 통과시키면 득점이다. 선수 중 골키퍼만 팔과 손으로도 공을 건드릴 수 있지만," +
//                "활동 구역이 제한되어 있으며. 다른 선수들은 경기장안에서 공을 고의로 만지면 핸드볼 반칙이 된다.");
//            databaseReference.setValue(sports_db);
//
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("농구").child("체험장소");
//            companies_DB= new companies();
//            C_Name = new ArrayList<String>();
//            C_Name.add("잠원 한강공원");C_Name.add("뚝섬 한강공원");C_Name.add("반포 한강공원");
//            C_Name.add("양화 한강공원");
//            C_Name.add("이촌 한강공원");C_Name.add("망원 한강공원");C_Name.add("난지 한강공원");C_Name.add("광나루 한강공원");
//            companies_DB.setCompanies_Name(C_Name);
//            databaseReference.setValue(companies_DB);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("농구");
//        sports_db= new Sports_DB();
//        sports_db.setName("농구");
//        sports_db.setEvent("구기 종목");
//        sports_db.setPhoto_name("basketball");
//        sports_db.setSimple_info("손을 주로 사용하며 다리를 제외한 신체부위 접촉이 허용되는 스포츠");
//        sports_db.setDetail_info("실내에서 즐기는 스포츠이며, 양팀의 5명[기본적으로]의 선수가 한 개의 공을" +
//                "다른 팀의 바구니 안에 던져 넣는 스포츠 이다.");
//            databaseReference.setValue(sports_db);
//
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("인라인").child("체험장소");
//            companies_DB= new companies();
//            C_Name = new ArrayList<String>();
//
//            C_Name.add("이촌 한강공원");
//            companies_DB.setCompanies_Name(C_Name);
//            databaseReference.setValue(companies_DB);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("인라인");
//        sports_db= new Sports_DB();
//        sports_db.setName("인라인");
//        sports_db.setEvent("구기 종목");
//        sports_db.setPhoto_name("inline");
//        sports_db.setSimple_info("한 줄로 이루어진 바퀴가 밑 창에 있는 신발을 이용해 즐기는 스포츠 입니다.");
//        sports_db.setDetail_info("해당 장소에서 즐길 수 있는 인라인은 일반적인 스케이트 입니다.");
//            databaseReference.setValue(sports_db);
    }


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
