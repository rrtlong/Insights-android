package com.imalljoy.insightdemo.greendao;

import android.content.Context;
import android.util.Log;

import com.imalljoy.insightdemo.greendao.bean.Test1;
import com.imalljoy.insightdemo.greendao.bean.UserBean;
import com.imalljoy.insightdemo.greendao.gen.DaoMaster;
import com.imalljoy.insightdemo.greendao.gen.DaoSession;
import com.imalljoy.insightdemo.utils.LogUtils;


import java.util.List;

/**
 * Created by lijilong on 03/08.
 * 数据库管理
 */

public class DatabaseManager {
    private static DatabaseManager instance = null;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    public DatabaseManager(Context context) {
    }

    //在Application中初始化,整个应用程序周期只最开始调用一次
    public static void init(Context context) {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                //第二次判断是否为空,多线程同时走到这里的时候,需要这样优化处理
                if (instance == null) {
                    instance = new DatabaseManager(context);
                    instance.getDaoSession(context);
                }
            }
        }
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            throw new RuntimeException("Must init in Applicatioin");
        }
        return instance;
    }

    public DaoMaster getDaoMaster(Context context) {
        if (daoMaster == null) {
            DaoMaster.DevOpenHelper helper = new MySQLiteOpenHelper(context);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

   public DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    public void addUser(UserBean userBean){
        if(daoSession != null){
            daoSession.getUserBeanDao().insert(userBean);
            List<UserBean> users = daoSession.getUserBeanDao().loadAll();
            if(users != null){
                LogUtils.e("dbManager",users.toString());
            }
        }else{
            Log.e("dbManager","daoSession is null");
        }

    }
/*   public void addCoinInfo(CoinInfo coinInfo){
        if(daoSession != null){
            daoSession.getCoinInfoDao().insert(coinInfo);
            List<CoinInfo> coinInfos = daoSession.getCoinInfoDao().loadAll();
            if(coinInfos != null){
                LogUtils.e("dbManager",coinInfos.toString());
            }
        }else{
            Log.e("dbManager","daoSession is null");
        }
    }*/

//    public void addOrder(OrderInfo orderInfo){
//        if(daoSession != null){
//            daoSession.getOrderInfoDao().insert(orderInfo);
//            List<OrderInfo> orderInfos = daoSession.getOrderInfoDao().loadAll();
//            if(orderInfos != null){
//                LogUtils.e("dbManager",orderInfos.toString());
//            }
//        }else{
//            Log.e("dbManager","daoSession is null");
//        }
//    }

   public void addTest1(Test1 test1){
        if(daoSession != null){
            daoSession.getTest1Dao().insert(test1);
            List<Test1> test1s = daoSession.getTest1Dao().loadAll();
            if(test1s != null){
                LogUtils.e("dbManager",test1s.toString());
            }
        }else{
            Log.e("dbManager","daoSession is null");
        }
    }
}
