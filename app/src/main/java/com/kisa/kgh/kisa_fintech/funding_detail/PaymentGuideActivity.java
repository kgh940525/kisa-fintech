package com.kisa.kgh.kisa_fintech.funding_detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kisa.kgh.kisa_fintech.R;

import static com.kisa.kgh.kisa_fintech.utils.IntentKey.CURRENT_MONEY;
import static com.kisa.kgh.kisa_fintech.utils.IntentKey.TITLE;

public class PaymentGuideActivity extends BaseGuideActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityList.add(this);
        setContentView(R.layout.activity_payment_guide);

        Intent it = getIntent();
        String title = it.getExtras().getString(TITLE);
        String currentPrice = it.getExtras().getString(CURRENT_MONEY);

        Button btn = findViewById(R.id.btn_guide_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), SelectRewardActivity.class);
                it.putExtra(TITLE, title);
                it.putExtra(CURRENT_MONEY, currentPrice);
                startActivity(it);
            }
        });
    }

    @Override
    public void onBackPressed() {
        activityList.remove(this);
        super.onBackPressed();
    }
}
