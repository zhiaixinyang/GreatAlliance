package com.greatalliance.model.leancloud;

import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVGeoPoint;
import com.avos.avoscloud.AVUser;

/**
 * Created by MBENBEN on 2017/7/11.
 */

public class User extends AVUser {
    private String name;
    private String signature;
    private AVFile avatar;
    private AVGeoPoint location;
    private int charm;
    private int fans;
    private int money;

    public int getCharm() {
        return getInt("charm");
    }

    public AVGeoPoint getLocation() {
        return getAVGeoPoint("location");
    }

    public void setLocation(AVGeoPoint location) {
        put("location",location);
    }

    public void setCharm(int charm) {
        put("charm",charm);
    }

    public int getFans() {
        return getInt("fans");
    }

    public void setFans(int fans) {
        put("fans",fans);
    }

    public int getMoney() {
        return getInt("money");
    }

    public void setMoney(int money) {
        put("money",money);
    }

    public void setName(String name) {
        put("name", name);
    }

    public String getName() {

        return getString("name");
    }

    public AVFile getAvatar() {
        return getAVFile("avatar");
    }

    public void setAvatar(AVFile avatar) {
        put("avatar",avatar);
    }


    public String getSignature() {
        return getString("signature");
    }

    public void setSignature(String signature) {
        put("signature",signature);
    }
}
