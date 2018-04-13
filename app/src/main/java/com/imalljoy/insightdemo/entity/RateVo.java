package com.imalljoy.insightdemo.entity;

import java.io.Serializable;

/**
 * Created by lijilong on 03/16.
 *评价
 */

public class RateVo implements Serializable{
    private int project;        //项目评分
    private int team;       //团队评分
    private int technology;     //技术评分
    private int business;   //业务评分
    private int capital;        //资金评分
    private int coin;       //代币评分
    private int law;        //法律评分
    private int influence;      //影响力评分
    private int userResearch;       //用户调查评分
    private int enterpriseInfo;      //企业问询
    private String projectIntro;    //项目评分描述
    private String teamIntro;
    private String technologyIntro;
    private String businessIntro;
    private String capitalIntro;
    private String coinIntro;
    private String lawIntro;
    private String influenceIntro;
    private String userResearchIntro;
    private String enterpriseInfoIntro;

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

    public int getEnterpriseInfo() {
        return enterpriseInfo;
    }

    public void setEnterpriseInfo(int enterpriseInfo) {
        this.enterpriseInfo = enterpriseInfo;
    }

    public String getProjectIntro() {
        return projectIntro;
    }

    public void setProjectIntro(String projectIntro) {
        this.projectIntro = projectIntro;
    }

    public String getTeamIntro() {
        return teamIntro;
    }

    public void setTeamIntro(String teamIntro) {
        this.teamIntro = teamIntro;
    }

    public String getTechnologyIntro() {
        return technologyIntro;
    }

    public void setTechnologyIntro(String technologyIntro) {
        this.technologyIntro = technologyIntro;
    }

    public String getBusinessIntro() {
        return businessIntro;
    }

    public void setBusinessIntro(String businessIntro) {
        this.businessIntro = businessIntro;
    }

    public String getCapitalIntro() {
        return capitalIntro;
    }

    public void setCapitalIntro(String capitalIntro) {
        this.capitalIntro = capitalIntro;
    }

    public String getCoinIntro() {
        return coinIntro;
    }

    public void setCoinIntro(String coinIntro) {
        this.coinIntro = coinIntro;
    }

    public String getLawIntro() {
        return lawIntro;
    }

    public void setLawIntro(String lawIntro) {
        this.lawIntro = lawIntro;
    }

    public String getInfluenceIntro() {
        return influenceIntro;
    }

    public void setInfluenceIntro(String influenceIntro) {
        this.influenceIntro = influenceIntro;
    }

    public String getUserResearchIntro() {
        return userResearchIntro;
    }

    public void setUserResearchIntro(String userResearchIntro) {
        this.userResearchIntro = userResearchIntro;
    }

    public String getEnterpriseInfoIntro() {
        return enterpriseInfoIntro;
    }

    public void setEnterpriseInfoIntro(String enterpriseInfoIntro) {
        this.enterpriseInfoIntro = enterpriseInfoIntro;
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
                ", enterpriseInfo=" + enterpriseInfo +
                ", projectIntro='" + projectIntro + '\'' +
                ", teamIntro='" + teamIntro + '\'' +
                ", technologyIntro='" + technologyIntro + '\'' +
                ", businessIntro='" + businessIntro + '\'' +
                ", capitalIntro='" + capitalIntro + '\'' +
                ", coinIntro='" + coinIntro + '\'' +
                ", lawIntro='" + lawIntro + '\'' +
                ", influenceIntro='" + influenceIntro + '\'' +
                ", userResearchIntro='" + userResearchIntro + '\'' +
                ", enterpriseInfoIntro='" + enterpriseInfoIntro + '\'' +
                '}';
    }
}
