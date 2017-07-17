package com.greatalliance.ui.shop;

import android.view.View;
import android.view.ViewGroup;

import com.greatalliance.R;
import com.greatalliance.base.BaseActivity;
import com.greatalliance.base.navigationbar.DefaultNavigationBar;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class LocationActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_location;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {
        new DefaultNavigationBar.Builder(this,
                (ViewGroup) findViewById(android.R.id.content))
                .setLeftIcon(R.drawable.btn_back)
                .setLeftOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                })
                .setTitle("添加/选择默认收货地址").create();
    }
}
