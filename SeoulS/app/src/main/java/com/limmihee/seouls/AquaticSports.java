package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AquaticSports extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;

    LinearLayout layout;
    Context context;


    private LayoutInflater layoutInflater;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquatic_sports);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        context=this;
        layout = (LinearLayout) findViewById(R.id.aqua_list);

        CreateAquaticSports("잠실 한강공원","최저 20,000원 최대 85,000원","모터 보트, 바나나보트, 수상스키 등","water_sports_1");
        CreateAquaticSports("뚝섬 한강공원","최저 (소인)10,000원 최대 20,000원","요트, 조정 체험가능","water_sports_2");
        CreateAquaticSports("잠원 한강공원","최저 20,000원 최대 50,000원","보터보트, 수상스키, 웨이크 보드 등","water_sports_3");
        CreateAquaticSports("반포 한강공원","최소 (소인) 20,000원 최대 30,000원","요트 , 튜브스터 체험가능","water_sports_4");
        CreateAquaticSports("이촌 한강공원","25,000원 고정","수상 스키, 웨이크 보드 체험가능","water_sports_5");
        CreateAquaticSports("여의도 한강공원","최저 4,000원 최대 100,000원","수상 스키, 딩기요트, 워터보드, 블롭점프 등","water_sports_6");
        CreateAquaticSports("양화 한강공원","최저 20,000원 최대 40,000원","모터보트, 카약, 카누, 오리보트 등","water_sports_5");
        CreateAquaticSports("망원 한강공원","최저 15,000원 최대 39,000원","모터보트, 웨이크보드, 윈드 서핑 등","jeremy");
    }
    private void CreateAquaticSports(final String name, String info, String info_l,String img_String){
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
                Intent intent = new Intent(AquaticSports.this,Details_info.class);
                startActivity(intent);
            }
        });

        layout.addView(view);

        }
}
