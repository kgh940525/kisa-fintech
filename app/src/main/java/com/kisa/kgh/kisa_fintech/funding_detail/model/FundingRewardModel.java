package com.kisa.kgh.kisa_fintech.funding_detail.model;

public class FundingRewardModel {
    private String rewardName;
    private String rewardMoney;
    private String rewardCost;
    private String rewardSale;
    private String rewardDelivery;
    private String rewardPrediction;
    private boolean isCheck = false;
    private boolean isDoing = true;

    public FundingRewardModel(String name, String money, String cost, String sale, String delivery, String rewardPrediction) {
        this.rewardName = name;
        this.rewardMoney = money;
        this.rewardCost = cost;
        this.rewardSale = sale;
        this.rewardDelivery = delivery;
        this.rewardPrediction = rewardPrediction;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public void setDoing(boolean doing) {
        isDoing = doing;
    }

    public String getRewardName() {
        return rewardName;
    }

    public String getRewardMoney() {
        return rewardMoney;
    }

    public String getRewardCost() {
        return rewardCost;
    }

    public String getRewardSale() {
        return rewardSale;
    }

    public String getRewardDelivery() {
        return rewardDelivery;
    }

    public String getRewardPrediction() {
        return rewardPrediction;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public boolean isDoing() {
        return isDoing;
    }
}
