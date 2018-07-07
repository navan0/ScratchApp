package com.scratch.navaneeth.firebasetest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.Profile;

public class QRactivity extends AppCompatActivity {

    public  TextView profilename;
    public ImageView dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qractivity);
        profilename = findViewById(R.id.profilename);
        dp= findViewById(R.id.dp);
        Profile profile = Profile.getCurrentProfile();
        String firstName = profile.getFirstName();
        profilename.setText(firstName);


//        Bitmap mBimap = profile.getProfilePictureUri(20,20);
//
//        dp.setImageBitmap(profile.getProfilePictureUri(20,20));


    }
}
