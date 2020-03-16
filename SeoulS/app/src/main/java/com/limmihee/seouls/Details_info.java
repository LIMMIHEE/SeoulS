package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Details_info extends AppCompatActivity {

    public static Context mContext;

    private TextView Sports_name = (TextView)findViewById(R.id.Sports_Name);
    private TextView Spl_name = (TextView)findViewById(R.id.simple_name);
    private TextView Spl_info = (TextView)findViewById(R.id.simple_info);
    private TextView Details_info_ = (TextView)findViewById(R.id.Detalis_info);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info);
        mContext=this;

    }
    public void Set_Layout(String Sp_name, String spl_name, String spl_info, String Details_info){
        Sports_name.setText(Sp_name);
        Spl_name.setText(spl_name);
        Spl_info.setText(spl_info);
        Details_info_.setText(Details_info);
    }

}
