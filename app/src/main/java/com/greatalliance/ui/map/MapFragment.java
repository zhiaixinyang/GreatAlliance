package com.greatalliance.ui.map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class MapFragment extends BaseFragment {

    public static MapFragment newInstance() {

        Bundle args = new Bundle();

        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.frag_map;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
