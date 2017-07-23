package com.robinhood.librarysample;

import android.app.Application;

import com.robinhood.librarysample.base.util.SharedPreferencesService;

/**
 * Created by sean on 2017. 7. 23..
 */
public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesService.getInstance().load(getApplicationContext());
    }
}
