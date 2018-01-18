package com.example.daggermvp.daggermvpapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

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
    private DaggerMvpApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        component = DaggerDaggerMvpApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        apiService = component.getApiService();
        picasso = component.getPicasso();

        ApiService apiService2 = component.getApiService();
        Picasso picasso2 = component.getPicasso();

        ApiService apiService3 = component.getApiService();
        Picasso picasso3 = component.getPicasso();

        Log.i("dagger", "apiservice " + apiService);
        Log.i("dagger", "picasso " + picasso);

        Log.i("dagger", "apiservice2 " + apiService2);
        Log.i("dagger", "picasso2 " + picasso2);

        Log.i("dagger", "apiservice3 " + apiService3);
        Log.i("dagger", "picasso3 " + picasso3);
    }

    public DaggerMvpApplicationComponent component() {
        return component;
    }

//    public ApiService getApiService() {
//        return apiService;
//    }
//
//    public Picasso getPicasso() {
//        return picasso;
//    }
}
