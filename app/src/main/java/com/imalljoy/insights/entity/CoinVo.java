package com.imalljoy.insights.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lijilong on 03/16.
 */

public class CoinVo implements Serializable {
    private long id;        //数币id
    private String name;        //数币名称
    private String intro;       //数币企业介绍
    private List<String> exchanges;     //数币所在的交易所
    private float price;        //数币的价格,根据交易所变化
    private double marketValue;  //数币的总市值,根据交易所变化
    private RateVo rating;      //评分
    private int rank;       //排名

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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<String> getExchanges() {
        return exchanges;
    }

    public void setExchanges(List<String> exchanges) {
        this.exchanges = exchanges;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public RateVo getRating() {
        return rating;
    }

    public void setRating(RateVo rating) {
        this.rating = rating;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "CoinVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", exchanges=" + exchanges +
                ", price=" + price +
                ", marketValue=" + marketValue +
                ", rating=" + rating +
                ", rank=" + rank +
                '}';
    }
}
