package com.kisa.kgh.kisa_fintech.funding_detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.kisa.kgh.kisa_fintech.R;
import com.kisa.kgh.kisa_fintech.funding_detail.adapters.FundingDetailRewardRecyclerViewAdapter;
import com.kisa.kgh.kisa_fintech.funding_detail.model.FundingRewardModel;

public class SelectRewardActivity extends BaseGuideActivity {

    private RecyclerView rcvSelectReward;
    private FundingDetailRewardRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityList.add(this);
        setContentView(R.layout.activity_select_reward);

        init();
    }

    private void init() {
        rcvSelectReward = findViewById(R.id.rcv_select_reward);
        rcvSelectReward.setLayoutManager(new LinearLayoutManager(this));
        rcvSelectReward.setHasFixedSize(true);

        adapter = new FundingDetailRewardRecyclerViewAdapter(this);

        for(int i=0;i<2;i++) {
            adapter.addItem(new FundingRewardModel("name","10,000","12,000","15","5,000원", "2018년 6월 중순"));
        }

        rcvSelectReward.setAdapter(adapter);

        Button btnPayment = findViewById(R.id.btn_select_reward);
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FundingPaymentActivity.class));
            }
        });
    }
}
