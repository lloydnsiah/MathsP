package com.example.mathsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

public class HomeScreen extends AppCompatActivity {

    private ImageView logo,name,bg;
    private LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        logo = findViewById(R.id.logo);
        name = findViewById(R.id.app_name);
        bg = findViewById(R.id.img);
        lottie = findViewById(R.id.lottie_animation);


        bg.animate().translationY(-3000).setDuration(1000).setStartDelay(4000);
        name.animate().translationY(2400).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2400).setDuration(1000).setStartDelay(4000);
        lottie.animate().translationY(2400).setDuration(1000).setStartDelay(4000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(HomeScreen.this,OnBoarding.class));
                finish();
            }
        },5000);
    }
}