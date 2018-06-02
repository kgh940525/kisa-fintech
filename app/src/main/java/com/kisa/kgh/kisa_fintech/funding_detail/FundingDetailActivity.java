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
import com.kisa.kgh.kisa_fintech.funding_detail.model.FundingDetailModel;
import com.kisa.kgh.kisa_fintech.network.RetrofitManager;
import com.kisa.kgh.kisa_fintech.network.module.NoteModule;
import com.kisa.kgh.kisa_fintech.network.module.NoteResponseModule;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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

        addData();
    }

    private void addData() {


    }

    private void init() {
        rcvFundingDetail = findViewById(R.id.rcv_content_detail);
        rcvFundingDetail.setHasFixedSize(true);
        rcvFundingDetail.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FundingDetailRecyclerViewAdapter(this);
        adapter.setItem(new FundingDetailModel(1, "http://124.80.127.237:10081/dragon/pics/dragon.png"));
        ;
        adapter.setItem(new FundingDetailModel(2, "제품 타이틀", "카테고리", "제품소개 제품소개 제품소개 제품소개 제품소개 제품소개 제품소개 제품소개 제품소개 제품소개 제품소개 ", "10", "10", "1,000,000", "30", "3,000,000", "2018.06.01", "2018.06.11"));
        for (int i = 0; i < 10; i++) {
            adapter.setItem(new FundingDetailModel(3, "타이틀", "ㄹㄴㄹ", "http://124.80.127.237:10081/dragon/pics/dragon.png", "ㄹㄴㅇㄻㄴㄹ"));
        }

        rcvFundingDetail.setAdapter(adapter);

        btnNext = findViewById(R.id.btn_content_detail_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PaymentGuideActivity.class));
            }
        });
    }
}
