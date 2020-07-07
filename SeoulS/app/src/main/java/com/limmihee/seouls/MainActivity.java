package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

import java.io.File;
import java.io.IOException;

import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity implements SensorEventListener{
    CardView cardView;
    Button recom_btn;


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    SensorManager manager;
    Sensor sensor;

    private int Steps = 0;
    private int CounterSteps = 0;


    TextView Step_count;
    TextView view_City;
    TextView view_temp;
    TextView view_Humidity;
    ImageView view_wether;

    Button siteBtn;
    Button AquaBtn;
    Button AthleticsBtn;
    Button TestBtn;
    Button todobtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);


        Step_count = (TextView)findViewById(R.id.step_count);
        TestBtn = (Button) findViewById(R.id.button8) ;
        todobtn = (Button) findViewById(R.id.Todo_btn);
        siteBtn = (Button)  findViewById(R.id.site_move);
        AquaBtn = (Button)  findViewById(R.id.apua);
        AthleticsBtn = (Button)  findViewById(R.id.athletics);

        Step_count.setText(Steps+"걸음");

        view_Humidity=(TextView)findViewById(R.id.Humidity);
        view_City= (TextView)findViewById(R.id.City_name);
        view_temp= (TextView)findViewById(R.id.Temperature);
        view_wether=(ImageView) findViewById(R.id.wether_img) ;
        cardView =findViewById(R.id.slide);
        recom_btn= (Button) findViewById(R.id.button3);

        api_Key();

        databaseReference = firebaseDatabase.getReference();


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
                databaseReference.child("현재운동분야").setValue("수상");
                Intent intent =  new Intent(MainActivity.this,AquaticSports.class);
                startActivity(intent);
            }
        });
        AthleticsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("현재운동분야").setValue("육상");
                Intent intent =  new Intent(MainActivity.this,Athletics.class);
                startActivity(intent);
            }
        });
        TestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Calltel = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:02-3780-0777"));
                startActivity(Calltel);
            }
        });
        todobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this,Todo_list.class);
                startActivity(intent);
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
    public void onStart() {
        super.onStart();
        if(sensor !=null){
            //센서의 속도 설정
            manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_GAME);
        }
    }
    public void onStop(){
        super.onStop();
        if(manager!=null){
            manager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_STEP_COUNTER){

            //stepcountsenersor는 앱이 꺼지더라도 초기화 되지않는다. 그러므로 초기값을 가지고 있어야한다.
            if (CounterSteps < 1) {
                CounterSteps = (int) event.values[0];
            }
            //리셋 안된 값 + 현재값 - 리셋 안된 값
            Steps = (int) (CounterSteps+event.values[0]) - CounterSteps;
            Step_count.setText(Steps+"걸음");

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override public void onBackPressed()
    {
        //super.onBackPressed();
    }
}
