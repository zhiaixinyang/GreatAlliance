package com.greatalliance.ui.register;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SignUpCallback;
import com.greatalliance.R;
import com.greatalliance.base.BaseActivity;
import com.greatalliance.base.Constant;
import com.greatalliance.model.leancloud.User;
import com.greatalliance.ui.MainActivity;
import com.greatalliance.utils.AlbumUtils;
import com.greatalliance.utils.AppUtils;
import com.greatalliance.utils.FileUtils;
import com.greatalliance.utils.ScreenUtils;
import com.greatalliance.utils.SelectorFactory;
import com.greatalliance.utils.SharedPreferencesUtils;
import com.greatalliance.utils.StringUtils;
import com.greatalliance.utils.ToastUtils;
import com.greatalliance.widget.CircleImageView;

import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by MBENBEN on 2017/7/10.
 */
@RuntimePermissions
public class RegisterActivity extends BaseActivity {
    @BindView(R.id.et_account) EditText etAccount;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.iv_avatar) CircleImageView ivAvatar;
    @BindView(R.id.btn_login) TextView btnLogin;

    @BindBitmap(R.drawable.icon_logo) Bitmap bmAvatar;
    private String photoPath;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initDatas() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }

        switch (requestCode) {
            case Constant.CROP_RESULT_CODE:
                String path = data.getStringExtra(Constant.RETURN_CLIP_PHOTO);
                bmAvatar = BitmapFactory.decodeFile(path);
                ivAvatar.setImageBitmap(bmAvatar);
                break;
            case Constant.START_ALBUM_REQUESTCODE:
                toClip(data);
                break;
            case Constant.CAMERA_WITH_DATA:
                // 照相机程序返回的,再次调用图片剪辑程序去修剪图片
                if (photoPath!=null){
                    toClip(data);
                }
                break;
        }
    }

    protected void toClip(Intent data) {
        photoPath= FileUtils.getPathUrlFromUri(RegisterActivity.this, data.getData());
        Intent toClip=new Intent(this,ClipImageActivity.class);
        toClip.putExtra(Constant.TO_CLIPACTIVITY,photoPath);
        startActivityForResult(toClip,Constant.CROP_RESULT_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        RegisterActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @Override
    public void configViews() {
        btnLogin.setBackground(SelectorFactory.newShapeSelector()
                .setCornerRadius(ScreenUtils.dp2px(20))
                .setDefaultBgColor(ContextCompat.getColor(
                        AppUtils.getAppContext(),
                        R.color.main_color))
                .create());
        etPassword.setBackground(SelectorFactory.newShapeSelector()
                .setCornerRadius(ScreenUtils.dp2px(8))
                .setDefaultStrokeColor(Color.GRAY)
                .setFocusedStrokeColor(ContextCompat.getColor(
                        AppUtils.getAppContext(),
                        R.color.main_color))
                .setStrokeWidth(ScreenUtils.dp2px(1))
                .create());
        etAccount.setBackground(SelectorFactory.newShapeSelector()
                .setCornerRadius(ScreenUtils.dp2px(8))
                .setDefaultStrokeColor(Color.GRAY)
                .setFocusedStrokeColor(ContextCompat.getColor(
                        AppUtils.getAppContext(),
                        R.color.main_color))
                .setStrokeWidth(ScreenUtils.dp2px(1))
                .create());
    }

    @OnClick({R.id.iv_avatar,R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_avatar:
                RegisterActivityPermissionsDispatcher.openAlbumWithCheck(this);
                break;
            case R.id.btn_login:
                final String strAccount=etAccount.getText().toString().trim();
                final String strPassword=etPassword.getText().toString().trim();
                if (!StringUtils.isEmpty(strAccount) && !StringUtils.isEmpty(strPassword)){
                    waitNetPopupWindowUtils.showWaitNetPopupWindow(this);
                    final User user=new User();
                    user.setUsername(strAccount);
                    user.setPassword(strPassword);
                    AVFile avFile = new AVFile(FileUtils.getFileName("my_avatar"), FileUtils.getByteFromBitmap(bmAvatar));
                    user.setAvatar(avFile);
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(AVException e) {
                            if (e==null){
                                user.logInInBackground(strAccount, strPassword, new LogInCallback<AVUser>() {
                                    @Override
                                    public void done(AVUser avUser, AVException e) {
                                        if (e==null){
                                            waitNetPopupWindowUtils.hideWaitNetPopupWindow(RegisterActivity.this);
                                            SharedPreferencesUtils.getInstance().putInt(Constant.ACCOUNT_LOGIN_KEY,1);
                                            Intent toMain=new Intent(RegisterActivity.this, MainActivity.class);
                                            startActivity(toMain);
                                            finish();
                                        }else{
                                            waitNetPopupWindowUtils.hideWaitNetPopupWindow(RegisterActivity.this);
                                            ToastUtils.showShort("错误："+e.getMessage());
                                        }
                                    }
                                });
                            }else{
                                waitNetPopupWindowUtils.hideWaitNetPopupWindow(RegisterActivity.this);
                                ToastUtils.showShort("错误："+e.getMessage());
                            }
                        }
                    });
                }
                break;
        }
    }

    @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
    protected void openAlbum() {
        AlbumUtils.startAlbum(this);
    }
}
