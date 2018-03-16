package com.imalljoy.insights.entity;

/**
 * Created by lijilong on 03/16.
 *评价
 */

public class RateVo {
    private int project;        //项目评分
    private int team;       //团队评分
    private int technology;     //技术评分
    private int business;   //业务评分
    private int capital;        //资金评分
    private int coin;       //代币评分
    private int law;        //法律评分
    private int influence;      //影响力评分
    private int userResearch;       //用户调查评分

    public RateVo(int project, int team, int technology, int business, int capital, int coin, int law, int influence, int userResearch) {
        this.project = project;
        this.team = team;
        this.technology = technology;
        this.business = business;
        this.capital = capital;
        this.coin = coin;
        this.law = law;
        this.influence = influence;
        this.userResearch = userResearch;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getTechnology() {
        return technology;
    }

    public void setTechnology(int technology) {
        this.technology = technology;
    }

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getLaw() {
        return law;
    }

    public void setLaw(int law) {
        this.law = law;
    }

    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    public int getUserResearch() {
        return userResearch;
    }

    public void setUserResearch(int userResearch) {
        this.userResearch = userResearch;
    }

    @Override
    public String toString() {
        return "RateVo{" +
                "project=" + project +
                ", team=" + team +
                ", technology=" + technology +
                ", business=" + business +
                ", capital=" + capital +
                ", coin=" + coin +
                ", law=" + law +
                ", influence=" + influence +
                ", userResearch=" + userResearch +
                '}';
    }
}
