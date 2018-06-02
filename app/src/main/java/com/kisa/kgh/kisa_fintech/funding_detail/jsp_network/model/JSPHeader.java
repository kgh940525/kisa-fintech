package com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model;

import com.google.gson.annotations.SerializedName;

public class JSPHeader {

    @SerializedName("ApiNm")
    String apinm;

    @SerializedName("Tsymd")
    String tsymd;

    @SerializedName("Trtm")
    String trtm;

    @SerializedName("Iscd")
    String lscd;

    @SerializedName("FintechApsno")
    String fintechApsno;

    @SerializedName("ApiSvcCd")
    String apiSvcCd;

    @SerializedName("IsTuno")
    String lsTuno;

    public JSPHeader(String apinm, String tsymd, String trtm, String lscd, String fintechApsno, String apiSvcCd, String lsTuno) {
        this.apinm = apinm;
        this.tsymd = tsymd;
        this.trtm = trtm;
        this.lscd = lscd;
        this.fintechApsno = fintechApsno;
        this.apiSvcCd = apiSvcCd;
        this.lsTuno = lsTuno;
    }

    public String getApinm() {
        return apinm;
    }

    public String getTsymd() {
        return tsymd;
    }

    public String getTrtm() {
        return trtm;
    }

    public String getLscd() {
        return lscd;
    }

    public String getFintechApsno() {
        return fintechApsno;
    }

    public String getApiSvcCd() {
        return apiSvcCd;
    }

    public String getLsTuno() {
        return lsTuno;
    }
}
