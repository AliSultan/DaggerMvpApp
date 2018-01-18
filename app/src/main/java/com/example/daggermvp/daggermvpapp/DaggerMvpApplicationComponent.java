package com.example.daggermvp.daggermvpapp;

import com.example.daggermvp.daggermvpapp.data.network.ApiService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Ali on 1/17/2018.
 */

@DaggerMvpApplicationScope
@Component(modules = {ApiServiceModule.class, PicassoModule.class})
public interface DaggerMvpApplicationComponent {

    Picasso getPicasso();

    ApiService getApiService();
}
