package com.example.ashish.client_host.Holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.ashish.pre_booked_hotel.R;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = ViewHolder.class.getSimpleName();

    View view;
    private CardView viewLayout;
    private LinearLayout viewVegLayout;
    private LinearLayout viewNonVegLayout;
    private String foodName;
    private String nonVegFoodName;
    public Button drinkBtn;

    public TextView textView;
    public TextView textPriceView;

    public String getNonVegFoodName() {
        return nonVegFoodName;
    }

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;

        viewVegLayout = itemView.findViewById(R.id.viewVegLayout);
        viewLayout=itemView.findViewById(R.id.viewLayout);
        viewNonVegLayout = itemView.findViewById(R.id.viewNonVegLayout);

        drinkBtn = itemView.findViewById(R.id.drinkButtonCount);

        Log.d(TAG, "ViewHolder: called _"+view);
    }

    public void setDetails(Context context,String imgUrl,String name,String price)
    {

        textView = view.findViewById(R.id.txtView);
        textPriceView = view.findViewById(R.id.drinkPriceView);
        ImageView imageView = view.findViewById(R.id.drinkImg);

        textView.setText(name);
        textPriceView.setText(price);
        Picasso.get().load(imgUrl).into(imageView);
    }
    public void setVegFoodDetails(Context ctx,String foodUrl,String foodName)
    {
        TextView vegTextView = view.findViewById(R.id.vegTxt);
        ImageView vegImageView = view.findViewById(R.id.vegImg);

        vegTextView.setText(foodName);
        this.foodName = foodName;
        Picasso.get().load(foodUrl).into(vegImageView);
    }

    public void setNonVegFoodDetails(Context context,String nonVegUrl,String nonVegName)
    {
        TextView nonVegTextView = view.findViewById(R.id.nonVegTxt);
        ImageView nonVegImageView = view.findViewById(R.id.nonVegImg);
        this.nonVegFoodName = nonVegName;
        nonVegTextView.setText(nonVegName);
        Picasso.get().load(nonVegUrl).into(nonVegImageView);
    }

    public CardView getViewLayout() {
        return viewLayout;
    }

    public LinearLayout getViewVegLayout() {
        return viewVegLayout;
    }

    public void setViewVegLayout(LinearLayout viewVegLayout) {
        this.viewVegLayout = viewVegLayout;
    }

    public LinearLayout getViewNonVegLayout() {
        return viewNonVegLayout;
    }

    public void setViewNonVegLayout(LinearLayout viewNonVegLayout) {
        this.viewNonVegLayout = viewNonVegLayout;
    }

    public void setViewLayout(CardView viewLayout) {
        this.viewLayout = viewLayout;
    }

    public String getFoodName() {
        return foodName;
    }
}