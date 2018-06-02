package com.kisa.kgh.kisa_fintech.funding_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kisa.kgh.kisa_fintech.R;

import java.util.ArrayList;


public class MyFundingListActivity extends AppCompatActivity {
    RecyclerView rcv;
    MyFundingListAdapter rcvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recyclerview);
        rcv = (RecyclerView) findViewById(R.id.recyclerview);

        // 화면이 안나올경우 이 설정이필요하다

        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        String arr_title[] = {"농사꾼 최고1","농사꾼 최고2","농사꾼 최고3","농사꾼 최고4","농사꾼 최고5","농사꾼 최고6","농사꾼 최고7",
                "농사꾼 최고8","농사꾼 최고9","농사꾼 최고10"};
        ArrayList<MyFundingListItem> list = new ArrayList<>();

        for(int i=0; i<arr_title.length; i++){

            list.add(new MyFundingListItem("농사꾼", 1,2,3,"2018-06-02","T1",arr_title[i],"딸기"));
        }



        //list.add(new MyFundingListItem("Jung Jihun", 1,1000,10,"2018-06-02","T1","농부1","딸기"));
//        list.add(new MyFundingListItem("Lee Minho", 2));
//        list.add(new MyFundingListItem("Alex", 2));
//        list.add(new MyFundingListItem("Daniel", 4));
//        list.add(new MyFundingListItem("Kim Bora", 3));
//        list.add(new MyFundingListItem("Joa Sigong", 1));
//        list.add(new MyFundingListItem("Park Somi", 1));
//        list.add(new MyFundingListItem("Kim Minji", 3));
//        list.add(new MyFundingListItem("Andrew", 3));

        rcvAdapter = new MyFundingListAdapter(this, list);
        rcv.setAdapter(rcvAdapter);

    }








}
