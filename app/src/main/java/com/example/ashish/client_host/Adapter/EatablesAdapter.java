package com.example.ashish.client_host.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.ashish.client_host.Model.ItemDetails;
import com.example.ashish.client_host.activity.AllEatablesActivity;
import com.example.ashish.client_host.util.SharedPreferences;
import com.example.ashish.pre_booked_hotel.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EatablesAdapter extends RecyclerView.Adapter<EatablesAdapter.ViewHolder> {

    AllEatablesActivity context;
    private static final String TAG = EatablesAdapter.class.getSimpleName();
    private AllEatablesActivity allEatablesActivity;
    private Map<String, List<ItemDetails>> foodMap;
    private String food;
    public List<ItemDetails> dataList = new ArrayList<>();
    private Button button;
    private HashMap<String, ItemDetails> foodDetails = new HashMap<>();
    private ItemDetails itemDetails;

    public EatablesAdapter(AllEatablesActivity context)
    {
        this.context=context;
    }

    public EatablesAdapter(AllEatablesActivity allEatablesActivity, Map<String, List<ItemDetails>> foodMap, List<ItemDetails> dataList) {
        this.allEatablesActivity = allEatablesActivity;
        this.foodMap = foodMap;
        this.food = food;
        this.dataList = dataList;
        Log.d(TAG, "EatablesAdapter: called1:"+dataList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_details, viewGroup, false);
        button = view.findViewById(R.id.buttonCount);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.txtView.setText(dataList.get(position).getFoodName());
        viewHolder.txtPrice.setText(dataList.get(position).getPrice() + "");
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                SharedPreferences.putFoodList(dataList.get(position).getFoodName(), dataList.get(position).getPrice());
                Toast.makeText(view.getContext(),"Item Added To Cart",Toast.LENGTH_SHORT).show();

                for (String key : SharedPreferences.getFoodDetails().keySet()) {
                    ItemDetails itemDetailss = SharedPreferences.getFoodDetails().get(key);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        Log.d(TAG, "EatablesAdapter: called2:"+dataList.size());
        if (dataList == null) {
            return 0;
        } else
            return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtView;
        public TextView txtPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.txtView);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}