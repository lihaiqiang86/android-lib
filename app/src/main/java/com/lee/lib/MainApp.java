package com.lee.lib;

import android.app.Application;

import com.lee.lib.common.LeeLog;

/**
 * @author lihaiqiang
 * @since 2019/11/25
 */
public class MainApp extends Application {

    private final LeeLog LOGGER = LeeLog.getLogger(MainApp.class);

    @Override
    public void onCreate() {
        super.onCreate();
        LOGGER.debug("onCreate-debug-1");
        LOGGER.info("onCreate-info");
        LOGGER.warn("onCreate-warn");
        LOGGER.error("onCreate-error");
        LeeLog.init("TEST-LEE-LOG", LeeLog.DEBUG);
        LOGGER.debug("onCreate-debug-2");
    }
}
