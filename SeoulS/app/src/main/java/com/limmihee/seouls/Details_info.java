package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Details_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info);

        Button back_btn = (Button) findViewById(R.id.BackBtn);
        back_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onBackPressed();
            }
        });
        Button CallBtn = (Button) findViewById(R.id.Call_Btn);
        CallBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Call("1111");
            }
        });

    }


    public void Call (String Number){
        String tel = "tel:"+Number;
        Intent Calltel = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
        startActivity(Calltel);
    }
}
