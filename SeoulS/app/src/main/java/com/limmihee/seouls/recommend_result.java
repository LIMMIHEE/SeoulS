package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    TextView Info_Text;
    Button main_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_result);
        context=this;
        ResultText = (TextView)findViewById(R.id.resultBtn);

        ArrayList<String> result = ((Recommendation)Recommendation.context).Reco_list;
        models = new ArrayList<>();

        Info_Text= (TextView)findViewById(R.id.info_text);
        main_btn = (Button) findViewById(R.id.main_btn);

        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(recommend_result.this,MainActivity.class);
                startActivity(intent);
            }
        });


        if(result.isEmpty()){
            ResultText.setText("맞는 스포츠가... 없습니다!");
            Info_Text.setText("아래의 집 모양을 눌러주세요!");
        }else{
            for(String value : result){
                models.add(new Model(R.drawable.water_sports_4,value,"Test"));
            }
        }

        adapter = new Adapter(models , this);



        viewPager = findViewById(R.id.select);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(150,0,150,0);


    }
    @Override public void onBackPressed()
    {
        //super.onBackPressed();
    }
}
