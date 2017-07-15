package com.greatalliance.ui.shop;

import android.os.Bundle;

import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class ShopFragment extends BaseFragment {
    public static ShopFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutResId() {
        return R.layout.frag_shop;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
