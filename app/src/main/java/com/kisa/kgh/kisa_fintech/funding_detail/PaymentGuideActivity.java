package com.kisa.kgh.kisa_fintech.funding_detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kisa.kgh.kisa_fintech.R;

public class PaymentGuideActivity extends BaseGuideActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityList.add(this);
        setContentView(R.layout.activity_payment_guide);

        Button btn = findViewById(R.id.btn_guide_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SelectRewardActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        activityList.remove(this);
        super.onBackPressed();
    }
}
