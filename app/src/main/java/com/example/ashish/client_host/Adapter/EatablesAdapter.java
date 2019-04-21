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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EatablesAdapter extends RecyclerView.Adapter<EatablesAdapter.ViewHolder> {

    private static final String TAG = EatablesAdapter.class.getSimpleName();
    private AllEatablesActivity allEatablesActivity;
    private Map<String, List<ItemDetails>> foodMap;
    private String food;
    private List<ItemDetails> dataList = new ArrayList<>();
    private ElegantNumberButton button;
    private HashMap<String, ItemDetails> foodDetails = new HashMap<>();
    private ItemDetails itemDetails;

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
        // final int counter = 0;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.txtView.setText(dataList.get(position).getFoodName());
        viewHolder.txtPrice.setText(dataList.get(position).getPrice() + "");
        button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = button.getNumber();
                Log.d(TAG, "onClick: number"+number);
//   itemDetails = new ItemDetails();
//                itemDetails.setFoodName(dataList.get(position));
//                itemDetails.setItemCount(Integer.parseInt(number));
//                itemDetails.setPrice(0);
               // foodDetails.put(dataList.get(position).getFoodName(), dataList.get(position));
                // foodDetails.put(dataList.get(position).getPrice(), itemDetails);
                Log.d(TAG, "onClick: called ka list:"+"___"+dataList.get(position).getFoodName()+"__"+dataList.get(position)+"__"+foodDetails.size());
               // SharedPreferences.putFoodDetails(dataList.get(position).getFoodName(), foodDetails);

                Log.d(TAG, "onClick: check price:"+dataList.get(position).getFoodName()+"__"+dataList.get(position).getPrice());
                SharedPreferences.putFoodList(dataList.get(position).getFoodName(),dataList.get(position).getPrice());

                for (String key : SharedPreferences.getFoodDetails().keySet()) {
                    ItemDetails itemDetailss = SharedPreferences.getFoodDetails().get(key);
                }

            }
        });
        button.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Log.d(TAG, String.format("oldValue: %d   newValue: %d", oldValue, newValue));
                dataList.get(position).setItemCount(newValue);
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
        private TextView txtView;
        private TextView txtPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.txtView);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}
