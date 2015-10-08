package com.example.zomato.foodtruckconsumer;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

/**
 * Created by zomato on 08/10/15.
 */
public class RegistrationIntentService extends IntentService {


    private static final String TAG = "pppppppp";
    static final String SENDER_ID="557158651923";
    String token = null;

    public String getRegToken(){
        SharedPreferences preferences = this.getSharedPreferences("gcm", Context.MODE_PRIVATE);
        return preferences.getString("gcm_reg", null);
    }

    public void saveRegToken(String str){
        SharedPreferences.Editor preferences = this.getSharedPreferences("gcm", Context.MODE_PRIVATE).edit();
        preferences.putString("gcm_reg", str);
        preferences.commit();
    }

    public RegistrationIntentService() {
        super("TAG");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (getRegToken() == null) {
            final InstanceID instanceID = InstanceID.getInstance(this);
            try {
                token = instanceID.getToken(SENDER_ID, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
                Log.i(TAG,"token is :"+token);
            } catch (IOException e) {
                e.printStackTrace();
            }
            saveRegToken(token);
        }else{
            Log.i(TAG," stored token is :"+token);
        }
    }
}
