package com.imalljoy.insights.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by lijilong on 03/16.
 */

public class RequestVo implements Serializable{
    private Long id;        //请求的id
    private String name;    //请求的名称
    private double reward;  //完成该请求后的奖励
    private int platform;   //发起平台,如企业发起,平台发起
    private String demand;  //分析的需求
    private Timestamp startTime;  //请求有效期开始时间
    private Timestamp endTime;      //请求有效期结束时间
    private int status;     //状态,如:待接收,已被接受,已完成
    private UserVo user;        //发起请求的用户
    private CoinVo coin;    //数币名
    private UserVo acceptUser; //接受请求的用户
    private ReportVo reportVo;  //针对请求的报告


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public CoinVo getCoin() {
        return coin;
    }

    public void setCoin(CoinVo coin) {
        this.coin = coin;
    }

    public UserVo getAcceptUser() {
        return acceptUser;
    }

    public void setAcceptUser(UserVo acceptUser) {
        this.acceptUser = acceptUser;
    }

    public ReportVo getReportVo() {
        return reportVo;
    }

    public void setReportVo(ReportVo reportVo) {
        this.reportVo = reportVo;
    }

    @Override
    public String toString() {
        return "RequestVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reward=" + reward +
                ", platform=" + platform +
                ", demand='" + demand + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", user=" + user +
                ", coin=" + coin +
                ", acceptUser=" + acceptUser +
                '}';
    }
}
