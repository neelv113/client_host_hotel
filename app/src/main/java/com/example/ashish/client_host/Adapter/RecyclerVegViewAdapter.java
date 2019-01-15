package com.example.ashish.client_host.Adapter;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish.client_host.activity.GridRecyclerActivity;
import com.example.ashish.client_host.fragment.TabVegFragment;
import com.example.ashish.client_host.util.FragmentUtil;
import com.example.ashish.pre_booked_hotel.R;

public class RecyclerVegViewAdapter extends RecyclerView.Adapter<RecyclerVegViewAdapter.ViewHolder> {
    private static final String TAG = RecyclerVegViewAdapter.class.getSimpleName();
    private TabVegFragment context;

    public RecyclerVegViewAdapter(TabVegFragment context){
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.veg_view, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.setData(position);
        holder.vegTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(FragmentUtil.getActivity(context),GridRecyclerActivity.class));
                //Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView vegTextView;
        private ImageView vegFoodImg;

        public ViewHolder(View itemView) {
            super(itemView);
            vegTextView = itemView.findViewById(R.id.vegTxt);
            vegFoodImg = itemView.findViewById(R.id.vegImg);
        }

        public void setData(int position) {
            Log.d(TAG, "setData: "+position);
            vegTextView.setText("" + position);
        }
    }
}