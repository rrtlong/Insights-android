package com.imalljoy.insights.entity;

import java.sql.Timestamp;

/**
 * Created by lijilong on 03/16.
 */

public class NewVo {
    private long id;        //新闻id
    private String name;        //新闻标题
    private String intro;       //新闻描述,小标题
    private String content;     //新闻内容
    private Timestamp publishTime;      //发布时间
    private long fromId;        //新闻发布者id
    private int type;       //新闻类型,如企业新闻/数币新闻/

    public NewVo(long id, String name, String intro, String content, Timestamp publishTime, long fromId, int type) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.content = content;
        this.publishTime = publishTime;
        this.fromId = fromId;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public long getFromId() {
        return fromId;
    }

    public void setFromId(long fromId) {
        this.fromId = fromId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NewVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", content='" + content + '\'' +
                ", publishTime=" + publishTime +
                ", fromId=" + fromId +
                ", type=" + type +
                '}';
    }
}
