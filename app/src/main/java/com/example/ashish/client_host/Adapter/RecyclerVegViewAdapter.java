package com.example.ashish.client_host.Adapter;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ashish.client_host.activity.GridRecyclerActivity;
import com.example.ashish.client_host.fragment.TabVegFragment;
import com.example.ashish.client_host.util.FragmentUtil;
import com.example.ashish.pre_booked_hotel.R;

public class RecyclerVegViewAdapter extends RecyclerView.Adapter<RecyclerVegViewAdapter.ViewHolder> {


    private static final String TAG = RecyclerVegViewAdapter.class.getSimpleName();
    private TabVegFragment context;

    public RecyclerVegViewAdapter(TabVegFragment context){
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.veg_view, parent, false);
        return new ViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.setData(position);
        holder.txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(FragmentUtil.getActivity(context),GridRecyclerActivity.class));
                //Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtView;
        private ImageView vegImg;

//        public void setDetails(Context context,String imgUrl,String name)
//        {
//            txtView = itemView.findViewById(R.id.txtView);
//            vegImg = itemView.findViewById(R.id.vegImg);
//
//            txtView.setText(name);
//            Picasso.get().load(imgUrl).into(vegImg);
//        }

        public ViewHolder(View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.txtView);
            vegImg = itemView.findViewById(R.id.vegImg);
        }

        public void setData(int position) {
            Log.d(TAG, "setData: "+position);
            txtView.setText("" + position);
        }
    }
}