package com.kisa.kgh.kisa_fintech.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kisa.kgh.kisa_fintech.R;

/**
 * Created by kgh on 2018. 6. 2..
 */

public class HomeFragment extends Fragment {

    private static class SingleTon {
        private static final HomeFragment instance = new HomeFragment();
    }

    public static HomeFragment getInstance() {
        return SingleTon.instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_list_recyclerview, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO detail acticity
    }
}
