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
                int draw=0;
                switch (value){
                    case  "농구": draw = getDraw_id("drawable","basketball");break;
                    case  "배구": draw = getDraw_id("drawable","volleyball");break;
                    case  "배드민턴": draw = getDraw_id("drawable","badminton"); break;
                    case  "야구": draw = getDraw_id("drawable","baseball");break;
                    case  "양궁": draw = getDraw_id("drawable","archery");break;
                    case  "인라인": draw = getDraw_id("drawable","inline");break;
                    case  "족구": draw = getDraw_id("drawable","foot_volleyball");break;
                    case  "축구": draw = getDraw_id("drawable","soccer");break;
                    case  "테니스": draw = getDraw_id("drawable","tennis");break;
                    default: draw = getDraw_id("drawable","water_sports_"+(int)((Math.random() * 7)+1)); break;

                }

                models.add(new Model(draw,value,"Test"));
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

    private int getDraw_id (String type, String name){
        int getId = getResources().getIdentifier("com.limmihee.seouls:"+type+"/"+name,null,null);
        return getId;
    }

}
