package com.limmihee.seouls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

public class Details_info extends AppCompatActivity {
    Current_usage_sports usage_sports;

    String sports_name_Fire;
    String sports_Field_Fire;

    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;



    TextView Sports_name;
    TextView Spl_name;
    TextView Spl_info;
    TextView Details_info_;
    ImageView SP_img;



    String name;
    String photo="R.drawable.";
    String simple_info;
    String event;
    String detail_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info);

        Sports_name = (TextView) findViewById(R.id.Com_Name);
        Spl_name = (TextView) findViewById(R.id.simple_info);
        Spl_info = (TextView) findViewById(R.id.Com_Pay);
        Details_info_ = (TextView) findViewById(R.id.Detalis_info);
        SP_img =(ImageView) findViewById(R.id.Detalis_Sports_img);





        firebaseDatabase = FirebaseDatabase.getInstance();
          databaseReference = firebaseDatabase.getReference();
          databaseReference.child("현재운동").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                sports_name_Fire=dataSnapshot.getValue(String.class);


                databaseReference.child("현재운동분야").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        sports_Field_Fire = dataSnapshot.getValue(String.class);
                        databaseReference=firebaseDatabase.getReference().child(sports_Field_Fire).child(sports_name_Fire);
                        databaseReference.addValueEventListener(new ValueEventListener() {

                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                name=dataSnapshot.child("name").getValue().toString();
                                photo=dataSnapshot.child("photo_name").getValue().toString();
                                simple_info=dataSnapshot.child("simple_info").getValue().toString();
                                event=dataSnapshot.child("event").getValue().toString();
                                detail_info=dataSnapshot.child("detail_info").getValue().toString();

                                int  getID = getDraw_id("drawable",photo);

                                Sports_name.setText(name);
                                Spl_name.setText(event);
                                Spl_info.setText(simple_info);
                                Details_info_.setText(detail_info);
                                SP_img.setImageResource(getID);

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Button back_Btn = (Button) findViewById(R.id.BackBtn);
        back_Btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onBackPressed();
            }
        });

        Button company_go_btn = (Button) findViewById(R.id.Com_button);
        company_go_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Details_info.this, Exercise_page.class);
                startActivity(intent);
            }
        });

        try {
            JSONObject jsonObject = new JSONObject(getJson());
            JSONArray jsonArray = jsonObject.getJSONArray("현재운동분야");

            //jsonArray.
        }catch (Exception e){

        }
//        Spl_name.setText(sp_name);
//        Spl_info.setText(info);
//        Details_info_.setText(D_info);
    }

    private int getDraw_id (String type, String name){
        int getId = getResources().getIdentifier("com.limmihee.seouls:"+type+"/"+name,null,null);
        return getId;
    }



    private String getJson(){
        String json="";

        try {
            InputStream is = getAssets().open("seouls-export.json");
            int size = is.available();
            byte [] buffer = new  byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");

        }catch (Exception e){
            e.printStackTrace();
        }

        return json;
    }
}
