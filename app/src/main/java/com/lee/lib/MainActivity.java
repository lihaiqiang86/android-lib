package com.lee.lib;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lee.lib.common.AppUtil;
import com.lee.lib.common.DateUtil;
import com.lee.lib.common.LeeLog;

public class MainActivity extends AppCompatActivity {

    private final LeeLog LOGGER = LeeLog.getLogger(MainActivity.class);

    private static final String packageName = "com.aspire.jshdc.soft.terminal";
    private static final String className = "com.aspire.jshdc.soft.terminal.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LOGGER.info("onCreate");
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtil.startApp(MainActivity.this, packageName, className);
            }
        });

        testAppUtil();
    }

    private void testAppUtil() {
        LOGGER.info("isInstalled: " + AppUtil.isInstalled(this, packageName));
        LOGGER.info("getVersionCode: " + AppUtil.getVersionCode(this, packageName));
        LOGGER.info("getVersionName: " + AppUtil.getVersionName(this, packageName));
        LOGGER.info("getFirstInstallTime: " + DateUtil.formatDateTime(AppUtil.getFirstInstallTime(this, packageName)));
        LOGGER.info("getLastUpdateTime: " + DateUtil.formatDateTime(AppUtil.getLastUpdateTime(this, packageName)));
        LOGGER.info("getSignatureMD5: " + AppUtil.getSignatureMD5(this, packageName));
        LOGGER.info("getSignatureSHA1: " + AppUtil.getSignatureSHA1(this, packageName));
        LOGGER.info("getSignatureSHA256: " + AppUtil.getSignatureSHA256(this, packageName));
    }
}
