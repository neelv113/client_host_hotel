package com.example.ashish.client_host.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ashish.pre_booked_hotel.R;

public class ToolbarRatingActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_rating);

        ratingBar = findViewById(R.id.Rating);
        textView = findViewById(R.id.RatingText);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b)
            {
                textView.setText("Value is : "+rating);
            }
        });
    }
}
