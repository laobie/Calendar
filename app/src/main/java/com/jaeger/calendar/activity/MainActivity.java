package com.jaeger.calendar.activity;

import android.widget.TextView;

import com.jaeger.calendar.R;
import com.jaeger.calendar.base.BaseActivity;
import com.jaeger.calendar.entity.Day;

public class MainActivity extends BaseActivity {
    private Day mToday;
    private TextView mTvDay;
    private TextView mTvLunar;
    private TextView mTvYear;
    private TextView mTvMonth;
    private TextView mTvWeek;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        mTvYear = (TextView) findViewById(R.id.tv_year);
        mTvMonth = (TextView) findViewById(R.id.tv_month);
        mTvWeek = (TextView) findViewById(R.id.tv_week);
        mTvDay = (TextView) findViewById(R.id.tv_day);
        mTvLunar = (TextView) findViewById(R.id.tv_lunar);
    }

    @Override
    protected void setViewStatus() {
        mToday = Day.getToday();

        mTvYear.setText(mToday.getYearStr());
        mTvMonth.setText(mToday.getMonthStr());
        mTvWeek.setText(mToday.getWeekStr());
        mTvDay.setText(mToday.getDayStr());
        mTvLunar.setText(mToday.getLunarDayMD());

        super.setViewStatus();
    }
}
