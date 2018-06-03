package com.kisa.kgh.kisa_fintech.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kisa.kgh.kisa_fintech.R;
import com.kisa.kgh.kisa_fintech.adapters.HomeRecyclerViewAdapter;
import com.kisa.kgh.kisa_fintech.adapters.model.HomeModel;

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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private RecyclerView rcvHome;

    private HomeRecyclerViewAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        rcvHome = getView().findViewById(R.id.rcv_home_list);
        rcvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvHome.setHasFixedSize(true);

        adapter = new HomeRecyclerViewAdapter(getContext());

        adapter.setItem(new HomeModel(1,"감귤 꿀맛\n맛있다 귤","제주 바다 바람을 맞으며\n하루하루 달콤해지는 감귤","https://cdn.zeplin.io/5b112d8eaa458d733b55e109/assets/460F6A2D-9B92-4A6C-8EE7-93FD535AF916.png"));
        adapter.setItem(new HomeModel(2,"당근","인천 연수구에 사는 박성호씨가 진심을 다해 키운 당근입니다. 제초제, 성장 촉진제를 사용하지 않아 몸에 친절한 당근이죠.","120%","3,249,000원 모집","3일 남음","https://cdn.zeplin.io/5b112d8eaa458d733b55e109/assets/42313AEE-576C-48AB-9403-58AE0227D740.png"));
        adapter.setItem(new HomeModel(3,"사과","수원시 영통구에 사는 누군가가 열과 성을 다해 키운 사과입니다. 사과는 맛있고 맛있으면 배탈나는 위험한 사과입니다.","90%", "2,800,000원 모집", "12일 남음","https://cdn.zeplin.io/5b112d8eaa458d733b55e109/assets/D5467F3E-80B2-4059-9794-DCAAFE91904C.png"));

        rcvHome.setAdapter(adapter);
    }
}
