package com.haotsang.neteasecloudmusic.utils;

import android.content.Context;

import com.haotsang.neteasecloudmusic.App;

public class ContextUtil {
    public static Context sContext;
    public static App sApplication;

    public static void init(App application) {
        ContextUtil.sApplication = application;
        sContext = application.getApplicationContext();
    }

}
