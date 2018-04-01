package com.scratch.navaneeth.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity  implements ValueEventListener {

    private DatabaseReference mDatabaseRef;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mPrize;

    //UI references

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView)findViewById(R.id.textView);
        mDatabase=FirebaseDatabase.getInstance();
        mDatabaseRef= mDatabase.getReference();
        mPrize=mDatabaseRef.child("prize");

    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
