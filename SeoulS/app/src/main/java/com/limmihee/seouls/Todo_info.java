package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Todo_info extends AppCompatActivity {
    private long StartCountDownTimer;


    private long CountDownTimer;
    private  long TimeLeftIWillis = StartCountDownTimer;

    private android.os.CountDownTimer mCountDownTimer;
    private boolean IsTimerWork;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    Button Start_btn;
    Button Pause_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_info);

        //StartCountDownTimer = 파이어 베이스 가져오기
        //https://sosolife.tistory.com/518 퍼센트 계산
        //https://www.youtube.com/watch?v=MDuGwI6P-X8

        Start_btn = (Button) findViewById(R.id.timer_play);
        Pause_btn = (Button) findViewById(R.id.timer_pause);

        Start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(IsTimerWork){
                    pauseTimer();
                }
            }
        });
        Pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
            }
        });
        updateCounteDown();
    }
    private void pauseTimer(){
        mCountDownTimer.cancel();
        IsTimerWork = false;

    }
    private void StartTimer(){
        mCountDownTimer = new CountDownTimer(TimeLeftIWillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TimeLeftIWillis = millisUntilFinished;
                updateCounteDown();
            }

            @Override
            public void onFinish() {
                IsTimerWork=false;
            }
        }.start();
        IsTimerWork=true;
    }

    private void updateCounteDown(){
        int minutes = (int)(TimeLeftIWillis / 1000/60);
    }
}
