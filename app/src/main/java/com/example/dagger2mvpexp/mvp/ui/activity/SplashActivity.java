package com.example.dagger2mvpexp.mvp.ui.activity;

import android.os.Bundle;

import com.example.common_base.mvp.BaseActivity;
import com.example.dagger2mvpexp.R;
import com.example.dagger2mvpexp.mvp.contract.SplashContract;
import com.example.dagger2mvpexp.mvp.presenter.SplashPresenter;

/**
 * Created by sky 2020-02-23.
 */
public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initLayout(Bundle savedInstanceState) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (null != mPresenter){
            mPresenter.launch();
        }

    }

    @Override
    public void toWarningActivity() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
