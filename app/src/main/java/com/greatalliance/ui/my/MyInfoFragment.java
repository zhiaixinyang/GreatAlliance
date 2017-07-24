package com.greatalliance.ui.my;

import android.os.Bundle;

import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;
import com.greatalliance.ui.share.ShareFragment;

/**
 * Created by 谷 聪聪 on 2017/7/23 0023.
 */

public class MyInfoFragment extends BaseFragment {
    public static MyInfoFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MyInfoFragment fragment = new MyInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutResId() {
        return R.layout.frag_my_info;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
