package com.example.dagger2mvpexp.mvp.contract;

import com.example.common_base.mvp.IModel;
import com.example.common_base.mvp.IView;

/**
 * Created by sky 2020-02-23.
 */
public interface SplashContract {
    interface View extends IView{
        void toWarningActivity();
    }

    interface Model extends IModel {
         Boolean isFirstLaunch();
    }

}
