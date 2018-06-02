package com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model;

import com.google.gson.annotations.SerializedName;

public class JSPResponseHeader {

    @SerializedName("Trtm")
    String trtm;

    @SerializedName("Rsms")
    String rsms;

    @SerializedName("ApiNm")
    String apiNm;

    @SerializedName("IsTuno")
    String lsTuno;

    @SerializedName("Tsymd")
    String tsymd;

    @SerializedName("FintechApsno")
    String fintechApsno;

    @SerializedName("Iscd")
    String lscd;

    @SerializedName("Rpcd")
    String rpcd;

    @SerializedName("ApiSvcCd")
    String apisvcd;


    public String getTrtm() {
        return trtm;
    }

    public String getApiNm() {
        return apiNm;
    }

    public String getLsTuno() {
        return lsTuno;
    }

    public String getTsymd() {
        return tsymd;
    }

    public String getFintechApsno() {
        return fintechApsno;
    }

    public String getLscd() {
        return lscd;
    }

    public String getRpcd() {
        return rpcd;
    }

    public String getApisvcd() {
        return apisvcd;
    }

    public String getRsms() {
        return rsms;
    }
}
