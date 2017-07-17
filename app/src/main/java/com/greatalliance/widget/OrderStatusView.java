package com.greatalliance.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.greatalliance.R;
import com.greatalliance.utils.ScreenUtils;

/**
 * Created by 谷 聪聪 on 2017/7/15 0015.
 */

public class OrderStatusView extends View {
    /**
     * 订单量中状态：
     * 配送中 和 配送完成
     * 配送中 显示动画效果
     * 配送完成 动画效果结束
     */
    public static final int ORDER_STATUS_DELIVERING = 0;
    public static final int ORDER_STATUS_DELIVERED = 1;

    private static final int DEF_DOTCOLOR_DELIVERING = Color.parseColor("#f6f6f6");
    private static final int DEF_DOTCOLOR_DELIVERED = Color.parseColor("#EC4A48");

    private int mOrderStatus;
    private int mDotColorDelivering;
    private int mDotColorDelivered;
    private int mWidth;
    private int mHeight;
    private int mRadius;
    private int mPadding;

    /**
     * mHint1：预计送达。
     * mHint2：预计送达时间，例：12：30
     * mHint3: 您的订单正在配送中。
     */
    private String mHint_Predict;
    private String mHint_Moment;
    private String mHint_Status;

    private Canvas mCanvas;
    private Paint mPaint;

    private float mBigDotSize;
    private float mSmallDotSize;

    public OrderStatusView(Context context) {
        this(context ,null);
    }

    public OrderStatusView(Context context, AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public OrderStatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.OrderStatusView
                , defStyleAttr, 0);
        mDotColorDelivering = a.getColor(R.styleable.OrderStatusView_dotColor_delivering
                , DEF_DOTCOLOR_DELIVERING);
        mDotColorDelivered = a.getColor(R.styleable.OrderStatusView_dotColor_delivered
                , DEF_DOTCOLOR_DELIVERED);
        a.recycle();
        mOrderStatus = ORDER_STATUS_DELIVERING;
        mHint_Moment = "00:00";
        mPadding = ScreenUtils.dp2px(6f);
        mSmallDotSize = ScreenUtils.dp2px(3f);
        mBigDotSize = ScreenUtils.dp2px(4f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRadius = Math.min((w - getPaddingLeft() - getPaddingRight()),(h - getPaddingTop() - getPaddingBottom()))/2;

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        mCanvas = canvas;
        mPaint = new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true);
        mWidth = getWidth();
        mHeight = getHeight();
        if (mOrderStatus == ORDER_STATUS_DELIVERING) {
            drawBgDotAndHints();
        }

    }

    private void drawBgDotAndHints(){
        mPaint.setColor(mDotColorDelivering);
        mCanvas.save();
        for (int i = 0 ;i < 60 ; i++){
            mCanvas.drawCircle(mWidth/2,mPadding,mSmallDotSize,mPaint);
            mCanvas.rotate(6f, mWidth/2, mHeight/2);
        }
        mCanvas.restore();

        int centerTextHeight;
        int margin = 40;


        //绘制“12:32”（送达时间）字样
        Rect textBound = new Rect();
        mPaint.setTextSize(135f);
        mPaint.setColor(Color.BLACK);
        mPaint.getTextBounds(mHint_Moment,0,mHint_Moment.length(),textBound);
        centerTextHeight = textBound.height();
        mCanvas.drawText(mHint_Moment,mWidth/2 - textBound.width()/2
                , mHeight/2 + textBound.height()/2 + mPadding ,mPaint);


        //绘制“预计送达”字样
        mHint_Predict = "预计送达";
        mPaint.setTextSize(40f);
        mPaint.setColor(mDotColorDelivering);
        mPaint.getTextBounds(mHint_Predict,0,mHint_Predict.length(),textBound);
        mCanvas.drawText(mHint_Predict, mWidth/2 - textBound.width()/2
                , mHeight/2 - centerTextHeight/2 - textBound.height()  + mPadding ,mPaint);

        //绘制“您的订单正在配送中”字样
        mHint_Status = "您的订单正在配送中";
        mPaint.setTextSize(35f);
        mPaint.setColor(getResources().getColor(R.color.light_pink));
        mPaint.getTextBounds(mHint_Status, 0, mHint_Status.length(), textBound);
        mCanvas.drawText(mHint_Status, mWidth/2 - textBound.width()/2
                , mHeight/2 + centerTextHeight/2 + margin + mPadding, mPaint);

    }
    public void setOrderStstus(int orderStstus){
        this.mOrderStatus = orderStstus;
    }
    public int getOrderStatus(){
        return mOrderStatus;
    }
    public int getDotColorDelivering() {
        return mDotColorDelivering;
    }

    public void setDotColorDelivering(int mDotColorDelivering) {
        this.mDotColorDelivering = mDotColorDelivering;
    }

    public int getDotColorDelivered() {
        return mDotColorDelivered;
    }

    public void setDotColorDelivered(int mDotColorDelivered) {
        this.mDotColorDelivered = mDotColorDelivered;
    }
}
