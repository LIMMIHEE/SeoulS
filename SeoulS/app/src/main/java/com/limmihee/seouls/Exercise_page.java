package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Exercise_page extends AppCompatActivity {
    private static final float FONT_SIZE = 19;
     LinearLayout container;
    int cont=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_page);

        container=(LinearLayout) findViewById(R.id.Park_info);
        textview("강남");
        textview("세글자");
        textview("마포?");


    }

    public void textview(String a){

        //TextView 생성
        TextView view1 = new TextView(this);
        view1.setText(a);
        view1.setBackgroundResource(R.drawable.btn_re_mian_red);
        view1.setTextSize(FONT_SIZE);
        view1.setPadding(20, 20, 20, 20);
        view1.setTypeface(null, Typeface.BOLD);
        view1.setLetterSpacing(0.2f);
        view1.setGravity(Gravity.CENTER);


        //layout_width, layout_height, gravity 설정
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lp.topMargin= 60;

        lp.width=330; lp.height=300;
        lp.setMarginStart(52);

        view1.setLayoutParams(lp);

        //부모 뷰에 추가
        container.addView(view1);
    }

//
//
}

