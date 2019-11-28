package kr.hs.emirim.mirimhee.my_seoul_sports;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> implements Filterable {

    private ArrayList<MainData> arrayList;
    private ArrayList<MainData> arrayList_Full;

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
        arrayList_Full = new ArrayList<>(arrayList);
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,false);
          CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder holder, int position) {
            holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
            holder.iv_name.setText(arrayList.get(position).getIv_name());
            holder.iv_number.setText(arrayList.get(position).getIv_number());

            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String curName  = holder.iv_name.getText().toString();
                    Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
                }
            });

//            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//                    return true;
//                }
//            });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    @Override
    public Filter getFilter() {
        return arrayFilter;
    }

    private Filter arrayFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<MainData> filteredList = new ArrayList<>();

            if(charSequence ==null || charSequence.length() ==0){
                filteredList.addAll(arrayList_Full);
            }else{
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for(MainData item : arrayList_Full){
                    if(item.getIv_name().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults  results  = new FilterResults();
            results.values = filteredList;

            return  results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            arrayList.clear();
            arrayList.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView iv_name;
        protected  TextView iv_number;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile=(ImageView) itemView.findViewById(R.id.iv_profile);
            this.iv_name = (TextView) itemView.findViewById(R.id.iv_name);
            this.iv_number = (TextView) itemView.findViewById(R.id.iv_number);
        }
    }
}
