package com.example.unioncoop.di;

import com.example.unioncoop.MainActivity;

import org.jetbrains.annotations.NotNull;

import dagger.Subcomponent;

/**
 * Created by Raed Saeed on 11/6/2019.
 */
@ActivityScope
@Subcomponent()
public interface ActivityComponent {

    void inject(@NotNull MainActivity mainActivity);

    @Subcomponent.Factory
    interface Factory {
        ActivityComponent create();
    }
}
