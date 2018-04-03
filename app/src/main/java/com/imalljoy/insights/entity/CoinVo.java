package com.imalljoy.insights.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by lijilong on 03/16.
 */

public class CoinVo implements Serializable {
    private long id;        //数币id
    private String name;        //数币名称
    private String logoUrl;     //logo地址
    private String websiteUrl;      //官方网站
    private Timestamp icoTime;      //ico时间2017年08月08日
    private Timestamp onlineExchangeTime;       //上线交易时间2017年10月20日
    private String onlineExchange;      //上线交易所:OKEX
    private String location;        //所在国家  新加坡
    private String telegraphGroup;   //电报群:15000人
    private String twitterFans;     //Twitter粉丝:18000人

    private String intro;       //数币企业介绍
    private List<String> exchanges;     //数币所在的交易所
    private float price;        //数币的价格,根据交易所变化
    private float exchangeRate; //汇率 如该币兑换比特币的汇率
    private String forCoin;     //能和该币兑换的币名称
    private double marketValue;  //数币的总市值,根据交易所变化
    private float range;   //涨幅，跌幅；比例 +1.24%
    private float rangeRate;    //涨幅值，+2300
    private RateVo rating;      //评分，不是单一报告决定的
    private int rank;       //排名
    private String shortName;   //简称
    private int type;   //0:空投   1:新上  2:即将ico  3:正在ico  4:ico结束 5：币市
    private Timestamp icoEndTime;   //ico结束时间
    private int roni;   //roni指数
    private float bsri; //bsri指数
    private String level;   //评级A
    private int airDropNum;     //空投个数


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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Timestamp getIcoTime() {
        return icoTime;
    }

    public void setIcoTime(Timestamp icoTime) {
        this.icoTime = icoTime;
    }

    public Timestamp getOnlineExchangeTime() {
        return onlineExchangeTime;
    }

    public void setOnlineExchangeTime(Timestamp onlineExchangeTime) {
        this.onlineExchangeTime = onlineExchangeTime;
    }

    public String getOnlineExchange() {
        return onlineExchange;
    }

    public void setOnlineExchange(String onlineExchange) {
        this.onlineExchange = onlineExchange;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTelegraphGroup() {
        return telegraphGroup;
    }

    public void setTelegraphGroup(String telegraphGroup) {
        this.telegraphGroup = telegraphGroup;
    }

    public String getTwitterFans() {
        return twitterFans;
    }

    public void setTwitterFans(String twitterFans) {
        this.twitterFans = twitterFans;
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

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getType() {
        return type;
    }

    /**
     *
     * @param type 0:空投   1:新上  2:即将ico  3:正在ico  4:ico结束 5：币市
     */
    public void setType(int type) {
        this.type = type;
    }

    public Timestamp getIcoEndTime() {
        return icoEndTime;
    }

    public void setIcoEndTime(Timestamp icoEndTime) {
        this.icoEndTime = icoEndTime;
    }

    public int getRoni() {
        return roni;
    }

    public void setRoni(int roni) {
        this.roni = roni;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAirDropNum() {
        return airDropNum;
    }

    public void setAirDropNum(int airDropNum) {
        this.airDropNum = airDropNum;
    }

    public float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getForCoin() {
        return forCoin;
    }

    public void setForCoin(String forCoin) {
        this.forCoin = forCoin;
    }

    public float getRangeRate() {
        return rangeRate;
    }

    public void setRangeRate(float rangeRate) {
        this.rangeRate = rangeRate;
    }

    public float getBsri() {
        return bsri;
    }

    public void setBsri(float bsri) {
        this.bsri = bsri;
    }

    @Override
    public String toString() {
        return "CoinVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", icoTime=" + icoTime +
                ", onlineExchangeTime=" + onlineExchangeTime +
                ", onlineExchange='" + onlineExchange + '\'' +
                ", location='" + location + '\'' +
                ", telegraphGroup='" + telegraphGroup + '\'' +
                ", twitterFans='" + twitterFans + '\'' +
                ", intro='" + intro + '\'' +
                ", exchanges=" + exchanges +
                ", price=" + price +
                ", marketValue=" + marketValue +
                ", rating=" + rating +
                ", rank=" + rank +
                '}';
    }
}
