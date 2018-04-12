package com.imalljoy.insights.entity;

import java.sql.Timestamp;

/**
 * Created by lijilong on 04/11.
 * 新闻评级实体
 */

public class NewRateVo {
    private String name;
    private String cover;
    private String title;
    private Timestamp publishTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }
}
