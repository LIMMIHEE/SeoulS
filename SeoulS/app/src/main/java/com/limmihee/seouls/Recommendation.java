package com.limmihee.seouls;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Recommendation extends AppCompatActivity {

    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;
    RadioGroup radioGroup5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

            radioGroup1 = (RadioGroup)findViewById(R.id.Group1);         radioGroup2 = (RadioGroup)findViewById(R.id.Group2);
            radioGroup3 = (RadioGroup)findViewById(R.id.Group3);         radioGroup4 = (RadioGroup)findViewById(R.id.Group4);
            radioGroup5 = (RadioGroup)findViewById(R.id.Group5);

            radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup radioGroup,  int id) {
                    if(id == R.id.g_1_1){
                        Toast.makeText(Recommendation.this, "라디오 그룹 버튼1 눌렸습니다."+id, Toast.LENGTH_SHORT).show();
                    }
                    else if(id == R.id.g_1_2){
                        Toast.makeText(Recommendation.this, "라디오 그룹 버튼2 눌렸습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            });


    }
}
