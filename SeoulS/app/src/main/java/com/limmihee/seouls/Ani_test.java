package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Ani_test extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models ;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_test);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.water_sports_1,"1","1"));
        models.add(new Model(R.drawable.water_sports_2,"2","2"));
        models.add(new Model(R.drawable.water_sports_3,"3","3"));
        models.add(new Model(R.drawable.water_sports_4,"4","4"));

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
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(
                            positionOffset, colors[position],colors[position + 1])
                    );
                }else{
                    viewPager.setBackgroundColor(colors[colors.length -1]);
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
