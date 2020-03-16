package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Athletics_sports extends AppCompatActivity implements AthleticsSports {
//    private OnItamClickListener mListner;
//    public interface OnItamClickListener{
//        void OnItamListener(int position);
//    }
//    public void setOnItamClickListener(OnItamClickListener listener){
//        mListner = listener;
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletics_sports);

        Button Arhletics_main_btn = (Button) findViewById(R.id.BackButton);
        Arhletics_main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Athletics_sports.this, MainActivity.class);
                startActivity(intent);
            }
        });

        View Card_View = (View) findViewById(R.id.Apuar_sports);
        Card_View.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Athletics_sports.this, Details_info.class);
                ((Details_info)Details_info.mContext).Set_Layout("테니스","Tennis",
                        "설명","설명2");


                startActivity(intent);
            }
        });
    }

}
