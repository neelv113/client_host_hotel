package com.example.ashish.client_host.Holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ashish.pre_booked_hotel.R;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View view;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;
    }

    public void setDetails(Context context,String imgUrl,String name)
    {
        TextView textView = view.findViewById(R.id.txtView);
        ImageView imageView = view.findViewById(R.id.drinkImg);

        textView.setText(name);
        Picasso.get().load(imgUrl).into(imageView);
    }
    public void setVegFoodDetails(Context ctx,String foodUrl,String foodName)
    {
        TextView vegTextView = view.findViewById(R.id.vegTxt);
        ImageView vegImageView = view.findViewById(R.id.vegImg);

        vegTextView.setText(foodName);
        Picasso.get().load(foodUrl).into(vegImageView);
    }

    public void setNonVegFoodDetails(Context context,String nonVegUrl,String nonVegName)
    {
        TextView nonVegTextView = view.findViewById(R.id.nonVegTxt);
        ImageView nonVegImageView = view.findViewById(R.id.nonVegImg);

        nonVegTextView.setText(nonVegName);
        Picasso.get().load(nonVegUrl).into(nonVegImageView);
    }
//    public void setRating(Context context,float rating)
//    {
//        RatingBar ratingBar = view.findViewById(R.id.Rating);
//        ratingBar.setRating(rating);
//    }
//    public void setContact(Context context,String contact)
//    {
//        EditText editText = view.findViewById(R.id.contactNumber);
//        editText.setText(contact);
//    }
}