package com.example.ashish.client_host.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ashish.pre_booked_hotel.R;

public class Splash_Activity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_Activity.this,FoodMenuActivity.class));
                finish();
            }
        },2000);
    }
}
