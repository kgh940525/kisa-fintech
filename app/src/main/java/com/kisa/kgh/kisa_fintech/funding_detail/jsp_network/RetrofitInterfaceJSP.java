package com.kisa.kgh.kisa_fintech.funding_detail.jsp_network;

import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model.JSPModel;
import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model.JSPResponseModel;
import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model.JSPTest;
import com.kisa.kgh.kisa_fintech.network.module.NoteModule;
import com.kisa.kgh.kisa_fintech.network.module.ResponseModule;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import static com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.Keys.PROCESS;
import static com.kisa.kgh.kisa_fintech.network.Keys.GET_NODE;
import static com.kisa.kgh.kisa_fintech.network.Keys.SIGN_IN;
import static com.kisa.kgh.kisa_fintech.network.Keys.SIGN_UP;


public interface RetrofitInterfaceJSP {

    @POST(PROCESS)
    Observable<JSPResponseModel> withdraw(@Query("p") String p, @Query("fintechApsno") String n, @Body JSPTest model);

}
