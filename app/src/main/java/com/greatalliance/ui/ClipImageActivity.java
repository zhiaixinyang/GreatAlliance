package com.greatalliance.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.greatalliance.R;
import com.greatalliance.base.BaseActivity;
import com.greatalliance.base.Constant;
import com.greatalliance.utils.AppUtils;
import com.greatalliance.utils.FileUtils;
import com.greatalliance.utils.ScreenUtils;
import com.greatalliance.utils.SelectorFactory;
import com.greatalliance.widget.clip.ClipImageLayout;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 裁剪图片的Activity
 *
 * @author xiechengfa2000@163.com
 * @ClassName: CropImageActivity
 * @Description:
 * @date 2015-5-8 下午3:39:22
 */
public class ClipImageActivity extends BaseActivity {

    @BindView(R.id.clipImageLayout)
    ClipImageLayout mClipImageLayout = null;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_ok)
    TextView btnOk;
    @BindView(R.id.btn_cancle)
    TextView btnCancle;

    @Override
    public int getLayoutId() {
        return R.layout.layout_crop_image;
    }

    @Override
    public void initDatas() {
        String path = getIntent().getStringExtra(Constant.TO_CLIPACTIVITY);

        // 有的系统返回的图片是旋转了，有的没有旋转，所以处理
        int degreee = readBitmapDegree(path);
        Bitmap bitmap = FileUtils.createBitmap(path);
        if (bitmap != null) {
            if (degreee == 0) {
                mClipImageLayout.setImageBitmap(bitmap);
            } else {
                mClipImageLayout.setImageBitmap(rotateBitmap(degreee, bitmap));
            }
        } else {
            finish();
        }
    }

    @Override
    public void configViews() {
        tvTitle.setText("头像剪裁");
        btnOk.setBackground(SelectorFactory.newShapeSelector()
                .setCornerRadius(ScreenUtils.dp2px(20))
                .setDefaultBgColor(ContextCompat.getColor(
                        AppUtils.getAppContext(),
                        R.color.white))
                .create());
        btnCancle.setBackground(SelectorFactory.newShapeSelector()
                .setCornerRadius(ScreenUtils.dp2px(20))
                .setDefaultBgColor(ContextCompat.getColor(
                        AppUtils.getAppContext(),
                        R.color.white))
                .create());
    }

    @OnClick({R.id.btn_ok, R.id.btn_cancle})
    public void onClicked(View v) {
        if (v.getId() == R.id.btn_ok) {
            Bitmap bitmap = mClipImageLayout.clip();

            String path = Environment.getExternalStorageDirectory() + "/"
                    + "my_avatar.jpg";
            FileUtils.saveBitmap(bitmap, path);

            Intent intent = new Intent();
            intent.putExtra(Constant.RETURN_CLIP_PHOTO, path);
            setResult(RESULT_OK, intent);
        } finish();
    }


    // 读取图像的旋转度
    private int readBitmapDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    // 旋转图片
    private Bitmap rotateBitmap(int angle, Bitmap bitmap) {
        // 旋转图片 动作
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        // 创建新的图片
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        return resizedBitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
