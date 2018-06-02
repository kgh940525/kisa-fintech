package com.kisa.kgh.kisa_fintech;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kisa.kgh.kisa_fintech.adapters.MainViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private MainViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.vp_main);
        adapter = new MainViewPagerAdapter(getSupportFragmentManager());

        vp.setAdapter(adapter);

    }
}
