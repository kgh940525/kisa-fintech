package com.kisa.kgh.kisa_fintech.funding_detail.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kisa.kgh.kisa_fintech.R;
import com.kisa.kgh.kisa_fintech.funding_detail.model.FundingDetailModel;

import java.util.ArrayList;
import java.util.List;

public class FundingDetailRecyclerViewAdapter extends RecyclerView.Adapter<FundingDetailRecyclerViewAdapter.GenericViewHolder> {

    private List<FundingDetailModel> items = new ArrayList();
    private Context context;

    public FundingDetailRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setItems(List<FundingDetailModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setItem(FundingDetailModel item) {
        items.add(item);
        notifyDataSetChanged();
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
                return new FundingDetailRecycleHeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.item_content_detail_header, parent, false));
            }
            case 2: {
                return new FundingDetailSubHeaderRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_content_detail_sub_header, parent, false));
            }
            default: {
                return new FundingDetailRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_content_detail, parent, false));
            }
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

    abstract class GenericViewHolder extends RecyclerView.ViewHolder {
        public GenericViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void setDataOnView(int position);
    }

    class FundingDetailRecyclerViewHolder extends GenericViewHolder {

        TextView txtTitle;
        TextView txtSubTitle;
        ImageView img;
        TextView txtInfo;


        public FundingDetailRecyclerViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_item_content_detail_title);
            txtSubTitle = itemView.findViewById(R.id.txt_item_content_detail_sub_title);
            txtInfo = itemView.findViewById(R.id.txt_item_content_detail_info);
            img = itemView.findViewById(R.id.img_item_content_detail);
        }

        @Override
        public void setDataOnView(int position) {
            txtTitle.setText(items.get(position).getTitle());
            txtSubTitle.setText(items.get(position).getSubTitle());
            txtInfo.setText(items.get(position).getInfo());
            Glide.with(context).load(items.get(position).getImageUrl()).into(img);
        }
    }

    class FundingDetailSubHeaderRecyclerViewHolder extends GenericViewHolder {

        TextView txtTitle;
        TextView txtCategory;
        TextView txtInfo;
        TextView txtRemindDay;
        TextView txtPercentage;
        SeekBar seekBar;
        TextView txtCurrentFundMoney;
        TextView txtCurrentFundPeople;
        TextView txtGoalFundMoney;
        TextView txtGoalFundStartDay;
        TextView txtGoalFundLastDay;

        public FundingDetailSubHeaderRecyclerViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_content_detail_title);
            txtCategory = itemView.findViewById(R.id.txt_content_detail_category);
            txtInfo = itemView.findViewById(R.id.txt_content_detail_information);
            txtRemindDay = itemView.findViewById(R.id.txt_content_detail_remind_days);
            txtPercentage = itemView.findViewById(R.id.txt_content_detail_gaol_percentage);
            seekBar = itemView.findViewById(R.id.seek_bar_content_detail_percentage);
            txtCurrentFundMoney = itemView.findViewById(R.id.txt_content_detail_current_funding_money);
            txtCurrentFundPeople = itemView.findViewById(R.id.txt_content_detail_current_funding_people);
            txtGoalFundMoney = itemView.findViewById(R.id.txt_content_detail_goal_money);
            txtGoalFundStartDay = itemView.findViewById(R.id.txt_content_detail_funding_start_day);
            txtGoalFundLastDay = itemView.findViewById(R.id.txt_content_detail_funding_last_day);
        }

        @Override
        public void setDataOnView(int position) {
            FundingDetailModel item = items.get(position);
            txtTitle.setText(item.getTitle());
            txtCategory.setText(item.getCategory());
            txtInfo.setText(item.getInfo());
            txtRemindDay.setText(item.getRemindDay());
            txtPercentage.setText(item.getPercentage());
            txtCurrentFundMoney.setText(item.getCurrentMoney());
            txtCurrentFundPeople.setText(item.getCurrentPeople());
            txtGoalFundStartDay.setText(item.getStartDay());
            txtGoalFundLastDay.setText(item.getLastDay());
            txtGoalFundMoney.setText(item.getGoalMoney());
            seekBar.setProgress(10);
        }
    }

    class FundingDetailRecycleHeaderViewHolder extends GenericViewHolder {

        ImageView imgHeader;

        public FundingDetailRecycleHeaderViewHolder(View itemView) {
            super(itemView);
            imgHeader = itemView.findViewById(R.id.img_detail_main);
        }

        @Override
        public void setDataOnView(int position) {
            Glide.with(context).load(items.get(position).getImageUrl()).into(imgHeader);
        }
    }
}