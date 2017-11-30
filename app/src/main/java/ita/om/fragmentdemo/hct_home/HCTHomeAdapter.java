package ita.om.fragmentdemo.hct_home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ita.om.fragmentdemo.R;

/**
 * Created by sasmob on 11/29/2017.
 */

public class HCTHomeAdapter extends RecyclerView.Adapter<HCTHomeAdapter.ViewHolder> {
    Context mContext;
    ArrayList<HomeItems> homeItems;
    public OnAdapterItemClick onItemClick;

    public interface  OnAdapterItemClick{
        public void onItemClick(int position);
    }

    public HCTHomeAdapter(Context mContext, ArrayList<HomeItems> homeItems) {
        this.mContext = mContext;
        this.homeItems = homeItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater= (LayoutInflater) mContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.home_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
         HomeItems items= homeItems.get(position);
         holder.home_items.setText(items.getHomeImage());
         holder.home_image.setImageResource(items.getHomeImage());
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onItemClick.onItemClick(position);
             }
         });
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView home_items;
        ImageView home_image;
        public ViewHolder(View itemView) {
            super(itemView);
         home_items= (TextView)   itemView.findViewById(R.id.textView);
         home_image=(ImageView)   itemView.findViewById(R.id.imageView);


        }
    }
    public void setOnItemClick(OnAdapterItemClick onItemClick){
        this.onItemClick=onItemClick;
    }
}
