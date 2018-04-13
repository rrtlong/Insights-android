package com.imalljoy.insightdemo.greendao.bean;

import java.sql.Timestamp;

/**
 * Created by lijilong on 03/09.
 * 问卷题目表
 */

public class Question {
    private long id;    //问题id
    private long researchId;  //调研表id;
    private int num;  //第几题序号
    private String requestionDes;  //问题描述
    private String option1;  //选项一
    private String option2;  //选项二
    private String option3;  //选项三
    private String option4;  //选项四
    private String option5;  //选项五
    private String option6;  //选项六
    private String option7;  //选项七
    private String option8;  //选项八
    private String answer;  //答案(多选用,号隔开)
    private int type;  //问题类型(单选,多选,投票)
    private Timestamp createTime;  //创建时间
    private Timestamp updateTime;  //更新时间
}
