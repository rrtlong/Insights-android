package com.imalljoy.insightdemo.common;

import android.util.Log;

import com.imalljoy.insightdemo.entity.CoinVo;
import com.imalljoy.insightdemo.entity.PersonasVo;
import com.imalljoy.insightdemo.entity.QuestionVo;
import com.imalljoy.insightdemo.entity.QuestionnaireVo;
import com.imalljoy.insightdemo.entity.RateVo;
import com.imalljoy.insightdemo.entity.ReportVo;
import com.imalljoy.insightdemo.entity.RequestVo;
import com.imalljoy.insightdemo.entity.UserVo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by lijilong on 03/16.
 */

public class ConstantData {
    public static List<UserVo> userVos = new ArrayList<>();
    public static List<QuestionnaireVo> questionnaireVos = new ArrayList<>();
    public static List<RequestVo> requestVos = new ArrayList<>();
    public static List<ReportVo> reportVos = new ArrayList<>();
    public static List<CoinVo> optionalCoinVos1 = new ArrayList<>();
    public static List<CoinVo> optionalCoinVos2 = new ArrayList<>();
    public static List<CoinVo> optionalCoinVos3 = new ArrayList<>();
    public static List<CoinVo> currencyCoinVos = new ArrayList<>();
    public static List<CoinVo> icoCoinVos = new ArrayList<>();
    public static List<CoinVo> airdropCoinVos = new ArrayList<>();
    public static List<ReportVo> myReports = new ArrayList<>();

    public static UserVo mUserVo;
    public static int requestRequestCode = 0;
    public static int reportRequestCode = 1;
    public static int buildQuestionnaireRequestCode = 2;
    public static int myReportsActivityRequestCode = 3;

