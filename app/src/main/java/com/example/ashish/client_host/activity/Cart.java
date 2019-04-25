package com.example.ashish.client_host.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashish.client_host.Adapter.CartAdapter;
import com.example.ashish.client_host.Adapter.EatablesAdapter;
import com.example.ashish.client_host.util.SharedPreferences;
import com.example.ashish.pre_booked_hotel.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Cart extends AppCompatActivity {

    OkHttpClient mClient;
    Button placeOrderBtn;
    Button removeOrderBtn;
    EditText edtTable;
    private static final String TAG = Cart.class.getSimpleName();

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        edtTable=findViewById(R.id.edtTable);
        removeOrderBtn = findViewById(R.id.removeOrder);

        removeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    SharedPreferences.clear();
                    cartRecyclerView.setAdapter(null);
                    cartRecyclerView.setAdapter(cartAdapter);
                    startActivity(new Intent(Cart.this,FoodMenuActivity.class));

            }
        });

        Log.d(TAG, "onCreate: called ak cart 1");
        initViews();
        placeOrderBtn = findViewById(R.id.placeOrder);
       placeOrderBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String table = edtTable.getText().toString();

               if(SharedPreferences.isEmpty())
               {
                   startActivity(new Intent(Cart.this,AllEatablesActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP));
                   Toast.makeText(Cart.this,"Please select any order",Toast.LENGTH_LONG).show();
                   finish();
               }
               else if(table.isEmpty())
               {
                   Toast.makeText(Cart.this,"Please enter table number",Toast.LENGTH_LONG).show();
               }
               else
               {
                   sendNotification();
                   startActivity(new Intent(Cart.this,FoodMenuActivity.class));
               }
           }
       });
    }

    private void sendNotification() {
        mClient = new OkHttpClient();
        String refreshedToken = "fIyd5BoUhmk:APA91bHuU75ns-2r00CmSZoGArcE2f-SvZvtVFfKHHjCXVqUBjIks27KpwNFhO6pMHUGkANVAyEgoYgBicHiT7CTdnzhICaLduGo7lsFmcgAYYvEVrHwuKmR8IAQ-53U2sNK-K5LvRA4";
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(refreshedToken);
        sendMessage(jsonArray, "hello", SharedPreferences.getFoodListName().toString(), "Http://google.com", edtTable.getText().toString());
    }

    private void sendMessage(final JSONArray recipients, final String title, final String body, final String icon, final String message) {
        Log.d(TAG, "sendMessage: called ak send message:");
        new AsyncTask<String,String,String>(){
            @Override
            protected String doInBackground(String... strings) {
                try {
                    JSONObject root = new JSONObject();
                    JSONObject notification = new JSONObject();
                    notification.put("body", body);
                    notification.put("title", title);
                    notification.put("icon", icon);

                    JSONObject data = new JSONObject();
                    data.put("message", message);
                    root.put("notification", notification);
                    root.put("data", data);
                    root.put("registration_ids", recipients);

                    String result = postToFCM(root.toString());
                    Log.d(TAG,"response ak1:"+result);
                    return result;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                try{
                    JSONObject resultJson=new JSONObject(result);
                    int success;
                    int failure;
                    success=resultJson.getInt("success");
                    failure=resultJson.getInt("failure");
                    //Toast.makeText(Cart.this,"Message Success:"+success+"Failure"+failure,Toast.LENGTH_SHORT).show();
                    Toast.makeText(Cart.this,"Order Placed Successfully",Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    e.printStackTrace();
                    Log.d(TAG, "onPostExecute: called failure:"+e.getMessage());
                    Toast.makeText(Cart.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }.execute();
    }

    private String postToFCM(String bodyString)throws IOException {
        Log.d(TAG,"response al:2");
        String FCM_MESSAGE_URL = "https://fcm.googleapis.com/fcm/send";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, bodyString);
        Request request = new Request.Builder()
                .url(FCM_MESSAGE_URL)
                .post(body)
                .addHeader("Authorization", "key=" + "AIzaSyCc8pnR2KhsYshriO4_BztCQeREpx6q1ZQ")
                .build();
        Response response = mClient.newCall(request).execute();
        return response.body().string();
    }

    private void initViews() {
        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(this);
        cartRecyclerView.setAdapter(cartAdapter);
    }
}