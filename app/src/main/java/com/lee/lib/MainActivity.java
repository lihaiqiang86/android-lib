package com.lee.lib;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lee.lib.common.LeeLog;

public class MainActivity extends AppCompatActivity {

    private final LeeLog LOGGER = LeeLog.getLogger(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LOGGER.info("onCreate");
        setContentView(R.layout.activity_main);
    }
}
