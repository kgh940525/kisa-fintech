package com.kisa.kgh.kisa_fintech.funding_detail.jsp_network;

import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model.JSPResponseModel;
import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model.JSPTest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.Keys.PROCESS;


public interface RetrofitInterfaceJSP {

    @POST(PROCESS)
    Observable<JSPResponseModel> withdraw(@Header("Content-Type") String header, @Query("p") String p, @Query("fintechApsno") String n, @Body JSPTest model);

}
