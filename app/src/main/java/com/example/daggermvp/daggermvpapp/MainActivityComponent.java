package com.example.daggermvp.daggermvpapp;

import com.example.daggermvp.daggermvpapp.data.network.ApiService;
import com.example.daggermvp.daggermvpapp.ui.MainActivity;

import dagger.Component;

/**
 * Created by Ali on 1/18/2018.
 */

@MainActivityScope
@Component(modules = MainActivityModule.class, dependencies = DaggerMvpApplicationComponent.class)
public interface MainActivityComponent {
//
//    RecyclerViewAdapter getRecyclerViewAdapter();
//
//    ApiService apiService();

    void injectMainActivity(MainActivity mainActivity);
}
