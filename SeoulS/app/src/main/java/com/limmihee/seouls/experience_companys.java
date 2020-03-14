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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class experience_companys extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    private MapView mapView;

    private double Map_x=37.56;
    private double Map_y=126.97;

    private String Map_name="체험장소";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_companys);

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
                Call("1111");
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
