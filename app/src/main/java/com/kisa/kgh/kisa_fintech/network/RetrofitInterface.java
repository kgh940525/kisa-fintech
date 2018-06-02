package com.kisa.kgh.kisa_fintech.network;

import com.kisa.kgh.kisa_fintech.network.module.NoteModule;
import com.kisa.kgh.kisa_fintech.network.module.ResponseModule;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static com.kisa.kgh.kisa_fintech.network.Keys.GET_NODE;
import static com.kisa.kgh.kisa_fintech.network.Keys.SIGN_IN;
import static com.kisa.kgh.kisa_fintech.network.Keys.SIGN_UP;


public interface RetrofitInterface {

    @POST(SIGN_IN)
    Observable<ResponseModule> signInCheck(@Body ResponseModule data);



    @POST(SIGN_UP)
    Observable<ResponseModule> signUp(@Body ResponseModule data);

    @POST(GET_NODE)
    Observable<NoteModule> getList();
}
