package com.limmihee.seouls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.io.InputStream;

import kotlin.random.Random;

public class experience_companys extends AppCompatActivity implements OnMapReadyCallback {

    TextView Sports_name;
    TextView Spl_Pay;
    TextView simple_info;
    TextView Details_info_;


    Button Call_btn;

    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;

    private GoogleMap mGoogleMap;
    private MapView mapView;

    private double Map_x;
    private double Map_y;

    String Sports_Name;
    String Now_com;

    String name;
    String call_num;
    Bundle Num;

    String Map_info="해당 체험 장소는 이곳입니다.";

    private String Map_name="체험장소";
    String sports_Field_Fire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_companys);

        Num = savedInstanceState;

        Sports_name=(TextView) findViewById(R.id.Com_Name);
        Spl_Pay=(TextView) findViewById(R.id.Com_Pay);
        simple_info=(TextView) findViewById(R.id.simple_info);
        Details_info_=(TextView) findViewById(R.id.Detalis_info);
        Call_btn=(Button)findViewById(R.id.Call_Btn);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        databaseReference.child("현재운동").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Sports_Name=dataSnapshot.getValue().toString();

                databaseReference.child("현재체험장소").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Now_com=dataSnapshot.getValue().toString();

                        databaseReference.child("현재운동분야").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                sports_Field_Fire = dataSnapshot.getValue(String.class);
                                try{
                                    JSONObject jsonObject = new JSONObject(getJson());
                                    String sport = jsonObject.getString(sports_Field_Fire);
                                    JSONObject jsonObject2 = new JSONObject(sport);
                                    String sport1 = jsonObject2.getString(Sports_Name);
                                    JSONObject jsonObject3 = new JSONObject(sport1);
                                    String sport1_1 = jsonObject3.getString("체험장소");
                                    JSONObject jsonObject3_1 = new JSONObject(sport1_1);
                                    String sport2 = jsonObject3_1.getString(Now_com);
                                    JSONObject jsonObject4 = new JSONObject(sport2);

                                    Sports_name.setText(jsonObject4.getString("name"));
                                    Spl_Pay.setText(jsonObject4.getString("pay"));
                                    simple_info.setText(jsonObject4.getString("simple_info"));
                                    Details_info_.setText(jsonObject4.getString("detail_info"));

                                    switch (jsonObject4.getString("name")){
                                        case "광나루 한강공원": Map_x=37.548804; Map_y=127.120044 ; break;
                                        case "난지 한강공원": Map_x= 37.566154; Map_y=126.876389 ; break;
                                        case "뚝섬 한강공원": Map_x= 37.529179; Map_y=127.071335; break;
                                        case "망원 한강공원": Map_x= 37.555724; Map_y= 126.894571 ; break;
                                        case "반포 한강공원": Map_x= 37.509784; Map_y=126.994746 ; break;
                                        case "양화 한강공원": Map_x= 37.538301; Map_y=126.902270 ; break;
                                        case "이촌 한강공원": Map_x= 37.515971; Map_y=126.975833; break;
                                        case "잠원 한강공원": Map_x= 37.521403; Map_y=127.011954 ; break;
                                        case "잠실 한강공원": Map_x= 37.518019; Map_y=127.081901 ; break;

                                        case "아리랑하우스": Map_x= 37.528229; Map_y=127.067777; break;
                                        case "씨에이글로벌": Map_x= 37.553368; Map_y=126.896609 ; break;
                                        case "요트에베뉴": Map_x= 37.505841; Map_y=126.981121; break;
                                        case "튜브스터코리아": Map_x= 37.511341; Map_y=126.995309 ; break;
                                        case "한강레저스포츠": if(Sports_Name=="여의도 한강공원"){
                                            Map_x= 37.522817;Map_y=126.941650;
                                        } else{Map_x= 37.528357; Map_y= 126.935157; } break;
                                        case "서울마리나": Map_x= 37.534764; Map_y=126.911554 ; break;
                                        case "파라다이스": Map_x= 37.522740; Map_y=126.941621; break;
                                        case "프라이어스이노베이션": Map_x= 37.518361; Map_y=127.081583; break;
                                        case "ON수상레저": Map_x= 37.527333; Map_y=127.017861; break;
                                        case "화창레저산업": Map_x= 37.518964; Map_y=127.008030; break;
                                        default: Map_x= 0; Map_y=0; Map_info="해당 장소를 찾을 수 없습니다.";break;
                                    }

                                    onMapReady(mGoogleMap);
                                    call_num=(jsonObject4.getString("phone_num"));
                                }catch (Exception e){
                                    Toast.makeText(experience_companys.this, ". : "+e, Toast.LENGTH_SHORT).show();
                                }



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
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


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
                Call(call_num);
            }
        });


    }






    public void Call (String Number){
        String tel = "tel:"+Number;
        Intent Calltel = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
        startActivity(Calltel);
    }

    @Override
    protected  void onStart(){
        super.onStart();

        mapView=findViewById(R.id.mapView);
        mapView.onCreate(Num);
        mapView.getMapAsync(this);

        mapView.onStart();


    }
    @Override
    protected  void onResume(){
        super.onResume();
        mapView.onResume();
    }
    @Override
    protected  void onPause(){
        super.onPause();
        mapView.onPause();
    }
    @Override
    protected  void onStop(){
        super.onStop();
        mapView.onStop();
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        googleMap.animateCamera(zoom);


        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(Map_x, Map_y));
        markerOptions.title(Sports_name.getText().toString());
        markerOptions.snippet(Map_info);
        mGoogleMap.addMarker(markerOptions).showInfoWindow();

        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(Map_x, Map_y)));
        //mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(14));


        // Log.d("MAP_DEBUG","onMapReady: map is showing on the screen");
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
