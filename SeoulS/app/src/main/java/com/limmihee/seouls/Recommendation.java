package com.limmihee.seouls;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class Recommendation extends AppCompatActivity {

    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;
    RadioGroup radioGroup5;
    Button Print_Btn ;

    boolean isVisi=false;
    boolean isAquaOrAth = false;
    boolean isBody = false;
    boolean isUse = false;

    ArrayList<String> Reco_list = new ArrayList<>();
    ArrayList<String> remove_list = new ArrayList<>();
    String athletics[] = {"농구", "배구", "배드민턴", "야구", "양궁", "인라인", "족구", "축구", "테니스"};
    String aqua[] = {"요트" , "조정" , "모터 보트", "수상 스키", "웨이크 보드", "윈드 서핑", "바나나 보트",
            "튜브스터","카약", "카누", "딩기 요트" ,"땅콩 보트", "수상 오토바이", "워터 보드", "블롭 점프"};


    String upperBody[]= {"양궁" , "요트", "조정", "모터", "보트", "바나나 보트","튜브스터","카약","카누","딩기 요트","땅콩 보트","수상 오토바이"};
    String lower_Body[]= {"족구", "인라인", "축구", "요트","모터 보트","웨이크 보드","튜브스터","수상 오토바이"};
    String Body[] = {"농구", "배구", "배드민턴", "야구" ,"테니스", "요트","모터 보트","수상 스키","웨이크 보드", "윈드 서핑","튜브스터","수상 오토바이","워터 보드", "블롭 점프"};

    String UseObject [] = {"농구", "배구", "배드민턴", "야구", "족구", "축구", "테니스","양궁"};
    // 카누나 카약 같은 손으로 ㅆ그는 무언가도 넣어두기
    String DonUseObject [] = {"요트" , "조정" , "모터 보트", "수상 스키", "웨이크 보드", "윈드 서핑", "바나나 보트",
            "튜브스터","카약", "카누", "딩기 요트" ,"땅콩 보트", "수상 오토바이", "워터 보드", "블롭 점프", "인라인"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        Print_Btn = (Button)findViewById(R.id.Print_Btn);
        Print_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAquaOrAth==false||isBody==false ||isUse==false  ){
                    Toast.makeText(Recommendation.this, "클릭함 : "+Reco_list, Toast.LENGTH_SHORT).show();
                }

            }
        });
        // 농구 배구 배드민턴 야구 양궁 인라인 족구 축구 테니스
        // 요트  조정  모터보트 수상스키 웨이크 보드 윈드 서핑 바나나 보트
        // 튜브스터 카약 카누 딩기 요트 땅콩 보트 수상 오토바이 수상스키 웨이크보드 바나나보트 웨터보트 블롭 점프

            radioGroup2 = (RadioGroup)findViewById(R.id.Group2);
            radioGroup3 = (RadioGroup)findViewById(R.id.Group3);         radioGroup4 = (RadioGroup)findViewById(R.id.Group4);
            radioGroup5 = (RadioGroup)findViewById(R.id.Group5);

            radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup radioGroup,  int id) {
                    switch (id){
                        case R.id.g_2_1: Reco_list = new ArrayList<>();for(int i=0; i< athletics.length; i++){Reco_list.add(athletics[i]);} isAquaOrAth=true; break;
                        case R.id.g_2_2: Reco_list = new ArrayList<>();for(int i=0; i< aqua.length; i++){Reco_list.add(aqua[i]);} isAquaOrAth=true; break;
                        case R.id.g_2_3: Reco_list = new ArrayList<>();for(int i=0; i< athletics.length; i++){Reco_list.add(athletics[i]);}
                                         for(int i=0; i< aqua.length; i++){Reco_list.add(aqua[i]);} isAquaOrAth=true; ;break;
                    }
                }
            });
            radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup radioGroup,  int id) {
                    switch (id) {
                        case R.id.g_3_1:
                            remove_list = new ArrayList<>();
                            for (String value : Reco_list) {
                                for (String num : upperBody) {
                                    if (value == num) { isVisi = true; break; }
                                }
                                if (isVisi == false) {  remove_list.add(value); }isVisi = false;
                            }
                            for (String name : remove_list){ Reco_list.remove(name); }
                            isBody=true;
                            break;
                        case R.id.g_3_2:
                            remove_list = new ArrayList<>();
                            for (String value : Reco_list) {
                                for (String num : lower_Body) {
                                    if (value == num) { isVisi = true; break; }
                                }
                                if (isVisi == false) {  remove_list.add(value); } isVisi = false;
                            }
                            for (String name : remove_list){ Reco_list.remove(name); }
                            isBody=true;
                            break;
                        case R.id.g_3_3:
                            remove_list = new ArrayList<>();
                            for (String value : Reco_list) {
                                for (String num : Body) {
                                    if (value == num) { isVisi = true; break; }
                                }
                                if (isVisi == false) {  remove_list.add(value); }isVisi = false;
                            }
                            for (String name : remove_list){ Reco_list.remove(name); }
                            isBody=true;
                            break;
                    }

                }
             });
            radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup radioGroup,  int id) {
                    switch (id) {
                        case R.id.g_4_1:
                            remove_list = new ArrayList<>();
                            for (String value : Reco_list) {
                                for (String num : UseObject) {
                                    if (value == num) { isVisi = true; break; }
                                }
                                if (isVisi == false) {  remove_list.add(value);  }isVisi = false;
                            }
                            for (String name : remove_list){ Reco_list.remove(name); }
                            isUse=true;
                            break;
                        case R.id.g_4_2:
                            remove_list = new ArrayList<>();
                            for (String value : Reco_list) {
                                for (String num : DonUseObject) {
                                    if (value == num) { isVisi = true; break; }
                                }
                                if (isVisi == false) {  remove_list.add(value);} isVisi = false;
                            }
                            for (String name : remove_list){ Reco_list.remove(name); }
                            isUse=true;
                            break;
                        case R.id.g_4_3: isUse=true;break;
                    }
                }
            });
            radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup radioGroup,  int id) {

                }
            });
    }
}
