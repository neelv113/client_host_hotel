package com.example.ashish.client_host.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.ashish.client_host.Adapter.RecyclerVegViewAdapter;
import com.example.ashish.client_host.Holder.ViewHolder;
import com.example.ashish.client_host.Model.Data;
import com.example.ashish.client_host.activity.AllEatablesActivity;

import com.example.ashish.pre_booked_hotel.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.support.constraint.Constraints.TAG;

public class TabVegFragment extends Fragment{

    private RecyclerView recyclerVeg;
    private RecyclerVegViewAdapter recyclerVegAdapter;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_veg_fragment, container, false);
        initViews(view);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("VegFoods");

        return view;
    }

    @Override
    public void onStart() {

        super.onStart();
        FirebaseRecyclerAdapter<Data, ViewHolder>firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Data, ViewHolder>(
                        Data.class,
                        R.layout.veg_view,
                        ViewHolder.class,
                        reference)
                {

                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Data model, int position) {
                        viewHolder.setVegFoodDetails(getContext(),model.getFoodUrl(),model.getFoodName());
                    }


                    @Override
                    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
                        Log.d(TAG, "onBindViewHolder:");
                        super.onBindViewHolder(viewHolder, position);
                        viewHolder.getViewVegLayout().setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                Log.d(TAG, "onEnterVeg: "+viewHolder.getFoodName());
                                Intent intent = new Intent(getActivity().getBaseContext(),AllEatablesActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("food",viewHolder.getFoodName());
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        });
                    }
                };
        recyclerVeg.setAdapter(firebaseRecyclerAdapter);
    }
    private void initViews(View view) {
        //spinner = view.findViewById(R.id.vegSpinner);
        recyclerVeg = view.findViewById(R.id.recyclerVeg);
        recyclerVeg.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerVegAdapter = new RecyclerVegViewAdapter(this);
        recyclerVeg.setAdapter(recyclerVegAdapter);
    }
}