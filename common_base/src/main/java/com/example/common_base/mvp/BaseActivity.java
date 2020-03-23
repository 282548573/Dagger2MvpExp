package com.example.common_base.mvp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

//import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by sky 2020-02-23.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements HasSupportFragmentInjector {
    @Inject
    public P mPresenter;

    @Inject
    protected DispatchingAndroidInjector<Fragment> mFragmentInjector;

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void initLayout(Bundle savedInstanceState);

    protected abstract void initData(Bundle savedInstanceState);

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector(){
        return mFragmentInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        //获取视图（外部实现）
        setContentView(getLayoutId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        //ARouter注入本类对象
        ARouter.getInstance().inject(this);
        //初始化布局（外部实现）
        initLayout(savedInstanceState);
        //初始化数据（外部是实现）
        initData(savedInstanceState);
    }

    //用资源ID冒泡提示
    protected void toast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    //用字符串冒泡提示
    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
