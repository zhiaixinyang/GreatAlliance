package com.greatalliance.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.greatalliance.R;
import com.greatalliance.base.BaseActivity;
import com.greatalliance.base.Constant;
import com.greatalliance.ui.map.MapFragment;
import com.greatalliance.ui.my.MyFragment;
import com.greatalliance.ui.register.LoginActivity;
import com.greatalliance.ui.share.ShareFragment;
import com.greatalliance.ui.shop.ShopFragment;
import com.greatalliance.utils.SharedPreferencesUtils;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    @BindView(R.id.navigation) BottomNavigationView bottomNavigation;
    private MapFragment mapFragment;
    private ShopFragment shopFragment;
    private ShareFragment shareFragment;
    private MyFragment myFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initDatas() {
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

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_content,mapFragment).commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()){
            case R.id.menu_map:
                if (mapFragment==null) {
                    mapFragment = MapFragment.newInstance();
                }
                transaction.replace(R.id.frag_content,mapFragment);
                break;
            case R.id.menu_shop:
                if (shopFragment==null){
                    shopFragment=ShopFragment.newInstance();
                }
                transaction.replace(R.id.frag_content,shopFragment);
                break;
            case R.id.menu_share:
                if (shareFragment==null){
                    shareFragment=ShareFragment.newInstance();
                }
                transaction.replace(R.id.frag_content,shareFragment);
                break;
            case R.id.menu_my:
                if (myFragment==null){
                    myFragment=MyFragment.newInstance();
                }
                transaction.replace(R.id.frag_content,myFragment);
                break;
        }
        transaction.commit();
        return true;
    }
}
