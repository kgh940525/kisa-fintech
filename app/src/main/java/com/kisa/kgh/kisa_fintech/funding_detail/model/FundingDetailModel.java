package com.kisa.kgh.kisa_fintech.funding_detail.model;

public class FundingDetailModel {
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

    public FundingDetailModel(int viewType, String title, String subTitle, String imageUrl) {
        this.viewType = viewType;
        this.title = title;
        this.subTitle = subTitle;
        this.imageUrl = imageUrl;
    }

    public FundingDetailModel(int viewType, String imageUrl) {
        this.viewType = viewType;
        this.imageUrl = imageUrl;
    }

    public FundingDetailModel(int viewType, String title, String subTitle, String imageUrl, String info) {
        this.viewType = viewType;
        this.title = title;
        this.subTitle = subTitle;
        this.imageUrl = imageUrl;
        this.info = info;
    }

    public FundingDetailModel(int viewType, String title, String category, String info, String remindDay, String percentage, String currentMoney, String people, String goalMoney, String startDay, String lastDay) {
        this.viewType = viewType;
        this.title = title;
        this.category = category;
        this.info = info;
        this.remindDay = remindDay;
        this.percentage = percentage;
        this.currentMoney = currentMoney;
        this.currentPeople = people;
        this.goalMoney = goalMoney;
        this.startDay = startDay;
        this.lastDay = lastDay;
    }

    public int getViewType() {
        return viewType;
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
}
