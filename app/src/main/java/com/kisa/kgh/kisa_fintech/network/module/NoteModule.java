package com.kisa.kgh.kisa_fintech.network.module;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NoteModule {

    @SerializedName("response")
    List<NoteResponseModule> list;

    public List<NoteResponseModule> getList() {
        return list;
    }

    public void setList(List<NoteResponseModule> list) {
        this.list = list;
    }
}
