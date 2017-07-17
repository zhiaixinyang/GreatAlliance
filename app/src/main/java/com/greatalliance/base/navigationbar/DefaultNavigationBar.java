package com.greatalliance.base.navigationbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.greatalliance.R;

/**
 * Created by MBENBEN on 2017/7/15.
 */

public class DefaultNavigationBar<D extends AbsNavigationBar.Builder.NavigationParams> extends
        AbsNavigationBar<DefaultNavigationBar.Builder.DefaultNavigationParams> {
    public DefaultNavigationBar(Builder.DefaultNavigationParams params) {
        super(params);
    }

    @Override
    public void applyView() {
        // 给我们的导航条绑定资源
        setImageResource(R.id.iv_left, getParams().leftIconRes);
        setImageResource(R.id.iv_right, getParams().rightIconRes);
        setText(R.id.tv_title, getParams().title);
        setText(R.id.tv_left, getParams().leftTv);
        setText(R.id.tv_right, getParams().rightTv);
        setOnClickListener(R.id.iv_left, getParams().leftOnClickListener);
        setOnClickListener(R.id.iv_right, getParams().leftOnClickListener);
    }

    @Override
    public int bindLayoutId() {
        // 绑定布局layoutId
        return R.layout.base_navigation_default;
    }

    // 构建导航条类
    public static class Builder extends AbsNavigationBar.Builder {
        private DefaultNavigationParams params;

        public Builder(Context context, ViewGroup parent) {
            params = new DefaultNavigationParams(context, parent);
        }

        public Builder setTitle(String title) {
            params.title = title;
            return this;
        }

        public Builder setRight(String right) {
            params.rightTv = right;
            return this;
        }

        public Builder setLeft(String left) {
            params.leftTv = left;
            return this;
        }

        public Builder setLeftIcon(int iconRes) {
            params.leftIconRes = iconRes;
            return this;
        }

        public Builder setRightIcon(int iconRes) {
            params.rightIconRes = iconRes;
            return this;
        }

        public Builder setTitleBackgroundColor(int bgColor) {
            params.bgColor = bgColor;
            return this;
        }

        public Builder setLeftOnClickListener(View.OnClickListener onClickListener) {
            params.leftOnClickListener = onClickListener;
            return this;
        }

        public Builder setRightOnClickListener(View.OnClickListener onClickListener) {
            params.rightOnClickListener = onClickListener;
            return this;
        }

        @Override
        public DefaultNavigationBar<NavigationParams> create() {
            DefaultNavigationBar<NavigationParams> navigation = new DefaultNavigationBar<NavigationParams>(params);
            return navigation;
        }

        // 默认的配置参数
        public static class DefaultNavigationParams extends NavigationParams {
            //标题
            public String title;
            //左边图片资源
            public int leftIconRes;
            //右边图片资源
            public int rightIconRes;
            //左边的点击事件
            public View.OnClickListener leftOnClickListener;
            //右边的点击事件
            public View.OnClickListener rightOnClickListener;
            public String leftTv;
            public String rightTv;
            public int bgColor;

            public DefaultNavigationParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }
    }
}
