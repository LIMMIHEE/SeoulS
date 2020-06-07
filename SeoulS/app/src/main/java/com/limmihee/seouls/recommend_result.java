package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class recommend_result extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models ;
    public static Context context;

    String [][] aqua_Sp = {};

    Recommendation recommendation;
    TextView ResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_result);
        context=this;
        ResultText = (TextView)findViewById(R.id.resultBtn);

        ArrayList<String> result = ((Recommendation)Recommendation.context).Reco_list;
        models = new ArrayList<>();


        if(result.isEmpty()){
            ResultText.setText("맞는 스포츠가... 없습니다!");
        }else{
            for(String value : result){
                models.add(new Model(R.drawable.water_sports_4,value,"Test"));
            }
            ResultText.setText("아래의 스포츠들입니다.\n원하는 스포츠를 클릭해 정보를 알아보세요!");
        }

        adapter = new Adapter(models , this);



        viewPager = findViewById(R.id.select);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(150,0,150,0);


    }
}
