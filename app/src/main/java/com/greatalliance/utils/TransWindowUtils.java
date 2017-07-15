package com.greatalliance.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.greatalliance.GreatAllianceApplication;

/**
 * Created by MBENBEN on 2016/10/20.
 */

public class TransWindowUtils {
    public static void setTransWindow(Activity activity){
        if (activity!=null){
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }
    public static void setTransWindowAndView(Activity activity,View view){
        if (activity!=null){
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }else{
                view.setVisibility(View.GONE);
            }
        }
    }
    //设置背景透明度
    public static void setBackgroundAlpha(Activity activity,float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        activity.getWindow().setAttributes(lp);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }
}
