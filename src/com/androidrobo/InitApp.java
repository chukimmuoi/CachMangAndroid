package com.androidrobo;

import android.app.Application;

public class InitApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //initial database creation..
        new DbHelper(getApplicationContext()).getWritableDatabase();
    }
}