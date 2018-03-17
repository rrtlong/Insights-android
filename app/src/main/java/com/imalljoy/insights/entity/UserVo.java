package com.imalljoy.insights.entity;

import com.imalljoy.insights.greendao.bean.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijilong on 03/16.
 */

public class UserVo {
    private long userId;        //用户id
    private String name;        //用户名称
    private String headPic;
    private int gender;     //性别;0:未知,1:男,2:女
    private String password;        //用户密码
    private int actor;      //用户角色,如企业/媒体/分析师/投资者/数币
    private int certification;      //是否认证
    private double coinNumber;      //IN币数量
    private double reward;      //收到的打赏,企业给分析师的打赏
    private List<RequestVo> requests;       //请求的调查任务
    private List<RequestVo> accepRequests;      //接受的调查任务
    private List<QuestionVo> questions;     //发布过的调查问卷
    private List<QuestionVo> accepQuestions;        //参与过的调查问卷

    public void addRequest(RequestVo vo, boolean isOwnRequest){
        if(isOwnRequest){
            if(requests ==null){
                requests = new ArrayList<>();
            }
            requests.add(vo);
        }else{
            if(accepRequests == null){
                accepRequests = new ArrayList<>();
            }
            accepRequests.add(vo);
        }
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActor() {
        return actor;
    }

    public void setActor(int actor) {
        this.actor = actor;
    }

    public int getCertification() {
        return certification;
    }

    public void setCertification(int certification) {
        this.certification = certification;
    }

    public double getCoinNumber() {
        return coinNumber;
    }

    public void setCoinNumber(double coinNumber) {
        this.coinNumber = coinNumber;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public List<RequestVo> getRequests() {
        if(requests == null){
            requests = new ArrayList<>();
        }
        return requests;
    }

    public void setRequests(List<RequestVo> requests) {
        this.requests = requests;
    }

    public List<RequestVo> getAccepRequests() {
        if(accepRequests == null)
            accepRequests = new ArrayList<>();
        return accepRequests;
    }

    public void setAccepRequests(List<RequestVo> accepRequests) {
        this.accepRequests = accepRequests;
    }

    public List<QuestionVo> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionVo> questions) {
        this.questions = questions;
    }

    public List<QuestionVo> getAccepQuestions() {
        return accepQuestions;
    }

    public void setAccepQuestions(List<QuestionVo> accepQuestions) {
        this.accepQuestions = accepQuestions;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", headPic='" + headPic + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", actor=" + actor +
                ", certification=" + certification +
                ", coinNumber=" + coinNumber +
                ", reward=" + reward +
                ", requests=" + requests +
                ", accepRequests=" + accepRequests +
                ", questions=" + questions +
                ", accepQuestions=" + accepQuestions +
                '}';
    }
}
