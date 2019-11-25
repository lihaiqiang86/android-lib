package com.lee.lib.common;

import android.util.Log;

/**
 * @author lihaiqiang
 * @since 2019/11/25
 */
public class LeeLog {

    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;

    private static String APP_TAG = "LEE-LOG";
    /**
     * 默认日志级别
     */
    private static int LEVEL = INFO;

    private String clsTag;

    public static void init(String appTag, int level) {
        APP_TAG = appTag;
        LEVEL = level;
    }

    public static LeeLog getLogger(Class cls) {
        return getLogger(cls.getSimpleName());
    }

    public static LeeLog getLogger(String clsTag) {
        return new LeeLog(clsTag);
    }

    private LeeLog(String clsTag) {
        this.clsTag = clsTag;
    }

    public void debug(String msg) {
        if (DEBUG >= LEVEL) {
            Log.d(getTag(), msg);
        }
    }

    public void info(String msg) {
        if (INFO >= LEVEL) {
            Log.i(getTag(), msg);
        }
    }

    public void warn(String msg) {
        if (WARN >= LEVEL) {
            Log.w(getTag(), msg);
        }
    }

    public void error(String msg) {
        if (ERROR >= LEVEL) {
            Log.e(getTag(), msg);
        }
    }

    public void error(String msg, Throwable throwable) {
        if (ERROR >= LEVEL) {
            Log.e(getTag(), msg, throwable);
        }
    }

    private String getTag() {
        return Thread.currentThread().getName() + " " + APP_TAG + ":" + clsTag;
    }
}
