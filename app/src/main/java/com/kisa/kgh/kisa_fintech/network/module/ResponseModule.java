package com.kisa.kgh.kisa_fintech.network.module;

import com.google.gson.annotations.SerializedName;

public class ResponseModule {



    @SerializedName("code")
    private String code;

    @SerializedName("id_email")
    private String id;

    @SerializedName("pwd")
    private String pwd;

    @SerializedName("name")
    private String name;

    @SerializedName("doc_type")
    private int type;

    public String getCode() {
        return code;
    }

    public ResponseModule(String id, String pwd, String name, int type) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.type = type;
    }


    public ResponseModule() {

    }

    public ResponseModule(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }
}
