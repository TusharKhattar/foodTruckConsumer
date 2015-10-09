package com.example.zomato.foodtruckconsumer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by zomato on 09/10/15.
 */
public class LocationFragment extends Fragment {

    public static GoogleMap mMap;
    public static double latitude,lng;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.location_fragment, null);
        latitude=23.2222;
        lng=78.3223;


        return v;
    }
}
