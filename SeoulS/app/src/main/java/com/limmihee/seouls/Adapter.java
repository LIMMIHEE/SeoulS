package com.limmihee.seouls;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends PagerAdapter {
    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;


    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    private int num=1;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;
        TextView title,desc;
        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImg());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        firebaseDatabase = FirebaseDatabase.getInstance();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> result = ((Recommendation)Recommendation.context).Reco_list;
                try{
                    databaseReference.child("현재운동").setValue(models.get(position).getName());
                }catch (Exception e){
                    Toast.makeText(((Ani_test)Ani_test.context), "클릭함 : "+e, Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(((Ani_test)Ani_test.context), "클릭함 : "+models.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(((Ani_test)Ani_test.context), Details_info.class);
                ((Ani_test)Ani_test.context).startActivity(intent);
            }
        });


        container.addView(view,0);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }
}
