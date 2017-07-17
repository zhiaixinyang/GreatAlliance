package com.greatalliance.ui.my;

import android.os.Bundle;

import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;

/**
 * Created by MBENBEN on 2017/7/16.
 */

public class MyShareFoodFragment extends BaseFragment {
    public static MyShareFoodFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MyShareFoodFragment fragment = new MyShareFoodFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutResId() {
        return R.layout.frag_my_share_food;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
