package com.imalljoy.insights.bus;

/**
 * Created by lijilong on 03/18.
 */

public class EditReturnData {
    public static int COIN_RATING = 0;
    public static int PROJECT =1;
    public static int TEAM =2;
    public static int TECHNOLOGY = 3;
    public static int BUSINESS = 4;
    public static int CAPITAL = 5;
    public static int COIN = 6;
    public static int LAW = 7;
    public static int INFLUENCE = 8;
    public static int USERRESEARCH = 9;
    public static int ENTERPRISEINFO = 10;
    public static int EDIT_COIN_LEVEL = 11;
    private int flag;
    private int score;
    private String scoreIntro;

    public EditReturnData(int flag, int score, String scoreIntro) {
        this.flag = flag;
        this.score = score;
        this.scoreIntro = scoreIntro;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int index) {
        this.flag = index;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getScoreIntro() {
        return scoreIntro;
    }

    public void setScoreIntro(String scoreIntro) {
        this.scoreIntro = scoreIntro;
    }

    @Override
    public String toString() {
        return "EditReturnData{" +
                "flag=" + flag +
                ", score=" + score +
                ", scoreIntro='" + scoreIntro + '\'' +
                '}';
    }
}
