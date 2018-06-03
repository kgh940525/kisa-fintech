package com.kisa.kgh.kisa_fintech.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kisa.kgh.kisa_fintech.R;
import com.kisa.kgh.kisa_fintech.adapters.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.GenericViewHolder> {

    private Context context;

    private List<HomeModel> items = new ArrayList<>();

    public void setItems(List<HomeModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setItem(HomeModel item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public HomeRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getViewType();
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case 1: {
                return new HomeMainRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_header, parent, false));
            }
            case 2: {
                return new HomeRightRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_body_right, parent, false));
            }
            default:
                return new HomeLeftRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_body_left, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.setDataOnView(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class HomeMainRecyclerViewHolder extends GenericViewHolder {

        ImageView img;
        TextView title;
        TextView subTitle;

        public HomeMainRecyclerViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_item_home_main);
            title = itemView.findViewById(R.id.txt_home_header_title);
            subTitle = itemView.findViewById(R.id.txt_home_header_sub_title);
        }

        @Override
        public void setDataOnView(int position) {
            Glide.with(context).load(items.get(position).getImageUrl()).into(img);
            title.setText(items.get(position).getTitle());
            subTitle.setText(items.get(position).getSubTitle());
        }
    }

    class HomeRightRecyclerViewHolder extends GenericViewHolder {

        ImageView img;
        TextView title;
        TextView subTitle;
        TextView percentage;
        TextView price;
        TextView day;

        public HomeRightRecyclerViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_item_home_right);
            title = itemView.findViewById(R.id.txt_item_home_right_title);
            subTitle = itemView.findViewById(R.id.txt_item_home_right_sub_title);
            percentage = itemView.findViewById(R.id.txt_item_home_right_percentage);
            price = itemView.findViewById(R.id.txt_item_home_right_current_money);
            day = itemView.findViewById(R.id.txt_item_home_right_day);
        }

        @Override
        public void setDataOnView(int position) {
            Glide.with(context).load(items.get(position).getImageUrl()).into(img);
            title.setText(items.get(position).getTitle());
            subTitle.setText(items.get(position).getSubTitle());
            percentage.setText(items.get(position).getPercentage());
            price.setText(items.get(position).getCurrentMoney());
            day.setText(items.get(position).getRemindDay());
        }
    }

    class HomeLeftRecyclerViewHolder extends GenericViewHolder {

        ImageView img;
        TextView title;
        TextView subTitle;
        TextView percentage;
        TextView price;
        TextView day;

        public HomeLeftRecyclerViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_item_home_left);
            title = itemView.findViewById(R.id.txt_item_home_left_title);
            subTitle = itemView.findViewById(R.id.txt_item_home_left_sub_title);
            percentage = itemView.findViewById(R.id.txt_item_home_left_percentage);
            price = itemView.findViewById(R.id.txt_item_home_left_current_money);
            day = itemView.findViewById(R.id.txt_item_home_left_day);
        }

        @Override
        public void setDataOnView(int position) {
            Glide.with(context).load(items.get(position).getImageUrl()).into(img);
            title.setText(items.get(position).getTitle());
            subTitle.setText(items.get(position).getSubTitle());
            percentage.setText(items.get(position).getPercentage());
            price.setText(items.get(position).getCurrentMoney());
            day.setText(items.get(position).getRemindDay());
        }
    }

    abstract class GenericViewHolder extends RecyclerView.ViewHolder {
        public GenericViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void setDataOnView(int position);
    }
}
