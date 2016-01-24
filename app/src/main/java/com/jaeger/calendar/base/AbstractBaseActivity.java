package com.jaeger.calendar.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class AbstractBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initIntentParam(getIntent());
        beforeInitView();
        super.onCreate(savedInstanceState);
        initView();
        setViewStatus();
    }

    // 初始化传入的参数
    protected abstract void initIntentParam(Intent intent);

    // 加载View之前的处理事件
    protected abstract void beforeInitView();

    // 加载视图
    protected abstract void initView();

    // 设置View状态，包含事件监听
    protected abstract void setViewStatus();

}
