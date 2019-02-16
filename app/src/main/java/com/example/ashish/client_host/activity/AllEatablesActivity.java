package com.example.ashish.client_host.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ashish.client_host.Adapter.EatablesAdapter;
import com.example.ashish.pre_booked_hotel.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllEatablesActivity extends AppCompatActivity {

    private Map<String, List<String>> foodMap;
    private static final String KEY_BIRIYANI = "Biryani";
    private List<String> biriyaniList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EatablesAdapter eatablesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_eatables);
        Bundle bundle = getIntent().getExtras();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodMap = new HashMap<>();
        biriyaniList.add("biriyani 1");
        biriyaniList.add("biriyani 2");
        foodMap.put(KEY_BIRIYANI, biriyaniList);

        if (eatablesAdapter == null) {
            eatablesAdapter = new EatablesAdapter(this,foodMap,bundle.getString("food"));
            recyclerView.setAdapter(eatablesAdapter);
        }
    }
}
