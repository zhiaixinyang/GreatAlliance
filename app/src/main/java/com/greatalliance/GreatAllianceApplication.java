package com.greatalliance;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;
import com.greatalliance.base.Constant;
import com.greatalliance.utils.AppUtils;
import com.greatalliance.utils.SharedPreferencesUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by MBENBEN on 2017/7/9.
 */

public class GreatAllianceApplication extends Application {
    private static GreatAllianceApplication instance;
    private Set<Activity> allActivities;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppUtils.init(this);
        initPrefs();
        init();
    }

    private void init() {
        AVOSCloud.initialize(this, Constant.LEAN_CLOUD_APP_ID, Constant.LEAN_CLOUD_APP_KEY);
    }

    public static GreatAllianceApplication getInstance() {

        return instance;
    }

    /**
     * 初始化SharedPreference
     */
    protected void initPrefs() {
        SharedPreferencesUtils.init(getApplicationContext(), getPackageName() + "_preference", Context.MODE_MULTI_PROCESS);
    }

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }
}
