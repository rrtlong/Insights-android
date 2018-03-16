package com.imalljoy.insights.entity;

import java.util.List;

/**
 * Created by lijilong on 03/16.
 * 调研报告
 */

public class ReportVo {
    private long id;        //调研报告的id
    private String name;        //调研报告名称
    private String content;     //调研报告内容
    private float grade;        //该报告的评分
    private List<String> evaluates;     //该报告收到的评价
    private double reward;      //该报告收到的打赏
    private double cost;        //查看报告需要的费用
    private UserVo user;        //分析师
    private RateVo rating;      //评级

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
                '}';
    }
}
