package com.example.daggermvp.daggermvpapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.daggermvp.daggermvpapp.data.network.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by Ali on 1/16/2018.
 */

public class DaggerMvpApplication extends Application {

    public static DaggerMvpApplication get(Activity activity) {
        return (DaggerMvpApplication) activity.getApplication();
    }

    private ApiService apiService;
    private Picasso picasso;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        DaggerMvpApplicationComponent component = DaggerDaggerMvpApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        apiService = component.getApiService();
        picasso = component.getPicasso();
    }

    public ApiService getApiService() {
        return apiService;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
