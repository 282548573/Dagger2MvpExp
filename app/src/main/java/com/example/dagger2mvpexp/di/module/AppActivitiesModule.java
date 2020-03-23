package com.example.dagger2mvpexp.di.module;

import com.example.common_base.di.annotation.ActivityScope;
import com.example.dagger2mvpexp.di.module.activty.SplashActivityModule;
import com.example.dagger2mvpexp.mvp.ui.activity.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by sky 2020-03-22.
 */
@Module
abstract class AppActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {SplashActivityModule.class})
    abstract SplashActivity contributesSplashActivityIninjector();
}