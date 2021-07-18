package com.wyc.gif;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * 作者： wyc
 * <p>
 * 创建时间： 2020/11/30 16:18
 * <p>
 * 文件名字： com.wyc.gif
 * <p>
 * 类的介绍：
 */
public class App extends Application {
    @SuppressLint("StaticFieldLeak")
    private static App sInstance;
    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sContext = this.getApplicationContext();
    }

    public static App getInstance() {
        return sInstance;
    }

    public static Context getContext() {
        return sContext;
    }
}
