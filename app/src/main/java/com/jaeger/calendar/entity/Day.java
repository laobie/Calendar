package com.jaeger.calendar.entity;

import com.jaeger.calendar.lib.Lunar;

/**
 * Created by Jaeger on 16/1/24.
 * Calendar
 */
public class Day extends Lunar {

    private static final String YEAR = "年";
    private static final String MONTH = "月";
    private String[] WEEK_DAY = new String[]{
            "日", "一", "二", "三", "四", "五", "六"
    };

    public Day() {
    }

    public Day(long millisecond) {
        super(millisecond);
    }

    public Day(int year, int month, int day) {
        super(year, month, day);
    }

    public static Day getToday() {
        return new Day(System.currentTimeMillis());
    }

    public String getLunarDayMD() {
        return getLunarMonth() + MONTH + " " + getLunarDay();
    }

    public String getMonthStr() {
        return (getSolarMonth() + 1) + MONTH;
    }

    public String getDayStr() {
        return String.valueOf(getSolarDay());
    }

    public String getYearStr() {
        return getSolarYear() + YEAR;
    }

    public String getWeekStr() {
        return "星期" + WEEK_DAY[getDayOfWeek() - 1];
    }
}
