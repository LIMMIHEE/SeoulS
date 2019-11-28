package kr.hs.emirim.mirimhee.my_seoul_sports;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<MainData> arrayList;
    private  MainAdapter mainAdapter;
    private  LinearLayoutManager linearLayoutManager;

    private TextView Seachtext;
    private ImageButton SearchimgButton;

    private RecyclerView recycleView;
    private  RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 전화걸기
        Button call_btn = (Button)findViewById((R.id.call_button));
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction((Intent.ACTION_DIAL));
                intent.setData(Uri.parse("tel:123142"));
                startActivity(intent);
            }
        });

        ArrayList<MainData> exampleList = new ArrayList<>();
        exampleList.add(new MainData(R.drawable.ic_directions_run_, "Line 1", "Line 2"));
        exampleList.add(new MainData(R.drawable.ic_rowing_, "Line 3", "Line 4"));
        exampleList.add(new MainData(R.drawable.ic_subject_, "Line 5", "Line 6"));

    //리싸이클러 뷰
//        recycleView = (RecyclerView)findViewById(R.id.recycler_view_);
//        linearLayoutManager = new LinearLayoutManager(this);
//        recycleView.setLayoutManager(linearLayoutManager);
//
//        arrayList = new ArrayList<>();
//        mainAdapter = new MainAdapter(arrayList);
//        recycleView.setAdapter(mainAdapter);




        // 파이어 베이스
//        mSportsDatabase = FirebaseDatabase.getInstance().getReference("Sports");
//
//        Seachtext =(TextView) findViewById(R.id.seach_text);
//        SearchimgButton = (ImageButton) findViewById(R.id.SearchButton);
//
//        REcycleView = (RecyclerView) findViewById(R.id.recyclerView);
//        REcycleView.setHasFixedSize(true);
//        REcycleView.setLayoutManager(new LinearLayoutManager(this));
//        SearchimgButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                firebaseSportsSearch();
//            }
//        });

    }

    ////////////////////////파이어 베이스

    }
}
