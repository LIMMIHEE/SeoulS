package com.limmihee.seouls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    Button back_btn;

    TextView todo_name;
    TextView todo_info;
    TextView todo_time;
    TextView Percent;
    TextView time_second_view;


    String TODO_NAME;
    String TODO_Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_info);


        Start_btn = (Button) findViewById(R.id.timer_play);
        Pause_btn = (Button) findViewById(R.id.timer_pause);
        Del_Btn = (Button) findViewById(R.id.todo_del);
        back_btn = (Button) findViewById(R.id.backBtn);

        Percent = (TextView) findViewById(R.id.Time_Percent);
        todo_name = (TextView) findViewById(R.id.todo_name);
        todo_info = (TextView) findViewById(R.id.todo_info);
        todo_time= (TextView) findViewById(R.id.TODO_time);
        time_second_view = (TextView) findViewById(R.id.time_second);

        databaseReference.child("현재TODO").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                TODO_NAME = dataSnapshot.getValue().toString();
                todo_name.setText(TODO_NAME);
                databaseReference.child("TODO").child(TODO_NAME).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Count_time = Integer.parseInt(dataSnapshot.child("advanced_time").getValue().toString());
                        first_set_time();
                        todo_info.setText(dataSnapshot.child("info").getValue().toString());
//                        todo_time.setText("목표 시간 "+dataSnapshot.child("time").getValue().toString()+"시간");
                        todo_time.setText("목표 시간 "+dataSnapshot.child("time").getValue().toString()+"분 중");
                        StartCountDownTimer =  Long.parseLong(dataSnapshot.child("time").getValue().toString());
                        StartCountDownTimer *= 10000;
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



        //todo_time.setText("목표 시간 "+TODO_Time+"시간");
        handler = new Handler();
         runnable = new Runnable() {
            @Override
            public void run() {
                Count_time++;

                //Percent.setText(StartCountDownTimer+"중 "+Count_time+"%");
//                int persent =(int)(Count_time*1000/(StartCountDownTimer)*100);
                if(Count_time*1000==StartCountDownTimer){

                    Percent.setText("목표 달성 완료!");
                    time_second_view.setText("완벽해요!");
                    Percent.setTextColor(Color.parseColor("#FF00FFF2"));
                    time_second_view.setTextColor(Color.parseColor("#FF00FFF2"));

                    handler.removeCallbacks(runnable);

                }
                if(Count_time*1000/60000 >= 60){
                    int t = (Count_time*1000/60000)/60;
                    Percent.setText(t+"시간 "+((Count_time*1000/60000)%60)+"분");
                }else{
                    Percent.setText((Count_time*1000/60000)+"분");
                }


                if(Count_time/60>=1){
                    time_second_view.setText(Count_time%60+"초");
                }else{
                    time_second_view.setText(Count_time+"초");
                }
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
                Percent.setTextColor(Color.parseColor("#03A9F4"));
                time_second_view.setTextColor(Color.parseColor("#03A9F4"));
            }
        });
        Pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child("TODO").child(TODO_NAME).child("advanced_time").setValue(Count_time);
                handler.removeCallbacks(runnable);
                Percent.setTextColor(Color.parseColor("#1E1E1E"));
                time_second_view.setTextColor(Color.parseColor("#1E1E1E"));
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
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Todo_info.this,Todo_list.class);
                startActivity(intent);
            }
        });


    }
    private void first_set_time(){
        if(Count_time*1000/60000 >= 60){
            int t = (Count_time*1000/60000)/60;
            Percent.setText(t+"시간 "+((Count_time*1000/60000)%60)+"분");
        }else{
            Percent.setText((Count_time*1000/60000)+"분");
        }


        if(Count_time/60>=1){
            time_second_view.setText(Count_time%60+"초");
        }else{
            time_second_view.setText(Count_time+"초");
        }
    }
    @Override
    public void onBackPressed(){

        //sss
    }
}
