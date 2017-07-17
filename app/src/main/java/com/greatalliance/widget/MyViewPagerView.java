package com.greatalliance.widget;

import android.content.Context;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by MBENBEN on 2017/7/17.
 */

public class MyViewPagerView extends ViewPager implements NestedScrollingChild{
    public MyViewPagerView(Context context) {
        super(context);
    }

    public MyViewPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
