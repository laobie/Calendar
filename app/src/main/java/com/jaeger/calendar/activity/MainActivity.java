package com.jaeger.calendar.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.calendar.R;
import com.jaeger.calendar.adapter.MonthViewAdapter;
import com.jaeger.calendar.base.BaseActivity;
import com.jaeger.calendar.entity.Day;
import com.jaeger.calendar.utils.DateUtils;
import com.jaeger.calendar.utils.StrUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends BaseActivity {
    private Day mToday;
    private Calendar mCalendar;
    private List<Day> mDayList;
    private MonthViewAdapter mMonthViewAdapter;

    // 控件
    private TextView mTvLunarMonth;
    private TextView mTvLunarDay;
    private TextView mTvLunarHoliday;
    private TextView mTvYear;
    private TextView mTvMonth;
    private TextView mTvDay;
    private TextView mTvWeek;
    private ImageView mIvLastMonth;
    private TextView mTvYearAndMonth;
    private ImageView mIvNextMonth;
    private RecyclerView mRvMonthView;
    private TextView mTvLunarYear;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        mTvLunarMonth = (TextView) findViewById(R.id.tv_lunar_month);
        mTvLunarDay = (TextView) findViewById(R.id.tv_lunar_day);
        mTvLunarHoliday = (TextView) findViewById(R.id.tv_lunar_holiday);
        mTvYear = (TextView) findViewById(R.id.tv_year);
        mTvMonth = (TextView) findViewById(R.id.tv_month);
        mTvDay = (TextView) findViewById(R.id.tv_day);
        mTvWeek = (TextView) findViewById(R.id.tv_week);
        mIvLastMonth = (ImageView) findViewById(R.id.iv_last_month);
        mTvYearAndMonth = (TextView) findViewById(R.id.tv_year_and_month);
        mIvNextMonth = (ImageView) findViewById(R.id.iv_next_month);
        mRvMonthView = (RecyclerView) findViewById(R.id.rv_month_view);
        mTvLunarYear = (TextView) findViewById(R.id.tv_lunar_year);
    }

    @Override
    protected void setViewStatus() {
        mToday = Day.getToday();
        mCalendar = Calendar.getInstance();
        mDayList = new ArrayList<>();
        mDayList = DateUtils.getDaysOfMonth(mCalendar, mDayList);

        mTvYear.setText(mToday.getYearStr());
        mTvMonth.setText(mToday.getMonthStr());
        mTvWeek.setText(mToday.getWeekStr());
        mTvDay.setText(mToday.getDayStr());
        mTvLunarDay.setText(mToday.getLunarDay());
        mTvLunarMonth.setText(StrUtils.getFormatString(R.string.lunar_month_unit, mToday.getLunarMonth()));
        mTvLunarYear.setText(StrUtils.getFormatString(R.string.lunar_year_unit, mToday.getZodiac()));
        mTvYearAndMonth.setText(StrUtils.getFormatString(R.string.year_and_month_unit, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH) + 1));
        mTvLunarHoliday.setText(DateUtils.getLastedLunarHoliday());

        mIvLastMonth.setOnClickListener(this);
        mIvNextMonth.setOnClickListener(this);

        mRvMonthView.setLayoutManager(new GridLayoutManager(this, 7));
        mMonthViewAdapter = new MonthViewAdapter(this, mDayList);
        mRvMonthView.setAdapter(mMonthViewAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_last_month:
                mCalendar.add(Calendar.MONTH, -1);
                mDayList = DateUtils.getDaysOfMonth(mCalendar, mDayList);
                mMonthViewAdapter.notifyDataSetChanged();
                mTvYearAndMonth.setText(StrUtils.getFormatString(R.string.year_and_month_unit, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH) + 1));
                break;
            case R.id.iv_next_month:
                mCalendar.add(Calendar.MONTH, 1);
                mDayList = DateUtils.getDaysOfMonth(mCalendar, mDayList);
                mMonthViewAdapter.notifyDataSetChanged();
                mTvYearAndMonth.setText(StrUtils.getFormatString(R.string.year_and_month_unit, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH) + 1));
                break;
        }
    }
}
