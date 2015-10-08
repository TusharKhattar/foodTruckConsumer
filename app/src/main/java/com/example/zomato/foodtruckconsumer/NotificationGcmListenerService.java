package com.example.zomato.foodtruckconsumer;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by zomato on 08/10/15.
 */
public class NotificationGcmListenerService extends GcmListenerService implements FusedLocationService.LocationListener {

    double foodTruckLatitude;
    double foodTruckLongitude;
    public static final double VICINITY_DISTANCE=1;

    @Override
    public void onMessageReceived(String from, Bundle data) {

        String latitude=data.getString("latitude");
        String longitude=data.getString("longitude");
        Log.i("iiiiiii","aaaaaa");
        foodTruckLatitude=Double.parseDouble(latitude);
        foodTruckLongitude=Double.parseDouble(longitude);
        new FusedLocationService(getApplicationContext(),this);

    }

    public void showNotification(String message,double lat,double lng){

        Intent resultIntent=new Intent(this,FoodTruckPresentLocationMap.class);
        resultIntent.putExtra("latitude",lat);
        resultIntent.putExtra("longitude",lng);
        PendingIntent resultPendingIntent=PendingIntent.getActivity(this,0,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder=new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.drawable.common_signin_btn_icon_dark);
        notificationBuilder.setContentTitle("GCM message").setContentText(message).setSound(defaultSoundUri);
        notificationBuilder.setContentIntent(resultPendingIntent);

        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notificationBuilder.build());
    }

    public String getLocationAddress(double latitude,double longitude){
        String output="";
        StringBuilder strAddress;
        Geocoder geocoder=new Geocoder(this, Locale.ENGLISH);
        try {
            List<Address> addresses=geocoder.getFromLocation(latitude, longitude, 2);
            if(addresses!=null){
                Address fetchedAddress=addresses.get(0);
                Log.i("ppppppp",fetchedAddress.toString());
                strAddress = new StringBuilder();

                for(int i=0; i<fetchedAddress.getMaxAddressLineIndex(); i++) {
                    strAddress.append(fetchedAddress.getAddressLine(i)).append("\n");
                }
                output=strAddress.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    @Override
    public void onReceiveLocation(Location location) {
        Log.i("iiiiii","  "+location.getLatitude()+"  "+location.getLongitude());
        double userLatitude=location.getLatitude();
        double userLongitude=location.getLongitude();
        double dist=Utilities.distance(userLatitude,userLongitude,foodTruckLatitude,foodTruckLongitude);
        if(dist<VICINITY_DISTANCE){
            showNotification("YOUR FAV FOODTRUCK IS HERE!! ",foodTruckLatitude,foodTruckLongitude );
        }
    }

    @Override
    public void onLocationDisabled(String msg) {

    }

    @Override
    public void onConnectionFailed(String msg) {

    }
}
