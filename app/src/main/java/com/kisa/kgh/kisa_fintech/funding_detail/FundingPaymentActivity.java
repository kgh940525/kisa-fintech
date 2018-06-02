package com.kisa.kgh.kisa_fintech.funding_detail;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.kisa.kgh.kisa_fintech.R;
import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.RetrofitManagerJSP;
import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model.JSPHeader;
import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model.JSPModel;
import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model.JSPResponseModel;
import com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model.JSPTest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.RetrofitManagerJSP.catchAllThrowable;

public class FundingPaymentActivity extends BaseGuideActivity {

    private Button btn;

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activityList.add(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funding_payment);

        btn = findViewById(R.id.btn_payment);

        btn.setOnClickListener(view -> {
            send();
        });
    }

    private void send() {

        String json = makeJson();

        JSPTest jspTest = new JSPTest(json);

        Log.e("test",json);

        RetrofitManagerJSP.getRetrofitMethod().withdraw("sender","001", jspTest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JSPResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(JSPResponseModel jspResponseModel) {
                        Log.e("pay", jspResponseModel.getHeader().getRsms().toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.toString());
                        Log.e("error",e.getMessage());

                        Toast.makeText(getApplicationContext(), catchAllThrowable(getApplicationContext(), e),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private String makeJson()  {
        String json = "";
        try {
            JSONObject jsonObject = new JSONObject();
            JSONObject jsonHeader = new JSONObject();

            long now = System.currentTimeMillis();
            Date date = new Date(now);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String formatDate = simpleDateFormat.format(date);
            formatDate += "000001";

            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
            String yearMonthDay = simpleDateFormat2.format(date);

            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("HHmmss");
            String hourMinuteSecond = simpleDateFormat3.format(date);

            jsonHeader.put("ApiNm", "DrawingTransfer");
            jsonHeader.put("Tsymd", yearMonthDay);
            jsonHeader.put("Trtm", hourMinuteSecond);
            jsonHeader.put("Iscd", "000021");
            jsonHeader.put("FintechApsno", "001");
            jsonHeader.put("ApiSvcCd", "01D_001_00");
            jsonHeader.put("IsTuno", formatDate);

            jsonObject.put("Header", jsonHeader);
            jsonObject.put("FinAcno", "00820111503501513391503394476");
            jsonObject.put("Tram", "10");
            jsonObject.put("DractOtlt", "");
            jsonObject.put("MractOtlt", "");

            json = jsonObject.toString();
        } catch (JSONException je) {
            je.printStackTrace();
        }

        return json;
    }

    private void input() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatDate = simpleDateFormat.format(date);
        formatDate += "000001";

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd");
        String yearMonthDay = simpleDateFormat2.format(date);

        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("HHmmss");
        String hourMinuteSecond = simpleDateFormat3.format(date);

        JSPHeader jspHeader = new JSPHeader("DrawingTransfer", yearMonthDay, hourMinuteSecond, "000021", "001", "01D_001_00", formatDate);


        JSPModel jspModel = new JSPModel(jspHeader, "00820111503501513391503394476", "10", "", "");
    }

    /**
     * {
     "Header":{
     "ApiNm":"DrawingTransfer",
     "Tsymd":"20180601",
     "Trtm":"125809",
     "Iscd":"000021",
     "FintechApsno":"001",
     "ApiSvcCd":"01D_001_00",
     "IsTuno":"20180530150115873896"
     },
     "FinAcno":"00820111503501513391503394476",
     "Tram":"10",
     "DractOtlt":"",
     "MractOtlt" : ""
     }
     */
}
