package com.example.common_base.mvp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

//import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by sky 2020-02-23.
 */
public abstract class BaseActivity<P> extends AppCompatActivity {
    protected P mPresenter;

    @LayoutRes
    protected abstract int getLayoutId();
    protected abstract void initLayout(Bundle savedInstanceState);
    protected abstract void initData(Bundle savedInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        ARouter.getInstance().inject(this);
        initLayout(savedInstanceState);
        initData(savedInstanceState);
    }

    protected void toast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    protected void toast(String msg) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
