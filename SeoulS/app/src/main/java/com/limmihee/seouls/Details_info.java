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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Details_info extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private ChildEventListener mChild;

    public static Context mContext;

    private TextView Sports_name = (TextView) findViewById(R.id.Sports_Name);
    private TextView Spl_name = (TextView) findViewById(R.id.simple_name);
    private TextView Spl_info = (TextView) findViewById(R.id.simple_info);
    private TextView Details_info_ = (TextView) findViewById(R.id.Detalis_info);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info);
        mContext=this;

        String n = FirebaseDatabase.getInstance().getReference().child("육상").child("족구").getKey();
        Sports_name.setText(n);
//        Spl_name.setText(sp_name);
//        Spl_info.setText(info);
//        Details_info_.setText(D_info);
    }


}
