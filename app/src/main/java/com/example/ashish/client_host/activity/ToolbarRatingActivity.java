package com.example.ashish.client_host.activity;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.ashish.client_host.Model.Ratings;
import com.example.ashish.pre_booked_hotel.R;
import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URL;

public class ToolbarRatingActivity extends AppCompatActivity{

    private static final String TAG = ToolbarRatingActivity.class.getSimpleName();

     String no;
     float rate;
     EditText number;
     RatingBar ratingBar;
     Button button;

     Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_rating);

        ratingBar = findViewById(R.id.Rating);
        number = findViewById(R.id.contactNumber);
        button = findViewById(R.id.feedbackButton);

        Firebase.setAndroidContext(this);

     //   String deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(),Settings.Secure.ANDROID_ID);

        firebase = new Firebase("https://typroject-93943.firebaseio.com/UserRatings");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no = number.getText().toString();
                rate = ratingBar.getRating();
                Log.d(TAG, "onClick:1"+no);
                //Toast.makeText(ToolbarRatingActivity.this,"Rate : "+ratingBar.getRating(),Toast.LENGTH_SHORT).show();
                if(no.length() < 10)
                {
                    Log.d(TAG, "onClick:2");
                    Toast.makeText(ToolbarRatingActivity.this,"Invalid Contact",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Firebase newChild;
                    newChild = firebase.child(no);
                    newChild.setValue(rate);

               //     new Ratings(rate,no);
                    Toast.makeText(ToolbarRatingActivity.this,"Thank You for your feedback...",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ToolbarRatingActivity.this,FoodMenuActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP));

                }
            }
        });
    }
}