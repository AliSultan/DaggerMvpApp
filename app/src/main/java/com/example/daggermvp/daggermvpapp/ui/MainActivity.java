package com.example.daggermvp.daggermvpapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.daggermvp.daggermvpapp.DaggerMainActivityComponent;
import com.example.daggermvp.daggermvpapp.DaggerMvpApplication;
import com.example.daggermvp.daggermvpapp.MainActivityComponent;
import com.example.daggermvp.daggermvpapp.MainActivityModule;
import com.example.daggermvp.daggermvpapp.R;
import com.example.daggermvp.daggermvpapp.RecyclerViewAdapter;
import com.example.daggermvp.daggermvpapp.data.network.ApiService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_recyclerview)
    protected RecyclerView main_recyclerview;

    @Inject
    RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        MainActivityComponent component = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .daggerMvpApplicationComponent(DaggerMvpApplication.get(this).component())
                .build();

        component.injectMainActivity(this);
        //  recyclerViewAdapter = component.getRecyclerViewAdapter();
        // apiService = component.apiService();

        main_recyclerview.setAdapter(recyclerViewAdapter);
    }
}
