package com.example.dagger2mvpexp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common_base.utils.ConstantUtils;
import com.example.dagger2mvpexp.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by sky 2020-02-23.
 */
public class MyApplication extends Application implements  HasActivityInjector , HasSupportFragmentInjector {
    public static MyApplication myApplication;
    @Inject
    public DispatchingAndroidInjector<Activity> mActivityInjector;

    @Inject
    public DispatchingAndroidInjector<Fragment> mFragmentInjector;

    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        ConstantUtils.init(this);
        initARouter();
        DaggerAppComponent.builder().build().inject(this);
    }

    private void initARouter() {
        if (ConstantUtils.isAppDebug()) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mActivityInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }
}
