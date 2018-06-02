package com.kisa.kgh.kisa_fintech.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO detail acticity
    }
}
