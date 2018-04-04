package com.imalljoy.insights.entity;

import com.imalljoy.insights.greendao.bean.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijilong on 03/16.
 */

public class UserVo implements Serializable{
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
    private List<QuestionnaireVo> questionnaires;     //发布过的调查问卷
    private List<QuestionnaireVo> acceptQuestionnaires;        //参与过的调查问卷

    /**
     *
     * @param vo    请求实体
     * @param isBuildRequest  是否是自己新建请求,还是接受请求
     */
    public void addRequest(RequestVo vo, boolean isBuildRequest){
        if(isBuildRequest){
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


    public List<QuestionnaireVo> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<QuestionnaireVo> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public List<QuestionnaireVo> getAcceptQuestionnaires() {
        return acceptQuestionnaires;
    }

    public void setAcceptQuestionnaires(List<QuestionnaireVo> acceptQuestionnaires) {
        this.acceptQuestionnaires = acceptQuestionnaires;
    }
}
