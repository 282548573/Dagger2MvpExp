package com.example.dagger2mvpexp.di.module;

import android.app.Application;

import com.example.dagger2mvpexp.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sky 2020-03-22.
 */


@Module(includes = {AppActivitiesModule.class})
public class AppModule {
    @Singleton
    @Provides
    Application provideApplication() {
        return MyApplication.myApplication;
    }

}