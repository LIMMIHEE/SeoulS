package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Ani_test extends AppCompatActivity {

    ViewPager viewPager;
    CardView cardView;
    Adapter adapter;
    List<Model> models ;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    Button recom_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_test);

        cardView =findViewById(R.id.slide);
        recom_btn= (Button) findViewById(R.id.button3);
        recom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Ani_test.this,Recommendation.class);
                startActivity(intent);
            }
        });

        models = new ArrayList<>();
        models.add(new Model(R.drawable.water_sports_1,"#나와_맞는_스포츠찾기","테스트를 통해 나와 맞는 스포츠의 장소와 위치를 찾아보세요!"));
        models.add(new Model(R.drawable.water_sports_4,"#서울 날씨","4"));
        models.add(new Model(R.drawable.water_sports_2,"#육상스포츠"," 실내 혹은 실외 등! 다양한 육상 스포츠들에 대해 알아보세요"));
        models.add(new Model(R.drawable.water_sports_3,"#수상스포츠"," 보드 혹은 스키까지! 다양한 수상 스포츠들에 대해 알아보세요"));

        adapter = new Adapter(models , this);



        viewPager = findViewById(R.id.select);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(150,0,150,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.colorBlue),
                getResources().getColor(R.color.colorLightBlue),
                getResources().getColor(R.color.colorDeepBlue),
                getResources().getColor(R.color.colorMintBlue)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position < (adapter.getCount() -1 ) && position < (colors.length-1)){
                   // cardView.setCardBackgroundColor(colors[colors.length -1]);
//                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(
//                            positionOffset, colors[position],colors[position + 1])
//                    );
                }else{
                    //cardView.setCardBackgroundColor(colors[colors.length -1]);
                    //viewPager.setBackgroundColor(colors[colors.length -1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
