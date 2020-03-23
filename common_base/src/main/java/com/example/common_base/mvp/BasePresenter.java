package com.example.common_base.mvp;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.uber.autodispose.ScopeProvider;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

/**
 * Created by sky 2020-02-23.
 */
public abstract class BasePresenter<V extends IView, M extends IModel> implements IPresenter {
    protected V mView;
    protected M mModel;
    private LifecycleOwner mLifecycleOwner = null;

    public BasePresenter(V view, M model) {
        mView = view;
        mModel = model;
    }

    @Override
    public void setLifecycleOwner(LifecycleOwner owner) {
        if (null == owner) {
            throw new NullPointerException("lifecycleOwner == null");
        }
        mLifecycleOwner = owner;
    }

    @Override
    public LifecycleOwner getLifecycleOwner() {
        if (null == mLifecycleOwner) {
            throw new NullPointerException("lifecycleOwner == null");
        }
        return mLifecycleOwner;
    }

    protected ScopeProvider bindLifecycle() {
        if (null == mLifecycleOwner) {
            throw new NullPointerException("lifecycleOwner == null");
        }
        return AndroidLifecycleScopeProvider.from(mLifecycleOwner);
    }

    protected ScopeProvider bindLifecycle(Lifecycle.Event event) {
        if (null == mLifecycleOwner) {
            throw new NullPointerException("lifecycleOwner == null");
        }
        return AndroidLifecycleScopeProvider.from(mLifecycleOwner, event);
    }

    @MainThread
    @Override
    public void onCreate(LifecycleOwner lifecycleOwner) {

    }

    @MainThread
    @Override
    public void onStart(LifecycleOwner lifecycleOwner) {

    }

    @MainThread
    @Override
    public void onResume(LifecycleOwner lifecycleOwner) {

    }

    @MainThread
    @Override
    public void onPause(LifecycleOwner lifecycleOwner) {

    }

    @MainThread
    @Override
    public void onStop(LifecycleOwner lifecycleOwner) {

    }

    @MainThread
    @Override
    public void onDestroy(LifecycleOwner owner) {
        mModel.onDestroy();
    }

}
