package com.imalljoy.insights.entity;

/**
 * Created by lijilong on 04/11.
 */

public class CommentVo {
    private UserVo launchUser;
    private String publishTime;
    private String content;
    private String replyName;
    private String replyContent;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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
}
