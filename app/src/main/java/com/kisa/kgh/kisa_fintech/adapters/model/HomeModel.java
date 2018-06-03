package com.kisa.kgh.kisa_fintech.adapters.model;

public class HomeModel {
    private int viewType;
    private String title;
    private String subTitle;
    private String imageUrl;
    private String info = "";
    private String category;
    private String remindDay;
    private String percentage;
    private String currentMoney;
    private String currentPeople;
    private String goalMoney;
    private String startDay;
    private String lastDay;


    public HomeModel(int viewType, String title, String subTitle, String imageUrl) {
        this.viewType = viewType;
        this.title = title;
        this.subTitle = subTitle;
        this.imageUrl = imageUrl;
    }

    public HomeModel(int viewType, String title, String subTitle, String percentage, String price, String day, String imageUrl) {
        this.viewType = viewType;
        this.title = title;
        this.subTitle = subTitle;
        this.percentage = percentage;
        this.currentMoney = price;
        this.remindDay = day;
        this.imageUrl = imageUrl;
    }

    public int getViewType() {
        return viewType;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getInfo() {
        return info;
    }

    public String getCategory() {
        return category;
    }

    public String getRemindDay() {
        return remindDay;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getCurrentMoney() {
        return currentMoney;
    }

    public String getCurrentPeople() {
        return currentPeople;
    }

    public String getGoalMoney() {
        return goalMoney;
    }

    public String getStartDay() {
        return startDay;
    }

    public String getLastDay() {
        return lastDay;
    }
}
