package com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model;

import com.google.gson.annotations.SerializedName;

public class JSPModel {

    @SerializedName("Header")
    JSPHeader jspHeader;

    @SerializedName("FinAcno")
    String anco;

    @SerializedName("Tram")
    String tram;

    @SerializedName("DractOtlt")
    String dractOtlt;

    @SerializedName("MractOtlt")
    String mractOtlt;

    public JSPModel(JSPHeader jspHeader, String anco, String tram, String dractOtlt, String mractOtlt) {
        this.jspHeader = jspHeader;
        this.anco = anco;
        this.tram = tram;
        this.dractOtlt = dractOtlt;
        this.mractOtlt = mractOtlt;
    }

    public String getTram() {
        return tram;
    }

    public String getDractOtlt() {
        return dractOtlt;
    }

    public String getMractOtlt() {
        return mractOtlt;
    }

    public JSPHeader getJspHeader() {
        return jspHeader;
    }

    public String getAnco() {
        return anco;
    }
}
