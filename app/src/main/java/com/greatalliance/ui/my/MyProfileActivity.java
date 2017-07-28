package com.greatalliance.ui.my;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

import com.greatalliance.R;
import com.greatalliance.base.BaseActivity;
import com.greatalliance.utils.ToastUtils;
import com.greatalliance.widget.StickyNavLayout;

import butterknife.BindView;

/**
 * Created by 谷 聪聪 on 2017/7/27 0027.
 */

public class MyProfileActivity extends BaseActivity {
    @BindView(R.id.rootView_my)
    StickyNavLayout rootView;

    private int drawStartLocationX, drawStartLocationY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawStartLocationX = getIntent().getIntExtra("drawStartX", 0);
        drawStartLocationY = getIntent().getIntExtra("drawStartY", 0);
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
        rootView.setTranslationX(-rootView.getWidth());

        rootView.animate()
                .translationX(0)
                .setDuration(300)
                .start();
    }

    @Override
    public int getLayoutId() {
        return R.layout.frag_my;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }

    @Override
    public void onBackPressed() {
        startExitAnim();
        overridePendingTransition(0,0);
    }
    private void startExitAnim(){
        rootView.animate()
                .translationX(-rootView.getWidth())
                .setDuration(500)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        finish();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtils.showMyToast("Activity被销毁！", Toast.LENGTH_LONG);
    }
}
