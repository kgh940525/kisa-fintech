package com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model;

import com.google.gson.annotations.SerializedName;

public class JSPResponseModel {

    @SerializedName("Header")
    JSPResponseHeader header;

    public JSPResponseHeader getHeader() {
        return header;
    }
}
