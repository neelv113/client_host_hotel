package com.example.ashish.client_host.util;

import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.example.ashish.client_host.App;
import com.example.ashish.client_host.Model.ItemDetails;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
    private static Set<String> foodSet = new LinkedHashSet<>();
    private static Set<String> foodSetPrice = new LinkedHashSet<>();




    public static void putFoodDetails(String foodName, Map<String, ItemDetails> foodDetails) {
        mFoodDetails = foodDetails;
        Gson gson = new Gson();
        String hashMapString = gson.toJson(foodDetails);
        editor.putString(foodName, hashMapString);
        editor.commit();
    }

    public static void putFoodList(String foodName,int price) {
        foodSet.add(foodName);
        foodSetPrice.add(String.valueOf(price));
        editor.putStringSet("foodListName", foodSet);
        editor.putStringSet("foodListPrice", foodSetPrice);
        Log.d(TAG, "putFoodList: shared pred:"+foodName+"__"+price);
        editor.commit();
    }
    public static void clear()
    {
        editor.clear();
        editor.commit();
        //preferences.edit().remove("food").commit();
    }
    public static boolean isEmpty()
    {

        if(preferences.getAll().isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Set<String> getFoodListName() {
        return preferences.getStringSet("foodListName", null);
    }

    public static Set<String> getFoodListPrice() {
        return preferences.getStringSet("foodListPrice", null);
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

    public static void getCartItems() {
        Log.d(TAG, "getCartItems: get items:" + preferences.getString("cart_items", null));
    }
}
