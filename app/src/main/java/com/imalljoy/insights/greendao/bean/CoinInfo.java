package com.imalljoy.insights.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

import java.sql.Timestamp;

/**
 * Created by lijilong on 03/08.
 * 数币表
 */


public class CoinInfo {
    private long id;  //数币id
    private String name;  //名称
    private String companyIntroduce;  //企业介绍
    private int status;  //数币状态;0:未知 1:即将ICO 2:正在ICO 3:新上 4:未上市(ICO已完成但是没有上市) 4:已上市
    private float price;  //价格
    private long exchangeId;  //交易所id
    private String exchangeName;  //交易所名称
    private double totalMarketValue;  //总市值
    private float gains1h;  //1小时涨幅
    private float gains24h;  //24小时涨幅
    private double tradingVolume24h;  //24小时交易量
    private int rate;  //评级
    private float roni;  //roni指数
    private float roniDateType; //roni指数时间 1:10分钟  1:1小时  2:12小时  3:24小时  4:72小时
    private float bsri;  //bsri指数
    private Timestamp createTime;  //创建时间
    private Timestamp updateTime;  //更新时间





}
