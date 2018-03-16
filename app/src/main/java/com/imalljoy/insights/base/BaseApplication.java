package com.imalljoy.insights.base;

import android.app.Application;

import com.imalljoy.insights.greendao.DatabaseManager;
import com.orhanobut.hawk.Hawk;

/**
 * Created by lijilong on 03/07.
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
        DatabaseManager.init(this);
    }
}
