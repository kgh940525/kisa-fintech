package com.kisa.kgh.kisa_fintech.funding_list;

import android.app.Activity;
import android.content.Context;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kisa.kgh.kisa_fintech.R;


import java.util.ArrayList;
public class MyFundingListAdapter extends RecyclerView.Adapter<MyFundingListAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<MyFundingListItem> dataList;

    public MyFundingListAdapter(Activity activity, ArrayList<MyFundingListItem> dataList) {
        this.activity = activity;
        this.dataList = dataList;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView my_Image;
        TextView my_money,my_percent,my_date,my_farmer,my_category,my_title;
        SeekBar my_seekbar;
        public ViewHolder(View itemView) {
            super(itemView);
            my_Image = (ImageView) itemView.findViewById(R.id.my_image);
            my_money = (TextView) itemView.findViewById(R.id.current_money);
            my_percent = (TextView) itemView.findViewById(R.id.current_percent);
            my_date = (TextView) itemView.findViewById(R.id.remain_date);
            my_farmer = (TextView) itemView.findViewById(R.id.txt_funding_list_farmer_name);
            my_category = (TextView) itemView.findViewById(R.id.txt_funding_list_category_name);
            my_title = (TextView) itemView.findViewById(R.id.txt_funding_list_title);
            my_seekbar = (SeekBar) itemView.findViewById(R.id.seekBar);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activity, "click " + dataList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Toast.makeText(activity, "remove " + dataList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                    removeItem(getAdapterPosition());
                    return false;
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_my_funding_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        MyFundingListItem tmpData = dataList.get(position);

        holder.my_farmer.setText(tmpData.getFarmer());
       // holder.my_Image.setImageURI(Uri.parse(tmpData.getUrl("https://s.pstatic.net/static/www/img/2018/img_cl_electionx2.png")));
        holder.my_category.setText(tmpData.getCategory());
        holder.my_percent.setText(String.valueOf(tmpData.getPercent()));
        holder.my_money.setText(String.valueOf(tmpData.getMoney()));
        holder.my_title.setText(tmpData.getTitle());
        holder.my_date.setText(tmpData.getDate());
        //holder.my_seekbar.setMax(tmpData.getPercent());


        // 글라이더 이미지 처리 하기


        //Glide.with(activity).load(dataList.get(position).getUrl("https://s.pstatic.net/static/www/img/2018/img_cl_electionx2.png")).into(holder.my_Image);



        switch(tmpData.getImageNumber()){
            case 1:
                holder.my_Image.setImageResource(R.drawable.ic_launcher_background);
                break;
            case 2:
                holder.my_Image.setImageResource(R.drawable.ic_launcher_background);
                break;
            case 3:
                holder.my_Image.setImageResource(R.drawable.ic_launcher_background);
                break;
            case 4:
                holder.my_Image.setImageResource(R.drawable.ic_launcher_background);
                break;
        }
    }

    private void removeItem(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, dataList.size()); // 지워진 만큼 다시 채워넣기.
    }
}
