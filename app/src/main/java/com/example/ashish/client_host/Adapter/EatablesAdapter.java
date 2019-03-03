package com.example.ashish.client_host.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.ashish.client_host.Model.ItemDetails;
import com.example.ashish.client_host.activity.AllEatablesActivity;
import com.example.ashish.client_host.util.SharedPreferences;
import com.example.ashish.pre_booked_hotel.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EatablesAdapter extends RecyclerView.Adapter<EatablesAdapter.ViewHolder> {

    private static final String TAG = EatablesAdapter.class.getSimpleName();
    private AllEatablesActivity allEatablesActivity;
    private Map<String, List<String>> foodMap;
    private String food;
    private List<String> dataList;
    private ElegantNumberButton button;
    private HashMap<String, ItemDetails> foodDetails = new HashMap<>();
    private ItemDetails itemDetails;

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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.txtView.setText(dataList.get(position));
        button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = button.getNumber();
                itemDetails = new ItemDetails();
                itemDetails.setFoodName(dataList.get(position));
                itemDetails.setItemCount(Integer.parseInt(number));
                itemDetails.setPrice(0);
                foodDetails.put(dataList.get(position), itemDetails);
                SharedPreferences.putFoodDetails(dataList.get(position), foodDetails);
                Log.d(TAG, "onClick: called_"+SharedPreferences.getFoodDetails().keySet());
                for (String key : SharedPreferences.getFoodDetails().keySet()) {
                    ItemDetails itemDetailss = SharedPreferences.getFoodDetails().get(key);
                }

            }
        });
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
