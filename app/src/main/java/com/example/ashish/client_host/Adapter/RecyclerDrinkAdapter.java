package com.example.ashish.client_host.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashish.client_host.activity.AllEatablesActivity;
import com.example.ashish.client_host.activity.DrinkOrderActivity;
import com.example.ashish.client_host.activity.GridRecyclerActivity;
import com.example.ashish.client_host.util.FragmentUtil;
import com.example.ashish.pre_booked_hotel.R;

public class RecyclerDrinkAdapter extends RecyclerView.Adapter<RecyclerDrinkAdapter.ViewHolder> {
    private static final String TAG = RecyclerDrinkAdapter.class.getSimpleName();
    private DrinkOrderActivity context;

    public RecyclerDrinkAdapter(DrinkOrderActivity context)
    {
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: rda called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int  position) {
        //holder.setData(position);
        holder.txtView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            context.startActivity(new Intent(context,GridRecyclerActivity.class));
            Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show();
            }
        });

        holder.viewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,AllEatablesActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtPriceView;
        private TextView txtView;
        private CardView viewLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            txtPriceView = itemView.findViewById(R.id.drinkPriceView);
            txtView = itemView.findViewById(R.id.txtView);
            viewLayout=itemView.findViewById(R.id.viewLayout);
        }

        public void setData(int position) {
            Log.d(TAG, "setData: "+position);
            txtView.setText("" + position);
            txtPriceView.setText("" + position);
        }
    }
}