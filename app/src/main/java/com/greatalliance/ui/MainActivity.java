package com.greatalliance.ui;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.greatalliance.R;
import com.greatalliance.base.BaseActivity;
import com.greatalliance.base.Constant;
import com.greatalliance.ui.map.MapFragment;
import com.greatalliance.ui.my.MyFragment;
import com.greatalliance.ui.register.LoginActivity;
import com.greatalliance.ui.share.ShareFragment;
import com.greatalliance.ui.shop.ShopFragment;
import com.greatalliance.utils.ScreenUtils;
import com.greatalliance.utils.SharedPreferencesUtils;
import com.greatalliance.utils.ToastUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    @BindView(R.id.navigation) BottomNavigationView bottomNavigation;
    @BindView(R.id.frag_content)
    FrameLayout frameLayout;

    private MapFragment mapFragment;
    private ShopFragment shopFragment;
    private ShareFragment shareFragment;
    private MyFragment myFragment;
    private FragmentManager fragmentManager;

    private boolean pendingIntroAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) pendingIntroAnim = true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initDatas() {
        Log.d("aaaa","!!!!!!!!!!!!!!!!!!!!!!!!");
        if (SharedPreferencesUtils.getInstance().getInt(Constant.ACCOUNT_LOGIN_KEY)==1){

        }else{
            Intent toLogin=new Intent(this,LoginActivity.class);
            startActivity(toLogin);
            finish();
        }
    }

    @Override
    public void configViews() {
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        mapFragment=MapFragment.newInstance();
        shareFragment=ShareFragment.newInstance();
        shopFragment=ShopFragment.newInstance();
        myFragment=MyFragment.newInstance();

        fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.frag_content,mapFragment)
                .commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()){
            case R.id.menu_map:
                if (mapFragment==null) {
                    mapFragment = MapFragment.newInstance();
                }
                if (!mapFragment.isAdded()) {
                    transaction.add(R.id.frag_content, mapFragment)
                            //为什么，add完又show...因为测试时发现，只add，存在add显示为空白
                            .show(mapFragment)
                            .hide(shopFragment)
                            .hide(shareFragment)
                            .hide(myFragment)
                            .commit();
                }else{
                    transaction.show(mapFragment)
                            .hide(shopFragment)
                            .hide(shareFragment)
                            .hide(myFragment)
                            .commit();
                }
                break;
            case R.id.menu_shop:
                if (shopFragment==null){
                    shopFragment=ShopFragment.newInstance();
                }
                if (!shopFragment.isAdded()) {
                    transaction.add(R.id.frag_content, shopFragment)
                            .show(shopFragment)
                            .hide(mapFragment)
                            .hide(shareFragment)
                            .hide(myFragment)
                            .commit();
                }else{
                    transaction.show(shopFragment)
                            .hide(mapFragment)
                            .hide(shareFragment)
                            .hide(myFragment)
                            .commit();
                }
                break;
            case R.id.menu_share:
                if (shareFragment==null){
                    shareFragment=ShareFragment.newInstance();
                }
                if (!shareFragment.isAdded()) {
                    transaction.add(R.id.frag_content, shareFragment)
                            .show(shareFragment)
                            .hide(mapFragment)
                            .hide(shopFragment)
                            .hide(myFragment)
                            .commit();
                }else{
                    transaction.show(shareFragment)
                            .hide(mapFragment)
                            .hide(shopFragment)
                            .hide(myFragment)
                            .commit();
                }
                break;
            case R.id.menu_my:
                if (myFragment==null){
                    myFragment=MyFragment.newInstance();
                }
                if (!myFragment.isAdded()) {
                    transaction.add(R.id.frag_content, myFragment)
                            .show(myFragment)
                            .hide(mapFragment)
                            .hide(shopFragment)
                            .hide(shareFragment)
                            .commit();
                    fragmentManager.executePendingTransactions();


                }else{
                    transaction.show(myFragment)
                            .hide(mapFragment)
                            .hide(shopFragment)
                            .hide(shareFragment)
                            .commit();
                }
                break;
        }
        return true;
    }

    private void startIntroAnim(){
//        int bottomNavViewSize = ScreenUtils.dp2px(bottomNavigation.getHeight());
//        bottomNavigation.setTranslationY(bottomNavViewSize);
        bottomNavigation.setAlpha(0.5f);

        bottomNavigation.animate()
                .alpha(1f)
                .setDuration(500)
                .start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtils.showShort("MainActivity Destroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        startIntroAnim();
        ToastUtils.showShort("MainActivity Resume");
    }
}
