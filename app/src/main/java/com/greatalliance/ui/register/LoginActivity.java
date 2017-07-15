package com.greatalliance.ui.register;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.greatalliance.R;
import com.greatalliance.base.BaseActivity;
import com.greatalliance.base.Constant;
import com.greatalliance.model.User;
import com.greatalliance.ui.MainActivity;
import com.greatalliance.utils.AppUtils;
import com.greatalliance.utils.ScreenUtils;
import com.greatalliance.utils.SelectorFactory;
import com.greatalliance.utils.SharedPreferencesUtils;
import com.greatalliance.utils.StringUtils;
import com.greatalliance.utils.ToastUtils;
import com.greatalliance.widget.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by MBENBEN on 2017/7/10.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_account) EditText etAccount;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.iv_avatar) CircleImageView ivAvatar;
    @BindView(R.id.btn_login) TextView btnLogin;
    @BindView(R.id.btn_register) TextView btnRegister;



    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {
        btnRegister.setBackground(SelectorFactory.newShapeSelector()
                .setCornerRadius(ScreenUtils.dp2px(20))
                .setDefaultStrokeColor(ContextCompat.getColor(
                        AppUtils.getAppContext(),
                        R.color.main_color))
                .setStrokeWidth(ScreenUtils.dp2px(1))
                .create());
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

    @OnClick({R.id.btn_login,R.id.btn_register})
    public void onClicked(View view){
        switch (view.getId()){
            case R.id.btn_login:
                final String strAccount=etAccount.getText().toString().trim();
                final String strPassword=etPassword.getText().toString().trim();
                if (!StringUtils.isEmpty(strAccount) && !StringUtils.isEmpty(strPassword)) {
                    waitNetPopupWindowUtils.showWaitNetPopupWindow(this);
                    final User user = new User();
                    user.setUsername(strAccount);
                    user.setPassword(strPassword);
                    user.logInInBackground(strAccount, strPassword, new LogInCallback<AVUser>() {
                        @Override
                        public void done(AVUser avUser, AVException e) {
                            if (e==null){
                                waitNetPopupWindowUtils.hideWaitNetPopupWindow(LoginActivity.this);
                                Intent toMain=new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(toMain);
                                finish();
                                SharedPreferencesUtils.getInstance().putInt(Constant.ACCOUNT_LOGIN_KEY,1);
                            }else{
                                waitNetPopupWindowUtils.hideWaitNetPopupWindow(LoginActivity.this);
                                ToastUtils.showShort("登陆失败，请注意：账号/密码/网络");
                            }
                        }
                    });
                }
                break;
            case R.id.btn_register:
                Intent toRegister=new Intent(this,RegisterActivity.class);
                startActivity(toRegister);
                finish();
                break;
        }
    }
}
