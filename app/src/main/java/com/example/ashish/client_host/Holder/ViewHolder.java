package com.example.ashish.client_host.Holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
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
        ImageView imageView = view.findViewById(R.id.vegImg);

        textView.setText(name);
        Picasso.get().load(imgUrl).into(imageView);
    }
    }

