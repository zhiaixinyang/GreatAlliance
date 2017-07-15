package com.greatalliance.ui.my;

import android.os.Bundle;

import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class MyFragment extends BaseFragment {

    public static MyFragment newInstance() {

        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.frag_my;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
