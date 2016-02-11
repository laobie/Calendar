package com.jaeger.calendar.utils;

import com.jaeger.calendar.entity.Day;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Jaeger on 16/1/24.
 * Calendar
 */
public class DateUtils {

    public static List<Day> getDaysOfMonth(Calendar calendar, List<Day> days) {
        days.clear();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        for (int i = 0; i < calendar.get(Calendar.DAY_OF_WEEK) - 1; i++) {
            days.add(null);
        }
        for (int i = 1; i <= calendar.getActualMaximum(Calendar.DATE); i++) {
            Day day = new Day(year, month, i);
            days.add(day);
        }
        return days;
    }

    public static String getLastedLunarHoliday() {
        Calendar calendar = Calendar.getInstance();
        Day day = new Day(calendar);
        int i = 0;
        while (day.getSolarTerm() == null) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            i++;
            day.setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        }

        if (i == 0) {
            return day.getSolarTerm();
        } else {
            return i + "天后 " + day.getSolarTerm();
        }
    }

}
