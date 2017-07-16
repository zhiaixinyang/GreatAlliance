/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greatalliance.base;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.greatalliance.GreatAllianceApplication;
import com.greatalliance.R;
import com.greatalliance.utils.SharedPreferencesUtils;
import com.greatalliance.utils.StatusBarCompat;
import com.greatalliance.utils.StatusBarUtils;
import com.greatalliance.utils.WaitNetPopupWindowUtils;

import butterknife.ButterKnife;
/**
 * Created by MBENBEN on 2017/7/9.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected int statusBarColor = 0;
    protected View statusBarView = null;
    private boolean mNowMode;
    protected WaitNetPopupWindowUtils waitNetPopupWindowUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFormat(PixelFormat.TRANSLUCENT);

        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setStatusBarColor();

        mContext = this;
        waitNetPopupWindowUtils=new WaitNetPopupWindowUtils();
        GreatAllianceApplication.getInstance().addActivity(this);
        initDatas();
        configViews();
        mNowMode = SharedPreferencesUtils.getInstance().getBoolean(Constant.ISNIGHT);
    }

    private void setStatusBarColor() {
        StatusBarUtils.setColorNoTranslucent(this,ContextCompat.getColor(this,R.color.white));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SharedPreferencesUtils.getInstance().getBoolean(Constant.ISNIGHT, false) != mNowMode) {
            if (SharedPreferencesUtils.getInstance().getBoolean(Constant.ISNIGHT, false)) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            recreate();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GreatAllianceApplication.getInstance().removeActivity(this);
    }

    public abstract int getLayoutId();


    public abstract void initDatas();

    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public abstract void configViews();

    protected void gone(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.GONE);
                }
            }
        }
    }

    protected void visible(final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(View.VISIBLE);
                }
            }
        }

    }

    protected boolean isVisible(View view) {
        return view.getVisibility() == View.VISIBLE;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void hideStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        if(statusBarView != null){
            statusBarView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    protected void showStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        if(statusBarView != null){
            statusBarView.setBackgroundColor(statusBarColor);
        }
    }

}
