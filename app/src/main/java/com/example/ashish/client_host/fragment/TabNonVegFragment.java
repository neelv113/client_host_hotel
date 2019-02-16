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

import com.example.ashish.client_host.Adapter.RecyclerNonVegAdapter;
import com.example.ashish.client_host.Holder.ViewHolder;
import com.example.ashish.client_host.Model.Data;
import com.example.ashish.client_host.activity.AllEatablesActivity;
import com.example.ashish.pre_booked_hotel.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.support.constraint.Constraints.TAG;

public class TabNonVegFragment extends Fragment {
    private RecyclerView recyclerNonVeg;
    private RecyclerNonVegAdapter recyclerNonVegAdapter;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_nonveg_fragment, container, false);
        initViews(view);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("NonVegFoods");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Data, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Data, ViewHolder>(
                        Data.class,
                        R.layout.nonveg_view,
                        ViewHolder.class,
                        reference)
                {

                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Data model, int position) {
                        viewHolder.setNonVegFoodDetails(getContext(),model.getNonVegUrl(),model.getNonVegName());
                    }

                    @Override
                    public void onBindViewHolder(ViewHolder viewHolder, int position) {
                        Log.d(TAG, "onBindViewHolder1:");
                        super.onBindViewHolder(viewHolder, position);
                        viewHolder.getViewNonVegLayout().setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                Log.d(TAG, "onClick:");
                                Intent intent = new Intent(getActivity().getBaseContext(),AllEatablesActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                };
        recyclerNonVeg.setAdapter(firebaseRecyclerAdapter);
    }

    private void initViews(View view) {
        recyclerNonVeg = view.findViewById(R.id.recyclerNonVeg);
        recyclerNonVeg.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerNonVegAdapter = new RecyclerNonVegAdapter(this);
        recyclerNonVeg.setAdapter(recyclerNonVegAdapter);
    }
}
