package com.greatalliance.ui.share;

import android.os.Bundle;

import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class ShareFragment extends BaseFragment {
    public static ShareFragment newInstance() {

        Bundle args = new Bundle();

        ShareFragment fragment = new ShareFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutResId() {
        return R.layout.frag_share;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
