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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends BaseActivity {
    private Day mToday;
    private TextView mTvDay;
    private TextView mTvLunar;
    private TextView mTvYear;
    private TextView mTvMonth;
    private TextView mTvWeek;
    private RecyclerView mRvMonthView;
    private Calendar mCalendar;
    private List<Day> mDayList;
    private MonthViewAdapter mMonthViewAdapter;

    private ImageView mIvLastMonth;
    private TextView mTvYearAndMonth;
    private ImageView mIvNextMonth;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        mTvYear = (TextView) findViewById(R.id.tv_year);
        mTvMonth = (TextView) findViewById(R.id.tv_month);
        mTvWeek = (TextView) findViewById(R.id.tv_week);
        mTvDay = (TextView) findViewById(R.id.tv_day);
        mTvLunar = (TextView) findViewById(R.id.tv_lunar);
        mRvMonthView = (RecyclerView) findViewById(R.id.rv_month_view);
        mIvLastMonth = (ImageView) findViewById(R.id.iv_last_month);
        mTvYearAndMonth = (TextView) findViewById(R.id.tv_year_and_month);
        mIvNextMonth = (ImageView) findViewById(R.id.iv_next_month);

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
        mTvLunar.setText(mToday.getLunarDayMD());
        mTvYearAndMonth.setText(mCalendar.get(Calendar.YEAR) + "年" + " " + (mCalendar.get(Calendar.MONTH) + 1) + "月");
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
                mTvYearAndMonth.setText(mCalendar.get(Calendar.YEAR) + "年" + " " + (mCalendar.get(Calendar.MONTH) + 1) + "月");
                break;
            case R.id.iv_next_month:
                mCalendar.add(Calendar.MONTH, 1);
                mDayList = DateUtils.getDaysOfMonth(mCalendar, mDayList);
                mMonthViewAdapter.notifyDataSetChanged();
                mTvYearAndMonth.setText(mCalendar.get(Calendar.YEAR) + "年" + " " + (mCalendar.get(Calendar.MONTH) + 1) + "月");
                break;
        }
    }
}
