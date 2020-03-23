package com.example.dagger2mvpexp.mvp.presenter;

import android.util.Log;

import com.example.common_base.mvp.BasePresenter;
import com.example.dagger2mvpexp.mvp.contract.SplashContract;


import javax.inject.Inject;

/**
 * Created by sky 2020-02-23.
 */
public class  SplashPresenter extends BasePresenter<SplashContract.View, SplashContract.Model> {
    @Inject
    SplashPresenter(SplashContract.View view, SplashContract.Model model) {
        super(view, model);
    }

    public void launch() {
        Log.d("www","eeee");

    }
}
