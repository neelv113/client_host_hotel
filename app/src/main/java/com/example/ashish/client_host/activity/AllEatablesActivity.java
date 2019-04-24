package com.example.ashish.client_host.activity;

import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ashish.client_host.Adapter.EatablesAdapter;
import com.example.ashish.client_host.Model.ItemDetails;
import com.example.ashish.pre_booked_hotel.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllEatablesActivity extends AppCompatActivity {

    private static final String TAG = AllEatablesActivity.class.getSimpleName();
    private Map<String, List<ItemDetails>> foodMap;

    //Veg

    private List<ItemDetails> biriyaniList = new ArrayList<>();

    private List<ItemDetails> pastaList = new ArrayList<>();

    private List<ItemDetails> pizzaList = new ArrayList<>();

    private List<ItemDetails> sandwichList = new ArrayList<>();

    private List<ItemDetails> soupsList = new ArrayList<>();

    private List<ItemDetails> noodlesList = new ArrayList<>();

    private List<ItemDetails> dosaList = new ArrayList<>();

    private List<ItemDetails> startersList = new ArrayList<>();

    private List<ItemDetails> burgerList = new ArrayList<>();

    private List<ItemDetails> rollsList = new ArrayList<>();

    //NonVeg

    private List<ItemDetails> chickenList = new ArrayList<>();

    private List<ItemDetails> omletList = new ArrayList<>();

    private List<ItemDetails> beefList = new ArrayList<>();

    private List<ItemDetails> fishList = new ArrayList<>();

    private List<ItemDetails> hotDogList = new ArrayList<>();

    private List<ItemDetails> squidFryList = new ArrayList<>();

    private List<ItemDetails> crabList = new ArrayList<>();

    private List<ItemDetails> eggsList = new ArrayList<>();

    private List<ItemDetails> muttonList = new ArrayList<>();

    private List<ItemDetails> prawnList = new ArrayList<>();


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
                if(com.example.ashish.client_host.util.SharedPreferences.isEmpty())
                {
                    Toast.makeText(AllEatablesActivity.this,"Select any food",Toast.LENGTH_LONG).show();
                }
                else
                {
                    startActivity(new Intent(AllEatablesActivity.this, Cart.class));
                }
            }
        });


        foodMap = new HashMap<>();

        //BIRYANI ITEMS
        ItemDetails biriItemDetails = new ItemDetails();
        biriItemDetails.setFoodName("Biriyani");
        biriItemDetails.setPrice(60);
        biriItemDetails.setItemCount(0);
        biriyaniList.add(biriItemDetails);


        ItemDetails biriItemDetails1 = new ItemDetails();
        biriItemDetails1.setFoodName("Vegetable Biriyani");
        biriItemDetails1.setPrice(70);
        biriItemDetails1.setItemCount(0);
        biriyaniList.add(biriItemDetails1);


        ItemDetails biriItemDetails2 = new ItemDetails();
        biriItemDetails2.setFoodName("Veg Hyderabadi Biriyani");
        biriItemDetails2.setPrice(90);
        biriItemDetails2.setItemCount(0);
        biriyaniList.add(biriItemDetails2);

        ItemDetails biriItemDetails3 = new ItemDetails();
        biriItemDetails3.setFoodName("Kofta Biriyani");
        biriItemDetails3.setPrice(100);
        biriItemDetails3.setItemCount(0);
        biriyaniList.add(biriItemDetails3);

        ItemDetails biriItemDetails4 = new ItemDetails();
        biriItemDetails4.setFoodName("Chana Biriyani");
        biriItemDetails4.setPrice(80);
        biriItemDetails4.setItemCount(0);
        biriyaniList.add(biriItemDetails4);

        foodMap.put("Biryani", biriyaniList);
        biriyaniList = new ArrayList<>();

        //PASTA ITEMS

        ItemDetails pastaItemDetails = new ItemDetails();
        pastaItemDetails.setFoodName("Vegetable Pasta");
        pastaItemDetails.setPrice(65);
        pastaItemDetails.setItemCount(0);
        pastaList.add(pastaItemDetails);

        ItemDetails pastaItemDetails1 = new ItemDetails();
        pastaItemDetails1.setFoodName("Pasta Twists");
        pastaItemDetails1.setPrice(75);
        pastaItemDetails1.setItemCount(0);
        pastaList.add(pastaItemDetails1);

        ItemDetails pastaItemDetail2 = new ItemDetails();
        pastaItemDetail2.setFoodName("White Sauce Pasta");
        pastaItemDetail2.setPrice(95);
        pastaItemDetail2.setItemCount(0);
        pastaList.add(pastaItemDetail2);

        ItemDetails pastaItemDetail3 = new ItemDetails();
        pastaItemDetail3.setFoodName("Red sauce Pasta");
        pastaItemDetail3.setPrice(110);
        pastaItemDetail3.setItemCount(0);
        pastaList.add(pastaItemDetail3);

        ItemDetails pastaItemDetail4 = new ItemDetails();
        pastaItemDetail4.setFoodName("Cheese Pasta");
        pastaItemDetail4.setPrice(85);
        pastaItemDetail4.setItemCount(0);
        pastaList.add(pastaItemDetail4);

        foodMap.put("Pasta", pastaList);

        //Pizza

        ItemDetails pizzaItemDetails = new ItemDetails();
        pizzaItemDetails.setFoodName("Veg Pizza");
        pizzaItemDetails.setPrice(120);
        pizzaItemDetails.setItemCount(0);
        pizzaList.add(pizzaItemDetails);



        ItemDetails pizzaItemDetails1 = new ItemDetails();
        pizzaItemDetails1.setFoodName("Veg Cheese Pizza");
        pizzaItemDetails1.setPrice(130);
        pizzaItemDetails1.setItemCount(0);
        pizzaList.add(pizzaItemDetails1);


        ItemDetails pizzaItemDetails2 = new ItemDetails();
        pizzaItemDetails2.setFoodName("Only Cheese Pizza");
        pizzaItemDetails2.setPrice(115);
        pizzaItemDetails2.setItemCount(0);
        pizzaList.add(pizzaItemDetails2);


        ItemDetails pizzaItemDetails3 = new ItemDetails();
        pizzaItemDetails3.setFoodName("Noodles pizza");
        pizzaItemDetails3.setPrice(140);
        pizzaItemDetails3.setItemCount(0);
        pizzaList.add(pizzaItemDetails3);


        ItemDetails pizzaItemDetails4 = new ItemDetails();
        pizzaItemDetails4.setFoodName("Mini Pizza");
        pizzaItemDetails4.setPrice(98);
        pizzaItemDetails4.setItemCount(0);
        pizzaList.add(pizzaItemDetails4);

        foodMap.put("Pizza",pizzaList);

        //SANDWICH ITEM
        ItemDetails sandwichItemDetails = new ItemDetails();
        sandwichItemDetails.setFoodName("Veg sandwich");
        sandwichItemDetails.setPrice(40);
        sandwichItemDetails.setItemCount(0);
        sandwichList.add(sandwichItemDetails);


        ItemDetails sandwichItemDetails1 = new ItemDetails();
        sandwichItemDetails1.setFoodName("Paneer sandwich");
        sandwichItemDetails1.setPrice(68);
        sandwichItemDetails1.setItemCount(0);
        sandwichList.add(sandwichItemDetails1);

        ItemDetails sandwichItemDetails2 = new ItemDetails();
        sandwichItemDetails2.setFoodName("Cheese sandwich");
        sandwichItemDetails2.setPrice(55);
        sandwichItemDetails2.setItemCount(0);
        sandwichList.add(sandwichItemDetails2);


        ItemDetails sandwichItemDetails3 = new ItemDetails();
        sandwichItemDetails3.setFoodName("Grilled sandwich");
        sandwichItemDetails3.setPrice(72);
        sandwichItemDetails3.setItemCount(0);
        sandwichList.add(sandwichItemDetails3);


        ItemDetails sandwichItemDetails4 = new ItemDetails();
        sandwichItemDetails4.setFoodName("Mushroom sandwich");
        sandwichItemDetails4.setPrice(88);
        sandwichItemDetails4.setItemCount(0);
        sandwichList.add(sandwichItemDetails4);

        foodMap.put("Sandwich", sandwichList);


        //SOUPS ITEM
        ItemDetails soupsItemDetails = new ItemDetails();
        soupsItemDetails.setFoodName("Manchaw Soup");
        soupsItemDetails.setPrice(58);
        soupsItemDetails.setItemCount(0);
        soupsList.add(soupsItemDetails);


        ItemDetails soupsItemDetails1 = new ItemDetails();
        soupsItemDetails1.setFoodName("Tomato Soup");
        soupsItemDetails1.setPrice(76);
        soupsItemDetails1.setItemCount(0);
        soupsList.add(soupsItemDetails1);


        ItemDetails soupsItemDetails2 = new ItemDetails();
        soupsItemDetails2.setFoodName("Broccoli Soup");
        soupsItemDetails2.setPrice(96);
        soupsItemDetails2.setItemCount(0);
        soupsList.add(soupsItemDetails2);


        ItemDetails soupsItemDetails3 = new ItemDetails();
        soupsItemDetails3.setFoodName("Carrot Soup");
        soupsItemDetails3.setPrice(104);
        soupsItemDetails3.setItemCount(0);
        soupsList.add(soupsItemDetails3);


        ItemDetails soupsItemDetails4 = new ItemDetails();
        soupsItemDetails4.setFoodName("Cauliflower Soup");
        soupsItemDetails4.setPrice(125);
        soupsItemDetails4.setItemCount(0);
        soupsList.add(soupsItemDetails4);

        foodMap.put("Soups",soupsList);

       //NOODLES ITEM

        ItemDetails noodlesItemDetails = new ItemDetails();
        noodlesItemDetails.setFoodName("Gravy Noodles");
        noodlesItemDetails.setPrice(108);
        noodlesItemDetails.setItemCount(0);
        noodlesList.add(noodlesItemDetails);

        ItemDetails noodlesItemDetails1 = new ItemDetails();
        noodlesItemDetails1.setFoodName("Chilli Garlic Noodles");
        noodlesItemDetails1.setPrice(150);
        noodlesItemDetails1.setItemCount(0);
        noodlesList.add(noodlesItemDetails1);

        ItemDetails noodlesItemDetails2 = new ItemDetails();
        noodlesItemDetails2.setFoodName("Veg Hakka Noodles");
        noodlesItemDetails2.setPrice(118);
        noodlesItemDetails2.setItemCount(0);
        noodlesList.add(noodlesItemDetails2);

        ItemDetails noodlesItemDetails3 = new ItemDetails();
        noodlesItemDetails3.setFoodName("Pan Fried Noodles");
        noodlesItemDetails3.setPrice(94);
        noodlesItemDetails3.setItemCount(0);
        noodlesList.add(noodlesItemDetails3);

        ItemDetails noodlesItemDetails4 = new ItemDetails();
        noodlesItemDetails4.setFoodName("Raw Rainbow Noodles");
        noodlesItemDetails4.setPrice(160);
        noodlesItemDetails4.setItemCount(0);
        noodlesList.add(noodlesItemDetails4);

        foodMap.put("Noodles",noodlesList);


        //DOSA ITEM
        ItemDetails dosaItemDetails = new ItemDetails();
        dosaItemDetails.setFoodName("Plain Dosa");
        dosaItemDetails.setPrice(86);
        dosaItemDetails.setItemCount(0);
        dosaList.add(dosaItemDetails);

        ItemDetails dosaItemDetails1 = new ItemDetails();
        dosaItemDetails1.setFoodName("Masala Dosa");
        dosaItemDetails1.setPrice(45);
        dosaItemDetails1.setItemCount(0);
        dosaList.add(dosaItemDetails1);

        ItemDetails dosaItemDetails2 = new ItemDetails();
        dosaItemDetails2.setFoodName("Mysore Masala Dosa");
        dosaItemDetails2.setPrice(59);
        dosaItemDetails2.setItemCount(0);
        dosaList.add(dosaItemDetails2);

        ItemDetails dosaItemDetails3 = new ItemDetails();
        dosaItemDetails3.setFoodName("Paper Dosa");
        dosaItemDetails3.setPrice(69);
        dosaItemDetails3.setItemCount(0);
        dosaList.add(dosaItemDetails3);

        ItemDetails dosaItemDetails4 = new ItemDetails();
        dosaItemDetails4.setFoodName("Onion Dosa");
        dosaItemDetails4.setPrice(49);
        dosaItemDetails4.setItemCount(0);
        dosaList.add(dosaItemDetails4);


        foodMap.put("Dosa",dosaList);

        //STARTERS ITEM

        ItemDetails staterItemDetails = new ItemDetails();
        staterItemDetails.setFoodName("Chilli Paneer Dry");
        staterItemDetails.setPrice(155);
        staterItemDetails.setItemCount(0);
        startersList.add(staterItemDetails);

        ItemDetails staterItemDetails1 = new ItemDetails();
        staterItemDetails1.setFoodName("Cream Cheese Rolls");
        staterItemDetails1.setPrice(165);
        staterItemDetails1.setItemCount(0);
        startersList.add(staterItemDetails1);

        ItemDetails staterItemDetails2 = new ItemDetails();
        staterItemDetails2.setFoodName("Onion Rings");
        staterItemDetails2.setPrice(101);
        staterItemDetails2.setItemCount(0);
        startersList.add(staterItemDetails2);

        ItemDetails staterItemDetails3 = new ItemDetails();
        staterItemDetails3.setFoodName("Dragon Potatoes");
        staterItemDetails3.setPrice(92);
        staterItemDetails3.setItemCount(0);
        startersList.add(staterItemDetails3);

        ItemDetails staterItemDetails4 = new ItemDetails();
        staterItemDetails4.setFoodName("Dry Manchurian");
        staterItemDetails4.setPrice(82);
        staterItemDetails4.setItemCount(0);
        startersList.add(staterItemDetails4);

        foodMap.put("Starters",startersList);

        //BURGER ITEMS

        ItemDetails burgerItemDetails = new ItemDetails();
        burgerItemDetails.setFoodName("Veg Burger");
        burgerItemDetails.setPrice(81);
        burgerItemDetails.setItemCount(0);
        burgerList.add(burgerItemDetails);

        ItemDetails burgerItemDetails1 = new ItemDetails();
        burgerItemDetails1.setFoodName("Mexican Burger");
        burgerItemDetails1.setPrice(122);
        burgerItemDetails1.setItemCount(0);
        burgerList.add(burgerItemDetails1);

        ItemDetails burgerItemDetails2 = new ItemDetails();
        burgerItemDetails2.setFoodName("Lebanise Burger");
        burgerItemDetails2.setPrice(152);
        burgerItemDetails2.setItemCount(0);
        burgerList.add(burgerItemDetails2);

        ItemDetails burgerItemDetails3 = new ItemDetails();
        burgerItemDetails3.setFoodName("Paneer Grill Burger");
        burgerItemDetails3.setPrice(168);
        burgerItemDetails3.setItemCount(0);
        burgerList.add(burgerItemDetails3);

        ItemDetails burgerItemDetails4 = new ItemDetails();
        burgerItemDetails4.setFoodName("Cheese Burger");
        burgerItemDetails4.setPrice(158);
        burgerItemDetails4.setItemCount(0);
        burgerList.add(burgerItemDetails4);
        foodMap.put("Burger",burgerList);

        //ROLLS ITEMS
        ItemDetails rollsItemDetails = new ItemDetails();
        rollsItemDetails.setFoodName("Veg Roll");
        rollsItemDetails.setPrice(91);
        rollsItemDetails.setItemCount(0);
        rollsList.add(rollsItemDetails);

        ItemDetails rollsItemDetails1 = new ItemDetails();
        rollsItemDetails1.setFoodName("Paneer Tikka Kathi Roll");
        rollsItemDetails1.setPrice(124);
        rollsItemDetails1.setItemCount(0);
        rollsList.add(rollsItemDetails1);

        ItemDetails rollsItemDetails2 = new ItemDetails();
        rollsItemDetails2.setFoodName("Paneer and Salsa");
        rollsItemDetails2.setPrice(154);
        rollsItemDetails2.setItemCount(0);
        rollsList.add(rollsItemDetails2);

        ItemDetails rollsItemDetails3 = new ItemDetails();
        rollsItemDetails3.setFoodName("Hummus and Avacado");
        rollsItemDetails3.setPrice(170);
        rollsItemDetails3.setItemCount(0);
        rollsList.add(rollsItemDetails3);

        ItemDetails rollsItemDetails4 = new ItemDetails();
        rollsItemDetails4.setFoodName("Quesadila");
        rollsItemDetails4.setPrice(180);
        rollsItemDetails4.setItemCount(0);
        rollsList.add(rollsItemDetails4);
        foodMap.put("Rolls",rollsList);

        //CHICKEN ITEMS

        ItemDetails chickenItemDetails = new ItemDetails();
        chickenItemDetails.setFoodName("Chicken Lolipop");
        chickenItemDetails.setPrice(190);
        chickenItemDetails.setItemCount(0);
        chickenList.add(chickenItemDetails);

        ItemDetails chickenItemDetails1 = new ItemDetails();
        chickenItemDetails1.setFoodName("Chicken Akbari");
        chickenItemDetails1.setPrice(200);
        chickenItemDetails1.setItemCount(0);
        chickenList.add(chickenItemDetails1);

        ItemDetails chickenItemDetails2 = new ItemDetails();
        chickenItemDetails2.setFoodName("Chicken Rarajosh");
        chickenItemDetails2.setPrice(185);
        chickenItemDetails2.setItemCount(0);
        chickenList.add(chickenItemDetails2);

        ItemDetails chickenItemDetails3 = new ItemDetails();
        chickenItemDetails3.setFoodName("Chicken Malvani");
        chickenItemDetails3.setPrice(250);
        chickenItemDetails3.setItemCount(0);
        chickenList.add(chickenItemDetails3);

        ItemDetails chickenItemDetails4 = new ItemDetails();
        chickenItemDetails4.setFoodName("Chicken Do Pyaza");
        chickenItemDetails4.setPrice(210);
        chickenItemDetails4.setItemCount(0);
        chickenList.add(chickenItemDetails4);

        foodMap.put("Chicken",chickenList);

       //OMLET ITEMS

        ItemDetails omletItemDetails = new ItemDetails();
        omletItemDetails.setFoodName("Cheese Omlet");
        omletItemDetails.setPrice(57);
        omletItemDetails.setItemCount(0);
        omletList.add(omletItemDetails);

        ItemDetails omletItemDetails1 = new ItemDetails();
        omletItemDetails1.setFoodName("Jalapeno Omlet");
        omletItemDetails1.setPrice(103);
        omletItemDetails1.setItemCount(0);
        omletList.add(omletItemDetails1);

        ItemDetails omletItemDetails2 = new ItemDetails();
        omletItemDetails2.setFoodName("Denver Omlet");
        omletItemDetails2.setPrice(102);
        omletItemDetails2.setItemCount(0);
        omletList.add(omletItemDetails2);

        ItemDetails omletItemDetails3 = new ItemDetails();
        omletItemDetails3.setFoodName("German Omlet");
        omletItemDetails3.setPrice(159);
        omletItemDetails3.setItemCount(0);
        omletList.add(omletItemDetails3);

        ItemDetails omletItemDetails4 = new ItemDetails();
        omletItemDetails4.setFoodName("Chilli Cheese Omlet");
        omletItemDetails4.setPrice(138);
        omletItemDetails4.setItemCount(0);
        omletList.add(omletItemDetails4);

        foodMap.put("Omlet",omletList);

        //BEEF IEMS
        ItemDetails beefItemDetails = new ItemDetails();
        beefItemDetails.setFoodName("Chuck");
        beefItemDetails.setPrice(205);
        beefItemDetails.setItemCount(0);
        beefList.add(beefItemDetails);

        ItemDetails beefItemDetails1 = new ItemDetails();
        beefItemDetails1.setFoodName("Rib");
        beefItemDetails1.setPrice(300);
        beefItemDetails1.setItemCount(0);
        beefList.add(beefItemDetails1);

        ItemDetails beefItemDetails2 = new ItemDetails();
        beefItemDetails2.setFoodName("Loin");
        beefItemDetails2.setPrice(255);
        beefItemDetails2.setItemCount(0);
        beefList.add(beefItemDetails2);

        ItemDetails beefItemDetails3 = new ItemDetails();
        beefItemDetails3.setFoodName("Round");
        beefItemDetails3.setPrice(230);
        beefItemDetails3.setItemCount(0);
        beefList.add(beefItemDetails3);

        ItemDetails beefItemDetails4 = new ItemDetails();
        beefItemDetails4.setFoodName("Brisket");
        beefItemDetails4.setPrice(215);
        beefItemDetails4.setItemCount(0);
        beefList.add(beefItemDetails4);

        foodMap.put("Beef Fry",beefList);

       //FISH ITEMS

        ItemDetails fishItemDetails = new ItemDetails();
        fishItemDetails.setFoodName("Fish Currry");
        fishItemDetails.setPrice(148);
        fishItemDetails.setItemCount(0);
        fishList.add(fishItemDetails);

        ItemDetails fishItemDetails1 = new ItemDetails();
        fishItemDetails1.setFoodName("Fish Cutlet");
        fishItemDetails1.setPrice(201);
        fishItemDetails1.setItemCount(0);
        fishList.add(fishItemDetails1);

        ItemDetails fishItemDetails2 = new ItemDetails();
        fishItemDetails2.setFoodName("Fried Fish");
        fishItemDetails2.setPrice(195);
        fishItemDetails2.setItemCount(0);
        fishList.add(fishItemDetails2);

        ItemDetails fishItemDetails3 = new ItemDetails();
        fishItemDetails3.setFoodName("Fish Finger");
        fishItemDetails3.setPrice(258);
        fishItemDetails3.setItemCount(0);
        fishList.add(fishItemDetails3);

        ItemDetails fishItemDetails4 = new ItemDetails();
        fishItemDetails4.setFoodName("Steamed Fish");
        fishItemDetails4.setPrice(256);
        fishItemDetails4.setItemCount(0);
        fishList.add(fishItemDetails4);
        foodMap.put("Fish",fishList);

        //HOT DOG

        ItemDetails hotDogItemDetails = new ItemDetails();
        hotDogItemDetails.setFoodName("chicago Dog");
        hotDogItemDetails.setPrice(107);
        hotDogItemDetails.setItemCount(0);
        hotDogList.add(hotDogItemDetails);

        ItemDetails hotDogItemDetails1 = new ItemDetails();
        hotDogItemDetails1.setFoodName("Junkyard Dog");
        hotDogItemDetails1.setPrice(207);
        hotDogItemDetails1.setItemCount(0);
        hotDogList.add(hotDogItemDetails1);

        ItemDetails hotDogItemDetails2 = new ItemDetails();
        hotDogItemDetails2.setFoodName("Blazin Dog");
        hotDogItemDetails2.setPrice(157);
        hotDogItemDetails2.setItemCount(0);
        hotDogList.add(hotDogItemDetails2);

        ItemDetails hotDogItemDetails3 = new ItemDetails();
        hotDogItemDetails3.setFoodName("All-American Dog");
        hotDogItemDetails3.setPrice(187);
        hotDogItemDetails3.setItemCount(0);
        hotDogList.add(hotDogItemDetails3);

        ItemDetails hotDogItemDetails4 = new ItemDetails();
        hotDogItemDetails4.setFoodName("Pastrami Dog");
        hotDogItemDetails4.setPrice(257);
        hotDogItemDetails4.setItemCount(0);
        hotDogList.add(hotDogItemDetails4);

        foodMap.put("Hot Dog",hotDogList);

       //SQUID FRY

        ItemDetails squidItemDetails = new ItemDetails();
        squidItemDetails.setFoodName("Stuffed Squid");
        squidItemDetails.setPrice(206);
        squidItemDetails.setItemCount(0);
        squidFryList.add(squidItemDetails);

        ItemDetails squidItemDetails1 = new ItemDetails();
        squidItemDetails1.setFoodName("Crispy Squid");
        squidItemDetails1.setPrice(176);
        squidItemDetails1.setItemCount(0);
        squidFryList.add(squidItemDetails1);

        ItemDetails squidItemDetails2 = new ItemDetails();
        squidItemDetails2.setFoodName("Tuscan Seafood Stew");
        squidItemDetails2.setPrice(256);
        squidItemDetails2.setItemCount(0);
        squidFryList.add(squidItemDetails2);

        ItemDetails squidItemDetails3 = new ItemDetails();
        squidItemDetails3.setFoodName("Cioppino");
        squidItemDetails3.setPrice(300);
        squidItemDetails3.setItemCount(0);
        squidFryList.add(squidItemDetails3);

        ItemDetails squidItemDetails4 = new ItemDetails();
        squidItemDetails4.setFoodName("Fritto Misto");
        squidItemDetails4.setPrice(208);
        squidItemDetails4.setItemCount(0);
        squidFryList.add(squidItemDetails4);

        foodMap.put("Squid Fry",squidFryList);

        //CRAB ITEMS

        ItemDetails crabItemDetails = new ItemDetails();
        crabItemDetails.setFoodName("Crab Cake");
        crabItemDetails.setPrice(210);
        crabItemDetails.setItemCount(0);
        crabList.add(crabItemDetails);

        ItemDetails crabItemDetails1 = new ItemDetails();
        crabItemDetails1.setFoodName("Soft Shell Crab");
        crabItemDetails1.setPrice(220);
        crabItemDetails1.setItemCount(0);
        crabList.add(crabItemDetails1);

        ItemDetails crabItemDetails2 = new ItemDetails();
        crabItemDetails2.setFoodName("Crab Dip");
        crabItemDetails2.setPrice(260);
        crabItemDetails2.setItemCount(0);
        crabList.add(crabItemDetails2);

        ItemDetails crabItemDetails3 = new ItemDetails();
        crabItemDetails3.setFoodName("Deviled Crab");
        crabItemDetails3.setPrice(310);
        crabItemDetails3.setItemCount(0);
        crabList.add(crabItemDetails3);

        ItemDetails crabItemDetails4 = new ItemDetails();
        crabItemDetails4.setFoodName("Chilli Crab");
        crabItemDetails4.setPrice(188);
        crabItemDetails4.setItemCount(0);
        crabList.add(crabItemDetails4);

        foodMap.put("Crab",crabList);

       //EGGS ITEM

        ItemDetails eggItemDetails = new ItemDetails();
        eggItemDetails.setFoodName("Soft Boiled Egg");
        eggItemDetails.setPrice(29);
        eggItemDetails.setItemCount(0);
        eggsList.add(eggItemDetails);

        ItemDetails eggItemDetails1 = new ItemDetails();
        eggItemDetails1.setFoodName("Scrambled Egg");
        eggItemDetails1.setPrice(48);
        eggItemDetails1.setItemCount(0);
        eggsList.add(eggItemDetails1);

        ItemDetails eggItemDetails2 = new ItemDetails();
        eggItemDetails2.setFoodName("Fried Egg");
        eggItemDetails2.setPrice(20);
        eggItemDetails2.setItemCount(0);
        eggsList.add(eggItemDetails2);

        ItemDetails eggItemDetails3 = new ItemDetails();
        eggItemDetails3.setFoodName("Poached Egg");
        eggItemDetails3.setPrice(30);
        eggItemDetails3.setItemCount(0);
        eggsList.add(eggItemDetails3);

        ItemDetails eggItemDetails4 = new ItemDetails();
        eggItemDetails4.setFoodName("Shirred Egg");
        eggItemDetails4.setPrice(39);
        eggItemDetails4.setItemCount(0);
        eggsList.add(eggItemDetails4);

        foodMap.put("Eggs",eggsList);

       //MUTTON ITEMS

        ItemDetails muttonItemDetails = new ItemDetails();
        muttonItemDetails.setFoodName("Mutton Kuzhambu");
        muttonItemDetails.setPrice(225);
        muttonItemDetails.setItemCount(0);
        muttonList.add(muttonItemDetails);

        ItemDetails muttonItemDetails1 = new ItemDetails();
        muttonItemDetails1.setFoodName("Mutton Korma");
        muttonItemDetails1.setPrice(235);
        muttonItemDetails1.setItemCount(0);
        muttonList.add(muttonItemDetails1);

        ItemDetails muttonItemDetails2 = new ItemDetails();
        muttonItemDetails2.setFoodName("Nalli Nihari");
        muttonItemDetails2.setPrice(301);
        muttonItemDetails2.setItemCount(0);
        muttonList.add(muttonItemDetails2);

        ItemDetails muttonItemDetails3 = new ItemDetails();
        muttonItemDetails3.setFoodName("Kosha Mangsho");
        muttonItemDetails3.setPrice(350);
        muttonItemDetails3.setItemCount(0);
        muttonList.add(muttonItemDetails3);

        ItemDetails muttonItemDetails4 = new ItemDetails();
        muttonItemDetails4.setFoodName("Pasanda");
        muttonItemDetails4.setPrice(177);
        muttonItemDetails4.setItemCount(0);
        muttonList.add(muttonItemDetails4);

        foodMap.put("Mutton",muttonList);

       //PRAWN ITEMS
        ItemDetails prawnItemDetails = new ItemDetails();
        prawnItemDetails.setFoodName("Kerala Fried Prawn");
        prawnItemDetails.setPrice(166);
        prawnItemDetails.setItemCount(0);
        prawnList.add(prawnItemDetails);

        ItemDetails prawnItemDetails1 = new ItemDetails();
        prawnItemDetails1.setFoodName("Prawn Curry");
        prawnItemDetails1.setPrice(266);
        prawnItemDetails1.setItemCount(0);
        prawnList.add(prawnItemDetails1);

        ItemDetails prawnItemDetails2 = new ItemDetails();
        prawnItemDetails2.setFoodName("Malai Prawn Curry");
        prawnItemDetails2.setPrice(366);
        prawnItemDetails2.setItemCount(0);
        prawnList.add(prawnItemDetails2);

        ItemDetails prawnItemDetails3 = new ItemDetails();
        prawnItemDetails3.setFoodName("Prawn Pulao");
        prawnItemDetails3.setPrice(236);
        prawnItemDetails3.setItemCount(0);
        prawnList.add(prawnItemDetails3);

        ItemDetails prawnItemDetails4 = new ItemDetails();
        prawnItemDetails4.setFoodName("Spicy Prawns");
        prawnItemDetails4.setPrice(198);
        prawnItemDetails4.setItemCount(0);
        prawnList.add(prawnItemDetails4);

        foodMap.put("Prawn",prawnList);

        if (eatablesAdapter == null) {
            Log.d(TAG, "onCreate: called_" + bundle.getString("food"));
            Log.d(TAG, "EatablesAdapter: called3:"+bundle.getString("food")+"__"+foodMap.get(bundle.getString("food")));
            eatablesAdapter = new EatablesAdapter(this, foodMap, foodMap.get(bundle.getString("food")));
            recyclerView.setAdapter(eatablesAdapter);
        }
    }
}