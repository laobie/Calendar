package com.jaeger.calendar.utils;

import android.content.res.Resources;

import com.jaeger.calendar.App;

/**
 * Created by Jaeger on 16/2/11.
 * Calendar
 */
public class StrUtils {
    private static Resources getRes() {
        return App.getContext().getResources();
    }

    public static String getString(int id) {
        return getRes().getString(id);
    }

    public static String getFormatString(int id, Object... objects) {
        return String.format(getRes().getString(id), objects);
    }
}
