package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    experience_point experience_point;

    public Sports_DB sports_db;
    experience_point Experience_point;
    public companies companies_DB;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    String img_name[]={"water_sports_1","water_sports_2","water_sports_3","water_sports_4"
            ,"water_sports_5","water_sports_6","water_sports_7","jeremy","tennis","badminton","archery","baseball",
            "volleyball","foot_volleyball","soccer","basketball","inline"};
    String Sports_names[]={"잠실 한강공원","뚝섬 한강공원","잠원 한강공원","반포 한강공원","이촌 한강공원"
            ,"여의도 한강공원","양화 한강공원","망원 한강공원","테니스","배드민턴","양궁","야구",
            "배구","족구","축구","농구","인라인"};
    String now_sport="";
    int rand_num;

    TextView rand_sports_name;
    ImageView rand_sports_img;

    TextView view_City;
    TextView view_temp;
    ImageView view_wether;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_City= (TextView)findViewById(R.id.City_name);
        view_City.setText("");
        view_temp= (TextView)findViewById(R.id.Temperature);
        view_temp.setText("");

        view_wether=(ImageView) findViewById(R.id.wether_img) ;



        rand_sports();
        api_Key();

        databaseReference = firebaseDatabase.getReference();
        Button aqua_main_btn = (Button) findViewById(R.id.aqua_sports_btn);
        aqua_main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동분야").setValue("수상");
                Intent intent = new Intent(MainActivity.this, AquaticSports.class);
                startActivity(intent);
            }
        });

        Button Arhletics_main_btn = (Button) findViewById(R.id.athletics_sports_btn);
        Arhletics_main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동분야").setValue("육상");
                Intent intent = new Intent(MainActivity.this, Athletics_sports.class);
                startActivity(intent);
            }
        });

        Button ALLBtn = (Button) findViewById(R.id.Site_btn);
        ALLBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hangang.seoul.go.kr/"));
                startActivity(intent);
            }
        });
        Button rand_btn = (Button) findViewById(R.id.rand_info_btn);
        rand_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동분야").setValue(now_sport);
                databaseReference.child("현재운동").setValue(Sports_names[rand_num]);
                Intent intent = new Intent(MainActivity.this,  Details_info.class);
                startActivity(intent);
            }
        });

    }

    private void api_Key() {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?q=Korea,seoul&appid=6d227a80ea70b832267d7aebe7cc6668")
                .get()
                .build();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Response response = client.newCall(request).execute();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {

                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    String responData = response.body().string();
                    try {
                        JSONObject json  = new JSONObject(responData);
                        JSONArray array = json.getJSONArray("weather");
                        JSONObject object = array.getJSONObject(0);


                        String icon = object.getString("icon");

                        JSONObject temlp = json.getJSONObject("main");
                        Double Temprature = temlp.getDouble("temp") - 273.15;


                        setText(view_City, "서울");
                        String temps = Math.round(Temprature)+" ℃";
                        setText(view_temp, temps);
                        setImage(view_wether,icon);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void setText (final TextView textView, final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(value);
            }
        });
    }
    private void setImage (final ImageView imageView, final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
              switch (value){
                  case "01d": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d01d)); break;
                  case "01n": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d01d)); break;
                  case "02d": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d02d)); break;
                  case "02n": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d02d)); break;
                  case "03d": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d03d)); break;
                  case "03n": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d03d)); break;
                  case "04d": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d04d)); break;
                  case "04n": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d04d)); break;
                  case "09d": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d09d)); break;
                  case "09n": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d09d)); break;
                  case "10d": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d10d)); break;
                  case "10n": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d10d)); break;
                  case "11d": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d11d)); break;
                  case "11n": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d11d)); break;
                  case "13d": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d13d)); break;
                  case "13n": imageView.setImageDrawable(getResources().getDrawable(R.drawable.d13d)); break;
                  default:  imageView.setImageDrawable(getResources().getDrawable(R.drawable.d04d)); break;
              }
            }
        });
    }
    public void rand_sports(){
        Random random = new Random();
        rand_num = random.nextInt(17)+1;
        if(rand_num <=8){
            now_sport="수상";
        }else{
            now_sport="육상";
        }

        rand_sports_name=(TextView)findViewById(R.id.rand_name);
        rand_sports_name.setText(Sports_names[rand_num]);

        rand_sports_img=(ImageView)findViewById(R.id.rand_img);
        int Get_img_id =  getDraw_id("drawable",img_name[rand_num]);
        rand_sports_img.setImageResource(Get_img_id);

    }
    private int getDraw_id (String type, String name){
        int getId = getResources().getIdentifier("com.limmihee.seouls:"+type+"/"+name,null,null);
        return getId;
    }


}
