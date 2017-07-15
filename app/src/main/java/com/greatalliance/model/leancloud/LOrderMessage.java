package com.greatalliance.model.leancloud;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

/**
 * Created by MBENBEN on 2017/7/15.
 */
@AVClassName("LOrderMessage")
public class LOrderMessage extends AVObject {
    private String location;
    private String phone;
    private String foodName;
    private String price;
    private String money;

    public String getLocation() {
        return getString("location");
    }

    public void setLocation(String location) {
        put("location",location);
    }

    public String getPhone() {
        return getString("phone");
    }

    public void setPhone(String phone) {
        put("phone",phone);
    }

    public String getFoodName() {
        return getString("foodName");
    }

    public void setFoodName(String foodName) {
        put("foodName",foodName);
    }

    public String getPrice() {
        return getString("price");
    }

    public void setPrice(String price) {
        put("price",price);
    }

    public String getMoney() {
        return getString("money");
    }

    public void setMoney(String money) {
        put("money",money);
    }
}
