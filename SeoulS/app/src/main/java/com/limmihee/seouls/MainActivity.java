package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.JsonWriter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    CardView cardView;
    Adapter adapter;
    List<Model> models ;


    Button recom_btn;



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
    TextView view_Humidity;
    ImageView view_wether;

    Button siteBtn;
    Button AquaBtn;
    Button AthleticsBtn;
    Button TestBtn;
    JSONObject jsonObject;
    String now_part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            jsonObject = new JSONObject(get_Json());
            now_part  = jsonObject.getString("현재운동분야");
        }catch (Exception e){

        }


        TestBtn = (Button) findViewById(R.id.button8) ;

        siteBtn = (Button)  findViewById(R.id.site_move);
        AquaBtn = (Button)  findViewById(R.id.apua);
        AthleticsBtn = (Button)  findViewById(R.id.athletics);

        view_Humidity=(TextView)findViewById(R.id.Humidity);
        view_City= (TextView)findViewById(R.id.City_name);
        view_City.setText("");
        view_temp= (TextView)findViewById(R.id.Temperature);
        view_temp.setText("");
        view_wether=(ImageView) findViewById(R.id.wether_img) ;
        cardView =findViewById(R.id.slide);
        recom_btn= (Button) findViewById(R.id.button3);



//        models = new ArrayList<>();
//        models.add(new Model(R.drawable.water_sports_4,"#TEST","Test"));
////        models.add(new Model(R.drawable.water_sports_1,"#나와_맞는_스포츠찾기","테스트를 통해 나와 맞는 스포츠의 장소와 위치를 찾아보세요!"));
////        models.add(new Model(R.drawable.water_sports_4,"#서울 날씨","4"));
////        models.add(new Model(R.drawable.water_sports_2,"#육상스포츠"," 실내 혹은 실외 등! 다양한 육상 스포츠들에 대해 알아보세요"));
////        models.add(new Model(R.drawable.water_sports_3,"#수상스포츠"," 보드 혹은 스키까지! 다양한 수상 스포츠들에 대해 알아보세요"));
//
//        adapter = new Adapter(models , this);
//
//
//
//        viewPager = findViewById(R.id.select);
//        viewPager.setAdapter(adapter);
//        viewPager.setPadding(150,0,150,0);





        //rand_sports();
        api_Key();

        databaseReference = firebaseDatabase.getReference();
        Button aqua_main_btn = (Button) findViewById(R.id.apua);
        aqua_main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동분야").setValue("수상");
                Intent intent = new Intent(MainActivity.this, AquaticSports.class);
                startActivity(intent);
            }
        });

        Button Arhletics_main_btn = (Button) findViewById(R.id.athletics);
        Arhletics_main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseReference.child("현재운동분야").setValue("육상");
                Intent intent = new Intent(MainActivity.this, Athletics_sports.class);
                startActivity(intent);
            }
        });

//        Button rand_btn = (Button) findViewById(R.id.rand_info_btn);
//        rand_btn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                databaseReference.child("현재운동분야").setValue(now_sport);
//                databaseReference.child("현재운동").setValue(Sports_names[rand_num]);
//                Intent intent = new Intent(MainActivity.this,  Details_info.class);
//                startActivity(intent);
//            }
//        });
        recom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,Recommendation.class);
                startActivity(intent);
            }
        });

        siteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hangang.seoul.go.kr/"));
                startActivity(intent);
            }
        });
        AquaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,AquaticSports.class);
                startActivity(intent);
            }
        });
        AthleticsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,Athletics_sports.class);
                startActivity(intent);
            }
        });
        TestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "클릭함 : "+now_part, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void api_Key() {
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=6d227a80ea70b832267d7aebe7cc6668")
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
                        String humidity = "습도 : "+temlp.getString("humidity")+"%";

                        setText(view_Humidity,humidity);
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

        //rand_sports_name=(TextView)findViewById(R.id.rand_name);
        rand_sports_name.setText(Sports_names[rand_num]);

        //rand_sports_img=(ImageView)findViewById(R.id.rand_img);
        int Get_img_id =  getDraw_id("drawable",img_name[rand_num]);
        rand_sports_img.setImageResource(Get_img_id);

    }
    private int getDraw_id (String type, String name){
        int getId = getResources().getIdentifier("com.limmihee.seouls:"+type+"/"+name,null,null);
        return getId;
    }

    private String get_Json(){
        String Json=null;
        try {
            InputStream is = getAssets().open("seouls-export.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            Json = new String(buffer,"UTF-8");
//            JSONObject jsonObject = new JSONObject();


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return Json;
    }

}
