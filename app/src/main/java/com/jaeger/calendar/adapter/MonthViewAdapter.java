package com.jaeger.calendar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaeger.calendar.R;
import com.jaeger.calendar.base.BaseRecyclerAdapter;
import com.jaeger.calendar.entity.Day;

import java.util.List;

/**
 * Created by Jaeger on 16/1/24.
 * Calendar
 */
public class MonthViewAdapter extends BaseRecyclerAdapter<Day> {

    public MonthViewAdapter(Context context, List<Day> list) {
        super(context, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DayViewHolder(mInflater.inflate(R.layout.item_day, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DayViewHolder viewHolder = (DayViewHolder) holder;
        Day day = mList.get(position);
        if (day != null) {
            viewHolder.mTvDay.setText(day.getDayStr());
            viewHolder.mTvLunarDay.setText(day.getLunarDay());
        } else {
            viewHolder.mTvDay.setText(null);
            viewHolder.mTvLunarDay.setText(null);
        }
    }

    private class DayViewHolder extends BaseViewHolder {
        private TextView mTvDay;
        private TextView mTvLunarDay;

        public DayViewHolder(View itemView) {
            super(itemView);
            mTvDay = (TextView) itemView.findViewById(R.id.tv_day);
            mTvLunarDay = (TextView) itemView.findViewById(R.id.tv_lunar_day);
        }
    }
}
