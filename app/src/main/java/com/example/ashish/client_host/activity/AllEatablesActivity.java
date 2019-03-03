package com.example.ashish.client_host.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.ashish.client_host.Adapter.EatablesAdapter;
import com.example.ashish.pre_booked_hotel.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllEatablesActivity extends AppCompatActivity{

    private Map<String, List<String>> foodMap;

    //Veg

    private static final String KEY_BIRIYANI = "Biryani";
    private List<String> biriyaniList = new ArrayList<>();

    private static final String KEY_PASTA = "Pasta";
    private List<String> pastaList = new ArrayList<>();

    private static final String KEY_PIZZA = "Pizza";
    private List<String> pizzaList = new ArrayList<>();

    private static final String KEY_SANDWICH = "Sandwich";
    private List<String> sandwichList = new ArrayList<>();

    private static final String KEY_SOUPS = "Soups";
    private List<String> soupsList = new ArrayList<>();

    private static final String KEY_NOODLES = "Noodles";
    private List<String> noodlesList = new ArrayList<>();

    private static final String KEY_DOSA = "Dosa";
    private List<String> dosaList = new ArrayList<>();

    private static final String KEY_STARTERS = "Starters";
    private List<String> startersList = new ArrayList<>();

    private static final String KEY_BURGER = "Burger";
    private List<String> burgerList = new ArrayList<>();

    private static final String KEY_ROLLS = "Rolls";
    private List<String> rollsList = new ArrayList<>();


    //NonVeg

    private static final String KEY_CHICKEN = "Chicken";
    private List<String> chickenList = new ArrayList<>();

    private static final String KEY_OMLET = "Omlet";
    private List<String> omletList = new ArrayList<>();

    private static final String KEY_BEEF = "Beef Fry";
    private List<String> beefList = new ArrayList<>();

    private static final String KEY_FISH = "Fish";
    private List<String> fishList = new ArrayList<>();

    private static final String KEY_HOT_DOG = "Hot Dog";
    private List<String> hotDogList = new ArrayList<>();

    private static final String KEY_SQUID_FRY = "Squid Fry";
    private List<String> squidFryList = new ArrayList<>();

    private static final String KEY_CRAB = "Crab";
    private List<String> crabList = new ArrayList<>();

    private static final String KEY_EGGS = "Eggs";
    private List<String> eggsList = new ArrayList<>();

    private static final String KEY_MUTTON = "Mutton";
    private List<String> muttonList = new ArrayList<>();

    private static final String KEY_PRAWN = "Prawn";
    private List<String> prawnList = new ArrayList<>();


    private RecyclerView recyclerView;
    private EatablesAdapter eatablesAdapter;
    private Button buttonCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_eatables);
        Bundle bundle = getIntent().getExtras();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        buttonCart = findViewById(R.id.btnCart);


        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllEatablesActivity.this,Cart.class));

            }
        });


        foodMap = new HashMap<>();

        //BIRYANI ITEMS
        biriyaniList.add("Biriyani");
        biriyaniList.add("Vegetable Biriyani ");
        biriyaniList.add("Veg Hyderabadi Biriyani ");
        biriyaniList.add("Kofta Biriyani ");
        biriyaniList.add("Chana Biriyani ");
        foodMap.put(KEY_BIRIYANI, biriyaniList);


        //PASTA ITEMS
        pastaList.add("Vegetable Pasta");
        pastaList.add("Pasta Twists");
        pastaList.add("White Sauce Pasta");
        pastaList.add("Red Sauce Pasta");
        pastaList.add("Cheese Pasta");
        foodMap.put(KEY_PASTA, pastaList);


        //PIZZA ITEMS
        pizzaList.add("Veg Pizza");
        pizzaList.add("Veg Cheese Pizza");
        pizzaList.add("Only Cheese Pizza");
        pizzaList.add("Noodles Pizza");
        pizzaList.add("Mini Pizza");
        foodMap.put(KEY_PIZZA,pizzaList);


        //SANDWICH ITEM
        sandwichList.add("Veg Sandwich");
        sandwichList.add("Paneer Sandwich");
        sandwichList.add("Cheese Sandwich");
        sandwichList.add("Grilled Sandwich");
        sandwichList.add("Mushroom Sandwich");
        foodMap.put(KEY_SANDWICH,sandwichList);


        //SOUPS ITEM
        soupsList.add("Manchow Soup");
        soupsList.add("Tomato Soup");
        soupsList.add("Broccoli Soup");
        soupsList.add("Carrot Soup");
        soupsList.add("Cauliflower Soup");
        foodMap.put(KEY_SOUPS,soupsList);


        //NOODLES ITEM
        noodlesList.add("Veg Hakka Noodles");
        noodlesList.add("Gravy Noodles");
        noodlesList.add("Chili Garlic Noodles");
        noodlesList.add("Pan Fried Noodles");
        noodlesList.add("Raw Rainbow Noodles");
        foodMap.put(KEY_NOODLES,noodlesList);


        //DOSA ITEM
        dosaList.add("Plain Dosa");
        dosaList.add("Masala Dosa");
        dosaList.add("Mysore Masala Dosa");
        dosaList.add("Paper Dosa");
        dosaList.add("Onion Dosa");
        foodMap.put(KEY_DOSA,dosaList);


        //STARTERS ITEM
        startersList.add("Chilli Paneer Dry");
        startersList.add("Cream Cheese Rolls");
        startersList.add("Onion Rings");
        startersList.add("Dragon Potatoes");
        startersList.add("Dry Manchurian");
        foodMap.put(KEY_STARTERS,startersList);


        //BURGER ITEMS
        burgerList.add("Veg Burger");
        burgerList.add("Mexican Burger");
        burgerList.add("Lebanise Burger");
        burgerList.add("Paneer Grill Burger");
        burgerList.add("Cheese burger");
        foodMap.put(KEY_BURGER,burgerList);


        //ROLLS ITEMS
        rollsList.add("Veg Roll");
        rollsList.add("Paneer Tikka Kathi Roll");
        rollsList.add("Paneer and Salsa");
        rollsList.add("Hummus and Avacado");
        rollsList.add("Quesadila");
        foodMap.put(KEY_ROLLS,rollsList);


        //CHICKEN ITEMS
        chickenList.add("Chicken Lollipop");
        chickenList.add("Chicken Akbari");
        chickenList.add("Chicken Rarajosh");
        chickenList.add("Chicken Malvani");
        chickenList.add("Chicken Do Pyaza");
        foodMap.put(KEY_CHICKEN,chickenList);


        //OMLET ITEMS
        omletList.add("Cheese Omlet");
        omletList.add("Jalapeno Omlet");
        omletList.add("Denver Omlet");
        omletList.add("German Omlet");
        omletList.add("Chili Cheese Omlet");
        foodMap.put(KEY_OMLET,omletList);


        //BEEF IEMS
        beefList.add("Chuck");
        beefList.add("Rib");
        beefList.add("Loin");
        beefList.add("Round");
        beefList.add("Brisket");
        foodMap.put(KEY_BEEF,beefList);


        //FISH ITEMS
        fishList.add("Fish Curry");
        fishList.add("Fish Cutlet");
        fishList.add("Fried Fish");
        fishList.add("Fish Finger");
        fishList.add("Steamed Fish");
        foodMap.put(KEY_FISH,fishList);


        //HOT DOG
        hotDogList.add("Chicago Dog");
        hotDogList.add("Junkyard Dog");
        hotDogList.add("Blazin' Dog");
        hotDogList.add("All-American Dog");
        hotDogList.add("Pastrami Dog");
        foodMap.put(KEY_HOT_DOG,hotDogList);


        //SQUID FRY
        squidFryList.add("Stuffed Squid");
        squidFryList.add("Crispy Squid");
        squidFryList.add("Tuscan Seafood Stew");
        squidFryList.add("Cioppino");
        squidFryList.add("Fritto Misto");
        foodMap.put(KEY_SQUID_FRY,squidFryList);


        //CRAB ITEMS
        crabList.add("Crab Cake");
        crabList.add("Soft-Shell Crab");
        crabList.add("Crab Dip");
        crabList.add("Deviled Crab");
        crabList.add("Chilli Crab");
        foodMap.put(KEY_CRAB,crabList);


        //EGGS ITEM
        eggsList.add("Soft Boiled Egg");
        eggsList.add("Scrambled Egg");
        eggsList.add("Fried Egg");
        eggsList.add("Poached Eggs");
        eggsList.add("Shirred Eggs");
        foodMap.put(KEY_EGGS,eggsList);


        //MUTTON ITEMS
        muttonList.add("Mutton Kuzhambu");
        muttonList.add("Mutton Korma");
        muttonList.add("Nalli Nihari");
        muttonList.add("Kosha Mangsho");
        muttonList.add("Pasanda");
        foodMap.put(KEY_MUTTON,muttonList);


        //PRAWN ITEMS
        prawnList.add("Kerala Fried Prawns");
        prawnList.add("Prawn Curry");
        prawnList.add("Malai Prawn Curry");
        prawnList.add("Prawn Pulao");
        prawnList.add("Spicy Prawns");
        foodMap.put(KEY_PRAWN,prawnList);


        if (eatablesAdapter == null) {
            eatablesAdapter = new EatablesAdapter(this,foodMap,bundle.getString("food"));
            recyclerView.setAdapter(eatablesAdapter);
        }
    }
}