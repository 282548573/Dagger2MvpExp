package com.example.dagger2mvpexp.mvp.presenter;

import com.example.common_base.mvp.BasePresenter;
import com.example.dagger2mvpexp.mvp.contract.SplashContract;

/**
 * Created by sky 2020-02-23.
 */
public class SplashPresenter extends BasePresenter<SplashContract.View, SplashContract.Model>{

    public void launch() {
        if (mModel.isFirstLaunch()) {
            mView.toWarningActivity();
            return;
        }
    }
}
