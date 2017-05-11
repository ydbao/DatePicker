package com.xiong.datepicker.activity;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {

    public static BaseActivity instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        instance = this;
    }

    public static BaseActivity getInstance() {
        return instance;
    }
}

