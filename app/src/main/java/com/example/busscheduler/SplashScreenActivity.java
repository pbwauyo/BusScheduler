package com.example.busscheduler;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.motion.MotionLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView gifImageView;
    MotionLayout motionLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        gifImageView = findViewById(R.id.animation_gif);
        motionLayout = findViewById(R.id.splash_screen_motion_layout);

        motionLayout.transitionToEnd();

        Glide.with(this)
                .load(R.drawable.bus_2)
                .into(gifImageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();

            }
        }, 5*1000); // wait for 5 seconds
    }
}
