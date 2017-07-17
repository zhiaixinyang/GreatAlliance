package com.greatalliance.ui.my;

import android.os.Bundle;

import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;

/**
 * Created by MBENBEN on 2017/7/16.
 */

public class MyOrderFragment extends BaseFragment {
    public static MyOrderFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MyOrderFragment fragment = new MyOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutResId() {
        return R.layout.frag_my_order;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
