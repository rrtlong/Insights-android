package com.imalljoy.insights.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijilong on 03/16.
 * 问卷
 */

public class QuestionnaireVo implements Serializable{
    private long id;        //问卷的id
    private long reportId;  //报告id
    private int type;       //问卷类型；0:个人 1:企业
    private String name;        //问卷的名称
    private String content;     //问卷的描述
    private double reward;      //完成该问卷的IN币奖励
    private List<QuestionVo> questions;       //问卷的问题
    private PersonasVo personas;      //接受问卷人的用户画像
    private int status;     //问卷状态;如0:创建中/1:运行中/2:已结束/3:已完成
    private Timestamp startTime;        //发布时间
    private Timestamp endTime;      //结束时间
    private UserVo userVo;      //发起人
    private int totalNumber;        //总份数
    private int finishedNumber;     //完成的份数
    private List<UserVo> answerUserList;    //回答问题了的用户列表

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public List<QuestionVo> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionVo> questions) {
        this.questions = questions;
    }

    public PersonasVo getPersonas() {
        return personas;
    }

    public void setPersonas(PersonasVo personas) {
        this.personas = personas;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getFinishedNumber() {
        return finishedNumber;
    }

    public void setFinishedNumber(int finishedNumber) {
        this.finishedNumber = finishedNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<UserVo> getAnswerUserList() {
        if(answerUserList == null){
            answerUserList = new ArrayList<>();
        }
        return answerUserList;
    }

    public void setAnswerUserList(List<UserVo> answerUserList) {
        this.answerUserList = answerUserList;
    }

    @Override
    public String toString() {
        return "QuestionnaireVo{" +
                "id=" + id +
                ", reportId=" + reportId +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", reward=" + reward +
                ", questions=" + questions +
                ", personas=" + personas +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", userVo=" + userVo +
                ", totalNumber=" + totalNumber +
                ", finishedNumber=" + finishedNumber +
                ", answerUserList=" + answerUserList +
                '}';
    }
}
