package com.jaeger.calendar;

import android.app.Application;
import android.content.Context;

/**
 * Created by Jaeger on 16/2/11.
 * Calendar
 */
public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
