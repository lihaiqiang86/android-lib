package com.lee.lib;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import com.lee.lib.common.LeeLog;

public class ProxyStartAppActivity extends Activity {

    private final LeeLog LOGGER = LeeLog.getLogger(ProxyStartAppActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LOGGER.info("onCreate: action=" + getIntent().getAction());
        setContentView(R.layout.activity_start_app);

        if (Intent.ACTION_VIEW.equals(getIntent().getAction())) {
            parseFromH5();
        }
    }

    private void parseFromH5() {
        Uri uri = getIntent().getData();
        String pkg = uri.getQueryParameter("pkg");
        String cls = uri.getQueryParameter("cls");
        LOGGER.info("params: pkg=" + pkg + ",cls=" + cls);

        startApp(pkg, cls);
    }

    private void startApp(String pkg, String cls) {
        if (!TextUtils.isEmpty(pkg) && !TextUtils.isEmpty(cls)) {

        } else if (!TextUtils.isEmpty(pkg)) {
            Intent intent = getPackageManager().getLaunchIntentForPackage(pkg);
            LOGGER.info("Start intent: " + intent);
            startActivity(intent);
            finish();
        }
    }
}

