package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        Button ALLBtn = (Button) findViewById(R.id.all_sports_btn);
        ALLBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Details_info.class);
                startActivity(intent);
            }
        });


    }





//    ImageView imageView = (ImageView) findViewById(R.id.CardImage);
//    GradientDrawable drawable= (GradientDrawable) getApplicationContext().getDrawable(R.drawable.card_corner_radius);
//    imageView.setBackground(drawable);
//    imageView.setClipToOutline(true);

}
