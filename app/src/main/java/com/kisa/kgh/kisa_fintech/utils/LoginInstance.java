package com.kisa.kgh.kisa_fintech.utils;

public class LoginInstance {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private static class SingleTon {
        private static final LoginInstance instance = new LoginInstance();
    }

    public static LoginInstance getInstance() {
        return LoginInstance.SingleTon.instance;
    }

}
