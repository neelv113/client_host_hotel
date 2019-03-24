package com.example.ashish.client_host.util;

import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.example.ashish.client_host.App;
import com.example.ashish.client_host.Model.ItemDetails;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;
import static android.support.constraint.Constraints.TAG;

public class SharedPreferences {
    private static final String FOOD_NAME = "food_name";
    private static Set<ItemDetails> allFoodss;

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

    public static void putFoodDetailsList(ItemDetails itemDetails) {
//        allFoodss = allFoods;
//        Set<String> set = new HashSet<String>();
//        allFoodss.addAll(listOfExistingScores);
        Gson gson = new Gson();
        String json = gson.toJson(itemDetails);
        editor.putString("cart_items", json);
        editor.commit();
    }

    public static void getCartItems(){
        Log.d(TAG, "getCartItems: get items:"+preferences.getString("cart_items",null));
    }
}