    static {
        UserVo userVo = new UserVo();
        userVo.setUserId(1l);
        userVo.setName("刘洋");
        userVo.setHeadPic("head10");
        userVo.setGender(0);
        userVo.setAnalytsLevel(2);
        userVo.setAnalytsStars(3);
        userVos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(2l);
        userVo.setName("王雪");
        userVo.setHeadPic("head9");
        userVo.setGender(1);
        userVo.setAnalytsLevel(1);
        userVo.setAnalytsStars(3);
        userVos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(3l);
        userVo.setName("汪洋");
        userVo.setHeadPic("head8");
        userVo.setGender(0);
        userVo.setAnalytsLevel(3);
        userVo.setAnalytsStars(5);
        userVos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(4l);
        userVo.setName("程聪");
        userVo.setHeadPic("head7");
        userVo.setGender(0);
        userVo.setAnalytsLevel(2);
        userVo.setAnalytsStars(2);
        userVos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(5l);
        userVo.setName("孟志伟");
        userVo.setHeadPic("head6");
        userVo.setGender(0);
        userVo.setAnalytsLevel(2);
        userVo.setAnalytsStars(4);
        userVos.add(userVo);

        mUserVo = userVos.get(new Random().nextInt(5));
        CoinVo coinVo = new CoinVo();
        coinVo.setId(1l);
        coinVo.setName("比特币");
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");

//        QuestionnaireVo questionnaireVo = new QuestionnaireVo();
//        questionnaireVo.setUserVo(userVos.get(new Random().nextInt(5)));
//        questionnaireVo.setId(1l);
//        questionnaireVo.setName("你最爱吃什么");
//        questionnaireVo.setContent("描述描述秒速描述描述秒速描述描述秒速描述描述秒速");
//        questionnaireVo.setTotalNumber(100);
//        questionnaireVo.setReward(100);
//        questionnaireVo.setStartTime(new Timestamp(1508342400000l));//2017-10-19
//        questionnaireVo.setEndTime(new Timestamp(1508601600000l));//2017-10-22
//        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
//        questionnaireVo.setStatus(1);
//        questionnaireVo.setUserVo(mUserVo);
//
//        questionnaireVos.add(questionnaireVo);
//
//        questionnaireVo = new QuestionnaireVo();
//        questionnaireVo.setUserVo(userVos.get(new Random().nextInt(5)));
//        questionnaireVo.setId(2l);
//        questionnaireVo.setName("你想从事什么职业");
//        questionnaireVo.setContent("描述描述秒速描述描述秒速描述描述秒速描述描述秒速");
//        questionnaireVo.setTotalNumber(50);
//        questionnaireVo.setReward(50);
//        questionnaireVo.setStartTime(new Timestamp(1521043200000l));//2018-3-15
//        questionnaireVo.setEndTime(new Timestamp(1533686400000l));//2018-8-8
//        questionnaireVo.setPersonas(new PersonasVo(21, 0, "上海"));
//        questionnaireVo.setStatus(2);
//        questionnaireVo.setUserVo(mUserVo);
//        questionnaireVos.add(questionnaireVo);
//
//        questionnaireVo = new QuestionnaireVo();
//        questionnaireVo.setUserVo(userVos.get(new Random().nextInt(5)));
//        questionnaireVo.setId(3l);
//        questionnaireVo.setName("你周末想干啥");
//        questionnaireVo.setContent("描述描述秒速描述描述秒速描述描述秒速描述描述秒速");
//        questionnaireVo.setTotalNumber(200);
//        questionnaireVo.setReward(50);
//        questionnaireVo.setStartTime(new Timestamp(1533686400000l));//2018-8-8
//        questionnaireVo.setEndTime(new Timestamp(1533686400000l));//2018-8-8
//        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
//        questionnaireVo.setStatus(1);
//        questionnaireVo.setUserVo(mUserVo);
//        questionnaireVos.add(questionnaireVo);
//        Log.e("questionnaireVos", questionnaireVos.toString());

      /*  RequestVo requestVo = new RequestVo();
        requestVo.setId(1l);
        requestVo.setUser(userVos.get(new Random().nextInt(5)));
        requestVo.setCoin(coinVo);
        requestVo.setName("名称");
        requestVo.setPlatform(0);
        requestVo.setReward(33);
        requestVo.setStatus(1);//未接受
        requestVo.setDemand("要求被调查者都是年轻人");
        requestVo.setStartTime(new Timestamp(1508342400000l));//2017-10-19
        requestVo.setEndTime(new Timestamp(1508601600000l));//2017-10-22
        requestVos.add(requestVo);

        requestVo = new RequestVo();
        requestVo.setId(2l);
        requestVo.setUser(userVos.get(new Random().nextInt(5)));
        requestVo.setCoin(coinVo);
        requestVo.setName("名称");
        requestVo.setPlatform(1);
        requestVo.setDemand("2天之内给出结果");
        requestVo.setReward(66);
        requestVo.setStatus(2);//已接受
        requestVo.setStartTime(new Timestamp(1508342400000l));//2017-10-19
        requestVo.setEndTime(new Timestamp(1508601600000l));//2017-10-22
        requestVos.add(requestVo);

        requestVo = new RequestVo();
        requestVo.setId(3l);
        requestVo.setUser(userVos.get(new Random().nextInt(5)));
        requestVo.setCoin(coinVo);
        requestVo.setName("名称");
        requestVo.setPlatform(0);
        requestVo.setDemand("调查要详细");
        requestVo.setReward(99);
        requestVo.setStatus(3);//已完成
        requestVo.setStartTime(new Timestamp(1508342400000l));//2017-10-19
        requestVo.setEndTime(new Timestamp(1508601600000l));//2017-10-22
        requestVos.add(requestVo);*/

       /* ReportVo reportVo = new ReportVo();
        reportVo.setId(1l);
        reportVo.setUser(userVos.get(new Random().nextInt(5)));
        reportVo.setName("报告一");
        reportVo.setContent("报告一内容内容内容内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(33);
        reportVo.setGrade(100);
        requestVo = new RequestVo();
        requestVo.setName("请求名");
        requestVo.setCoin(coinVo);
        reportVo.setRequest(requestVo);
        reportVo.setStatus(1);
        reportVos.add(reportVo);

        reportVo = new ReportVo();
        reportVo.setId(2l);
        reportVo.setUser(userVos.get(new Random().nextInt(5)));
        reportVo.setName("报告二");
        reportVo.setContent("报告二内容内容内容内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(66);
        reportVo.setGrade(80);
        requestVo = new RequestVo();
        requestVo.setName("请求名");
        requestVo.setCoin(coinVo);
        reportVo.setRequest(requestVo);
        reportVo.setStatus(2);
        reportVos.add(reportVo);

        reportVo = new ReportVo();
        reportVo.setId(3l);
        reportVo.setUser(userVos.get(new Random().nextInt(5)));
        reportVo.setName("报告三");
        reportVo.setContent("报告三内容内容内容内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(99);
        reportVo.setGrade(60);
        requestVo = new RequestVo();
        requestVo.setName("请求名");
        requestVo.setCoin(coinVo);
        reportVo.setRequest(requestVo);
        reportVo.setStatus(1);
        reportVos.add(reportVo);

        reportVo = new ReportVo();
        reportVo.setId(4l);
        reportVo.setUser(userVos.get(new Random().nextInt(5)));
        reportVo.setName("报告四");
        reportVo.setContent("报告四内容内容内容内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(110);
        reportVo.setGrade(40);
        requestVo = new RequestVo();
        requestVo.setName("请求名");
        requestVo.setCoin(coinVo);
        reportVo.setRequest(requestVo);
        reportVo.setStatus(2);
        reportVos.add(reportVo);

        reportVo = new ReportVo();
        reportVo.setId(5l);
        reportVo.setUser(userVos.get(new Random().nextInt(5)));
        reportVo.setName("报告五");
        reportVo.setContent("报告五内容内容内容内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(33);
        reportVo.setGrade(30);
        requestVo = new RequestVo();
        requestVo.setName("请求名");
        requestVo.setCoin(coinVo);
        reportVo.setRequest(requestVo);
        reportVo.setStatus(1);
        reportVos.add(reportVo);*/

//        coinVo = new CoinVo();
//        coinVo.setId(1l);
//        coinVo.setType(5);//币市
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setName("Bitcoin");
//        coinVo.setShortName("BTC");
//        coinVo.setPrice(51921.47f);
//        coinVo.setExchangeRate(530.19f);
//        coinVo.setMarketValue(4934623.121);
//        coinVo.setForCoin("USDT");
//        coinVo.setRange(0.06334f);
//        coinVo.setRoni(80);
//        coinVo.setBsri(3.2f);
//        currencyCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(2l);
//        coinVo.setType(5);//币市
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setName("Ethereum");
//        coinVo.setShortName("ETH");
//        coinVo.setPrice(51921.47f);
//        coinVo.setExchangeRate(530.19f);
//        coinVo.setMarketValue(5234623.324);
//        coinVo.setForCoin("USDT");
//        coinVo.setRange(-0.06326f);
//        coinVo.setRoni(90);
//        coinVo.setBsri(2.1f);
//        currencyCoinVos.add(coinVo);
//
//        //new Timestamp(1519056000000l));//2018-2-20
//        //new Timestamp(1521907200000l));//2018-3-25
//        //new Timestamp(1524585600000l));//2018-4-25
//        //new Timestamp(1527177600000l));//2015-5-25
//        coinVo = new CoinVo();
//        coinVo.setId(3l);
//        coinVo.setType(1);//新上
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("新上A");
//        coinVo.setName("新上a");
//        coinVo.setIcoTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setRoni(100);
//        coinVo.setBsri(2.3f);
//        coinVo.setLevel("A");
//        icoCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(4l);
//        coinVo.setType(1);//新上
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("新上B");
//        coinVo.setName("新上b");
//        coinVo.setIcoTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setRoni(90);
//        coinVo.setBsri(2.25f);
//        coinVo.setLevel("B");
//        icoCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(5l);
//        coinVo.setType(1);//新上
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("新上C");
//        coinVo.setName("新上c");
//        coinVo.setIcoTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setRoni(80);
//        coinVo.setBsri(2.34f);
//        coinVo.setLevel("C");
//        icoCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(6l);
//        coinVo.setType(2);//即将ico
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("即将ICOA");
//        coinVo.setName("即将ICOa");
//        coinVo.setIcoTime(new Timestamp(1524585600000l));//2018-4-25
//        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setRoni(100);
//        coinVo.setBsri(2.33f);
//        coinVo.setLevel("A");
//        icoCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(7l);
//        coinVo.setType(2);//即将ico
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("即将ICOB");
//        coinVo.setName("即将ICOb");
//        coinVo.setIcoTime(new Timestamp(1524585600000l));//2018-4-25
//        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setRoni(90);
//        coinVo.setBsri(2.23f);
//        coinVo.setLevel("B");
//        icoCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(8l);
//        coinVo.setType(2);//即将ico
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("即将ICOC");
//        coinVo.setName("即将ICOc");
//        coinVo.setIcoTime(new Timestamp(1524585600000l));//2018-4-25
//        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setRoni(80);
//        coinVo.setBsri(2.12f);
//        coinVo.setLevel("C");
//        icoCoinVos.add(coinVo);
//
//        coinVo = new CoinVo();
//        coinVo.setId(9l);
//        coinVo.setType(3);//正在ico
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("正在ICOA");
//        coinVo.setName("正在ICOa");
//        coinVo.setIcoTime(new Timestamp(1521907200000l));//2018-3-25
//        coinVo.setIcoEndTime(new Timestamp(1524585600000l));//2015-4-25
//        coinVo.setRoni(100);
//        coinVo.setBsri(2.0f);
//        coinVo.setLevel("A");
//        icoCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(10l);
//        coinVo.setType(3);//正在ico
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("正在ICOB");
//        coinVo.setName("正在ICOb");
//        coinVo.setIcoTime(new Timestamp(1521907200000l));//2018-3-25
//        coinVo.setIcoEndTime(new Timestamp(1524585600000l));//2015-4-25
//        coinVo.setRoni(90);
//        coinVo.setBsri(1.9f);
//        coinVo.setLevel("B");
//        icoCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(11l);
//        coinVo.setType(3);//正在ico
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("正在ICOC");
//        coinVo.setName("正在ICOc");
//        coinVo.setIcoTime(new Timestamp(1521907200000l));//2018-3-25
//        coinVo.setIcoEndTime(new Timestamp(1524585600000l));//2015-4-25
//        coinVo.setRoni(80);
//        coinVo.setBsri(2.52f);
//        coinVo.setLevel("C");
//        icoCoinVos.add(coinVo);
//
//        coinVo = new CoinVo();
//        coinVo.setId(12l);
//        coinVo.setType(4);//ICO结束
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("ICO结束A");
//        coinVo.setName("ICO结束a");
//        coinVo.setIcoTime(new Timestamp(1519056000000l));//2015-2-20
//        coinVo.setIcoEndTime(new Timestamp(1521907200000l));//2018-3-25
//        coinVo.setRoni(100);
//        coinVo.setLevel("A");
//        coinVo.setBsri(2.1f);
//        icoCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(13l);
//        coinVo.setType(4);//ICO结束
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("ICO结束B");
//        coinVo.setName("ICO结束b");
//        coinVo.setIcoTime(new Timestamp(1519056000000l));//2015-2-20
//        coinVo.setIcoEndTime(new Timestamp(1521907200000l));//2018-3-25
//        coinVo.setRoni(90);
//        coinVo.setBsri(2.8f);
//        coinVo.setLevel("B");
//        icoCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(14l);
//        coinVo.setType(4);//ICO结束
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("ICO结束C");
//        coinVo.setName("ICO结束c");
//        coinVo.setIcoTime(new Timestamp(1519056000000l));//2015-2-20
//        coinVo.setIcoEndTime(new Timestamp(1521907200000l));//2018-3-25
//        coinVo.setRoni(80);
//        coinVo.setBsri(2.5f);
//        coinVo.setLevel("C");
//        icoCoinVos.add(coinVo);
//
//        coinVo = new CoinVo();
//        coinVo.setId(15l);
//        coinVo.setType(0);//空投 未开始
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("空投A");
//        coinVo.setName("空投a");
//        coinVo.setIcoTime(new Timestamp(1524585600000l));//2018-4-25
//        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setPrice(51921.47f);
//        coinVo.setAirDropNum(1000);
//        airdropCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(16l);
//        coinVo.setType(0);//空投 已开始，没结束
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("空投B");
//        coinVo.setName("空投b");
//        coinVo.setIcoTime(new Timestamp(1521907200000l));//2018-3-25
//        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
//        coinVo.setPrice(61232.21f);
//        coinVo.setAirDropNum(80);
//        airdropCoinVos.add(coinVo);
//        coinVo = new CoinVo();
//        coinVo.setId(17l);
//        coinVo.setType(0);//空投 已结束
//        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
//        coinVo.setShortName("空投C");
//        coinVo.setName("空投c");
//        coinVo.setIcoTime(new Timestamp(1519056000000l));//2015-2-20
//        coinVo.setIcoEndTime(new Timestamp(1521907200000l));//2018-3-25
//        coinVo.setPrice(42126.89f);
//        coinVo.setAirDropNum(500);
//        airdropCoinVos.add(coinVo);
//
//        optionalCoinVos1.add(currencyCoinVos.get(0));
//        optionalCoinVos1.add(currencyCoinVos.get(1));
//        optionalCoinVos2.add(icoCoinVos.get(0));
//        optionalCoinVos2.add(icoCoinVos.get(1));
//        optionalCoinVos3.add(airdropCoinVos.get(0));
//        optionalCoinVos3.add(airdropCoinVos.get(1));
        //上面注释掉的是虚假数据，下面的的比较真实数据
        coinVo = new CoinVo();
        coinVo.setName("Bitcoin");
        coinVo.setShortName("BTC");
        coinVo.setChineseName("比特币");
        coinVo.setIntro("比特币（bitcoin）的概念最初由中本聪在2009年提出，根据中本聪的思路设计发布的开源软件以及建构其上的p2p网络。比特币是一种p2p形式的数字货币。点对点的传输意味着一个去中心化的支付系统。\n" +
                "与大多数货币不同，比特币不依靠特定货币机构发行，它依据特定算法，通过大量的计算产生，比特币经济使用整个p2p网络中众多节点构成的分布式数据库来确认并记录所有的交易行为，并使用密码学的设计来确保货币流通各个环节安全性。\n");
        coinVo.setType(5);
        coinVo.setLogoUrl("BTC.png");
        coinVo.setPriceConvert("42,781CNY=6,782USDT");
        coinVo.setPrice(42781);
        coinVo.setPrice2("CNY");
        coinVo.setPrice3(6782f);
        coinVo.setPrice4("USDT");
        coinVo.setRoni(85.71f);
        coinVo.setBsri(350f);
        coinVo.setRange(0.0179f);
        coinVo.setHigh24(42987);
        coinVo.setLow24(42457);
        coinVo.setVol24(31137956174f);
        coinVo.setMarketValue(725826810476d);
        coinVo.setRank(1);
        coinVo.setTurnover(16968625);
        coinVo.setWebsiteUrl("https://bitcoin.org/en/");
        coinVo.setWhiteBookUrl("http://www.bitcoin.org/bitcoin.pdf");
        coinVo.setBlockStationUrl("https://blockchain.info/");
        coinVo.setIcoTime(new Timestamp(1225468800000l));//2008-11-1
        coinVo.setOnlineExchangeTime(new Timestamp(1228060800000l));//2008-12-1
        coinVo.setTelegraphGroup("13221");
        coinVo.setTwitterFans("117642");
        coinVo.setForCoin("BTC");
        coinVo.setSoftcap("$1000000");
        coinVo.setHardcap("$2000000");
        coinVo.setPrivatePrice("1300BTC=$1");
        coinVo.setPreIcoPrice("1300BTC=$2");
        coinVo.setIcoMarketValue("$2000000");
        coinVo.setOnlineExchange("OKEX 、Bitfinex");
        coinVo.setLocation("美国");
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setName("Rthereum");
        coinVo.setShortName("ETH");
        coinVo.setChineseName("以太坊");
        coinVo.setIntro("ethereum（以太坊）是一个平台和一种编程语言，使开发人员能够建立和发布下一代分布式应用。 ethereum可以用来编程，分散，担保和交易任何事物：投票，域名，金融交易所，众筹，公司管理， 合同和大部分的协议，知识产权，还有得益于硬件集成的智能资产。\n" +
                "以太坊将使用混合型的安全协议，前期使用工作量证明机制（pow），用于分发以太币，然后会切换到权益证明机制（pos）。自上线时起，每年都将有0.26x，即每年有60102216 * 0.26 = 15626576个以太币被矿工挖出。转成pos后，每年产出的以太币将减少\n");
        coinVo.setType(5);
        coinVo.setLogoUrl("ETH.png");
        coinVo.setPriceConvert("2,661.33CNY＝403USDT");
        coinVo.setPrice(2661.33f);
        coinVo.setPrice2("CNY");
        coinVo.setPrice3(403f);
        coinVo.setPrice4("USDT");
        coinVo.setRoni(87.76f);
        coinVo.setBsri(234.55f);
        coinVo.setRange(-0.0258f);
        coinVo.setHigh24(2718);
        coinVo.setLow24(2470);
        coinVo.setVol24(99803392505f);
        coinVo.setMarketValue(250336774520d);
        coinVo.setRank(2);
        coinVo.setTurnover(9803392505f);
        coinVo.setWebsiteUrl("https://www.ethereum.org/");
        coinVo.setWhiteBookUrl("https://github.com/ethereum/wiki/wiki/%5BEnglish%5D-White-Paper");
        coinVo.setBlockStationUrl("https://etherscan.io/");
        coinVo.setIcoTime(new Timestamp(1406131200000l));//2014-7-24
        coinVo.setOnlineExchangeTime(new Timestamp(1408809600000l));//2014-8-24
        coinVo.setTelegraphGroup("22123");
        coinVo.setTwitterFans("117761");
        coinVo.setForCoin("BTC");
        coinVo.setSoftcap("$720000000");
        coinVo.setHardcap("$980000000");
        coinVo.setPrivatePrice("1ETH=￥1.89");
        coinVo.setPreIcoPrice("1ETH=￥1.90");
        coinVo.setIcoMarketValue("$18000000");
        coinVo.setOnlineExchange("OKEX 、Bitfinex");
        coinVo.setLocation("美国");
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setName("Ripple");
        coinVo.setShortName("XRP");
        coinVo.setChineseName("瑞波币");
        coinVo.setIntro("瑞波币是ripple网络的基础货币，它可以在整个ripple网络中流通，总数量为1000亿，并且随着交易的增多而逐渐减少，瑞波币的运营公司为ripple labs（其前身为opencoin）。\n" +
                "瑞波币是ripple系统中唯一的通用货币，其不同于ripple系统中的其他货币，其他货币比如cny、usd不能跨网关提现的，换句话说，a网关发行的cny只能在a网关提现，若想在b网关提现，必须通过ripple系统的挂单功能转化为b网关的cny才可以到b网关提现。而瑞波币完全没有这方面的限制，它在ripple系统内是通用的\n");
        coinVo.setType(5);
        coinVo.setLogoUrl("XRP.png");
        coinVo.setPriceConvert("3.07CNY=0.4881USDT");
        coinVo.setPrice(3.07f);
        coinVo.setPrice2("CNY");
        coinVo.setPrice3(0.4881f);
        coinVo.setPrice4("USDT");
        coinVo.setRoni(85.32f);
        coinVo.setBsri(223f);
        coinVo.setRange(-0.0316f);
        coinVo.setHigh24(3.23);
        coinVo.setLow24(3.05);
        coinVo.setVol24(1404964467f);
        coinVo.setTurnover(39094802192f);
        coinVo.setMarketValue(120107368754d);
        coinVo.setRank(3);
        coinVo.setWebsiteUrl("https://ripple.com/");
        coinVo.setWhiteBookUrl("https://ripple.com/files/ripple_consensus_whitepaper.pdf");
        coinVo.setBlockStationUrl("https://ripple.com/graph");
        coinVo.setIcoTime(new Timestamp(1303056000000l));//2011-4-18
        coinVo.setOnlineExchangeTime(new Timestamp(1305648000000l));//2011-5-18
        coinVo.setTelegraphGroup("23121");
        coinVo.setTwitterFans("22212");
        coinVo.setForCoin("BTC");
        coinVo.setSoftcap("$121000000");
        coinVo.setHardcap("$281000000");
        coinVo.setPrivatePrice("1XRP=￥2.76");
        coinVo.setPreIcoPrice("1XRP=￥2.77");
        coinVo.setIcoMarketValue("$281000000");
        coinVo.setOnlineExchange("HitBTC、Coinbene、QBTC");
        coinVo.setLocation("美国");
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setName("Litecoin");
        coinVo.setShortName("LTC");
        coinVo.setChineseName("莱特币");
        coinVo.setIntro("莱特币受到了比特币（btc）的启发，并且在技术上具有相同的实现原理，莱特币的创造和转让基于一种开源的加密协议，不受到任何中央机构的管理。莱特币旨在改进比特币，与其相比，莱特币具有三种显著差异。第一，莱特币网络每2.5分钟（而不是10分钟）就可以处理一个块，因此可以提供更快的交易确认。第二，莱特币网络预期产出8400万个莱特币，是比特币网络发行货币量的四倍之多。第三，莱特币在其工作量证明算法中使用了由colin percival首次提出的scrypt加密算法，这使得相比于比特币，在普通计算机上进行莱特币挖掘更为容易。每一个莱特币被分成100,000,000个更小的单位，通过八位小数来界定。");
        coinVo.setType(5);
        coinVo.setLogoUrl("LTC.png");
        coinVo.setPriceConvert("716CNY=144USDT");
        coinVo.setPrice(716);
        coinVo.setPrice2("CNY");
        coinVo.setPrice3(144f);
        coinVo.setPrice4("USDT");
        coinVo.setRoni(76f);
        coinVo.setBsri(321f);
        coinVo.setRange(-0.057f);
        coinVo.setHigh24(764);
        coinVo.setLow24(714);
        coinVo.setVol24(1568850887f);
        coinVo.setMarketValue(40120184574d);
        coinVo.setRank(4);
        coinVo.setTurnover(56016463);
        coinVo.setWebsiteUrl("https://litecoin.com/");
        coinVo.setBlockStationUrl("http://explorer.litecoin.net/chain/Litecoin");
        coinVo.setIcoTime(new Timestamp(1320768000000l));//2011-11-9
        coinVo.setOnlineExchangeTime(new Timestamp(1323360000000l));//2011-12-9
        coinVo.setTelegraphGroup("213121");
        coinVo.setTwitterFans("36432");
        coinVo.setForCoin("BTC");
        coinVo.setSoftcap("$14,000,00.00");
        coinVo.setHardcap("$23,000,00.00");
        coinVo.setPrivatePrice("1LTC=￥0.089");
        coinVo.setPreIcoPrice("1LTC=￥0.090");
        coinVo.setIcoMarketValue("$23,000,00.00");
        coinVo.setOnlineExchange("OKEX 、Bitfinex");
        coinVo.setLocation("美国");
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setName("柚子");
        coinVo.setShortName("EOS");
        coinVo.setChineseName("柚子");
        coinVo.setIntro("eos 为区块链奇才 bm （daniel larimer）领导开发的类似操作系统的区块链架构平台，旨在实现分布式应用的性能扩展。eos 提供帐户，身份验证，数据库，异步通信以及在数以百计的cpu或群集上的程序调度。该技术的最终形式是一个区块链体系架构，该区块链每秒可以支持数百万个交易，同时普通用户无需支付使用费用。");
        coinVo.setType(5);
        coinVo.setLogoUrl("EOS.png");
        coinVo.setPriceConvert("36.74");
        coinVo.setPrice(36.74f);
        coinVo.setRoni(65.74f);
        coinVo.setBsri(221f);
        coinVo.setRange(-0.0266f);
        coinVo.setHigh24(38.14);
        coinVo.setLow24(36.74);
        coinVo.setVol24(1766168614f);
        coinVo.setMarketValue(28802971935d);
        coinVo.setRank(5);
        coinVo.setTurnover(783978382);
        coinVo.setWebsiteUrl("https://eos.io/");
        coinVo.setWhiteBookUrl("https://github.com/EOSIO/Documentation/blob/master/TechnicalWhitePaper.md");
        coinVo.setBlockStationUrl("https://etherscan.io/token/EOS");
        coinVo.setIcoTime(new Timestamp(1498924800000l));//2017-7-2
        coinVo.setOnlineExchangeTime(new Timestamp(1501603200000l));//2011-12-9
        coinVo.setTelegraphGroup("12213");
        coinVo.setTwitterFans("27752");
        coinVo.setForCoin("BTC");
        coinVo.setSoftcap("$120000000");
        coinVo.setHardcap("$500000000");
        coinVo.setPrivatePrice("1EOS=￥7");
        coinVo.setPreIcoPrice("1EOS=￥8");
        coinVo.setIcoMarketValue("$500000000");
        coinVo.setOnlineExchange("HitBTC、Coinbene、QBTC");
        coinVo.setLocation("美国");
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setName("Cardano");
        coinVo.setShortName("ADA");
        coinVo.setChineseName("艾达币");
        coinVo.setIntro("卡尔达诺是ada加密货币的归宿，可用于发送和接收数字资金。这种数字现金代表了未来的货币，通过使用加密技术，可以快速，直接的转帐，保证其安全性。\n" +
                "卡尔达诺不仅是一个加密货币，而是一个技术平台，能够运行在世界各地的个人、组织和政府每天使用的金融应用程序。该平台正在层次构建中，使系统更容易维护，并允许通过软叉进行升级。在运行ada的结算层构建完成后，将分离构建计算层来处理智能合约，这些数字法律协议将为未来的商业和业务提供支援。卡尔达诺还将运行分散应用程序或dapps，服务将不是由任何一方控制，而是以区块链方式进行运作。\n");
        coinVo.setType(5);
        coinVo.setLogoUrl("ADA.png");
        coinVo.setPriceConvert("0.945CNY=0.1501USDT");
        coinVo.setPrice(0.945f);
        coinVo.setPrice2("CNY");
        coinVo.setPrice3(0.1501f);
        coinVo.setPrice4("USDT");
        coinVo.setRoni(78f);
        coinVo.setBsri(321f);
        coinVo.setRange(-0.0697f);
        coinVo.setHigh24(1.03);
        coinVo.setLow24(0.9311);
        coinVo.setVol24(466416813f);
        coinVo.setTurnover(25927070538f);
        coinVo.setMarketValue(24500454906d);
        coinVo.setRank(6);
        coinVo.setWebsiteUrl("https://www.cardanohub.org/");
        coinVo.setWhiteBookUrl("https://www.cardanohub.org/zh/academic-papers-3/");
        coinVo.setBlockStationUrl("https://cardanoexplorer.com/");
        coinVo.setIcoTime(new Timestamp(1506873600000l));//2017-10-2
        coinVo.setOnlineExchangeTime(new Timestamp(1509552000000l));//2017-11-2
        coinVo.setTelegraphGroup("65331");
        coinVo.setTwitterFans("98817");
        coinVo.setForCoin("BTC");
        coinVo.setSoftcap("$34000000");
        coinVo.setHardcap("$43000000");
        coinVo.setPrivatePrice("1ADA=￥0.026");
        coinVo.setPreIcoPrice("1ADA=￥0.027");
        coinVo.setIcoMarketValue("$43000000");
        coinVo.setOnlineExchange("HitBTC、Coinbene、QBTC");
        coinVo.setLocation("美国");
        currencyCoinVos.add(coinVo);
        //ico coin
        coinVo = new CoinVo();
        coinVo.setShortName("TBD");
        coinVo.setName("Crowd Machine");
        coinVo.setLogoUrl("TBD.png");
        coinVo.setType(3);//正在ico
        coinVo.setRoni(45);
        coinVo.setLevel("B");
        coinVo.setForCoin("BTC,ETH");
        coinVo.setSoftcap("TBD");
        coinVo.setHardcap("TBD");
        coinVo.setIcoTime(new Timestamp(1522512000000l));//2018-4-1
        coinVo.setIcoEndTime(new Timestamp(1558454400000l));//2019-5-22
        coinVo.setWebsiteUrl("https://www.crowdmachine.com/");
        coinVo.setWebsiteUrl("");
        coinVo.setTwitterFans("435");
        coinVo.setPriceConvert("1TBD=$1.25");
        coinVo.setForCoin("BTC、ETH");
        coinVo.setSoftcap("$22000000");
        coinVo.setHardcap("$55000000");
        coinVo.setPrivatePrice("1TBD=$1.25");
        coinVo.setPreIcoPrice("1TBD=$1.00");
        coinVo.setIcoMarketValue("$55000000");
        coinVo.setOnlineExchange("CoinsBank、HitBTC");
        coinVo.setLocation("美国");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("ECOM");
        coinVo.setName("Omnitude");
        coinVo.setLogoUrl("ECOM.png");
        coinVo.setType(3);//正在ico
        coinVo.setRoni(85);
        coinVo.setLevel("B");
        coinVo.setForCoin("BTC,ETH");
        coinVo.setSoftcap("$10000000");
        coinVo.setHardcap("$25000000");
        coinVo.setIcoTime(new Timestamp(1522512000000l));//2018-4-1
        coinVo.setIcoEndTime(new Timestamp(1558454400000l));//2019-5-22
        coinVo.setWebsiteUrl("https://omnitude.tech/index.html");
        coinVo.setWhiteBookUrl("https://files.acrobat.com/a/preview/75fe0af9-d98b-4002-863c-138b43a131ef");
        coinVo.setTwitterFans("2563");
        coinVo.setPriceConvert("1ECOM = $0.46");
        coinVo.setForCoin("BTC、ETH");
        coinVo.setSoftcap("$23000000");
        coinVo.setHardcap("$46000000");
        coinVo.setPrivatePrice("1 ECOM = $0.46");
        coinVo.setPreIcoPrice("1 ECOM = $0.32");
        coinVo.setIcoMarketValue("$46000000");
        coinVo.setOnlineExchange("OKEX 、Bitfinex");
        coinVo.setLocation("英国");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("FC");
        coinVo.setName("FogCoin");
        coinVo.setLogoUrl("FC.png");
        coinVo.setType(4);//已结束
        coinVo.setRoni(67);
        coinVo.setLevel("C");
        coinVo.setForCoin("BTC,ETH");
        coinVo.setSoftcap("TBD");
        coinVo.setHardcap("TBD");
        coinVo.setIcoTime(new Timestamp(1511971200000l));//2017-11-30
        coinVo.setIcoEndTime(new Timestamp(1523289600000l));//2018-4-10
        coinVo.setWebsiteUrl("https://fogcoin.io/");
        coinVo.setWhiteBookUrl("https://fogcoin.io/documents/FogCoin-Whitepaper.pdf");
        coinVo.setTwitterFans("322");
        coinVo.setPriceConvert("1FC=$0.12");
        coinVo.setForCoin("BTC、ETH");
        coinVo.setSoftcap("$19000000");
        coinVo.setHardcap("$25000000");
        coinVo.setPrivatePrice("1FC=$0.12");
        coinVo.setPreIcoPrice("1FC=$0.10");
        coinVo.setIcoMarketValue("$25000000");
        coinVo.setOnlineExchange("OKEX 、Bitfinex");
        coinVo.setLocation("美国");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("ABYSS");
        coinVo.setName("The Abyss");
        coinVo.setLogoUrl("ABYSS.png");
        coinVo.setType(2);//即将ico
        coinVo.setLevel("D");
        coinVo.setForCoin("ETH,BNB");
        coinVo.setSoftcap("$6000000");
        coinVo.setHardcap("$18000000");
        coinVo.setIcoTime(new Timestamp(1523808000000l));//2018-4-16
        coinVo.setIcoEndTime(new Timestamp(1526400000000l));//2018-5-16
        coinVo.setWebsiteUrl("https://www.theabyss.com/zh?utm_source=icohotlist");
        coinVo.setWhiteBookUrl("https://theabyss.docsend.com/view/nff9r2c");
        coinVo.setTwitterFans("6753");
        coinVo.setPriceConvert("1ABYSS=0.0003ETH");
        coinVo.setForCoin("BTC、ETH");
        coinVo.setSoftcap("$15000000");
        coinVo.setHardcap("$35000000");
        coinVo.setPrivatePrice("1ABYSS=0.0003ETH");
        coinVo.setPreIcoPrice("1ABYSS=0.0002ETH");
        coinVo.setIcoMarketValue("$35000000");
        coinVo.setOnlineExchange("火币Pro-Huobi 、Bit-Z");
        coinVo.setLocation("美国");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("ELI");
        coinVo.setName("Eligma");
        coinVo.setLogoUrl("ELI.png");
        coinVo.setType(2);//即将ico
        coinVo.setLevel("B");
        coinVo.setPriceConvert("1ELI= 0.1USDT");
        coinVo.setPrice(1);
        coinVo.setPrice2("ELI");
        coinVo.setPrice3(0.1f);
        coinVo.setPrice4("USDT");
        coinVo.setForCoin("ETH");
        coinVo.setSoftcap("$24000000");
        coinVo.setHardcap("$3000000");
        coinVo.setIcoTime(new Timestamp(1523894400000l));//2018-4-17
        coinVo.setIcoEndTime(new Timestamp(1525708800000l));//2018-5-8
        coinVo.setWebsiteUrl("https://www.eligma.io/");
        coinVo.setWhiteBookUrl("https://www.eligma.io/pdf/eligma-white-paper_v1.1.pdf");
        coinVo.setTwitterFans("1243");
        coinVo.setPriceConvert("1ELI=$0.054");
        coinVo.setForCoin("BTC、ETH");
        coinVo.setSoftcap("$20300000");
        coinVo.setHardcap("$25300000");
        coinVo.setPrivatePrice("1ELI=$0.054");
        coinVo.setPreIcoPrice("1ELI=$0.045");
        coinVo.setIcoMarketValue("$25300000");
        coinVo.setOnlineExchange("HitBTC、Coinbene、QBTC");
        coinVo.setLocation("美国");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("GES");
        coinVo.setName("GalaxyeSolution");
        coinVo.setLogoUrl("GES.png");
        coinVo.setType(3);//正在ico
        coinVo.setRoni(76.32f);
        coinVo.setLevel("A");
        coinVo.setPriceConvert("10000GES=1ETH");
        coinVo.setPrice(10000);
        coinVo.setPrice2("GES");
        coinVo.setPrice3(1f);
        coinVo.setPrice4("ETH");
        coinVo.setForCoin("ETH");
        coinVo.setSoftcap("TBD");
        coinVo.setHardcap("TBD");
        coinVo.setIcoTime(new Timestamp(1519747200000l));//2018-2-18
        coinVo.setIcoEndTime(new Timestamp(1523721600000l));//2018-4-15
        coinVo.setWebsiteUrl("https://galaxy-esolutions.com/");
        coinVo.setWhiteBookUrl("http://whitepaper.galaxy-esolutions.com/GES_Business_Deck_Full_Version_EN.pdf");
        coinVo.setTwitterFans("1234");
        coinVo.setPriceConvert("1GES=0.00001ETH");
        coinVo.setForCoin("BTC、ETH");
        coinVo.setSoftcap("$15000000");
        coinVo.setHardcap("$30000000");
        coinVo.setPrivatePrice("1GES=0.00001ETH");
        coinVo.setPreIcoPrice("1GES=0.0000084ETH");
        coinVo.setIcoMarketValue("$30000000");
        coinVo.setOnlineExchange("Bitfinex、HitBTC");
        coinVo.setLocation("中国");
        icoCoinVos.add(coinVo);
        //airdrop coin
        coinVo = new CoinVo();
        coinVo.setShortName("ACT");
        coinVo.setPriceConvert("1.08CNY=0.1725USDT");
        coinVo.setPrice(564075272f);
        coinVo.setPrice4("USDT");
        coinVo.setAirDropNum(461);
        coinVo.setRange(-0.0365f);
        coinVo.setHigh24(1.17);
        coinVo.setLow24(1.07);
        coinVo.setVol24(86347615);
        coinVo.setMarketValue(500467223);
        coinVo.setRank(106);
        coinVo.setTurnover(461580723);
        coinVo.setName("Achain");
        coinVo.setLogoUrl("ACT.png");
        coinVo.setWebsiteUrl("https://www.achain.com/");
        coinVo.setWhiteBookUrl("https://www.achain.com/Achain%20Whitepaper%202.0_CHS.pdf");
        coinVo.setBlockStationUrl("https://browser.achain.com/");
        coinVo.setIcoTime(new Timestamp(1503763200000l));//2017/8/27
        coinVo.setOnlineExchange("Bitfinex、OKEX、Lbank");
        coinVo.setLocation("中国");
        coinVo.setTelegraphGroup("25695");
        coinVo.setTwitterFans("7161");
        coinVo.setIntro("achain独有的rdpos分布式共识机制，实现了拥有自主知识产权的图灵完备智能合约虚拟机，链上交易性能高达1000tps，是一款简单、快速、安全的区块链平台，用户可以使用achain快速部署数字资产、智能合约等企业级的去中心化应用。");
        coinVo.setPriceConvert("￥1.2=$0.1725");
        coinVo.setForCoin("BTC、ETH");
        coinVo.setSoftcap("$410000000");
        coinVo.setHardcap("$570000000");
        coinVo.setPrivatePrice("1ACT=0.00002769BTC");
        coinVo.setPreIcoPrice("1ACT=0.00002569BTC");
        coinVo.setIcoMarketValue("$570000000");
        coinVo.setOnlineExchange("CoinsBank、HitBTC");
        coinVo.setLocation("美国");
        airdropCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("SWTC");
        coinVo.setPriceConvert("0.0359CNY=0.0053USDT");
        coinVo.setPrice(3889719740f);
        coinVo.setAirDropNum(100000);
        coinVo.setRange(-0.0576f);
        coinVo.setHigh24(0.0449);
        coinVo.setLow24(0.0349);
        coinVo.setVol24(254639);
        coinVo.setMarketValue(3585085560d);
        coinVo.setRank(657);
        coinVo.setTurnover(100000000000f);
        coinVo.setName("斯微特");
        coinVo.setLogoUrl("SWTC.png");
        coinVo.setWebsiteUrl("https://www.jingtum.com/");
        coinVo.setBlockStationUrl("http://state.jingtum.com/");
        coinVo.setIntro("swtc，system working token china是斯微特区块链原生的数字资产，作用类似于比特币系统中的bitcoin或以太坊中的eth，是斯微特系统内交易所需的介质。swtc本身的作用有两方面，一方面提供用户在斯微特系统中建立有效账户的凭据；另一方面是用户在斯微特系统中交易的费用消耗。 同时，swtc保障系统运行的稳定和安全，提高恶意攻击的成本。交易中消耗的swtc费用，由系统本身回收进行循环利用。");
        coinVo.setIcoTime(new Timestamp(1427817600000l));//2015-4-1
        coinVo.setOnlineExchange("Bitfinex、Lbank");
        coinVo.setLocation("中国");
        coinVo.setTelegraphGroup("87453");
        coinVo.setTwitterFans("872");
        coinVo.setPriceConvert("￥1.2=$0.1725");
        coinVo.setForCoin("BTC、ETH");
        coinVo.setSoftcap("$410000000");
        coinVo.setHardcap("$570000000");
        coinVo.setPrivatePrice("1CT=$0.005896");
        coinVo.setPreIcoPrice("1CT=$0.005096");
        coinVo.setIcoMarketValue("$570000000");
        coinVo.setOnlineExchange("CoinsBank、HitBTC");
        coinVo.setLocation("美国");
        airdropCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("UGC");
        coinVo.setPriceConvert("￥0.213=$0.0342");
        coinVo.setPrice(112215448f);
        coinVo.setAirDropNum(500);
        coinVo.setRange(-0.0391f);
        coinVo.setHigh24(0.1942);
        coinVo.setLow24(0.1795);
        coinVo.setVol24(9148712);
        coinVo.setMarketValue(90838196);
        coinVo.setRank(309);
        coinVo.setTurnover(500000000);
        coinVo.setName("UGCHAIN");
        coinVo.setLogoUrl("UGC.png");
        coinVo.setIntro("ugchain—打造去中心化的游戏生态\n" +
                "ugchain是垂直于游戏行业的区块链项目，致力于推动虚拟资产的标准化及交易。首创的双链交互模式，解决了区块链应用中易用性与安全性难以协调的问题。\n" +
                "目前，总量10亿，销毁1亿，总可用量9亿，团队锁仓40%左右，市场流通在5亿左右\n");
        coinVo.setWebsiteUrl("http://www.ugchain.org/");
        coinVo.setIcoTime(new Timestamp(1515772800000l));//2018-1-13
        coinVo.setOnlineExchange("Bitfinex、火币网、HitBTC");
        coinVo.setLocation("中国");
        coinVo.setTelegraphGroup("9983");
        coinVo.setTwitterFans("1712");
        coinVo.setPriceConvert("￥0.213=$0.0342");
        coinVo.setForCoin("BTC、ETH");
        coinVo.setSoftcap("$50000000");
        coinVo.setHardcap("$80000000");
        coinVo.setPrivatePrice("1UGC=$0.0342");
        coinVo.setPreIcoPrice("1UGC=$0.0321");
        coinVo.setIcoMarketValue("$80000000");
        coinVo.setOnlineExchange("火币Pro-Huobi 、Bit-Z、Binanc");
        coinVo.setLocation("中国");
        airdropCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("CMT");
        coinVo.setLogoUrl("CMT.png");
        coinVo.setPriceConvert("￥1.6=$0.1925");
        coinVo.setPrice(407289019f);
        coinVo.setAirDropNum(700);
        coinVo.setRange(-0.0025f);
        coinVo.setHigh24(0.5307);
        coinVo.setLow24(0.4898);
        coinVo.setVol24(79149472);
        coinVo.setMarketValue(351267755);
        coinVo.setRank(137);
        coinVo.setTurnover(700000000);
        coinVo.setName("Achain");
        coinVo.setWebsiteUrl("https://cm.5miles.com/zh-tw/");
        coinVo.setWhiteBookUrl("https://cm.5miles.com/file/technical/Technical%20Whitepaper_zh-tw.pdf");
        coinVo.setIntro("cybermiles (\"cm\") 是由区块链开发研究室 5xlab 所开发的区块鍊和智能合约平台。5miles 在过去3 年多的美国本地移动市场的商业运营中，已累积了必要的技术，商业知识和商业创新， 这些为cybermiles打造应用于现实商业世界的区块链技术与智能商业合约打下了良好的基础。5xlab致力于结合这些专业知识来开发cybermiles，重视使其具有合法合规性和开发者社区的信任。这将使cybermiles成为现实商业的主流区块链技术");
        coinVo.setIcoTime(new Timestamp(1512576000000l));//2017-12-7
        coinVo.setOnlineExchange("Bitfinex、OKEX、Lbank");
        coinVo.setLocation("中国");
        coinVo.setTelegraphGroup("77162");
        coinVo.setTwitterFans("3213");
        coinVo.setPriceConvert("￥1.6=$0.1925");
        coinVo.setForCoin("BTC、ETH");
        coinVo.setSoftcap("$22000000");
        coinVo.setHardcap("$32000000");
        coinVo.setPrivatePrice("1CMT=$0.1925");
        coinVo.setPreIcoPrice("1CMT=$0.1825");
        coinVo.setIcoMarketValue("$32000000");
        coinVo.setOnlineExchange("OKEX 、Bitfinex");
        coinVo.setLocation("美国");
        airdropCoinVos.add(coinVo);
        optionalCoinVos1.add(currencyCoinVos.get(0));
        optionalCoinVos1.add(currencyCoinVos.get(1));
        optionalCoinVos2.add(icoCoinVos.get(0));
        optionalCoinVos2.add(icoCoinVos.get(1));
        optionalCoinVos3.add(airdropCoinVos.get(0));
        optionalCoinVos3.add(airdropCoinVos.get(1));


        long baseId = System.currentTimeMillis() / 1000;
        RequestVo requestVo;
        ReportVo reportVo = new ReportVo();
        reportVo.setId(baseId);
        reportVo.setUser(ConstantData.mUserVo);
        reportVo.setName("报告一");
        reportVo.setContent("报告一内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(33);
        reportVo.setGrade(100);
        requestVo = new RequestVo();
        requestVo.setName("请求一");
        requestVo.setCoin(coinVo);
        reportVo.setRequest(requestVo);
        reportVo.setStatus(2);
        myReports.add(reportVo);

        reportVo = new ReportVo();
        reportVo.setId(baseId + 1);
        reportVo.setUser(ConstantData.mUserVo);
        reportVo.setName("报告二");
        reportVo.setContent("报告二内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(66);
        reportVo.setGrade(80);
        requestVo = new RequestVo();
        requestVo.setName("请求二");
        requestVo.setCoin(coinVo);
        reportVo.setRequest(requestVo);
        reportVo.setStatus(2);
        myReports.add(reportVo);

        //真实问卷数据
        QuestionnaireVo questionnaireVo;
        List<QuestionVo> questionVos;
        List<String> optionVos;

        //问卷一
        questionnaireVo = new QuestionnaireVo();
        userVo = new UserVo();
        questionVos = new ArrayList<>();
        userVo.setName("江南西道");
        userVo.setHeadPic("head4");
        questionnaireVo.setUserVo(userVo);
        questionnaireVo.setId(1l);
        questionnaireVo.setName("区块链用户习惯调查");
        questionnaireVo.setContent("7个简答的小问题，2分钟，通过您的信息，一起创造属于大家好产品！");
        questionnaireVo.setTotalNumber(2000);
        questionnaireVo.setReward(100);
        questionnaireVo.setStartTime(new Timestamp(1523289600000l));//2018-4-10
        questionnaireVo.setEndTime(new Timestamp(1524153600000l));//2018-4-20
        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
        questionnaireVo.setStatus(1);
        questionnaireVo.setUserVo(userVo);
        optionVos = new ArrayList<>();
        optionVos.add("男");
        optionVos.add("女");
        questionVos.add(new QuestionVo(1l,"Q1：您的性别",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("只是听说过");
        optionVos.add("对概念有一些了解");
        optionVos.add("数字货币投资");
        optionVos.add("区块链工作者");
        questionVos.add(new QuestionVo(2l,"Q2：您参与过哪些区块链相关的事？（多选）",1,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("手机");
        optionVos.add("PC");
        questionVos.add(new QuestionVo(3l,"Q3：您习惯用手机还是PC了解区块链数字货币资讯？（多选）",1,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("巴比特、金色财经等网站");
        optionVos.add("微信公众号");
        optionVos.add("区块链、火币网交易所等app");
        optionVos.add("今日头条等app");
        questionVos.add(new QuestionVo(4l,"Q4：您常通过什么渠道了解到INB币呢（多选）",1,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("快讯");
        optionVos.add("深度文章");
        optionVos.add("视频");
        optionVos.add("其他有趣的形式");
        questionVos.add(new QuestionVo(5l,"Q5：您喜欢什么形式的内容？（多选）",1,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("PC网页");
        optionVos.add("PC软件");
        optionVos.add("手机app");
        questionVos.add(new QuestionVo(6l,"Q6：如果您炒币，喜欢什么方式看盘？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("安装一款app获得官方的主动推送信息");
        optionVos.add("从QQ群里了解");
        optionVos.add("上大媒体网站，从大媒体了解");
        optionVos.add("关注自媒体，从自媒体了解");
        questionVos.add(new QuestionVo(7l," Q7：如果您炒币，您更倾向于 什么方式获得信息",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        questionnaireVos.add(questionnaireVo);
        //问卷二
        questionnaireVo = new QuestionnaireVo();
        userVo = new UserVo();
        questionVos = new ArrayList<>();
        userVo.setName("等一轮满月");
        userVo.setHeadPic("head5");
        questionnaireVo.setUserVo(userVo);
        questionnaireVo.setId(2l);
        questionnaireVo.setName(" AVT币竞争力调查");
        questionnaireVo.setContent("问卷调查的目的是了解目前交易平台的用户群及交易风险");
        questionnaireVo.setTotalNumber(3000);
        questionnaireVo.setReward(300);
        questionnaireVo.setStartTime(new Timestamp(1523289600000l));//2018-4-10
        questionnaireVo.setEndTime(new Timestamp(1524153600000l));//2018-4-20
        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
        questionnaireVo.setStatus(1);
        questionnaireVo.setUserVo(userVo);
        optionVos = new ArrayList<>();
        optionVos.add("男");
        optionVos.add("女");
        questionVos.add(new QuestionVo(1l,"Q1：您的性别",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("18岁以下");
        optionVos.add("18~25");
        optionVos.add("26~30");
        optionVos.add("31~40");
        optionVos.add("41~50");
        optionVos.add("51~60");
        optionVos.add("60以上");
        questionVos.add(new QuestionVo(2l,"Q2：您的年龄区间是？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("不知道");
        optionVos.add("听说过");
        optionVos.add("很了解");
        questionVos.add(new QuestionVo(3l,"Q3：.您知道AVT币？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("会去看");
        optionVos.add("不会去看");
        questionVos.add(new QuestionVo(4l,"Q4：您打算购买一个数币之前会去看白皮书？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("通过朋友介绍");
        optionVos.add("通过数币信息网站");
        optionVos.add("通过新闻APP");
        optionVos.add("通过社交平台");
        optionVos.add("其他途径");
        questionVos.add(new QuestionVo(5l,"Q5：你是从什么渠道了解到AVT币的呢？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("有潜力");
        optionVos.add("观望中");
        optionVos.add("不看好");
        questionVos.add(new QuestionVo(6l,"Q6：你是否看好AVT币的前景?",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("愿意");
        optionVos.add("犹豫中");
        optionVos.add("不愿意");
        questionVos.add(new QuestionVo(7l," Q7：你是否愿意投资AVT币呢？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("完全不会");
        optionVos.add("有一点");
        optionVos.add("听朋友的");
        questionVos.add(new QuestionVo(8l," Q8：朋友能左右你投资AVT币的决心？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        questionnaireVos.add(questionnaireVo);
        //问卷三
        questionnaireVo = new QuestionnaireVo();
        userVo = new UserVo();
        questionVos = new ArrayList<>();
        userVo.setName("若曦");
        userVo.setHeadPic("head6");
        questionnaireVo.setUserVo(userVo);
        questionnaireVo.setId(3l);
        questionnaireVo.setName("DSH币的信息普及调查？");
        questionnaireVo.setContent("由于比特币交易没有第三方参与，所及几乎是免费的。由于政府不能控制比特币，所以它的价格波动很大。对于这种有风险的数币，大家对此的态度又是什么样的呢？");
        questionnaireVo.setTotalNumber(1500);
        questionnaireVo.setReward(150);
        questionnaireVo.setStartTime(new Timestamp(1523289600000l));//2018-4-10
        questionnaireVo.setEndTime(new Timestamp(1524153600000l));//2018-4-20
        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
        questionnaireVo.setStatus(1);
        questionnaireVo.setUserVo(userVo);
        optionVos = new ArrayList<>();
        optionVos.add("男");
        optionVos.add("女");
        questionVos.add(new QuestionVo(1l,"Q1：您的性别",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("小于16周岁");
        optionVos.add("16到23周岁");
        optionVos.add("23到29周岁");
        optionVos.add("30到39周岁");
        optionVos.add("40到49周岁");
        optionVos.add("50岁以上");
        questionVos.add(new QuestionVo(2l,"Q2：您的年龄区间是？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("高中以下");
        optionVos.add("高中");
        optionVos.add("本科或大专");
        optionVos.add("研究生");
        optionVos.add("博士或以上");
        questionVos.add(new QuestionVo(3l,"Q3：.你的教育程度？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("IT领域");
        optionVos.add("工程领域");
        optionVos.add("金融领域");
        optionVos.add("其他领域");
        questionVos.add(new QuestionVo(4l,"Q4：你的学习（如果你是学生）或工作（如果你已经工作）领域？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("仅仅听说过");
        optionVos.add("很熟悉");
        optionVos.add("完全没有听说过");
        questionVos.add(new QuestionVo(5l,"Q5：你听说过“DSH币”么？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("通过朋友介绍");
        optionVos.add("通过数币信息网站");
        optionVos.add("通过新闻APP");
        optionVos.add("通过社交平台");
        optionVos.add("其他途径");
        questionVos.add(new QuestionVo(6l,"Q6：你怎么知道“DSH币”的?",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("很有潜力");
        optionVos.add("只是昙花一现");
        optionVos.add("不好说");
        questionVos.add(new QuestionVo(7l," Q7：你怎么看待“DSH”币的生命力？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("是的");
        optionVos.add("不能");
        optionVos.add("不好说");
        questionVos.add(new QuestionVo(8l," Q8：你认为“DSH币”能有巨大的发展前景？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("方便");
        optionVos.add("不方便");
        optionVos.add("不好说");
        questionVos.add(new QuestionVo(9l," Q8：你觉得用数字货币在网上交易方便么？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("用他们在网上交易");
        optionVos.add("把他们存着，等价格处于高位时卖掉");
        optionVos.add("不好说");
        questionVos.add(new QuestionVo(10l," Q9：如果你拥有一些DSH币，你会拿他们来干什么？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        questionnaireVos.add(questionnaireVo);
        //问卷四
        questionnaireVo = new QuestionnaireVo();
        userVo = new UserVo();
        questionVos = new ArrayList<>();
        userVo.setName("vvxiyu");
        userVo.setHeadPic("head7");
        questionnaireVo.setUserVo(userVo);
        questionnaireVo.setId(3l);
        questionnaireVo.setName("BAT币的用户了解程度调查？");
        questionnaireVo.setContent("大家好，我们是香港中文大学的课题小组，研究人们对比特币（虚拟货币）的了解程度及使用意向");
        questionnaireVo.setTotalNumber(1000);
        questionnaireVo.setReward(100);
        questionnaireVo.setStartTime(new Timestamp(1523289600000l));//2018-4-10
        questionnaireVo.setEndTime(new Timestamp(1524153600000l));//2018-4-20
        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
        questionnaireVo.setStatus(1);
        questionnaireVo.setUserVo(userVo);
        optionVos = new ArrayList<>();
        optionVos.add("18岁以下");
        optionVos.add("18-25岁");
        optionVos.add("26-35岁");
        optionVos.add("35岁以上");
        questionVos.add(new QuestionVo(1l,"Q1：您的年龄区间是？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("金融经济类");
        optionVos.add("电子信息技术类");
        optionVos.add("法律类");
        optionVos.add("其他");
        questionVos.add(new QuestionVo(2l,"Q2：你所属的行业/专业是？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("非常关注");
        optionVos.add("一般关注");
        optionVos.add("不关注");
        questionVos.add(new QuestionVo(3l,"Q3：你是否关注BAT币？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("非常了解");
        optionVos.add("一般了解");
        optionVos.add("不知道");
        questionVos.add(new QuestionVo(4l,"Q4：你是否知道BAT币？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("有");
        optionVos.add("没有");
        questionVos.add(new QuestionVo(5l,"Q5：你有使用过虚拟货币吗？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("有");
        optionVos.add("没有");
        questionVos.add(new QuestionVo(6l," Q6：你曾被盗窃过虚拟货币吗？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("愿意");
        optionVos.add("不愿意");
        questionVos.add(new QuestionVo(7l," Q7：你今后愿意使用BAT币吗？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("交易方便");
        optionVos.add("能应付小额支付");
        optionVos.add("以后会是主要趋势");
        optionVos.add("游戏/软件/工作需要");
        optionVos.add("其他");
        questionVos.add(new QuestionVo(8l," Q8：你认为虚拟货币的优点是什么？（多选）",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("保存在网络中容易被盗");
        optionVos.add("易因忘记账号密码而丢失");
        optionVos.add("应用普遍性不强");
        optionVos.add("不能完全实现双向兑换");
        optionVos.add("其他");
        questionVos.add(new QuestionVo(9l," Q9：若使用BAT币，你有什么忧虑？（多选）",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("愿意");
        optionVos.add("观望");
        optionVos.add("不愿意");
        questionVos.add(new QuestionVo(10l," Q10：若BAT币与实际货币实现完全双向兑换，你愿意使用吗？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("匿名");
        optionVos.add("实名制");
        questionVos.add(new QuestionVo(11l," Q11：你希望虚拟货币是匿名的还是实名制的？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("虚拟货币");
        optionVos.add("实际货币");
        optionVos.add("都可以");
        questionVos.add(new QuestionVo(12l," Q12：如果虚拟货币可实现手机移动支付，你更愿意用虚拟货币还是实际货币支付？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        questionnaireVos.add(questionnaireVo);
        //问卷五
        questionnaireVo = new QuestionnaireVo();
        userVo = new UserVo();
        questionVos = new ArrayList<>();
        userVo.setName("陈风");
        userVo.setHeadPic("head8");
        userVo.setGender(0);
        userVo.setCertification(2);
        userVo.setAnalytsLevel(4);
        questionnaireVo.setUserVo(userVo);
        questionnaireVo.setId(3l);
        questionnaireVo.setName("区块链技术在个人档案身份链中的应用优化探析的调查问卷");
        questionnaireVo.setContent("您只需要根据自己的实际情况，选择最符合情况的答案，在相应选项前打钩或根据要求填写您的看法。谢谢您的支持和帮助！");
        questionnaireVo.setTotalNumber(1000);
        questionnaireVo.setReward(100);
        questionnaireVo.setStartTime(new Timestamp(1523289600000l));//2018-4-10
        questionnaireVo.setEndTime(new Timestamp(1524153600000l));//2018-4-20
        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
        questionnaireVo.setStatus(1);
        questionnaireVo.setUserVo(userVo);
        optionVos = new ArrayList<>();
        optionVos.add("男");
        optionVos.add("女");
        questionVos.add(new QuestionVo(1l,"Q1：您的性别",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("管理学");
        optionVos.add("经济学");
        optionVos.add("理学");
        optionVos.add("工学");
        optionVos.add("文学");
        optionVos.add("其他");
        questionVos.add(new QuestionVo(2l,"Q2：您的所获学位为？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("完全没有");
        optionVos.add("知道概念而已");
        optionVos.add("有去了解过但没兴趣");
        optionVos.add("很了解很感兴趣");
        questionVos.add(new QuestionVo(3l,"Q3：您有听过区块链吗?",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("完全不知道");
        optionVos.add("知道概念而已");
        optionVos.add("知道其运行原理");
        optionVos.add("非常了解");
        questionVos.add(new QuestionVo(4l,"Q4：您了解区块链吗？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("不知道，学校管着");
        optionVos.add("大致知道");
        optionVos.add("完全了解");
        questionVos.add(new QuestionVo(5l,"Q5：对于用人单位直接提走的您的个人档案，您知道里面有什么吗?",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("非常希望");
        optionVos.add("无所谓");
        optionVos.add("不希望");
        questionVos.add(new QuestionVo(6l," Q6：您希望了解您的大学四年电子档案吗？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("很感兴趣");
        optionVos.add("无所谓，不关心");
        optionVos.add("反感");
        questionVos.add(new QuestionVo(7l," Q7：如果贵校实行个人身份链，将您的大学四年内的人事相关记录与用人单位共享，对此，您的态度是？",0,true,optionVos));
        optionVos = new ArrayList<>();
        optionVos.add("个人隐私是否被泄露");
        optionVos.add("实施应用是否繁琐");
        optionVos.add("应用中是否存在BUG（漏洞）");
        optionVos.add("其他");
        questionVos.add(new QuestionVo(8l," Q8：对于这种身份链应用（将您的大学四年所有人事相关记录与用人单位共享），您最看中哪一点？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("很有希望");
        optionVos.add("看情况，不好说");
        optionVos.add("应该不会");
        optionVos.add("绝对不会");
        questionVos.add(new QuestionVo(9l," Q9：您觉得这种技术会推广到各大高校吗？",0,true,optionVos));
        questionnaireVo.setQuestions(questionVos);
        optionVos = new ArrayList<>();
        optionVos.add("愿意");
        optionVos.add("观望");
        optionVos.add("不愿意");
        questionVos.add(new QuestionVo(10l," Q10：绝对不会",2,true,optionVos));
        questionnaireVo.setQuestions(questionVos);


        //报告真实数据
        reportVo = new ReportVo();
        reportVo.setId(1l);
        reportVo.setStatus(1);
        coinVo = new CoinVo();
        coinVo.setShortName("PRA");
        coinVo.setName("ProChain");
        coinVo.setWebsiteUrl("https://chain.pro/ ico");
        coinVo.setIcoTime(new Timestamp(1520784000000l));//2018-3-12
        coinVo.setOnlineExchangeTime(new Timestamp(1515686400000l));//2018-1-12
        coinVo.setOnlineExchange("Bitfinex,Binance,OKEx");
        coinVo.setLocation("中国");
        coinVo.setTelegraphGroup("883778");
        coinVo.setTwitterFans("3000");
        reportVo.setCoin(coinVo);
        userVo = new UserVo();
        userVo.setName("张易");
        userVo.setHeadPic("head10");
        userVo.setGender(0);
        userVo.setAnalytsLevel(3);
        userVo.setAnalytsStars(4);
        reportVo.setUser(userVo);
        reportVo.setName("般若 ProChain 区块链项目分析报告");
        reportVo.setPublishTime(new Timestamp(1520784000000l));//2018-3-12
        reportVo.setCost(40000);
        reportVo.setEvalLevel(3);
        reportVo.setCoinLevel("A");
        RateVo rateVo = new RateVo();
        rateVo.setProject(96);
        rateVo.setProjectIntro("般若 ProChain 是一个去中心化的数字广告数据生态平台，致力于 改变当前互联网广告产业低结算效率、高流量欺诈、产业各环节互不信 任的痛点。以希望成为数字广告领域的润滑剂，将产业内的摩擦成本降 到最低，同时最大化数字广告参与各方的收益。");
        rateVo.setTeam(78);
        rateVo.setTeamIntro("创始人 ProChain 目前主要有 5 位 核心 创始人， 且 半数以上 核心成员 为技 术 型 成员 ， 非常符合一个技术先进的区块链 的人员配置 。团队区块链构 架师 A hmed Alsayadi 毕业于清华大学，在百度有过丰富的软件开发经 历 ，同时在 Sigma \u007F Tech 和 ABD 累计了丰富的技术领导人 经验。数据 科学家齐巍， 核心技术构架师张京磊均在腾讯累计了 丰富的大数据 处理， 数字广告反欺诈 经验 ，且 拥 有 独 立 设 计 以 太 坊 全 球 交 易 大 数 据 监 控 系 统 的经历。 同时市场和运维方面负责人也均有 BAT 级别互联网公司相关 经验， 核心 创始团队整体能力出众。");
        rateVo.setTechnology(77);
        rateVo.setTechnologyIntro("般若 ProChain 出色的技术团队是其一 大亮点，不仅有 BAT 传统数字广告相关 技术经历的成员，又有区块链技术大拿");
        rateVo.setBusiness(87);
        rateVo.setBusinessIntro("广告主可以通过ProChain提供的智能合约广告投放终端ProDSP，投放广告，查询广告完成进度，完成者信息等。同时在智能合约中可以自定义周期／预算／价格等关键信息。");
        rateVo.setCapital(65);
        rateVo.setCapitalIntro("ProToken 总共发行 1 亿，其中核心团队 20%，早起投资者与顾 问 12%，合作方补贴 5%，社区运营 8%，合规机构轮 30%，ProChain 基金会 15%，海外公开售卖仅 10%。 从其中 30%的机构轮比例，就可以看出该项目受到了专业投资机 构的一致追捧。");
        rateVo.setInfluence(76);
        rateVo.setInfluenceIntro("在 国际市场上已有部分竞争对手开始主打区块链＋广告的研究与 探索，如 Basi c \u007F Attention ， \u007F 然而 ProChain 作为国内首个区块链 ＋广告项目，有望在国内市场占据 主动的地位 。 \u007F \u007FPro Chain 的 生态框架相对传统区块链项目更加 复杂， 技术难度也 相对较高。 ProChain 的 顶级技术团队可以利用自身在 数字 广告、 大数据、区块链行业的丰富经验更快的实现项目落地。");
        rateVo.setCoinIntro("•核心团队20%，团队份额将锁定6个月，随后每月释放锁定额度的10%；\n" +
                "•早期投资者与顾问12%，分期解锁；\n" +
                "•合作方补贴5%；\n" +
                "•社区运营8%，其中认证企业试用补贴3%，用户实名认证补贴3%，代码贡献补贴2%；\n" +
                "•预售轮30%，限机构投资者认购，分期解锁；\n" +
                "•代币公开发行10%；•ProChain基金会15%，用于项目可持续发展；");
        reportVo.setRating(rateVo);
        rateVo.setLaw(96);
        rateVo.setUserResearch(71);
        rateVo.setEnterpriseInfo(87);
        rateVo.setCoin(57);
        reportVo.setPlatformIndex("A");
        reportVo.setUserResearchList(questionnaireVos);
        List<QuestionnaireVo> enterpriseList = new ArrayList<>();
        enterpriseList.add(questionnaireVos.get(0));
        reportVo.setEnterpriseInfoList(enterpriseList);
        reportVos.add(reportVo);

        //请求真实数据
        //请求一
        requestVo = new RequestVo();
        requestVo.setId(1l);
        requestVo.setUser(userVos.get(new Random().nextInt(5)));
        coinVo = new CoinVo();
        coinVo.setName("ERC");
        coinVo.setLogoUrl("erc");
        coinVo.setWebsiteUrl("https://www.europecoin.eu.org");
        coinVo.setIcoTime(new Timestamp(1506182400000l));//2017-09-24
        coinVo.setOnlineExchangeTime(new Timestamp(1506182400000l));//2017-9-24
        coinVo.setOnlineExchange("Bittrex");
        coinVo.setLocation("美国");
        coinVo.setTelegraphGroup("87718");
        coinVo.setTwitterFans("1921");
        requestVo.setCoin(coinVo);
        requestVo.setEnterpriseName("synergy");
        requestVo.setName("ERC的数币分析报告");
        requestVo.setDemand("请求关于ERC的数币分析报告");
        requestVo.setPlatform(0);//企业平台
        requestVo.setStartTime(new Timestamp(1522684800000l));//2018-4-3
        requestVo.setEndTime(new Timestamp(1526054400000l));//2018-5-12
        requestVo.setReward(1500);
        requestVo.setStatus(1);//未接受
        requestVos.add(requestVo);
        //请求二
        requestVo = new RequestVo();
        requestVo.setId(2l);
        requestVo.setUser(userVos.get(new Random().nextInt(5)));
        coinVo = new CoinVo();
        coinVo.setName("SNRG");
        coinVo.setLogoUrl("snrg");
        coinVo.setWebsiteUrl("http://www.synergycoin.com/");
        coinVo.setIcoTime(new Timestamp(1514044800000l));//2017-12-24
        coinVo.setOnlineExchangeTime(new Timestamp(1514044800000l));//2017-12-24
        coinVo.setOnlineExchange("Bittrex、Yobit");
        coinVo.setLocation("中国");
        coinVo.setTelegraphGroup("77121");
        coinVo.setTwitterFans("2817");
        requestVo.setCoin(coinVo);
        requestVo.setEnterpriseName("synergy");
        requestVo.setName("SNR的数币分析报告");
        requestVo.setDemand("请求关于SNR的数币分析报告");
        requestVo.setPlatform(0);//企业平台
        requestVo.setStartTime(new Timestamp(1521734400000l));//2018-03-23
        requestVo.setEndTime(new Timestamp(1523980800000l));//2018-04-18
        requestVo.setReward(2000);
        requestVo.setStatus(2);//已接受
        requestVos.add(requestVo);
        //请求三
        requestVo = new RequestVo();
        requestVo.setId(3l);
        requestVo.setUser(userVos.get(new Random().nextInt(5)));
        coinVo = new CoinVo();
        coinVo.setName("FDZ");
        coinVo.setLogoUrl("fdz");
        coinVo.setWebsiteUrl("https://friendz.io/");
        coinVo.setIcoTime(new Timestamp(1517500800000l));//2018-02-02
        coinVo.setOnlineExchangeTime(new Timestamp(1521820800000l));//2018-03-24
        coinVo.setOnlineExchange("Tidex、IDEX");
        coinVo.setLocation("中国");
        coinVo.setTelegraphGroup("81771");
        coinVo.setTwitterFans("1980");
        requestVo.setCoin(coinVo);
        requestVo.setEnterpriseName("Friendz");
        requestVo.setName("FDZ的数币分析报告");
        requestVo.setDemand("请求关于银河Friendz的数币FDZ的分析报告");
        requestVo.setPlatform(0);//企业平台
        requestVo.setStartTime(new Timestamp(1523548800000l));//2018-04-13
        requestVo.setEndTime(new Timestamp(1527177600000l));// 2018-05-25
        requestVo.setReward(3000);
        requestVo.setStatus(3);//已完成
        requestVos.add(requestVo);
        //请求四
        requestVo = new RequestVo();
        requestVo.setId(4l);
        requestVo.setUser(userVos.get(new Random().nextInt(5)));
        coinVo = new CoinVo();
        coinVo.setName("VIB");
        coinVo.setLogoUrl("vib");
        coinVo.setWebsiteUrl("https://www.viberate.com");
        coinVo.setIcoTime(new Timestamp(1514822400000l));//2018-01-02
        coinVo.setOnlineExchangeTime(new Timestamp(1518364800000l));//2018-02-12
        coinVo.setOnlineExchange("OKEX、Bittrex");
        coinVo.setLocation("中国");
        coinVo.setTelegraphGroup("72812");
        coinVo.setTwitterFans("3881");
        requestVo.setCoin(coinVo);
        requestVo.setEnterpriseName("Viberate");
        requestVo.setName("VIB的数币分析报告");
        requestVo.setDemand("极高的去中心化程度让 viberate 能够及时把握音乐行业迅速变化的趋势。 使用区块链技术把对歌手、演出场地和演出活动资料的管理众包出去，是让数据库保持最新状态和具有参考价值的唯一可行方法。请求关于Viberate的数币VIB分析报告");
        requestVo.setPlatform(0);//企业平台
        requestVo.setStartTime(new Timestamp(1523808000000l));//2018-04-16
        requestVo.setEndTime(new Timestamp(1529683200000l));// 2018-06-23
        requestVo.setReward(3500);
        requestVo.setStatus(1);//已完成
        requestVos.add(requestVo);
    }

    /**
     * 跟新请求中的报告数据
     *
     * @param requestId
     * @param reportVo
     * @return
     */
    public static boolean updateRequest(Long requestId, ReportVo reportVo) {
        for (int i = 0; i < ConstantData.requestVos.size(); i++) {
            if (ConstantData.requestVos.get(i).getId().equals(requestId)) {
                ConstantData.requestVos.get(i).setReportVo(reportVo);
                return true;
            }
        }
        return false;
    }

    public static boolean updateRequestStatus(Long id, int status) {
        for (int i = 0; i < ConstantData.requestVos.size(); i++) {
            if (ConstantData.requestVos.get(i).getId().equals(id)) {
                ConstantData.requestVos.get(i).setStatus(status);
                return true;
            }
        }
        return false;
    }

    public static boolean updateReportStatus(long id, int status) {
        for (int i = 0; i < ConstantData.reportVos.size(); i++) {
            if (ConstantData.reportVos.get(i).getId() == id) {
                ConstantData.reportVos.get(i).setStatus(status);
                return true;
            }
        }
        return false;
    }

    /**
     * 答完卷后，跟新questionnaireVos，以及reportVo中的问卷
     *
     * @param vo
     * @return
     */
    public static boolean updateQuestionnaireVo(QuestionnaireVo vo) {
        Log.e("updateQuestionnaireVo", "vo.getId=" + vo.getId() + ",vo.getReportId=" + vo.getReportId());
        for (int i = 0; i < ConstantData.questionnaireVos.size(); i++) {
            Log.e("updateQuestionnaireVo", "i=" + i + " vo.getId=" + questionnaireVos.get(i).getId());
            if (vo.getId() == (ConstantData.questionnaireVos.get(i).getId())) {
                ConstantData.questionnaireVos.set(i, vo);

                //跟新requestVos
                for (int x = 0; x < requestVos.size(); x++) {
                    //请求处于没完成状态，并且报告有暂存
                    if (requestVos.get(x).getStatus() == 2 && requestVos.get(x).getReportVo() != null && requestVos.get(x).getReportVo().getId() == vo.getReportId()) {
                        if (vo.getType() == 0) {

                        } else if (vo.getType() == 1) {
                            for (int y = 0; y < requestVos.get(x).getReportVo().getUserResearchList().size(); y++) {
                                if (requestVos.get(x).getReportVo().getUserResearchList().get(y).getId() == vo.getId()) {
                                    requestVos.get(x).getReportVo().getUserResearchList().get(y).getAnswerUserList().add(vo.getAnswerUserList().get(vo.getAnswerUserList().size() - 1));
                                    Log.e("updateQuestionnaireVo", "report is not publish");
                                    return true;
                                }
                            }
                        }
                    }
                }

                //跟新reportVos
                for (int j = 0; j < ConstantData.reportVos.size(); j++) {
                    Log.e("updateQuestionnaireVo", "j=" + j + " reportId=" + reportVos.get(j).getId());
                    if (ConstantData.reportVos.get(j).getId() == vo.getReportId()) {
                        if (vo.getType() == 0) {
                            //企业问询


                        } else if (vo.getType() == 1) {
                            //用户调研
                            for (int z = 0; z < ConstantData.reportVos.get(j).getUserResearchList().size(); z++) {
                                Log.e("updateQuestionnaireVo", "z=" + z + " questionnaireId=" + reportVos.get(j).getUserResearchList().get(z).getId());
                                if (vo.getId() == ConstantData.reportVos.get(j).getUserResearchList().get(z).getId()) {
                                    Log.e("updateQuestionnaireVo", "vo.getAnserUserList.size" + vo.getAnswerUserList().size());
                                    ConstantData.reportVos.get(j).getUserResearchList().get(z).getAnswerUserList().add(vo.getAnswerUserList().get(vo.getAnswerUserList().size() - 1));
                                    Log.e("updateQuestionnaireVo", "report is publish");
                                    return true;
                                }
                            }
                        }
                    }

                }
            }

        }
        return false;
    }

    public static List<CoinVo> getIcoCoinsByStatus(List<CoinVo> lists, int type) {
        List<CoinVo> vos = new ArrayList<CoinVo>();
        for (CoinVo vo : lists) {
            if (vo.getType() == type)
                vos.add(vo);
        }
        return vos;
    }

    public static List<CoinVo> getIcoCoinsBySort(List<CoinVo> vos, int flag, final boolean isDesc) {
        if (flag == 0) {
            //roni排序
            Collections.sort(vos, new Comparator<CoinVo>() {
                @Override
                public int compare(CoinVo o1, CoinVo o2) {
                    if (isDesc) {//降序
                        if (o1.getRoni() - o2.getRoni() > 0) {
                            return -1;
                        } else if (o1.getRoni() - o2.getRoni() == 0) {
                            return 0;
                        } else if (o1.getRoni() - o2.getRoni() < 0) {
                            return 1;
                        }
                    }
                    if (o1.getRoni() - o2.getRoni() > 0) {
                        return 1;
                    } else if (o1.getRoni() - o2.getRoni() == 0) {
                        return 0;
                    } else if (o1.getRoni() - o2.getRoni() < 0) {
                        return -1;
                    }
                    return 0;
                }
            });
        } else if (flag == 1) {
            //bsri
            Collections.sort(vos, new Comparator<CoinVo>() {
                @Override
                public int compare(CoinVo o1, CoinVo o2) {
                    if (isDesc) {//降序
                        if (o1.getBsri() - o2.getBsri() > 0) {
                            return -1;
                        } else if (o1.getBsri() - o2.getBsri() == 0) {
                            return 0;
                        } else if (o1.getBsri() - o2.getBsri() < 0) {
                            return 1;
                        }
                    }
                    if (o1.getBsri() - o2.getBsri() > 0) {
                        return 1;
                    } else if (o1.getBsri() - o2.getBsri() == 0) {
                        return 0;
                    } else if (o1.getBsri() - o2.getBsri() < 0) {
                        return -1;
                    }
                    return 0;
                }
            });
        } else if (flag == 2) {
            //level
            Collections.sort(vos, new Comparator<CoinVo>() {
                @Override
                public int compare(CoinVo o1, CoinVo o2) {
                    if (isDesc) {
                        return o1.getLevel().compareTo(o2.getLevel());
                    }
                    return o2.getLevel().compareTo(o1.getLevel());
                }
            });
        }
        return vos;
    }

    public static List<CoinVo> getCurrencysBySort(List<CoinVo> vos, int flag, final boolean isDesc) {
        if (flag == 0) {
            //币值
            Collections.sort(vos, new Comparator<CoinVo>() {
                @Override
                public int compare(CoinVo o1, CoinVo o2) {
                    if (isDesc) {
                        if (o1.getMarketValue() - o2.getMarketValue() > 0) {
                            return -1;
                        } else if (o1.getMarketValue() - o2.getMarketValue() == 0) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                    if (o1.getMarketValue() - o2.getMarketValue() > 0) {
                        return 1;
                    } else if (o1.getMarketValue() - o2.getMarketValue() == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
        } else if (flag == 1) {
            //价格
            Collections.sort(vos, new Comparator<CoinVo>() {
                @Override
                public int compare(CoinVo o1, CoinVo o2) {
                    if (isDesc) {
                        if (o1.getPrice() - o2.getPrice() > 0) {
                            return -1;
                        } else if (o1.getPrice() - o2.getPrice() == 0) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                    if (o1.getPrice() - o2.getPrice() > 0) {
                        return 1;
                    } else if (o1.getPrice() - o2.getPrice() == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
        } else if (flag == 2) {
            //涨跌幅
            Collections.sort(vos, new Comparator<CoinVo>() {
                @Override
                public int compare(CoinVo o1, CoinVo o2) {
                    if (isDesc) {
                        if (o1.getRange() - o2.getRange() > 0) {
                            return -1;
                        } else if (o1.getRange() - o2.getRange() == 0) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                    if (o1.getRange() - o2.getRange() > 0) {
                        return 1;
                    } else if (o1.getRange() - o2.getRange() == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
        } else if (flag == 3) {
            //根据roni进行排序
            Collections.sort(vos, new Comparator<CoinVo>() {
                @Override
                public int compare(CoinVo o1, CoinVo o2) {
                    if (isDesc) {
                        if (o1.getRoni() - o2.getRoni() > 0) {
                            return -1;
                        } else if (o1.getRoni() - o2.getRoni() == 0) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                    if (o1.getRoni() - o2.getRoni() > 0) {
                        return 1;
                    } else if (o1.getRoni() - o2.getRoni() == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
        } else if (flag == 4) {
            //根据bsri进行排序
            Collections.sort(vos, new Comparator<CoinVo>() {
                @Override
                public int compare(CoinVo o1, CoinVo o2) {
                    if (isDesc) {
                        if (o1.getBsri() - o2.getBsri() > 0) {
                            return -1;
                        } else if (o1.getBsri() - o2.getBsri() == 0) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                    if (o1.getBsri() - o2.getBsri() > 0) {
                        return 1;
                    } else if (o1.getBsri() - o2.getBsri() == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
        }
        return vos;
    }

    public static void addReportToUser(ReportVo vo) {
        if (!mUserVo.getReports().contains(vo)) {
            mUserVo.getReports().add(vo);
        }
    }

}
