package com.example.dagger2mvpexp.mvp.model;

import com.example.dagger2mvpexp.mvp.contract.SplashContract;

/**
 * Created by sky 2020-02-23.
 */
public class SplashModel implements SplashContract.Model {

    @Override
    public Boolean isFirstLaunch() {
        return null;
    }

    @Override
    public void onDestroy() {

    }
}
