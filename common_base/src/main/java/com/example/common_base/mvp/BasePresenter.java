package com.example.common_base.mvp;

/**
 * Created by sky 2020-02-23.
 */
public abstract class BasePresenter<V extends IView,M extends IModel> {
    protected V mView;
    protected M mModel;
}
