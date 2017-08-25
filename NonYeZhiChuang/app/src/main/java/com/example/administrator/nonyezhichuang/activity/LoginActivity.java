package com.example.administrator.nonyezhichuang.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.administrator.nonyezhichuang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登陆页面
 *
 *
 */


public class LoginActivity extends BaseActivity {


    @BindView(R.id.mEd_login)
    EditText mEdLogin;
    @BindView(R.id.mEd_password)
    EditText mEdPassword;
    @BindView(R.id.mBtn_forgetPassword)
    Button mBtnForgetPassword;
    @BindView(R.id.mBtn_login)
    Button mBtnLogin;
    @BindView(R.id.mBtn_regiest)
    Button mBtnRegiest;
    @BindView(R.id.activity_login)
    RelativeLayout activityLogin;

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public void getCode(String s) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void cancelLoading() {

    }

    @Override
    public void showFaliure(String s) {

    }

    @Override
    public void getLogin(String s) {

    }

    @Override
    public void getUpDate(String s) {

    }

    @OnClick({R.id.mBtn_forgetPassword, R.id.mBtn_login, R.id.mBtn_regiest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtn_forgetPassword:

                break;
            case R.id.mBtn_login:

                break;
            case R.id.mBtn_regiest:
//                startActivity(RegisterActivity.class);
                break;
        }
    }
}
