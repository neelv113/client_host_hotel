package com.example.ashish.client_host.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish.client_host.fragment.TabNonVegFragment;
import com.example.ashish.client_host.util.FragmentUtil;
import com.example.ashish.pre_booked_hotel.R;

import static android.content.ContentValues.TAG;

public class RecyclerNonVegAdapter extends RecyclerView.Adapter<RecyclerNonVegAdapter.ViewHolder> {
    private TabNonVegFragment context;
    public RecyclerNonVegAdapter(TabNonVegFragment context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nonveg_view, parent, false);
        return new ViewHolder(view);
    }
    public void onBindViewHolder(@Nullable ViewHolder holder,final int position)
    {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nonVegTextView;
        Layout layout;
        private ImageView imgView;
        public ViewHolder(View itemView) {
            super(itemView);
            nonVegTextView = itemView.findViewById(R.id.nonVegTxt);
            imgView = itemView.findViewById(R.id.nonVegImg);
        }

        public void setData(int position) {
            Log.d(TAG,"setData:" +position);
            nonVegTextView.setText("" + position);
        }
    }
}