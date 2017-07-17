package com.greatalliance.ui.shop;

import android.os.Bundle;
import android.view.View;

import com.greatalliance.R;
import com.greatalliance.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 谷 聪聪 on 2017/7/15 0015.
 */

public class OrderDetailActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_orderdetail;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_contactMerchant, R.id.btn_cancelOrder, R.id.btn_confirmDelivered})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_contactMerchant:
                finish();
                break;
            case R.id.btn_cancelOrder:
                finish();

                break;
            case R.id.btn_confirmDelivered:
                finish();

                break;
        }
    }
}
