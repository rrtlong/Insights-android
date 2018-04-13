package com.imalljoy.insightdemo.entity;

import java.sql.Timestamp;

/**
 * Created by lijilong on 04/11.
 * 分析师-》直播模块，实体类
 */

public class LiveVo {
    private UserVo userVo;
    private String title;
    private Timestamp startTime;
    private Timestamp endTime;
    private int type;

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
