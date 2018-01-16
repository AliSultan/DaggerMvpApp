package com.example.daggermvp.daggermvpapp;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ali on 1/17/2018.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context context() {
        return context;
    }
}
