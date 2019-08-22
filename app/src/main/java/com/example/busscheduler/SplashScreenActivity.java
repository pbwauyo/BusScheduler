package com.example.busscheduler;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import com.bumptech.glide.Glide;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView busImageView;
    MotionLayout motionLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        busImageView = findViewById(R.id.bus);
        motionLayout = findViewById(R.id.splash_screen_motion_layout);
        motionLayout.transitionToEnd();

        Glide.with(this)
                //.asGif()
                .load(R.drawable.front_bus)
                .fitCenter()
                .into(busImageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();

            }
        }, 5*1000); // wait for 5 seconds
    }
}
