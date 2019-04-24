package com.example.ashish.client_host.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.ashish.client_host.Adapter.RecyclerDrinkAdapter;
import com.example.ashish.client_host.Holder.ViewHolder;
import com.example.ashish.client_host.Model.Data;
import com.example.ashish.client_host.util.SharedPreferences;
import com.example.ashish.pre_booked_hotel.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class DrinkOrderActivity extends AppCompatActivity {
    private static final String TAG = DrinkOrderActivity.class.getSimpleName();
    private RecyclerView recyclerDrink;
    private RecyclerDrinkAdapter recyclerDrinkAdapter;
    FirebaseDatabase database;
    DatabaseReference myRef;
    Button btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_order);
        initViews();
        btnCart=findViewById(R.id.btnCart);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SharedPreferences.isEmpty())
                {
                    startActivity(new Intent(DrinkOrderActivity.this,DrinkOrderActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    Toast.makeText(DrinkOrderActivity.this,"Please select any order",Toast.LENGTH_LONG).show();
                }
                else
                    {
                        startActivity(new Intent(DrinkOrderActivity.this,Cart.class));
                    }

            }
        });

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Drinks");
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
                        viewHolder.setDetails(getApplicationContext(),model.getImgUrl(),model.getName(),model.getPrice());
                    }

                    @Override
                    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
                        super.onBindViewHolder(viewHolder, position);
                        Log.d(TAG, "onBindViewHolderDrink:"+viewHolder.drinkBtn);

                        viewHolder.drinkBtn.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                Toast.makeText(DrinkOrderActivity.this,"Item Added To Cart",Toast.LENGTH_LONG).show();
                                SharedPreferences.putFoodList(viewHolder.textView.getText().toString(),Integer.parseInt(viewHolder.textPriceView.getText().toString()));
                                Log.d(TAG, "onClickDrink: "+viewHolder.textView.getText()+"__"+viewHolder.textPriceView.getText());
                            }
                        });
                    }
                };
        recyclerDrink.setAdapter(firebaseRecyclerAdapter);
        }

    private void initViews() {
        recyclerDrink = findViewById(R.id.recyclerDrink);
        recyclerDrink.setLayoutManager(new LinearLayoutManager(this));
        //recyclerDrinkAdapter = new RecyclerDrinkAdapter(this);
        //recyclerDrink.setAdapter(recyclerDrinkAdapter);
    }
}