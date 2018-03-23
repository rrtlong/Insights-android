package com.imalljoy.insights.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lijilong on 03/16.
 * 问题
 */

public class QuestionVo implements Serializable {
    private long id;        //问题id
    private String name;        //问题名称
    private int type;       //问题类型;如单选,多选,填空
    private boolean isNecessary;        //是否必答
    private List<String> options;       //选项
    private String text;        //填空题答案
    private String answer;      //回答;自己根据类型解析,多选用,隔开

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isNecessary() {
        return isNecessary;
    }

    public void setNecessary(boolean necessary) {
        isNecessary = necessary;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", isNecessary=" + isNecessary +
                ", options=" + options +
                ", text='" + text + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
