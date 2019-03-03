package com.example.ashish.client_host.util;

import android.content.SharedPreferences.Editor;

import com.example.ashish.client_host.App;
import com.example.ashish.client_host.Model.ItemDetails;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferences {
    private static final String FOOD_NAME = "food_name";

    private static final String MY_PREFS_NAME = "sharedPref";
    private static Editor editor = App.getInstance().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
    private static android.content.SharedPreferences preferences = App.getInstance().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
    private static Map<String, ItemDetails> mFoodDetails = new HashMap<>();

    public static void putFoodDetails(String foodName, Map<String, ItemDetails> foodDetails) {
        mFoodDetails = foodDetails;
        Gson gson = new Gson();
        String hashMapString = gson.toJson(foodDetails);
        editor.putString(foodName, hashMapString);
        editor.commit();
    }

    public static Map<String, ItemDetails> getFoodDetails() {
        return mFoodDetails;
    }
}
