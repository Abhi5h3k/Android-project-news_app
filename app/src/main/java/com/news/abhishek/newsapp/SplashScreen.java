package com.news.abhishek.newsapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler=new Handler();
         handler.postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent loadMainActivity=new Intent(SplashScreen.this,MainActivity.class);
                 startActivity(loadMainActivity);
                 finish();
             }
         },2500);

    }
}
