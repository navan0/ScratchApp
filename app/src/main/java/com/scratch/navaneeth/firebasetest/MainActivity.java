package com.scratch.navaneeth.firebasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.cooltechworks.views.ScratchTextView;
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
    private List<String> prizeList = new ArrayList<>();

    //UI references

    private ScratchTextView mText;
    private String mVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = findViewById(R.id.textView);
        mDatabase = FirebaseDatabase.getInstance();


        mPrizeRef = mDatabase.getReference("prize");


//        mPrizeRef.push().child("prize").setValue("Car");
//        mPrizeRef.push().child("prize").setValue("Bike");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("iPhone");
//        mPrizeRef.push().child("prize").setValue("Coffee");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
//        mPrizeRef.push().child("prize").setValue("Better Luck Next Time");
        mPrizeRef.push().child("prize").setValue("Laptop");
        mPrizeRef.push().child("prize").setValue("iPad");
        mPrizeRef.push().child("prize").setValue("iPhone");
//        mPrizeRef.push().child("prize").setValue("Coffee");
//        mPrizeRef.push().child("prize").setValue("Burger");
//        mPrizeRef.push().child("prize").setValue("Pizza");
//


        //Read the single value
        mPrizeRef.child("prize")
                .equalTo(mVal);
        mPrizeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Log.d("MainActivity", "Value= " + dataSnapshot1.child("prize").getValue(String.class));
                    prizeList.add(dataSnapshot1.child("prize").getValue().toString());
                    String club = dataSnapshot1.getKey().toString();
//                    mPrizeRef.child(dataSnapshot1.getKey()).removeValue();

                    //club contain the unique key
                    mPrizeRef.child(club).removeValue();
//                        mText.setText(club);




                }


                if (prizeList.size() > 0) {
                    Random random = new Random();
                    mVal = prizeList.get(random.nextInt(prizeList.size())).toString();
                    mText.setText(prizeList.get(random.nextInt(prizeList.size())).toString());

                }


            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
    }


}