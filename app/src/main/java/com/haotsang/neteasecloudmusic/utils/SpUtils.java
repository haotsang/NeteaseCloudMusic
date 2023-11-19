package com.haotsang.neteasecloudmusic.utils;


import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {
    private static final int MODE = Context.MODE_PRIVATE;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    // 初始化SharedPreferences
    private static void init(Context context) {
        if (preferences == null) {
            preferences = context.getSharedPreferences(context.getPackageName(), MODE);
            editor = preferences.edit();
        }
    }

    // 存储String类型数据
    public static void putString(Context context, String key, String value) {
        init(context);
        editor.putString(key, value).apply();
    }

    // 获取String类型数据
    public static String getString(Context context, String key, String defaultValue) {
        init(context);
        return preferences.getString(key, defaultValue);
    }

    // 存储Int类型数据
    public static void putInt(Context context, String key, int value) {
        init(context);
        editor.putInt(key, value).apply();
    }

    // 获取Int类型数据
    public static int getInt(Context context, String key, int defaultValue) {
        init(context);
        return preferences.getInt(key, defaultValue);
    }

    // 存储Boolean类型数据
    public static void putBoolean(Context context, String key, boolean value) {
        init(context);
        editor.putBoolean(key, value).apply();
    }

    // 获取Boolean类型数据
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        init(context);
        return preferences.getBoolean(key, defaultValue);
    }

    // 存储Long类型数据
    public static void putLong(Context context, String key, long value) {
        init(context);
        editor.putLong(key, value).apply();
    }

    // 获取Long类型数据
    public static long getLong(Context context, String key, long defaultValue) {
        init(context);
        return preferences.getLong(key, defaultValue);
    }

    // 移除某个键对应的值
    public static void remove(Context context, String key) {
        init(context);
        editor.remove(key).apply();
    }

    // 清空所有数据
    public static void clear(Context context) {
        init(context);
        editor.clear().apply();
    }
}