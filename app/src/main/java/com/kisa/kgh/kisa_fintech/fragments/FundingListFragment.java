package com.kisa.kgh.kisa_fintech.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by kgh on 2018. 6. 2..
 */

public class FundingListFragment extends Fragment{

    private static class SingleTon {
        private static final FundingListFragment instance = new FundingListFragment();
    }

    public static FundingListFragment getInstance() {
        return FundingListFragment.SingleTon.instance;
    }
}
