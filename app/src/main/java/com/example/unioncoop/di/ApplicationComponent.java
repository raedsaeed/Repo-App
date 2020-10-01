package com.example.unioncoop.di;

import com.example.unioncoop.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;


/**
 * Created by Raed Saeed on 11/3/2019.
 */
@ApplicationScope
@Component(modules = {NetworkModule.class,
        ContextModule.class,
        ViewModelModule.class,
        AndroidInjectionModule.class})
public interface ApplicationComponent {
    ActivityComponent.Factory activityComponent();

    void inject(BaseApplication app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(BaseApplication application);

        ApplicationComponent create();
    }
}
