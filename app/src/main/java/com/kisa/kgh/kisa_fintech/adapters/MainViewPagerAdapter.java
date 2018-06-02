package com.kisa.kgh.kisa_fintech.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kisa.kgh.kisa_fintech.fragments.FundingListFragment;
import com.kisa.kgh.kisa_fintech.fragments.HomeFragment;
import com.kisa.kgh.kisa_fintech.fragments.MyPageFragment;

/**
 * Created by kgh on 2018. 6. 2..
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private static final String[] TITLES = {"HOME", "LIST", "MyPage"};

    private static final Fragment[] FRAGMENTS = {HomeFragment.getInstance(), FundingListFragment.getInstance(), MyPageFragment.getInstance()};

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public Fragment getItem(int position) {
        return FRAGMENTS[position];
    }

    @Override
    public int getCount() {
        return FRAGMENTS.length;
    }
}
