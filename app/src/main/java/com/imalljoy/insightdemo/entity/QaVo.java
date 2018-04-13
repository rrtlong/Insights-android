package com.imalljoy.insightdemo.entity;

/**
 * Created by lijilong on 04/11.
 * 提问与回答实体QA
 */

public class QaVo {
    private UserVo launchUser;
    private String publishTime;
    private String qContent;
    private String aContent;
    private String replyName;
    private String replyContent;
    private boolean isAnser;

    public UserVo getLaunchUser() {
        return launchUser;
    }

    public void setLaunchUser(UserVo launchUser) {
        this.launchUser = launchUser;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getqContent() {
        return qContent;
    }

    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

    public String getaContent() {
        return aContent;
    }

    public void setaContent(String aContent) {
        this.aContent = aContent;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public boolean isAnser() {
        return isAnser;
    }

    public void setAnser(boolean anser) {
        isAnser = anser;
    }
}
