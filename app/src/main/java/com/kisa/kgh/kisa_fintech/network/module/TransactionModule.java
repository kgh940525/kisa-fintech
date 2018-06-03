package com.kisa.kgh.kisa_fintech.network.module;

import com.google.gson.annotations.SerializedName;

public class TransactionModule {

    @SerializedName("id_email")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("pre_price")
    String price;

    @SerializedName("funding_price")
    String fund;

    public TransactionModule(String id, String title, String price, String fund) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.fund = fund;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getFund() {
        return fund;
    }
}
