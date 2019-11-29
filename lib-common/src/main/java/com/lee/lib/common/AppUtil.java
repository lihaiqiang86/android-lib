package com.lee.lib.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.security.MessageDigest;

/**
 * @author lihaiqiang
 * @since 2019/11/29
 */
public class AppUtil {

    private static final String TAG = "AppUtil";

    public static boolean isInstalled(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(packageName, PackageManager.GET_CONFIGURATIONS);
            return packageInfo != null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.i(TAG, "Check app installed or not: not, package=" + packageName);
        }
        return false;
    }

    public static int getVersionCode(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(packageName, PackageManager.GET_CONFIGURATIONS);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Get version code error: package=" + packageName, e);
        }
        return -1;
    }

    public static String getVersionName(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(packageName, PackageManager.GET_CONFIGURATIONS);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Get version name error: package=" + packageName, e);
        }
        return null;
    }

    public static long getFirstInstallTime(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(packageName, 0);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Get first install time error: package=" + packageName, e);
        }
        return 0;
    }

    public static long getLastUpdateTime(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(packageName, PackageManager.GET_CONFIGURATIONS);
            if (packageInfo != null) {
                return packageInfo.lastUpdateTime;
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Get last update time error: package=" + packageName, e);
        }
        return 0;
    }

    public static String getSignatureMD5(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return getMessageDigest("MD5", packageInfo.signatures[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Get signature md5 error: package=" + packageName, e);
        }
        return null;
    }

    public static String getSignatureSHA1(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return getMessageDigest("SHA-1", packageInfo.signatures[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Get signature SHA1 error: package=" + packageName, e);
        }
        return null;
    }

    public static String getSignatureSHA256(Context context, String packageName) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return getMessageDigest("SHA-256", packageInfo.signatures[0].toByteArray());
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Get signature SHA256 error: package=" + packageName, e);
        }
        return null;
    }

    private static String getMessageDigest(String algorithm, byte[] bytes) {
        char[] arrayOfChar1 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance(algorithm);
            localMessageDigest.update(bytes);
            byte[] arrayOfByte = localMessageDigest.digest();
            int i = arrayOfByte.length;
            char[] arrayOfChar2 = new char[i * 2];
            int j = 0;
            int k = 0;
            while (true) {
                if (j >= i) return new String(arrayOfChar2);
                int m = arrayOfByte[j];
                int n = k + 1;
                arrayOfChar2[k] = arrayOfChar1[(0xF & m >>> 4)];
                k = n + 1;
                arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
                j++;
            }
        } catch (Exception e) {
            Log.e(TAG, "Get message digest error: algorithm=" + algorithm, e);
        }
        return null;
    }

    public static void startApp(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
            context.startActivity(intent);
            Log.i(TAG, "Start app: start, package=" + packageName);
        } else {
            Log.w(TAG, "Start app: no launcher activity, package=" + packageName);
        }
    }

    public static void startApp(Context context, String packageName, String className) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(packageName, className));
        context.startActivity(intent);
    }
}
