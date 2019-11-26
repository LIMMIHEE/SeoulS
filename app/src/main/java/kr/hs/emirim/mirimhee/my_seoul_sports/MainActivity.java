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


public class MainActivity extends AppCompatActivity {

    private TextView Seachtext;
    private ImageButton SearchimgButton;

    private RecyclerView REcycleView;
    private DatabaseReference mSportsDatabase;


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





        // 파이어 베이스
        mSportsDatabase = FirebaseDatabase.getInstance().getReference("Sports");

        Seachtext =(TextView) findViewById(R.id.seach_text);
        SearchimgButton = (ImageButton) findViewById(R.id.SearchButton);

        REcycleView = (RecyclerView) findViewById(R.id.recyclerView);
        REcycleView.setHasFixedSize(true);
        REcycleView.setLayoutManager(new LinearLayoutManager(this));
        SearchimgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseSportsSearch();
            }
        });

    }

    ////////////////////////파이어 베이스
    private void firebaseSportsSearch() {

        FirebaseRecyclerAdapter<Sports,SportsViewHolder> firebaseRecyclerAdapter =
                /*
            new FirebaseRecyclerAdapter<Sports, SportsViewHolder>() {
                @Override
                protected void onBindViewHolder(@NonNull SportsViewHolder holder, int position, @NonNull Sports model) {


                }

                @NonNull
                @Override
                public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    return null;
                }
            };
*/
                new FirebaseRecyclerAdapter<Sports, SportsViewHolder>(
                Sports.class,
                R.layout.list_layout,
                SportsViewHolder.class,
                mSportsDatabase
        ) {

            protected void populateViewHolder(SportsViewHolder viewHolder, Sports name, int position){
                    viewHolder.setDetails(name.getName(), name.getNumber(), name.getNumber());
            }
        };
        REcycleView.setAdapter(firebaseRecyclerAdapter);
    }


    public static class  SportsViewHolder extends  RecyclerView.ViewHolder {

        View eView;


        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);
            eView = itemView;
        }
    public void setDetails(String spname, String spwhat, String spnumber){

        TextView  sports_name = (TextView) eView.findViewById(R.id.where);
        TextView  sports_what = (TextView) eView.findViewById(R.id.whatsports);
        TextView  sports_number = (TextView) eView.findViewById(R.id.number);

        sports_name.setText(spname);
        sports_what.setText(spwhat);
        sports_number.setText(spnumber);


       // Glide.with(getApplicationContext()).load(spname).into(sports_name);

    }

    }
}
