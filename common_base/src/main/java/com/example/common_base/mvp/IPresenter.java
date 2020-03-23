package com.example.common_base.mvp;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * Created by sky 2020-02-23.
 */
interface IPresenter extends DefaultLifecycleObserver {
    void setLifecycleOwner(LifecycleOwner owner);
    LifecycleOwner getLifecycleOwner();
}
