package com.imalljoy.insightdemo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijilong on 03/16.
 * 调研报告
 */

public class ReportVo implements Serializable {
    private long id;        //调研报告的id
    private String name;        //调研报告名称
    private String content;     //调研报告内容
    private float grade;        //该报告的评分
    private List<String> evaluates;     //该报告收到的评价
    private double reward;      //该报告收到的打赏
    private double cost;        //查看报告需要的费用
    private UserVo user;        //分析师
    private RateVo rating;      //评级
    private Timestamp publishTime;//报告发布日期
    private RequestVo request;    //报告对应的请求
    private int status;           //状态 0:新建报告 1未购买 2已购买
    private CoinVo coin;
    private String coinLevel;       //数币评级 如A+,A-,B+....
    private List<QuestionnaireVo> userResearchList;//用户调研问卷
    private List<QuestionnaireVo> enterpriseInfoList;//针对单一企业的调研问卷
    private int evalLevel;//评价等级
    private String platformIndex;//平台指数

    public List<QuestionnaireVo> getUserResearchList() {
        if (userResearchList == null)
            userResearchList = new ArrayList<>();
        return userResearchList;
    }

    public void setUserResearchList(List<QuestionnaireVo> userResearchList) {
        this.userResearchList = userResearchList;
    }

    public List<QuestionnaireVo> getEnterpriseInfoList() {
        if (enterpriseInfoList == null)
            enterpriseInfoList = new ArrayList<>();
        return enterpriseInfoList;
    }

    public void setEnterpriseInfoList(List<QuestionnaireVo> enterpriseInfoList) {
        this.enterpriseInfoList = enterpriseInfoList;
    }

    public void setCoinLevel(String coinLevel) {
        this.coinLevel = coinLevel;
    }

    public String getCoinLevel() {
        return coinLevel;
    }

    public void setCoin(CoinVo coinVo) {
        this.coin = coinVo;
    }

    public CoinVo getCoin() {
        if (coin == null) {
            coin = new CoinVo();
        }
        return coin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public List<String> getEvaluates() {
        return evaluates;
    }

    public void setEvaluates(List<String> evaluates) {
        this.evaluates = evaluates;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public RateVo getRating() {
        return rating;
    }

    public void setRating(RateVo rating) {
        this.rating = rating;
    }


    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public void setRequest(RequestVo vo) {
        this.request = vo;
    }

    public RequestVo getRequest() {
        if (request == null)
            request = new RequestVo();
        return request;
    }

    public int getEvalLevel() {
        return evalLevel;
    }

    public void setEvalLevel(int evalLevel) {
        this.evalLevel = evalLevel;
    }

    public String getPlatformIndex() {
        return platformIndex;
    }

    public void setPlatformIndex(String platformIndex) {
        this.platformIndex = platformIndex;
    }

    @Override
    public String toString() {
        return "ReportVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", grade=" + grade +
                ", evaluates=" + evaluates +
                ", reward=" + reward +
                ", cost=" + cost +
                ", user=" + user +
                ", rating=" + rating +
                ", publishTime=" + publishTime +
                ", request=" + request +
                ", status=" + status +
                ", coin=" + coin +
                ", coinLevel='" + coinLevel + '\'' +
                ", userResearchList=" + userResearchList +
                ", enterpriseInfoList=" + enterpriseInfoList +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReportVo vo = (ReportVo) obj;
        if (vo.getId() == this.id)
            return true;
        return false;

    }
}
