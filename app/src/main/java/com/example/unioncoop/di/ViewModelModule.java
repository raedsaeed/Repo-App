package com.example.unioncoop.di;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.unioncoop.RepoViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Raed Saeed on 11/6/2019.
 */
@SuppressWarnings("unused")
@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel.class)
    abstract ViewModel bindRepoViewModel(RepoViewModel repoViewModel);
}
