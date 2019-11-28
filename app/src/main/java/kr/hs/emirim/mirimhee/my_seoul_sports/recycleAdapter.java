package kr.hs.emirim.mirimhee.my_seoul_sports;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.ExampleViewHolder> {
    private ArrayList<MainData> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_profile);
            mTextView1 = itemView.findViewById(R.id.iv_name);
            mTextView2 = itemView.findViewById(R.id.iv_number);
        }
    }

    public recycleAdapter(ArrayList<MainData> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        MainData currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getIv_profile());
        holder.mTextView1.setText(currentItem.getIv_name());
        holder.mTextView2.setText(currentItem.getIv_number());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}