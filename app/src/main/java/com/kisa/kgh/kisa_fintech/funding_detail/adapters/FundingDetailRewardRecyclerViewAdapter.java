package com.kisa.kgh.kisa_fintech.funding_detail.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kisa.kgh.kisa_fintech.R;
import com.kisa.kgh.kisa_fintech.funding_detail.model.FundingRewardModel;

import java.util.ArrayList;
import java.util.List;

public class FundingDetailRewardRecyclerViewAdapter extends RecyclerView.Adapter<FundingDetailRewardRecyclerViewAdapter.FundingDetailRewardRecyclerViewHolder> {

    private Context context;

    private List<FundingRewardModel> items = new ArrayList<>();

    public void setItems(List<FundingRewardModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void addItem(FundingRewardModel item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public FundingDetailRewardRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public List<FundingRewardModel> getItems() {
        return items;
    }

    @NonNull
    @Override
    public FundingDetailRewardRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FundingDetailRewardRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_select_reward, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final FundingDetailRewardRecyclerViewHolder holder, final int position) {
        holder.txtRewardName.setText(items.get(position).getRewardName());
        holder.txtRewardCost.setText(items.get(position).getRewardCost());
        holder.txtRewardMoney.setText(items.get(position).getRewardMoney());
        holder.txtRewardPrediction.setText(items.get(position).getRewardPrediction());
        holder.txtRewardSale.setText(items.get(position).getRewardSale());
        holder.txtRewardDelivery.setText(items.get(position).getRewardDelivery());

        if (!items.get(position).isDoing()) {
            holder.layoutSale.setVisibility(View.VISIBLE);
            holder.checkBox.setClickable(false);
        } else {
            holder.layoutSale.setVisibility(View.GONE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    items.get(position).setCheck(!items.get(position).isCheck());
                    if (items.get(position).isCheck()) {
                        holder.checkBox.setChecked(true);
                    } else {
                        holder.checkBox.setChecked(false);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class FundingDetailRewardRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView txtRewardName;
        TextView txtRewardMoney;
        TextView txtRewardCost;
        TextView txtRewardSale;
        TextView txtRewardDelivery;
        TextView txtRewardPrediction;
        CheckBox checkBox;
        RelativeLayout layoutSale;

        public FundingDetailRewardRecyclerViewHolder(View itemView) {
            super(itemView);
            txtRewardName = itemView.findViewById(R.id.txt_item_reward_name);
            txtRewardMoney = itemView.findViewById(R.id.txt_item_reward_fund_money);
            txtRewardCost = itemView.findViewById(R.id.txt_item_reward_original_cost);
            txtRewardSale = itemView.findViewById(R.id.txt_item_reward_sale_percentage);
            txtRewardDelivery = itemView.findViewById(R.id.txt_item_reward_delivery);
            txtRewardPrediction = itemView.findViewById(R.id.txt_item_reward_prediction);
            checkBox = itemView.findViewById(R.id.cb_item_reward);
            layoutSale = itemView.findViewById(R.id.layout_all_sale);
        }
    }
}
