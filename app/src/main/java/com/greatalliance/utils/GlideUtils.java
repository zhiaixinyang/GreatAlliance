package com.greatalliance.utils;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class GlideUtils {
    public static void load(ImageView view, int path){
        Glide.with(AppUtils.getAppContext())
                .load(path)
                .into(view);
    }
}
