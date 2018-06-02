package com.kisa.kgh.kisa_fintech.funding_detail.jsp_network.model;

import com.google.gson.annotations.SerializedName;

public class JSPTest {

    @SerializedName("JSONData")
    String data;

    public JSPTest(String data) {
        this.data = data;
    }
}
