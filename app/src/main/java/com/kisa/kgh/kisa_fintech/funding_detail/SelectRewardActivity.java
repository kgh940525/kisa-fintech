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

import java.util.ArrayList;
import java.util.List;

import static com.kisa.kgh.kisa_fintech.utils.IntentKey.CURRENT_MONEY;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.PAYMENT;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.TITLE;

public class SelectRewardActivity extends BaseGuideActivity {

    private RecyclerView rcvSelectReward;
    private FundingDetailRewardRecyclerViewAdapter adapter;


    private String title;
    private String currentPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityList.add(this);
        setContentView(R.layout.activity_select_reward);

        Intent it = getIntent();
        title = it.getExtras().getString(TITLE);
        currentPrice = it.getExtras().getString(CURRENT_MONEY);

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

                int fund = 0;
                List<FundingRewardModel> l = adapter.getItems();
                for(int i=0;i<l.size();i++) {
                    if(l.get(i).isCheck()) {
                        String tmp = l.get(i).getRewardMoney();
                        String s = "";
                        for(int j=0;j<tmp.length();j++) {
                            char c = tmp.charAt(j);
                            if(c >='0' && c<='9') {
                                s += c;
                            }
                        }

                        fund = Integer.parseInt(s);

                        break;
                    }
                }

                Intent it = new Intent(getApplicationContext(), FundingPaymentActivity.class);
                it.putExtra(TITLE, title);
                it.putExtra(CURRENT_MONEY, currentPrice);
                it.putExtra(PAYMENT, fund);

                startActivity(it);
            }
        });
    }
}
