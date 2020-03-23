package com.example.dagger2mvpexp.di.component;

import com.example.dagger2mvpexp.MyApplication;
import com.example.dagger2mvpexp.di.module.AppModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;
/**
 * Created by sky 2020-03-22.
 */



@Singleton
@Component(
        modules =
        {
                AndroidInjectionModule.class,
                AndroidSupportInjectionModule.class,
                AppModule.class
        }
)
public interface AppComponent {
    void inject(MyApplication myApplication);

    @Component.Builder
    interface Builder {
        AppComponent build();
    }
}
