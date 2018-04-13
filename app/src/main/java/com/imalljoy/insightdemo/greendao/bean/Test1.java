package com.imalljoy.insightdemo.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lijilong on 03/08.
 */
@Entity
public class Test1 {
    @Id
    private long id;
    private String name;
    @Generated(hash = 1189026895)
    public Test1(long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 2050631462)
    public Test1() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
