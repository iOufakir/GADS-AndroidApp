package com.ilyo.gadsapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.ilyo.gadsapp.R;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        // Handler attached to the UI main thread
        new Handler(Looper.getMainLooper()).postDelayed(this::startActivity, 1200);
    }


    private void startActivity(){
        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(intent);
        // finish activity
        finish();
    }
}