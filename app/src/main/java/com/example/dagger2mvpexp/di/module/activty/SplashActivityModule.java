package com.example.dagger2mvpexp.di.module.activty;

import com.example.common_base.di.annotation.ActivityScope;
import com.example.dagger2mvpexp.mvp.contract.SplashContract;
import com.example.dagger2mvpexp.mvp.model.SplashModel;
import com.example.dagger2mvpexp.mvp.ui.activity.SplashActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sky 2020-03-22.
 */
@Module
public class SplashActivityModule {

    @ActivityScope
    @Provides
    SplashContract.View provideView(SplashActivity view) {
        return view;
    }

    @ActivityScope
    @Provides
    SplashContract.Model provideModel(SplashModel model) {
        return model;
    }
}
