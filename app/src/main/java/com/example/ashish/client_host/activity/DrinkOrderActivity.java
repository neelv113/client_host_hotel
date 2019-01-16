package com.example.ashish.client_host.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ashish.client_host.Adapter.RecyclerDrinkAdapter;
import com.example.ashish.client_host.Holder.ViewHolder;
import com.example.ashish.client_host.Model.Data;
import com.example.ashish.pre_booked_hotel.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DrinkOrderActivity extends AppCompatActivity {
    private static final String TAG = DrinkOrderActivity.class.getSimpleName();
    private RecyclerView recyclerDrink;
    private RecyclerDrinkAdapter recyclerDrinkAdapter;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_order);
        initViews();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Drinks");
      //  Log.d(TAG, "myRef:"+myRef);

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Data, ViewHolder>firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Data, ViewHolder>(
                        Data.class,
                        R.layout.drink_view,
                        ViewHolder.class,
                        myRef

                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Data model, int position) {
//                        Log.d(TAG, "populateViewHolder:");
                        viewHolder.setDetails(getApplicationContext(),model.getImgUrl(),model.getName());
                    }
                };
        recyclerDrink.setAdapter(firebaseRecyclerAdapter);
        }

    private void initViews() {
        recyclerDrink = findViewById(R.id.recyclerDrink);
        recyclerDrink.setLayoutManager(new LinearLayoutManager(this));
        recyclerDrinkAdapter = new RecyclerDrinkAdapter(this);
        recyclerDrink.setAdapter(recyclerDrinkAdapter);
    }
}