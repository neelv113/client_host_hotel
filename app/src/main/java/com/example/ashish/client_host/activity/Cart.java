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
        initViews();
        placeOrderBtn=findViewById(R.id.placeOrder);

        placeOrderBtn.setOnClickListener(placeorder);

    }

    View.OnClickListener placeorder=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sendNotification();
        }
    } ;

    private final void sendNotification() {
        this.mClient = new OkHttpClient();
        String refreshedToken = "f-Xot0hshes:APA91bG1WB_SVCardwAqNlU2JMD6F7j-boLF_StfUyFwxsxpO1blqJs1sQQ4BGVrK9JEY82c2yvtezEkJ2wckxa6d4Z9Yg0FbrU-H0CUqQJ8KOuMwhhsNjSqt-e8zC0DPZx6qHyiqTJ0";
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(refreshedToken);
        this.sendMessage(jsonArray, "hello", "ak", "Http://google.com", "my name is ashish");
    }

    void sendMessage(final JSONArray recipients, final String title, final String body, final String icon, final String message) {
        AsyncTask asyncTask = new AsyncTask<String,String,String>() {
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
                    Log.d(TAG, "doInBackground: called:"+result);
                    return result;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPreExecute() {
            }

            @Override
            protected void onPostExecute(String result) {
                try {
                    Log.d(TAG, "onPostExecute: called1:"+result);
                    JSONObject resultJSON= new JSONObject(result);
                    int success;
                    int failure;
                    success=resultJSON.getInt("success");
                    failure=resultJSON.getInt("Failure");
                    Toast.makeText(Cart.this,"Success"+success+"Failure"+failure,Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d(TAG, "onPostExecute: called:"+e.getMessage());
                    Toast.makeText(Cart.this,"Fail due to error",Toast.LENGTH_SHORT).show();
                }
            }


        }.execute();
    }
    private String postToFCM(String bodyString) throws IOException {
        Log.d(TAG, "postToFCM1: ");
        String FCM_MESSAGE_URL="https://fcm.googleapis.com/fcm/send";
        Log.d(TAG, "postToFCM2: ");
        MediaType JSON= MediaType.parse("application/json; charset=utf-8");
        Log.d(TAG, "postToFCM3: ");
        RequestBody body= RequestBody.create(JSON,bodyString);
        Log.d(TAG, "postToFCM4: ");
        Request request=new Request.Builder()
                .url(FCM_MESSAGE_URL)
                .post(body)
                .addHeader("Authorization","key="+"AIzaSyCc8pnR2KhsYshriO4_BztCQeREpx6q1ZQ")
                .build();
        Log.d(TAG, "postToFCM5: ");
        Response response=mClient.newCall(request).execute();
        Log.d(TAG, "postToFCM6: "+response+"___"+response.body()+"__"+response.body().toString()+"__"+response);
        return response.body().toString();
    }

    private void initViews()
    {
        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(this);
        cartRecyclerView.setAdapter(cartAdapter);
    }
}
