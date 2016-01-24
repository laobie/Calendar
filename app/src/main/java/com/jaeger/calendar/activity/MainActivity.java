package com.jaeger.calendar.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.jaeger.calendar.R;
import com.jaeger.calendar.adapter.MonthViewAdapter;
import com.jaeger.calendar.base.BaseActivity;
import com.jaeger.calendar.entity.Day;
import com.jaeger.calendar.utils.DateUtils;

public class MainActivity extends BaseActivity {
    private Day mToday;
    private TextView mTvDay;
    private TextView mTvLunar;
    private TextView mTvYear;
    private TextView mTvMonth;
    private TextView mTvWeek;
    private RecyclerView mRvMonthView;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        mTvYear = (TextView) findViewById(R.id.tv_year);
        mTvMonth = (TextView) findViewById(R.id.tv_month);
        mTvWeek = (TextView) findViewById(R.id.tv_week);
        mTvDay = (TextView) findViewById(R.id.tv_day);
        mTvLunar = (TextView) findViewById(R.id.tv_lunar);
        mRvMonthView = (RecyclerView) findViewById(R.id.rv_month_view);

    }

    @Override
    protected void setViewStatus() {
        mToday = Day.getToday();
        mTvYear.setText(mToday.getYearStr());
        mTvMonth.setText(mToday.getMonthStr());
        mTvWeek.setText(mToday.getWeekStr());
        mTvDay.setText(mToday.getDayStr());
        mTvLunar.setText(mToday.getLunarDayMD());

        mRvMonthView.setLayoutManager(new GridLayoutManager(this, 7));
        mRvMonthView.setAdapter(new MonthViewAdapter(this, DateUtils.getDaysOfMonth(2016, 0)));
    }
}
