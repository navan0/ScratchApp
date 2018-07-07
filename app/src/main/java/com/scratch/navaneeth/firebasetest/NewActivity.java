package com.scratch.navaneeth.firebasetest;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;


public class NewActivity extends AppCompatActivity {



    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        time=findViewById(R.id.timer);
        new CountDownTimer(300000000, 1000) {
            public void onTick(long millisUntilFinished) {
                time.setText(" time remaning " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("done!");
            }
        }.start();
    }
}
