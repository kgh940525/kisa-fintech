package com.kisa.kgh.kisa_fintech.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by kgh on 2018. 6. 2..
 */

public class MyPageFragment extends Fragment {

    private static class SingleTon {
        private static final MyPageFragment instance = new MyPageFragment();
    }

    public static MyPageFragment getInstance() {
        return SingleTon.instance;
    }



    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO detail acticity
    }

}
