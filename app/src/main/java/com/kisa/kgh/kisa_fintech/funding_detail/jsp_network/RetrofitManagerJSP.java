package com.kisa.kgh.kisa_fintech.funding_detail.jsp_network;

import android.annotation.SuppressLint;
import android.content.Context;

import com.kisa.kgh.kisa_fintech.R;

import java.lang.reflect.Field;
import java.net.ConnectException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.Keys.JSP_URL;


public class RetrofitManagerJSP {
    private static final String TAG = RetrofitManagerJSP.class.getSimpleName();

    private static RetrofitManagerJSP instance = null;

    private Retrofit mRetrofit;

    public static RetrofitManagerJSP getInstance() {
        if (instance == null) {
            synchronized (RetrofitManagerJSP.class) {
                if (instance == null) {
                    instance = new RetrofitManagerJSP();
                }
            }
        }
        return instance;
    }

    public void init() {
        mRetrofit = getDefaultRetrofitSetting();
    }

    private Retrofit getDefaultRetrofitSetting() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
        try {
            SSLContext sslContext;
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                @SuppressLint("TrustAllX509TrustManager")
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @SuppressLint("TrustAllX509TrustManager")
                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }}, new SecureRandom());
            HostnameVerifier hv = (hostname, session) -> true;
            String workerClassName = "okhttp3.OkHttpClient";
            try {
                Class workerClass = Class.forName(workerClassName);
                Field hostnameVerifier = workerClass.getDeclaredField("hostnameVerifier");
                hostnameVerifier.setAccessible(true);
                hostnameVerifier.set(httpClient, hv);
                Field sslSocketFactory = workerClass.getDeclaredField("sslSocketFactory");
                sslSocketFactory.setAccessible(true);
                sslSocketFactory.set(httpClient, sslContext.getSocketFactory());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Retrofit.Builder()
                .baseUrl(JSP_URL)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public static RetrofitInterfaceJSP getRetrofitMethod() {
        return getInstance().getRetrofit().create(RetrofitInterfaceJSP.class);
    }

    public static String catchAllThrowable(final Context context, final Throwable throwable) {
        if (throwable instanceof NullPointerException) {
            return context.getString(R.string.error_null);
        } else if (throwable instanceof ConnectException) {
            return context.getString(R.string.error_network);
        } else {
            return throwable.getMessage();
        }
    }

}