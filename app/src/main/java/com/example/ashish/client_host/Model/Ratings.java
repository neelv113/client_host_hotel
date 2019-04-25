package com.example.ashish.client_host.Model;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Ratings {

    private static final String TAG = Ratings.class.getSimpleName();

    public float rating;
    public String contact;

    public Ratings(final float rating, final String contact) {
        this.rating = rating;
        this.contact = contact;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference("Ratings");
        Log.d(TAG, "Ratings: called 1__"+reference);

            reference.child("contact").setValue(contact);
            reference.child("rating").setValue(String.valueOf(rating));


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG, "Ratings: called snap 1"+dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.d(TAG, "Ratings: called 2");
            }
        });
    }
}