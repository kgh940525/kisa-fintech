package com.kisa.kgh.kisa_fintech.adapters;

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
import com.kisa.kgh.kisa_fintech.network.module.NoteResponseModule;

import java.util.ArrayList;
import java.util.List;

public class FundingListRecyclerViewAdapter extends RecyclerView.Adapter<FundingListRecyclerViewAdapter.FundingListRecyclerViewHolder> {

    private Context context;

    private List<NoteResponseModule> items = new ArrayList<>();

    public void setItems(List<NoteResponseModule> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setItem(NoteResponseModule item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public FundingListRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FundingListRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FundingListRecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_funding_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FundingListRecyclerViewHolder holder, int position) {
        Glide.with(context).load(context.getResources().getDrawable(R.drawable.image)).into(holder.imgFunding);
        holder.txtTitle.setText(items.get(position).getTitle());
        holder.txtFarmerName.setText(items.get(position).getFarmerName());
        int percentage = changePercentage(items.get(position).getCurrentPrice(), items.get(position).getGoal());
        holder.txtPercentage.setText(percentage + "% 달성!");
        holder.txtCurrentMoney.setText(items.get(position).getCurrentPrice() + "모금");
        holder.txtRemindDay.setText(items.get(position).getDate() + " 까지");
        holder.txtCategory.setText(items.get(position).getCategory());
        holder.seekBar.setProgress(percentage);
    }

    private int changePercentage(String current, String goal) {
        int cu = changeInt(current);
        int go = changeInt(goal);

        int re = cu * 100 / go;

        return  re;
    }

    private int changeInt(String money) {
        String s = "";
        for (int i = 0; i < money.length(); i++) {
            char c = money.charAt(i);

            if (c >= '0' && c <= '9') {
                s += c;
            }
        }
        return Integer.parseInt(s);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class FundingListRecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFunding;
        TextView txtTitle;
        TextView txtFarmerName;
        TextView txtPercentage;
        TextView txtCurrentMoney;
        TextView txtRemindDay;
        TextView txtCategory;
        SeekBar seekBar;

        public FundingListRecyclerViewHolder(View itemView) {
            super(itemView);
            imgFunding = itemView.findViewById(R.id.img_item_funding_list);
            txtTitle = itemView.findViewById(R.id.txt_item_funding_list_title);
            txtFarmerName = itemView.findViewById(R.id.txt_item_funding_list_farmer_name);
            txtPercentage = itemView.findViewById(R.id.txt_item_funding_list_percentage);
            txtCurrentMoney = itemView.findViewById(R.id.txt_item_funding_list_current_cost);
            txtRemindDay = itemView.findViewById(R.id.txt_item_funding_list_remind_day);
            txtCategory = itemView.findViewById(R.id.txt_item_funding_list_category);
            seekBar = itemView.findViewById(R.id.seek_bar_funding_list);
        }
    }
}
