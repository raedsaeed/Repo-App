package com.example.unioncoop.di;

import androidx.lifecycle.ViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.MapKey;

/**
 * Created by Raed Saeed on 11/6/2019.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
