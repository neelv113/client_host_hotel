package com.example.ashish.client_host.activity;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ashish.client_host.Adapter.CartAdapter;
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
    private static final String TAG = Cart.class.getSimpleName();

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Log.d(TAG, "onCreate: called ak cart 1");
        initViews();
        placeOrderBtn = findViewById(R.id.placeOrder);
       placeOrderBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sendNotification();
           }
       });

    }


    private void sendNotification() {
        mClient = new OkHttpClient();
        String refreshedToken = "dKkc30tq6EQ:APA91bGKWQAAgXFV5lEBCqx--_4cR1Z4cpC-Q_j-TPUH8nSOzPbASWEOR9RwDF0WhFxgyzSmqzvhe3O0g4AakUzmtJOSHdZoRRJFw6rgn16Qg3WCrvc0WD3kqqFKqaKcNSxFgK75UNX2";
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(refreshedToken);
        sendMessage(jsonArray, "hello", "ak", "Http://google.com", "my name is ashish");
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
                    failure=resultJson.getInt("failuer");
                    Toast.makeText(Cart.this,"Message Success:"+success+"Failure"+failure,Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(Cart.this,"Failed due to error",Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }

    private String postToFCM(String bodyString)throws IOException {

        String FCM_MESSAGE_URL = "https://fcm.googleapis.com/fcm/send";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, bodyString);
        Request request = new Request.Builder()
                .url(FCM_MESSAGE_URL)
                .post(body)
                .addHeader("Authorization", "key=" + "AIzaSyCc8pnR2KhsYshriO4_BztCQeREpx6q1ZQ")
                .build();
        Response response = mClient.newCall(request).execute();
        Log.d(TAG,"response al:"+response+"__"+response.body().string()+"__"+response.body().string());
        return response.body().string();
    }

    private void initViews() {
        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(this);
        cartRecyclerView.setAdapter(cartAdapter);
    }
}
