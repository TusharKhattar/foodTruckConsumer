package com.example.zomato.foodtruckconsumer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class FoodTruckPersonalPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodtruck_personal_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).start();
        toolbar.animate().translationY(toolbar.getBottom()).setInterpolator(new AccelerateInterpolator()).start();
    }

}
