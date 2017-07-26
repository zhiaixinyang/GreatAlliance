package com.greatalliance.ui.share;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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

    String str;
    private Intent intent;
    private String articleTitle;
    private int articleCover;

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
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setTitle(articleTitle);
        str = "不吃葡萄皮倒吐葡萄皮.";
        appendText(str);
        articleContent.setText(str);

        Glide.with(this).load(articleCover).into(coverImage);

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
