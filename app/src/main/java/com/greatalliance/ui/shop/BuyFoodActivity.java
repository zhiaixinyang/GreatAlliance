package com.greatalliance.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.greatalliance.R;
import com.greatalliance.base.BaseActivity;
import com.greatalliance.base.Constant;
import com.greatalliance.model.bean.ShopBean;
import com.greatalliance.utils.GlideUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class BuyFoodActivity extends BaseActivity {
    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.iv_buy_food) ImageView ivBuyFood;
    @BindView(R.id.tv_buy_food_name) TextView tvBuyFoodName;
    @BindView(R.id.btn_add_location) TextView btnAddLocation;
    @BindView(R.id.et_location) EditText etLocation;
    @BindView(R.id.tv_money) TextView tvMoney;
    @BindView(R.id.btn_buy) TextView btnBuy;

    private ShopBean shopBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_buy_food;
    }

    @Override
    public void initDatas() {
        Intent fromBuyFrag = getIntent();
        if (fromBuyFrag != null) {
            shopBean = (ShopBean) fromBuyFrag.getSerializableExtra(Constant.INTENT_BUY_FOOD);
        }
    }

    @Override
    public void configViews() {
        tvTitle.setText("确认信息/支付");
        if (shopBean != null) {
            tvBuyFoodName.setText(shopBean.getFoodName());
            GlideUtils.load(ivBuyFood, shopBean.getFoodPhotoPath());
        }
    }



    @OnClick({R.id.btn_add_location, R.id.btn_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add_location:
                break;
            case R.id.btn_buy:
                break;
        }
    }
}
