package com.kisa.kgh.kisa_fintech.funding_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kisa.kgh.kisa_fintech.R;

public class FundingPaymentActivity extends BaseGuideActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityList.add(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funding_payment);
    }
}
