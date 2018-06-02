package com.kisa.kgh.kisa_fintech.funding_list;

import android.media.Image;
import android.widget.ImageView;

import java.util.Date;

/**
 * Created by penguo on 2018-01-17.
 */

public class MyFundingListItem {
    private String name;
    private int imageNumber;
    private String url;


    private String title;
    private String farmer;
    private String category;

    private String date;
    private int money;
    private int percent;
    private int seekbargage;


    public String getUrl(String s){

        return url;

    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFarmer() {
        return farmer;
    }

    public void setFarmer(String farmer) {
        this.farmer = farmer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public void setUrl(String url){

        this.url = url;
    }


    public MyFundingListItem(String name, int imageNumber, int money, int percent, String date, String title, String farmer, String category) {
        this.name = name;
        this.imageNumber = imageNumber;
        this.money = money;
        this.percent = percent;
        this.date = date;
        this.title = title;
        this.farmer = farmer;
        this.category = category;
    }


    public MyFundingListItem(String name, int imageNumber) {
        this.name = name;
        this.imageNumber = imageNumber;
    }


    public String getName() {
        return name;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }
}