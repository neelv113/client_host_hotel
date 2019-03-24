package com.example.ashish.client_host;

import android.app.Application;

import com.example.ashish.client_host.util.SharedPreferences;

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        getInstance();
        SharedPreferences.getCartItems();
    }

    public static App getInstance() {
        return instance;
    }
}
