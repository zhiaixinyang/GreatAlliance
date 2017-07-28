package com.greatalliance.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/**
 * Created by 谷 聪聪 on 2017/7/26 0026.
 */

public class ScaleImageView extends ImageView {

    private int initWidth;
    private int initHeight;

    public ScaleImageView(Context context){
        this(context, null);
    }
    public ScaleImageView(Context context, AttributeSet set){
        this(context, set, 0);
    }
    public ScaleImageView(Context context, AttributeSet set, int defStyle){
        super(context, set, defStyle);
    }
    public void initSize(int initWidth, int initHeight){
        this.initWidth = initWidth;
        this.initHeight = initHeight;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (initWidth > 0 && initHeight > 0) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = MeasureSpec.getSize(heightMeasureSpec);

            float scale = (float) initHeight / (float) initWidth;
            if (width > 0){
                height = (int) ((float)width * scale);
            }
            setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
