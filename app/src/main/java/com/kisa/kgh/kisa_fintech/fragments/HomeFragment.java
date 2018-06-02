package com.kisa.kgh.kisa_fintech.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by kgh on 2018. 6. 2..
 */

public class HomeFragment extends Fragment{

    private static class SingleTon {
        private static final HomeFragment instance = new HomeFragment();
    }

    public static HomeFragment getInstance() {
        return SingleTon.instance;
    }

}
