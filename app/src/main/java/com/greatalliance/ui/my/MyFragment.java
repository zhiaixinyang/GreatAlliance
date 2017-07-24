package com.greatalliance.ui.my;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.greatalliance.R;
import com.greatalliance.base.BaseFragment;
import com.greatalliance.widget.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.iv_avatar) CircleImageView ivAvatar;
    @BindView(R.id.tv_name) TextView tvName;
    @BindView(R.id.tv_content) TextView tvContent;
    @BindView(R.id.tv_my_followers_num) TextView tvMyFollowersNnum;
    @BindView(R.id.layout_one) RelativeLayout layoutOne;
    @BindView(R.id.tabLayout) TabLayout tabLayout;
    @BindView(R.id.viewPager) ViewPager viewPager;
    private MyOrderFragment myOrderFragment;
    private MyShareFoodFragment myShareFoodFragment;
    private MyInfoFragment myInfoFragment;
    private String[] titles;

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
        myOrderFragment=MyOrderFragment.newInstance();
        myShareFoodFragment=MyShareFoodFragment.newInstance();
        myInfoFragment = MyInfoFragment.newInstance();
        titles= new String[]{"美食分享", "历史订单", "我的信息"};
    }

    @Override
    public void configViews() {
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position==0){
                    return myShareFoodFragment;
                }
                if (position == 2) return myInfoFragment;
                return myOrderFragment;
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

}
