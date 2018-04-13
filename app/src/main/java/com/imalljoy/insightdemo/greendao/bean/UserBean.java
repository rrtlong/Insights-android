package com.imalljoy.insightdemo.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lijilong on 03/08.
 */
@Entity
public class UserBean {
    @Id
    private Long id;
    @NotNull
    private String name;


    @Generated(hash = 674618593)
    public UserBean(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }


    @Generated(hash = 1203313951)
    public UserBean() {
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }
}