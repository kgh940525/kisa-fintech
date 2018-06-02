package com.kisa.kgh.kisa_fintech.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kisa.kgh.kisa_fintech.R;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_list_recyclerview, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO detail acticity
    }
}
