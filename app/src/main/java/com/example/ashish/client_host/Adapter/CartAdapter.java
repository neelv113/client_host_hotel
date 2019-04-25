package com.example.ashish.client_host.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ashish.client_host.Model.ItemDetails;
import com.example.ashish.client_host.activity.Cart;
import com.example.ashish.client_host.util.SharedPreferences;
import com.example.ashish.pre_booked_hotel.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private static final String TAG = CartAdapter.class.getSimpleName();
    private Cart context;
    private List<String> keyList = new ArrayList<>(SharedPreferences.getFoodDetails().keySet());
    private List<ItemDetails> itemDetails = new ArrayList<>(SharedPreferences.getFoodDetails().values());
    private Set dataSet = SharedPreferences.getFoodListName();
    private Set dataSetPrice = SharedPreferences.getFoodListPrice();
    private Object[] dataList, dataPirceList;
    private List<String> list=new ArrayList<String>();


    public CartAdapter(Cart context) {
        this.context = context;
        dataList = dataSet.toArray();
        dataPirceList = dataSetPrice.toArray();
        list.addAll(SharedPreferences.getFoodListName());
        Log.d(TAG, "CartAdapter: called ak:check size:"+dataList.length+"__"+dataPirceList.length);
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_view, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtView.setText("Food Name : "+dataList[i] + "");
        viewHolder.txtPrice.setText("Price : "+dataPirceList[i] + "");
    }

    @Override
    public int getItemCount() {
        if(SharedPreferences.getFoodListName()==null)
        {
            return 0;
        }
        else
        return SharedPreferences.getFoodListName().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtView;
        private TextView txtPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.txtView);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }

        public void setData(int position) {
            txtView.setText("" + position);
        }
    }
}
