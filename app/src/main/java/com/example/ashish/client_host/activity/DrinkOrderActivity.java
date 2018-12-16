package com.example.ashish.client_host.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;



import com.example.ashish.client_host.Adapter.RecyclerDrinkAdapter;
import com.example.ashish.pre_booked_hotel.R;

public class DrinkOrderActivity extends AppCompatActivity {
    private RecyclerView recyclerDrink;
    private RecyclerDrinkAdapter recyclerDrinkAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_order);
        initViews();
    }
    
    private void initViews() {
        recyclerDrink = findViewById(R.id.recyclerDrink);
        recyclerDrink.setLayoutManager(new LinearLayoutManager(this));
        recyclerDrinkAdapter = new RecyclerDrinkAdapter(this);
        recyclerDrink.setAdapter(recyclerDrinkAdapter);
    }


}

