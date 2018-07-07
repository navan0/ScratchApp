package com.scratch.navaneeth.firebasetest;

import android.content.Intent;
import java.util.Timer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.cooltechworks.views.ScratchTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class    MainActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mPrizeRef;
    private List<Prizes> prizeList = new ArrayList<>();


    //UI references
    private ScratchTextView mText;
    public Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = findViewById(R.id.textView);
        mDatabase = FirebaseDatabase.getInstance();
        b2=findViewById(R.id.button2);


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
//        mPrizeRef.push().child("prize").setValue("Laptop");
//        mPrizeRef.push().child("prize").setValue("iPad");
//        mPrizeRef.push().child("prize").setValue("iPhone");



        //Read the single value
        mPrizeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Log.d("MainActivity", "Value= " + dataSnapshot1.child("prize").getValue(String.class));
                    Prizes prizes = new Prizes(dataSnapshot1.getKey(),dataSnapshot1.child("prize").getValue().toString());
                    if (prizeList.size() == 0){
                        prizeList.add(prizes);
                    }else{
                        Random random = new Random();
                        final Prizes prize = prizeList.get(random.nextInt(prizeList.size()));
                        mText.setText(prize.prize.toString());
                        mText.setRevealListener(new ScratchTextView.IRevealListener() {
                            @Override
                            public void onRevealed(ScratchTextView scratchTextView) {
                                mPrizeRef.child(prize.key).removeValue();

                                b2.setVisibility(scratchTextView.VISIBLE);
                            }


                            @Override
                            public void onRevealPercentChangedListener(ScratchTextView scratchTextView, float v) {

                            }

                        });

                        b2.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View arg0) {

                                // Start NewActivity.class
                                Intent myIntent = new Intent(MainActivity.this,
                                        QRactivity.class);
                                startActivity(myIntent);
                            }
                        });
                    }


                }
                Log.d("prizeListSize","= "+prizeList.size());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        Log.d("prizeListSize","= "+prizeList.size());
        if (prizeList.size() > 0) {

        }




    }



}