package com.kisa.kgh.kisa_fintech.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kisa.kgh.kisa_fintech.R;
import com.kisa.kgh.kisa_fintech.utils.LoginInstance;

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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mypage,container,false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        String email = LoginInstance.getInstance().getId();
        String[] t = email.split("@");

        TextView textView = getView().findViewById(R.id.userName);
        textView.setText(t[0]);

        TextView txtEmail = getView().findViewById(R.id.userEmail);
        txtEmail.setText(email);

        // TODO detail acticity
    }

}
