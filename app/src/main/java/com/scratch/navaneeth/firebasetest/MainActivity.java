package com.scratch.navaneeth.firebasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
//        mDatabaseRef = mDatabase.getReference();
        mPrizeRef = mDatabase.getReference("prize");
        mFirstPrizeRef = mDatabase.getReference("prize/first_prize");


        mPrizeRef.setValue(new Prizes("car","bike"));

        //listen the single data
        mFirstPrizeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mText.setText(""+dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //push n number for models
        mPrizeRef.push().setValue(new Prizes("laptop","mobile"));

    }

}