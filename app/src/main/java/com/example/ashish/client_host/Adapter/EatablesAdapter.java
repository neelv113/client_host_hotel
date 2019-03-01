package com.example.ashish.client_host.Adapter;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.ashish.client_host.activity.AllEatablesActivity;
import com.example.ashish.pre_booked_hotel.R;

import java.util.List;
import java.util.Map;

import static java.security.AccessController.getContext;

public class EatablesAdapter extends RecyclerView.Adapter<EatablesAdapter.ViewHolder> {

    private AllEatablesActivity allEatablesActivity;
    private Map<String, List<String>> foodMap;
    private String food;
    private List<String> dataList;
    private ElegantNumberButton button;

    public EatablesAdapter(AllEatablesActivity allEatablesActivity, Map<String, List<String>> foodMap, String food) {
        this.allEatablesActivity = allEatablesActivity;
        this.foodMap = foodMap;
        this.food = food;
        dataList = foodMap.get(food);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_details, viewGroup, false);
        button = view.findViewById(R.id.buttonCount);
        final int counter = 0;

        button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = button.getNumber();


            }
        });

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.txtView.setText(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        if (dataList == null) {
            return 0;
        } else
            return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.txtView);
        }
    }
}
