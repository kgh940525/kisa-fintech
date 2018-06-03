package com.kisa.kgh.kisa_fintech.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kisa.kgh.kisa_fintech.R;
import com.kisa.kgh.kisa_fintech.adapters.FundingListRecyclerViewAdapter;
import com.kisa.kgh.kisa_fintech.network.RetrofitManager;
import com.kisa.kgh.kisa_fintech.network.module.NoteModule;
import com.kisa.kgh.kisa_fintech.network.module.NoteResponseModule;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kgh on 2018. 6. 2..
 */

public class FundingListFragment extends Fragment {

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private static class SingleTon {
        private static final FundingListFragment instance = new FundingListFragment();
    }

    public static FundingListFragment getInstance() {
        return FundingListFragment.SingleTon.instance;
    }

    private RecyclerView rcvFundingList;
    private FundingListRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_funding_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO detail acticity

        init();

    }

    private void init() {
        rcvFundingList = getActivity().findViewById(R.id.rcv_funding_list);
        rcvFundingList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvFundingList.setHasFixedSize(true);

        adapter = new FundingListRecyclerViewAdapter(getActivity());

        getFunding();

        rcvFundingList.setAdapter(adapter);
    }

    private void getFunding() {
        RetrofitManager.getRetrofitMethod().getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.Observer<NoteModule>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(NoteModule noteModule) {
                        List<NoteResponseModule> list = noteModule.getList();

                        adapter.setItems(list);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
