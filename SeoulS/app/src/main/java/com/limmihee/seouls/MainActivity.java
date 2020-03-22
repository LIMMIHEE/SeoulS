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
    experience_point experience_point;

    public Sports_DB sports_db;
    experience_point Experience_point;
    public companies companies_DB;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //databaseReference.child("현재체험장소").setValue("뿌뿌");
        {
            {
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("테니스").child("체험장소").child("뚝섬 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("뚝섬 한강공원");
//                Experience_point.setPay("1회 2시간, 5000원 월정기권 75,000원");
//                Experience_point.setSimple_info("예약 홈페이지 주소의 경우 http://www.한강테니스장.com 입니다.");
//                Experience_point.setDetail_info("월 정기권의 경우 이용시간이 06:00시 ~ 09:00에 한하며 2시간 이내 사용해야합니다.");
//                Experience_point.setPhone_num("01054950798");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("테니스").child("체험장소").child("잠원 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("잠원 한강공원");
//                Experience_point.setPay("1회 2시간, 5000원 월정기권 75,000원");
//                Experience_point.setSimple_info("예약 홈페이지 주소의 경우 http://www.한강잠원망원테니스.kr 입니다.");
//                Experience_point.setDetail_info("월 정기권의 경우 이용시간이 06:00시 ~ 09:00에 한하며 2시간 이내 사용해야합니다.");
//                Experience_point.setPhone_num("01045123743");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("테니스").child("체험장소").child("이촌 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("이촌 한강공원");
//                Experience_point.setPay("1회 2시간, 5000원 월정기권 75,000원");
//                Experience_point.setSimple_info("예약 홈페이지 주소의 경우 http://www.한강테니스장.com 입니다.");
//                Experience_point.setDetail_info("월 정기권의 경우 이용시간이 06:00시 ~ 09:00에 한하며 2시간 이내 사용해야합니다.");
//                Experience_point.setPhone_num("01054950798");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("테니스").child("체험장소").child("망원 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("망원 한강공원");
//                Experience_point.setPay("1회 2시간, 5000원 월정기권 75,000원");
//                Experience_point.setSimple_info("예약 홈페이지 주소의 경우 http://www.한강잠원망원테니스.kr 입니다.");
//                Experience_point.setDetail_info("월 정기권의 경우 이용시간이 06:00시 ~ 09:00에 한하며 2시간 이내 사용해야합니다.");
//                Experience_point.setPhone_num("01045123743");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("테니스").child("체험장소").child("광나루 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("광나루 한강공원");
//                Experience_point.setPay("1회 2시간, 5000원 월정기권 75,000원");
//                Experience_point.setSimple_info("예약 홈페이지 주소의 경우 http://www.한강잠원망원테니스.kr 입니다.");
//                Experience_point.setDetail_info("월 정기권의 경우 이용시간이 06:00시 ~ 09:00에 한하며 2시간 이내 사용해야합니다.");
//                Experience_point.setPhone_num("01054950798");
//                databaseReference.setValue(Experience_point);

            }

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
            {
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배드민턴").child("체험장소").child("뚝섬 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("뚝섬 한강공원");
//                Experience_point.setPay("1회 2시간, 1000원 월정기권 30,000원");
//                Experience_point.setSimple_info("뚝섬 한강공원의 배드민턴 장은 총 3가지 입니다.");
//                Experience_point.setDetail_info("뚝섬 한강공원은 배드민턴 이외의 육상 스포츠 4가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800521");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배드민턴").child("체험장소").child("반포 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("반포 한강공원");
//                Experience_point.setPay("1회 2시간, 1000원 월정기권 30,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("뚝섬 한강공원은 배드민턴 이외의 육상 스포츠 2가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800521");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배드민턴").child("체험장소").child("이촌 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("이촌 한강공원");
//                Experience_point.setPay("1회 2시간, 1000원 월정기권 30,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("뚝섬 한강공원은 배드민턴 이외의 육상 스포츠 6가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800521");
//                databaseReference.setValue(Experience_point);

            }
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
            {
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("양궁").child("체험장소").child("난지 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("난지 한강공원");
//                Experience_point.setPay("1회 이용자 5,000원, 1일 이용 5,000원 월정기권 40,000원");
//                Experience_point.setSimple_info("1회 이용의 경우 코스 체험으로 20발이 주어지며. 1일의 경우 75발 이내, 3시간 이내로 개인장비를 소지해야 합니다. " +
//                        "이는 월별이용자와 같습니다.");
//                Experience_point.setDetail_info("뚝섬 한강공원은 배드민턴 이외의 육상 스포츠 3가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800611");
//               databaseReference.setValue(Experience_point);
            }
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
            {
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("야구").child("체험장소").child("망원 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("망원 한강공원");
//                Experience_point.setPay("[어린이 야구장] 1회 2시간, 8000원 / 월 정기 사용제 120,000원");
//                Experience_point.setSimple_info("어린이 야구장으로, 만 13세 미만 어린이만 사용가능 합니다.");
//                Experience_point.setDetail_info("망원 한강공원은 배드민턴 이외의 육상 스포츠 4가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800601");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("야구").child("체험장소").child("난지 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("난지 한강공원");
//                Experience_point.setPay("1회 3시간, 20000원 / 월 정기 사용제 X");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("난지 한강공원은 배드민턴 이외의 육상 스포츠 3가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800611");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("야구").child("체험장소").child("광나루 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("광나루 한강공원");
//                Experience_point.setPay("[성인] 1회 3시간, 20000원 / 주말 및 휴일 26,000원 / 월 정기 사용제 X ");
//                Experience_point.setSimple_info("[어린이 야구] 1회 2시간, 8000원 / 월 정기 120,000원 | 만 13세 미만 어린이 사용가능");
//                Experience_point.setDetail_info("광나루 한강공원은 배드민턴 이외의 육상 스포츠 5가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800501");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("야구").child("체험장소").child("망원 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("망원 한강공원");
//                Experience_point.setPay("[어린이 야구]  1회 2시간, 8000원 / 월 정기 120,000원 ");
//                Experience_point.setSimple_info("만 13세 미만 어린이 사용가능");
//                Experience_point.setDetail_info("망원 한강공원은 배드민턴 이외의 육상 스포츠 5가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800601");
//                databaseReference.setValue(Experience_point);

            }
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
            {
//           databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배구").child("체험장소").child("잠실 한강공원");
////                Experience_point = new experience_point();
////                Experience_point.setName("잠실 한강공원");
////                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
////                Experience_point.setSimple_info("-");
////                Experience_point.setDetail_info("잠실 한강공원은 배드민턴 이외의 육상 스포츠 1가지를 즐길 수 있습니다.");
////                Experience_point.setPhone_num("0237800511");
////                databaseReference.setValue(Experience_point);
////                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배구").child("체험장소").child("잠원 한강공원");
////                Experience_point = new experience_point();
////                Experience_point.setName("잠원 한강공원");
////                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
////                Experience_point.setSimple_info("-");
////                Experience_point.setDetail_info("잠원 한강공원은 배드민턴 이외의 육상 스포츠 3가지를 즐길 수 있습니다.");
////                Experience_point.setPhone_num("0237800531");
////                databaseReference.setValue(Experience_point);
////                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배구").child("체험장소").child("이촌 한강공원");
////                Experience_point = new experience_point();
////                Experience_point.setName("이촌 한강공원");
////                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
////                Experience_point.setSimple_info("-");
////                Experience_point.setDetail_info("이촌 한강공원은 배드민턴 이외의 육상 스포츠 6가지를 즐길 수 있습니다.");
////                Experience_point.setPhone_num("0237800551");
////                databaseReference.setValue(Experience_point);
////                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배구").child("체험장소").child("양화 한강공원");
////                Experience_point = new experience_point();
////                Experience_point.setName("양화 한강공원");
////                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
////                Experience_point.setSimple_info("-");
////                Experience_point.setDetail_info("양화 한강공원은 배드민턴 이외의 육상 스포츠 2가지를 즐길 수 있습니다.");
////                Experience_point.setPhone_num("0237800581");
////                databaseReference.setValue(Experience_point);
////                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배구").child("체험장소").child("망원 한강공원");
////                Experience_point = new experience_point();
////                Experience_point.setName("망원 한강공원");
////                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
////                Experience_point.setSimple_info("-");
////                Experience_point.setDetail_info("망원 한강공원은 배드민턴 이외의 육상 스포츠 4가지를 즐길 수 있습니다.");
////                Experience_point.setPhone_num("0237800601");
////                databaseReference.setValue(Experience_point);
////                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("배구").child("체험장소").child("광나루 한강공원");
////                Experience_point = new experience_point();
////                Experience_point.setName("광나루 한강공원");
////                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
////                Experience_point.setSimple_info("-");
////                Experience_point.setDetail_info("광나루 한강공원은 배드민턴 이외의 육상 스포츠 5가지를 즐길 수 있습니다.");
////                Experience_point.setPhone_num("0237800501");
////                databaseReference.setValue(Experience_point); {

            }
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
            {
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("족구").child("체험장소").child("잠실 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("잠실 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("잠실 한강공원은 족구 이외의 육상 스포츠 1가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800511");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("족구").child("체험장소").child("뚝섬 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("뚝섬 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("뚝섬 한강공원은 족구 이외의 육상 스포츠 4가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800521");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("족구").child("체험장소").child("이촌 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("이촌 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("이촌 한강공원은 족구 이외의 육상 스포츠 6가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800551");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("족구").child("체험장소").child("난지 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("난지 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("난지 한강공원은 족구 이외의 육상 스포츠 3가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800611");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("족구").child("체험장소").child("광나루 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("광나루 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("광나루 한강공원은 족구 이외의 육상 스포츠 5가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800501");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("족구").child("체험장소").child("강서 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("강서 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("강서 한강공원은 생태관광 명소 중 하나입니다. 잠시 쉬며 자연을 둘러보는 건 어떨까요?");
//                Experience_point.setPhone_num("0237800621");
//                databaseReference.setValue(Experience_point);

            }
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

            {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("축구").child("체험장소").child("뚝섬 한강공원");
                Experience_point = new experience_point();
                Experience_point.setName("뚝섬 한강공원");
                Experience_point.setPay("1회 2시간, 12000원 / 월 정기 사용제 225,000원");
                Experience_point.setSimple_info("야간(2시간) 25,000원");
                Experience_point.setDetail_info("뚝섬 한강공원은 축구 이외의 육상 스포츠 4가지를 즐길 수 있습니다.");
                Experience_point.setPhone_num("0237800521");
                databaseReference.setValue(Experience_point);
                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("축구").child("체험장소").child("잠원 한강공원");
                Experience_point = new experience_point();
                Experience_point.setName("잠원 한강공원");
                Experience_point.setPay("1회 2시간, 12000원 / 월 정기 사용제 225,000원");
                Experience_point.setSimple_info("해당 공원은 야간 X");
                Experience_point.setDetail_info("잠원 한강공원은 축구 이외의 육상 스포츠 3가지를 즐길 수 있습니다.");
                Experience_point.setPhone_num("0237800531");
                databaseReference.setValue(Experience_point);
                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("축구").child("체험장소").child("반포 한강공원");
                Experience_point = new experience_point();
                Experience_point.setName("반포 한강공원");
                Experience_point.setPay("1회 2시간, 12000원 / 월 정기 사용제 225,000원");
                Experience_point.setSimple_info("해당 공원은 야간 X");
                Experience_point.setDetail_info("반포 한강공원은 축구 이외의 육상 스포츠 2가지를 즐길 수 있습니다.");
                Experience_point.setPhone_num("0237800541");
                databaseReference.setValue(Experience_point);
                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("축구").child("체험장소").child("이촌 한강공원");
                Experience_point = new experience_point();
                Experience_point.setName("이촌 한강공원");
                Experience_point.setPay("1회 2시간, 12000원 / 월 정기 사용제 225,000원");
                Experience_point.setSimple_info("해당 공원은 야간 X");
                Experience_point.setDetail_info("이촌 한강공원은 축구 이외의 육상 스포츠 6가지를 즐길 수 있습니다.");
                Experience_point.setPhone_num("0237800551");
                databaseReference.setValue(Experience_point);
                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("축구").child("체험장소").child("양화 한강공원");
                Experience_point = new experience_point();
                Experience_point.setName("양화 한강공원");
                Experience_point.setPay("1회 2시간, 12000원 / 월 정기 사용제 225,000원");
                Experience_point.setSimple_info("해당 공원은 야간 X");
                Experience_point.setDetail_info("양화 한강공원은 축구 이외의 육상 스포츠 2가지를 즐길 수 있습니다.");
                Experience_point.setPhone_num("0237800581");
                databaseReference.setValue(Experience_point);
                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("축구").child("체험장소").child("망원 한강공원");
                Experience_point = new experience_point();
                Experience_point.setName("망원 한강공원");
                Experience_point.setPay("1회 2시간, 12000원 / 월 정기 사용제 225,000원");
                Experience_point.setSimple_info("해당 공원은 야간 X");
                Experience_point.setDetail_info("망원 한강공원은 축구 이외의 육상 스포츠 4가지를 즐길 수 있습니다.");
                Experience_point.setPhone_num("0237800601");
                databaseReference.setValue(Experience_point);
                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("축구").child("체험장소").child("광나루 한강공원");
                Experience_point = new experience_point();
                Experience_point.setName("광나루 한강공원");
                Experience_point.setPay("1회 2시간, 12000원 / 월 정기 사용제 225,000원");
                Experience_point.setSimple_info("해당 공원은 야간 X");
                Experience_point.setDetail_info("광나루 한강공원은 축구 이외의 육상 스포츠 5가지를 즐길 수 있습니다.");
                Experience_point.setPhone_num("0237800501");
                databaseReference.setValue(Experience_point);
            }
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
            {
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("농구").child("체험장소").child("뚝섬 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("뚝섬 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("뚝섬 한강공원은 농구 이외의 육상 스포츠 4가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800521");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("농구").child("체험장소").child("잠원 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("잠원 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("잠원 한강공원은 농구 이외의 육상 스포츠 3가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800531");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("농구").child("체험장소").child("반포 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("반포 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("반포 한강공원은 농구 이외의 육상 스포츠 2가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800541");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("농구").child("체험장소").child("이촌 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("이촌 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("이촌 한강공원은 농구 이외의 육상 스포츠 6가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800551");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("농구").child("체험장소").child("양화 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("양화 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("양화 한강공원은 농구 이외의 육상 스포츠 2가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800581");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("농구").child("체험장소").child("망원 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("망원 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("망원 한강공원은 농구 이외의 육상 스포츠 4가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800601");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("농구").child("체험장소").child("난지 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("난지 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("난지 한강공원은 농구 이외의 육상 스포츠 3가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800611");
//                databaseReference.setValue(Experience_point);
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("농구").child("체험장소").child("광나루 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("광나루 한강공원");
//                Experience_point.setPay("1회 2시간, 4000원 / 월 정기 사용제 75,000원");
//                Experience_point.setSimple_info("-");
//                Experience_point.setDetail_info("광나루 한강공원은 농구 이외의 육상 스포츠 5가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800501");
//                databaseReference.setValue(Experience_point);
            }
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
            {
//                databaseReference = FirebaseDatabase.getInstance().getReference().child("육상").child("인라인").child("체험장소").child("이촌 한강공원");
//                Experience_point = new experience_point();
//                Experience_point.setName("이촌 한강공원");
//                Experience_point.setPay("어린이 : 1000원, 청소년 1500원, 어른 :: 2000원 ");
//                Experience_point.setSimple_info("어린이 :: 6세 이상 12세이하, 청소년 :: 13세 이상 18세 이하. 어른 :: 19세 이상");
//                Experience_point.setDetail_info("이용시간 :: 09:00~19:00\n연중무휴(단, 눈이나 비가 내리면 안전상 운영안함)\n" +
//                        "장비대여로 2,000원 필요합니다\n이촌 한강공원은 농구 이외의 육상 스포츠 6가지를 즐길 수 있습니다.");
//                Experience_point.setPhone_num("0237800551");
//                databaseReference.setValue(Experience_point);
            }
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
