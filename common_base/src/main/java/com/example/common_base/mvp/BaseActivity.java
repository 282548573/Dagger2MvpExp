package com.example.common_base.mvp;

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
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Dagger2注入
        AndroidInjection.inject(this);

        //ARouter注入本类对象
        ARouter.getInstance().inject(this);

        super.onCreate(savedInstanceState);

        //获取视图（外部实现）
        setContentView(getLayoutId());

        //绑定寿命周期
        getLifecycle().addObserver(mPresenter);
        mPresenter.setLifecycleOwner(this);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        //初始化布局（外部实现）
        initLayout(savedInstanceState);

        //初始化数据（外部是实现）
        initData(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(mPresenter);
    }

    //用资源ID冒泡提示
    protected void toast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    //用字符串冒泡提示
    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    //用资源ID冒泡提示
    protected void toastLong(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
    }

    //用字符串冒泡提示
    protected void toastLong(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    protected void showArsLoadingDialog(Boolean cancelable, Boolean canceledOnTouchOutside) {
        //loading图加载
    }

    protected void hideArsLoadingDialog() {
        //loading图关闭
    }

}
