package com.imalljoy.insights.entity;

/**
 * Created by lijilong on 03/16.
 */

public class ExchangeVo {
    private long id;        //交易所id
    private String name;        //交易所名称

    public ExchangeVo(long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "ExchangeVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
