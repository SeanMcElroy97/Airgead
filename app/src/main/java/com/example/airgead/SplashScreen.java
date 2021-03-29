package com.example.airgead;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                startActivity(intent);
                Log.d("myTag", "Calling intent");
                finish(); } }, 1300);
        }
    }

