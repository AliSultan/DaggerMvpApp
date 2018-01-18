package com.example.daggermvp.daggermvpapp;

import com.example.daggermvp.daggermvpapp.ui.MainActivity;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ali on 1/18/2018.
 */

@Module
public class MainActivityModule {

    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public MainActivity mainActivity() {
        return mainActivity;
    }

//    @Provides
//    @MainActivityScope
//    public RecyclerViewAdapter recyclerViewAdapter(Picasso picasso) {
//        return new RecyclerViewAdapter(mainActivity, picasso);
//    }
}
