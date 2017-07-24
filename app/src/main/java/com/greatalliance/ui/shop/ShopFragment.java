package com.greatalliance.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;
import com.greatalliance.base.CommonAdapter;
import com.greatalliance.base.Constant;
import com.greatalliance.base.ViewHolder;
import com.greatalliance.model.bean.ShopBean;
import com.greatalliance.utils.AppUtils;
import com.greatalliance.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class ShopFragment extends BaseFragment {
    @BindView(R.id.rlv_shop) RecyclerView rlvShop;
    private List<ShopBean> data;

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
        data=new ArrayList<>();
        ShopBean shopBeanOne=new ShopBean();
        shopBeanOne.setFoodPhotoPath(R.drawable.icon_logo);
        shopBeanOne.setFoodContent("绝对美味");
        shopBeanOne.setFoodMoeny("10元");
        shopBeanOne.setFoodName("鸡排饭");
        data.add(shopBeanOne);

        ShopBean shopBeanTwo=new ShopBean();
        shopBeanTwo.setFoodPhotoPath(R.drawable.icon_logo);
        shopBeanTwo.setFoodContent("绝对美味");
        shopBeanTwo.setFoodMoeny("10元");
        shopBeanTwo.setFoodName("炒面");
        data.add(shopBeanTwo);

        ShopBean shopBeanThree=new ShopBean();
        shopBeanThree.setFoodPhotoPath(R.drawable.icon_logo);
        shopBeanThree.setFoodContent("绝对美味");
        shopBeanThree.setFoodMoeny("10元");
        shopBeanThree.setFoodName("水饺");
        data.add(shopBeanThree);
    }

    @Override
    public void configViews() {
        rlvShop.setLayoutManager(new LinearLayoutManager(AppUtils.getAppContext()));
        rlvShop.addItemDecoration(new SpaceDecoration(15));
        rlvShop.setAdapter(new CommonAdapter<ShopBean>(AppUtils.getAppContext(),
                R.layout.item_shop,data) {
            @Override
            public void convert(ViewHolder holder, final ShopBean shopBean) {
                holder.setText(R.id.tv_content,shopBean.getFoodContent());
                holder.setText(R.id.tv_money,shopBean.getFoodMoeny());
                holder.setText(R.id.tv_name,shopBean.getFoodName());
                GlideUtils.load((ImageView) holder.getView(R.id.iv_food),shopBean.getFoodPhotoPath());
                holder.getView(R.id.btn_buy).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toBuy=new Intent(AppUtils.getAppContext(),BuyFoodActivity.class);
                        toBuy.putExtra(Constant.INTENT_BUY_FOOD,shopBean);
                        startActivity(toBuy);
                    }
                });
            }
        });
    }
}
