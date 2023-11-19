package com.haotsang.neteasecloudmusic;

import android.app.Application;

import com.haotsang.neteasecloudmusic.utils.ContextUtil;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ContextUtil.init(this);

    }
}
