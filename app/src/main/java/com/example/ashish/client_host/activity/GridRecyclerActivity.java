package com.example.ashish.client_host.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ashish.client_host.Adapter.RecyclerGridAdapter;
import com.example.ashish.pre_booked_hotel.R;

public class GridRecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerGridAdapter recyclerGridAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_recycler_activity);
        initViews();
    }

    private void initViews() {
        recyclerView=findViewById(R.id.grid_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerGridAdapter = new RecyclerGridAdapter(this);
        recyclerView.setAdapter(recyclerGridAdapter);
    }
}
