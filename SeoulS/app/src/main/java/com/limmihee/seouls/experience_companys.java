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

    private double Map_x=37.56;
    private double Map_y=126.97;

    String Sports_Name;
    String Now_com;

    String name;
    String call_num;
    String simple_info_S;
    String Pay;
    String detail_info;

    private String Map_name="체험장소";
    String sports_Field_Fire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_companys);

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


                                databaseReference.child(sports_Field_Fire).child(Sports_Name).child("체험장소").child(Now_com).addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        name = dataSnapshot.child("name").getValue().toString();
                                        detail_info = dataSnapshot.child("detail_info").getValue().toString();
                                        call_num= dataSnapshot.child("phone_num").getValue().toString();
                                        simple_info_S = dataSnapshot.child("simple_info").getValue().toString();
                                        Pay= dataSnapshot.child("pay").getValue().toString();

                                        Sports_name.setText(name);
                                        Spl_Pay.setText(Pay);
                                        simple_info.setText(simple_info_S);
                                        Details_info_.setText(detail_info);
//                                Call_btn.setText(call_num);
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

        mapView=findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

        LatLng SEOUL = new LatLng(Map_x, Map_y);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title(Map_name);
        markerOptions.snippet("해당 체험 장소");
        mGoogleMap.addMarker(markerOptions);

        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(20));
       // Log.d("MAP_DEBUG","onMapReady: map is showing on the screen");
    }

    public void Call (String Number){
        String tel = "tel:"+Number;
        Intent Calltel = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
        startActivity(Calltel);
    }

    @Override
    protected  void onStart(){
        super.onStart();
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
}
