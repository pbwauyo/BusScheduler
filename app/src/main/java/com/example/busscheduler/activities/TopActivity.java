package com.example.busscheduler.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.busscheduler.R;
import com.example.busscheduler.fragments.BusLocationsFragment;
import com.example.busscheduler.fragments.FavoritesFragment;
import com.example.busscheduler.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

public class TopActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    Fragment fragment;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        FirebaseMessaging.getInstance().subscribeToTopic("default_notifications");

        navigationView = findViewById(R.id.bottom_nav_bar);
        actionBar = getSupportActionBar();

        //load SearchFragment by default
        actionBar.setTitle("Search bus stops");
        fragment = new SearchFragment();
        loadFragment(fragment);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.search:
                        actionBar.setTitle("Search bus stops");
                        fragment = new SearchFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.bus_location:
                        actionBar.setTitle("Bus locations");
                        fragment = new BusLocationsFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.favorites:
                        actionBar.setTitle("Favorite stops");
                        fragment = new FavoritesFragment();
                        loadFragment(fragment);
                        return true;
                }

                return false;
            }
        });

    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
