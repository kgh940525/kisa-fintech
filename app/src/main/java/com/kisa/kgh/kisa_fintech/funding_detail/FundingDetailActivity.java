package com.kisa.kgh.kisa_fintech.funding_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.kisa.kgh.kisa_fintech.R;
import com.kisa.kgh.kisa_fintech.funding_detail.adapters.FundingDetailRecyclerViewAdapter;
import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.RetrofitManagerJSP;
import com.kisa.kgh.kisa_fintech.funding_detail.model.FundingDetailModel;

import io.reactivex.disposables.CompositeDisposable;

import static com.kisa.kgh.kisa_fintech.utils.IntentKey.CATEGORY;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.CONTENT;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.CURRENT_MONEY;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.FARMER_NAME;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.GOAL;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.MAIN_CONTENT;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.PERCENTAGE;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.REMIND_DAY;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.SCHEDULE;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.TITLE;

public class FundingDetailActivity extends AppCompatActivity {

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private RecyclerView rcvFundingDetail;
    private FundingDetailRecyclerViewAdapter adapter;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funding_detail);

        init();

        RetrofitManagerJSP.getInstance().init();

        addData();
    }

    private void addData() {
        Intent it = getIntent();
        String title = it.getExtras().getString(TITLE);
        String farmerName = it.getExtras().getString(FARMER_NAME);
        String percentage = it.getExtras().getString(PERCENTAGE);
        String currentMoney = it.getExtras().getString(CURRENT_MONEY);
        String day = it.getExtras().getString(REMIND_DAY);
        String category = it.getExtras().getString(CATEGORY);
        String goal = it.getExtras().getString(GOAL);
        String content = it.getExtras().getString(CONTENT);
        String mainContent = it.getExtras().getString(MAIN_CONTENT);
        String schedule = it.getExtras().getString(SCHEDULE);

        String people = (int) ((Math.random() * 10) + 1) + "명";

        adapter.setItem(new FundingDetailModel(1, "http://124.80.127.237:10081/image/image.png"));
        adapter.setItem(new FundingDetailModel(2, title, category, content, day, percentage, currentMoney, people, goal, day, day));

        adapter.setItem(new FundingDetailModel(3,"상품스토리텔링",mainContent, "http://124.80.127.237:10081/image/image.png", schedule));

    }

    private void init() {
        rcvFundingDetail = findViewById(R.id.rcv_content_detail);
        rcvFundingDetail.setHasFixedSize(true);
        rcvFundingDetail.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FundingDetailRecyclerViewAdapter(this);

        rcvFundingDetail.setAdapter(adapter);

        btnNext = findViewById(R.id.btn_content_detail_next);
        btnNext.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), PaymentGuideActivity.class)));
    }
}
