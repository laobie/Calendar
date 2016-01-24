package com.jaeger.calendar.base;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Jaeger on 15/9/15.
 * ListenRain
 */
public class BaseActivity extends AbstractBaseActivity implements View.OnClickListener {

    protected String TAG = this.getClass().getSimpleName();

    @Override
    protected void initIntentParam(Intent intent) {

    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setViewStatus() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    protected void showBack() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {
    }

    public final String getStr(int strId) {
        return getResources().getString(strId);
    }
}
