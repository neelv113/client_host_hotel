package com.example.ashish.client_host.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ashish.pre_booked_hotel.R;

public class Splash_Activity extends AppCompatActivity {
    private static final String TAG =Splash_Activity.class.getSimpleName() ;
    private Activity context;

    String fixssid="\"android\"";



    protected void onCreate(@Nullable Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_splash);
        String ssid=getCurrentSsid(this);
        Log.d(TAG, "Ssid "+ssid);

        Log.d(TAG, "onCreate_a: "+ssid+"__"+fixssid);
        if(fixssid.contains(ssid)) {
            new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(Splash_Activity.this,FoodMenuActivity.class));
               finish();
           }
        },2000);
        }
    }

    public String getCurrentSsid(Context context) {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
        String ssid = null;
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo.isConnected()) {
            final WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            ssid = connectionInfo.getSSID();
            Log.d(TAG, "getCurrentSsid "+ssid);
        }
        return ssid;
    }
}
