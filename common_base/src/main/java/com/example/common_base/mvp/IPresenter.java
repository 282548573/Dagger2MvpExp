package com.example.common_base.mvp;

import androidx.lifecycle.LifecycleOwner;

/**
 * Created by sky 2020-02-23.
 */
interface IPresenter {
    void setLifecycleOwner(LifecycleOwner owner);
    LifecycleOwner getLifecycleOwner();
}
