package com.imalljoy.insightdemo.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.imalljoy.insightdemo.greendao.gen.DaoMaster;
import com.imalljoy.insightdemo.greendao.gen.Test1Dao;
import com.imalljoy.insightdemo.greendao.gen.UserBeanDao;

/**
 * Created by lijilong on 03/08.
 */

public class MySQLiteOpenHelper extends DaoMaster.DevOpenHelper {
    public static final String DBNAME = "insighs.db";

    public MySQLiteOpenHelper(Context context){
        super(context, DBNAME);
    }

    public MySQLiteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //用于更新数据库
        Log.e("SQLHelper","oldVersion=" + oldVersion + ",newVersion=" + newVersion);
        if(newVersion ==5){
            MigrationHelper.migrate(db, UserBeanDao.class, Test1Dao.class);
        }
    }


}
