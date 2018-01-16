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

        Context context = this;

        GsonBuilder gsonBuilder = new GsonBuilder();
        //gsonBuilder.registerTypeAdapter(DateTime.class,new DateTimeConver)
        Gson gson = gsonBuilder.create();

        Timber.plant(new Timber.DebugTree());

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });

        File cacheFile = new File(context.getCacheDir(), "okhttp_cache");
        cacheFile.mkdirs();

        Cache cache = new Cache(cacheFile, 10 * 1000 * 1000); //10MB cache

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://www.google.com")
                .build();

        apiService = retrofit.create(ApiService.class);

        picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }

    public ApiService getApiService() {
        return apiService;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
