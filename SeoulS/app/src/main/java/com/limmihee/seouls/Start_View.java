package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class Start_View extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__view);
        final Intent intent = new Intent(this,MainActivity.class);

        textView = (TextView) findViewById(R.id.inter);

        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo network = connectivityManager.getActiveNetworkInfo();

        if(network!=null &&network.isConnected()){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    startActivity(intent);
                }
            }, 1500);
        }  else {
            Toast.makeText(getApplicationContext(), "인터넷에 연결해 주세요", Toast.LENGTH_LONG).show();
            textView.setText("인터넷에 연결해 주세요");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {


                    moveTaskToBack(true);						// 태스크를 백그라운드로 이동
                    finishAndRemoveTask();						// 액티비티 종료 + 태스크 리스트에서 지우기
                    android.os.Process.killProcess(android.os.Process.myPid());	// 앱 프로세스 종료
                }
            }, 3000);

        }

    }
}
