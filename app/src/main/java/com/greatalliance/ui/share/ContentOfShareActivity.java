package com.greatalliance.ui.share;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.greatalliance.R;
import com.greatalliance.base.BaseActivity;
import butterknife.BindView;
/**
 * Created by 谷 聪聪 on 2017/7/24 0024.
 */

public class ContentOfShareActivity extends BaseActivity {
    @BindView(R.id.iv_articleCover)ImageView coverImage;
    @BindView(R.id.tv_articleContent) TextView articleContent;
    @BindView(R.id.toolbar_CttOfSr) Toolbar toolbar;
    @BindView(R.id.collapsingToolBar_CttOfSr) CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.rootView_CttOfSr) CoordinatorLayout rootView;
    @BindView(R.id.appBar_CttOfSr) AppBarLayout appBarLayout;

    String str;
    private Intent intent;
    private String articleTitle;

    private int articleCover;
    private int drawStartingLocationY, drawStartingLocationX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawStartingLocationY = getIntent().getIntExtra("drawStartingLocationY", 0);
        drawStartingLocationX = getIntent().getIntExtra("drawStartingLocationX", 0);
        Rect frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        Log.d("状态栏高度：", ""+frame.top);

        if (savedInstanceState == null){
            rootView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    rootView.getViewTreeObserver().removeOnPreDrawListener(this);
                    startIntroAnim();
                    return true;
                }
            });
        }
    }

    private void startIntroAnim(){
        rootView.setScaleX(0.1f);
        rootView.setScaleY(0.1f);
        rootView.setPivotX(drawStartingLocationX);
        rootView.setPivotY(drawStartingLocationY);

        rootView.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(200)
                .setInterpolator(new AccelerateInterpolator())
                .start();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_contentofshare;
    }

    @Override
    public void initDatas() {
        intent = getIntent();
        Bundle data = intent.getExtras();
        articleTitle = data.getString("articleTitle");
        articleCover = data.getInt("articleCover");
    }
    @Override
    public void configViews() {
        setupToolBar();
        setupAppBarLayout();
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        str = "不吃葡萄皮倒吐葡萄皮.";
        appendText(str);
        articleContent.setText(str);
        Glide.with(this).load(articleCover).into(coverImage);

    }

    private void setupToolBar(){
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupAppBarLayout(){
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                System.out.println("toolBarHeight : "+toolbar.getHeight()
                        +" "+"ImageHeight : " +coverImage.getHeight()
                        +" "+"offset : "+verticalOffset);

            }
        });
    }
    private void appendText(String str){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 500; i++){
            builder.append(str);
        }
        str = builder.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
