package com.imalljoy.insights.greendao.bean;

import java.sql.Timestamp;

/**
 * Created by lijilong on 03/09.
 * 用户回答问卷表
 */

public class Answer {
    private long id;  //回答表id
    private long userId;  //回答人id
    private int type;  //回答人类型
    private long researchId;  //调研表id
    private long analystId;  //分析师id
    private String answer;  //答案(每题之间用;间隔 多选用,间隔)
    private int score;  //分析师给答题人打分
    private double reward;  //回答问题得到的奖励
    private double extraReward;  //得到额外的奖励(打赏)
    private Timestamp createTime;  //创建时间
    private Timestamp updateTime;  //更新时间

}
