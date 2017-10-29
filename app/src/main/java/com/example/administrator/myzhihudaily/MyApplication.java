package com.example.administrator.myzhihudaily;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.Toolbar;

/**
 * Created by Administrator on 2017/10/21 0021.
 */

public class MyApplication extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
