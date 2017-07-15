package com.greatalliance.model.bean;

import java.io.Serializable;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class ShopBean implements Serializable{
    private int FoodPhotoPath;
    private String foodContent;
    private String foodName;
    private String foodMoeny;

    public int getFoodPhotoPath() {
        return FoodPhotoPath;
    }

    public void setFoodPhotoPath(int foodPhotoPath) {
        FoodPhotoPath = foodPhotoPath;
    }

    public String getFoodContent() {
        return foodContent;
    }

    public void setFoodContent(String foodContent) {
        this.foodContent = foodContent;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodMoeny() {
        return foodMoeny;
    }

    public void setFoodMoeny(String foodMoeny) {
        this.foodMoeny = foodMoeny;
    }
}
