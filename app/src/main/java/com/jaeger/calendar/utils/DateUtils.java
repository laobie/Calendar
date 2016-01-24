package com.jaeger.calendar.utils;

import com.jaeger.calendar.entity.Day;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Jaeger on 16/1/24.
 * Calendar
 */
public class DateUtils {

    public List<Day> getDaysOfMonth(int year, int month) {
        List<Day> days = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        for (int i = 0; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
            days.add(null);
        }
        for (int i = 1; i <= calendar.get(Calendar.DAY_OF_MONTH); i++) {
            Day day = new Day(year, month, i);
            days.add(day);
        }
        return days;
    }
}
