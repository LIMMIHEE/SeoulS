package com.limmihee.seouls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

import okhttp3.internal.http2.Header;

public class Todo_info extends AppCompatActivity {
    private long StartCountDownTimer=6000;
    //파이어베이스에서 가져오면 안된다. 따로 방법을 갈구 해야할듯.


    private long CountDownTimer;
    private int Count_time=0;
    private  long TimeLeftIWillis = StartCountDownTimer;

    Handler handler ;
    Runnable runnable;

    private android.os.CountDownTimer mCountDownTimer;
    private boolean IsTimerWork;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    Button Start_btn;
    Button Pause_btn;
    Button Del_Btn;

    ProgressBar progressBar;

    TextView todo_name;
    TextView todo_info;
    TextView todo_time;
    TextView Percent;


    String TODO_NAME;
    String TODO_Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_info);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Start_btn = (Button) findViewById(R.id.timer_play);
        Pause_btn = (Button) findViewById(R.id.timer_pause);
        Del_Btn = (Button) findViewById(R.id.todo_del);

        Percent = (TextView) findViewById(R.id.Time_Percent);
        todo_name = (TextView) findViewById(R.id.todo_name);
        todo_info = (TextView) findViewById(R.id.todo_info);
        todo_time= (TextView) findViewById(R.id.TODO_time);

        databaseReference.child("현재TODO").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                TODO_NAME = dataSnapshot.getValue().toString();
                todo_name.setText(TODO_NAME);
                databaseReference.child("TODO").child(TODO_NAME).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        todo_info.setText(dataSnapshot.child("info").getValue().toString());
//                        todo_time.setText("목표 시간 "+dataSnapshot.child("time").getValue().toString()+"시간");
                        todo_time.setText("목표 시간 "+dataSnapshot.child("time").getValue().toString()+"시간 중");
                        StartCountDownTimer =  Long.parseLong(dataSnapshot.child("time").getValue().toString());
                        StartCountDownTimer *= 3600000;
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

        TODO_Time = (String) todo_time.getText();
        //StartCountDownTimer = Long.parseLong(TODO_Time);

        progressBar.setProgress(10);

        //todo_time.setText("목표 시간 "+TODO_Time+"시간");
        StartCountDownTimer = 600000;
        handler = new Handler();
         runnable = new Runnable() {
            @Override
            public void run() {
                Count_time++;

                //Percent.setText(StartCountDownTimer+"중 "+Count_time+"%");
//                int persent =(int)(Count_time*1000/(StartCountDownTimer)*100);
                if(Count_time*1000==StartCountDownTimer){
                    handler.removeCallbacks(runnable);
                }
                Percent.setText((Count_time*1000/60000)+"분");
//                progressBar.setProgress((int)(Count_time*1000/(StartCountDownTimer)*100));
                handler.postDelayed(this,1000);

            }
        };
         //600,000 = 10분
        //3,600,000 60분


        Start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    handler.post(runnable);
            }
        });
        Pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
            }
        });
        Del_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Todo_info.this);
                dialog .setTitle("목표 삭제")
                        .setMessage("삭제하시겠습니까?")
                        .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("삭제하기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                databaseReference.child("TODO").child((String) todo_name.getText()).removeValue();
                                Intent intent = new Intent(Todo_info.this,Todo_list.class);
                                startActivity(intent);
                            }
                        }).create().show();

            }
        });



    }

}
