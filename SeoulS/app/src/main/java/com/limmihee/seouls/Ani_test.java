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

    Recommendation recommendation;
    TextView ResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_test);

        ResultText = (TextView)findViewById(R.id.resultBtn);

        ArrayList<String> result = ((Recommendation)Recommendation.context).Reco_list;

        if(result.isEmpty()){
            ResultText.setText("맞는 스포츠가... 없습니다!");
        }else{
            String print = "";
            for(String value : result){
                print += value+" \n ";
                print +="\n";
            }
            ResultText.setText(print);
        }


    }
}
