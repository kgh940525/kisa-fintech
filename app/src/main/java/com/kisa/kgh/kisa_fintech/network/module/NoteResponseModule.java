package com.kisa.kgh.kisa_fintech.network.module;

import com.google.gson.annotations.SerializedName;

public class NoteResponseModule {

    @SerializedName("_id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("farmerName")
    String farmerName;

    @SerializedName("category")
    String category;

    @SerializedName("content")
    String content;

    @SerializedName("mainContent")
    String mainContent;

    @SerializedName("schedule")
    String schedule;

    @SerializedName("goalPrice")
    String goal;

    @SerializedName("fundingPeriod")
    String date;

    @SerializedName("curPrice")
    String currentPrice;

    public NoteResponseModule() {

    }

    public NoteResponseModule(String id, String title, String farmerName, String category, String content, String mainContent, String schedule, String goal, String date, String currentPrice) {
        this.id = id;
        this.title = title;
        this.farmerName = farmerName;
        this.category = category;
        this.content = content;
        this.mainContent = mainContent;
        this.schedule = schedule;
        this.goal = goal;
        this.date = date;
        this.currentPrice = currentPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }
}
