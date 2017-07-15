package com.greatalliance.ui;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.greatalliance.R;
import com.greatalliance.base.Constant;
import com.greatalliance.utils.SharedPreferencesUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (SharedPreferencesUtils.getInstance().getInt(Constant.ACCOUNT_LOGIN_KEY)==1){

        }else{
            Intent toLogin=new Intent(this,LoginActivity.class);
            startActivity(toLogin);
            finish();
        }
    }
}
