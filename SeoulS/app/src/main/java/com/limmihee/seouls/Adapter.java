package com.limmihee.seouls;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends PagerAdapter {
    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;
    String aqua[] = {"요트" , "조정" , "모터보트", "수상스키", "웨이크보드", "윈드서핑", "바나나보트",
            "튜브스터","카약", "카누", "딩기요트" ,"땅콩보트", "수상오토바이", "워터 보드", "블롭 점프"};

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;
    private boolean IsVisi=false;

    private int num=1;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView title,desc;
        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImg());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = (models.get(position).getTitle()).replace(" ",""); // 결과 이름 가져오기
                try{
                    for(int i=0; i<aqua.length; i++){
                        if(aqua[i] == name){
                            IsVisi=true;
                            break;
                        }
                    }

                   //Toast.makeText(((Ani_test)Ani_test.context), "테스트 : "+jsonArray, Toast.LENGTH_SHORT).show();
                    if(IsVisi){
                            JSONObject jsonObject = new JSONObject(getJson());
                            JSONArray jsonArray = jsonObject.getJSONArray(name);
                            Random rnd = new Random();
                            int p = rnd.nextInt(jsonArray.length());
                            databaseReference.child("현재운동").setValue(jsonArray.get(p));
                            databaseReference.child("현재운동분야").setValue("수상");
                    }else{
                        databaseReference.child("현재운동").setValue(name);
                        databaseReference.child("현재운동분야").setValue("육상");
                    }
                }catch (Exception e){
                    Log.e(this.getClass().getName(),e+"오류 사랑");
                    Toast.makeText(((Ani_test)Ani_test.context), "오류 : "+e, Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(((Ani_test)Ani_test.context), "클릭함 : "+models.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(((Ani_test)Ani_test.context), Details_info.class);
                ((Ani_test)Ani_test.context).startActivity(intent);
            }
        });


        container.addView(view,0);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
    private String getJson(){
        String json="";

        try {
            InputStream is = ((Ani_test)Ani_test.context).getAssets().open("aqua.json");
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
