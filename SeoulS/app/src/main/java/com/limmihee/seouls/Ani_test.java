package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Ani_test extends AppCompatActivity {
    ViewPager viewPager;
    CardView cardView;
    Adapter adapter;
    List<Model> models ;

    Recommendation recommendation;
    TextView ResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_test);

        ResultText = (TextView)findViewById(R.id.resultBtn);

        ArrayList<String> result = ((Recommendation)Recommendation.context).Reco_list;
        models = new ArrayList<>();


        if(result.isEmpty()){
            ResultText.setText("맞는 스포츠가... 없습니다!");
        }else{
            String print = "";
            for(String value : result){
                print += value+" \n ";
                print +="\n";
                models.add(new Model(R.drawable.water_sports_4,value,"Test"));
            }
            ResultText.setText(print);
        }

//        models.add(new Model(R.drawable.water_sports_1,"#나와_맞는_스포츠찾기","테스트를 통해 나와 맞는 스포츠의 장소와 위치를 찾아보세요!"));
//        models.add(new Model(R.drawable.water_sports_4,"#서울 날씨","4"));
//        models.add(new Model(R.drawable.water_sports_2,"#육상스포츠"," 실내 혹은 실외 등! 다양한 육상 스포츠들에 대해 알아보세요"));
//        models.add(new Model(R.drawable.water_sports_3,"#수상스포츠"," 보드 혹은 스키까지! 다양한 수상 스포츠들에 대해 알아보세요"));

        adapter = new Adapter(models , this);



        viewPager = findViewById(R.id.select);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(150,0,150,0);


    }
}
