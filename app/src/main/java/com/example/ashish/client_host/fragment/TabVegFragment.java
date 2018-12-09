package com.example.ashish.client_host.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashish.client_host.Adapter.RecyclerVegViewAdapter;
import com.example.ashish.pre_booked_hotel.R;

public class TabVegFragment extends Fragment {
    private RecyclerView recyclerVeg;
    private RecyclerVegViewAdapter recyclerVegAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_veg_fragment, container, false);
        initViews(view);
        return view;
    }


        private void initViews(View view) {
            recyclerVeg = view.findViewById(R.id.recyclerVeg);
            recyclerVeg.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerVegAdapter = new RecyclerVegViewAdapter(this);
            recyclerVeg.setAdapter(recyclerVegAdapter);
        }


}
