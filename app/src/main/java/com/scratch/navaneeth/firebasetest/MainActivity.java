package com.scratch.navaneeth.firebasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mPrizeRef;
    private DatabaseReference mFirstPrizeRef;
    private DatabaseReference mSecondPrizeRef;

    //UI references

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = findViewById(R.id.textView);
        mDatabase = FirebaseDatabase.getInstance();


        mPrizeRef = mDatabase.getReference("prize");

        //Write single value
        mFirstPrizeRef = mDatabase.getReference("prize/first_prize");
        //Read the single value
        mFirstPrizeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Prizes> prizeList = new ArrayList();
                prizeList.add(prizes);
                Random randomGenerator = new Random();
                int index = randomGenerator.nextInt(catalogue.size());
                Prizes prizes= dataSnapshot.getValue(Prizes.class);
                mText.setText(""+dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

}