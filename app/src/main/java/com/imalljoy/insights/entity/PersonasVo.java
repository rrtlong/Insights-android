package com.imalljoy.insights.entity;

import java.io.Serializable;

/**
 * Created by lijilong on 03/16.
 */

public class PersonasVo implements Serializable{
    private int age;        //年龄
    private int gender;     //性别
    private String area;    //地域
    public PersonasVo(){}


    public PersonasVo(int age, int gender, String area) {
        this.age = age;
        this.gender = gender;
        this.area = area;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "PersonasVo{" +
                "age=" + age +
                ", gender=" + gender +
                ", area='" + area + '\'' +
                '}';
    }
}
