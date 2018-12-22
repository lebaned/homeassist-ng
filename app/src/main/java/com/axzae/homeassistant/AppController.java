package com.axzae.homeassistant;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDex;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class AppController extends Application {
    private static AppController mInstance;
    private static SharedPreferences sharedPref;

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        mInstance = this;

        //String android_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        //Crashlytics.log(Log.DEBUG, "YouQi", "");

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }

    }


    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public SharedPreferences getSharedPref() {
        if (sharedPref == null) {
            sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        }
        return sharedPref;
    }
}