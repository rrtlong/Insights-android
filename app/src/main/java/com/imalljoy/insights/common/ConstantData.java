package com.imalljoy.insights.common;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;

import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.entity.PersonasVo;
import com.imalljoy.insights.entity.QuestionnaireVo;
import com.imalljoy.insights.entity.ReportVo;
import com.imalljoy.insights.entity.RequestVo;
import com.imalljoy.insights.entity.UserVo;
import com.imalljoy.insights.mvps.coins.AirdropAdapter;
import com.imalljoy.insights.mvps.coins.CoinsChildFragment;
import com.imalljoy.insights.mvps.coins.detail.VoteStep1Adapter;

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
        userVo.setName("刘一");
        userVo.setHeadPic("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1711359766,3731166763&fm=111&gp=0.jpg");
        userVo.setGender(1);
        userVos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(2l);
        userVo.setName("陈二");
        userVo.setHeadPic("http://5b0988e595225.cdn.sohucs.com/images/20180316/4e8447f23a1f480993f73811a7dea77b.jpeg");
        userVo.setGender(0);
        userVos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(3l);
        userVo.setName("张三");
        userVo.setHeadPic("http://www.qqxoo.com/uploads/allimg/180315/144H61548-5.jpg");
        userVo.setGender(1);
        userVos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(4l);
        userVo.setName("李四");
        userVo.setHeadPic("http://img0.imgtn.bdimg.com/it/u=4016867486,3765799418&fm=11&gp=0.jpg");
        userVo.setGender(0);
        userVos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(5l);
        userVo.setName("王五");
        userVo.setHeadPic("http://pic.qqtn.com/up/2018-3/15211045617076231.jpg");
        userVo.setGender(1);
        userVos.add(userVo);
        Log.e("userVos", userVos.toString());

        mUserVo = userVos.get(new Random().nextInt(5));
        CoinVo coinVo = new CoinVo();
        coinVo.setId(1l);
        coinVo.setName("比特币");
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");

        QuestionnaireVo questionnaireVo = new QuestionnaireVo();
        questionnaireVo.setUserVo(userVos.get(new Random().nextInt(5)));
        questionnaireVo.setId(1l);
        questionnaireVo.setName("你最爱吃什么");
        questionnaireVo.setContent("描述描述秒速描述描述秒速描述描述秒速描述描述秒速");
        questionnaireVo.setTotalNumber(100);
        questionnaireVo.setReward(100);
        questionnaireVo.setStartTime(new Timestamp(1508342400000l));//2017-10-19
        questionnaireVo.setEndTime(new Timestamp(1508601600000l));//2017-10-22
        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
        questionnaireVo.setStatus(1);
        questionnaireVo.setUserVo(mUserVo);

        questionnaireVos.add(questionnaireVo);

        questionnaireVo = new QuestionnaireVo();
        questionnaireVo.setUserVo(userVos.get(new Random().nextInt(5)));
        questionnaireVo.setId(2l);
        questionnaireVo.setName("你想从事什么职业");
        questionnaireVo.setContent("描述描述秒速描述描述秒速描述描述秒速描述描述秒速");
        questionnaireVo.setTotalNumber(50);
        questionnaireVo.setReward(50);
        questionnaireVo.setStartTime(new Timestamp(1521043200000l));//2018-3-15
        questionnaireVo.setEndTime(new Timestamp(1533686400000l));//2018-8-8
        questionnaireVo.setPersonas(new PersonasVo(21, 0, "上海"));
        questionnaireVo.setStatus(2);
        questionnaireVo.setUserVo(mUserVo);
        questionnaireVos.add(questionnaireVo);

        questionnaireVo = new QuestionnaireVo();
        questionnaireVo.setUserVo(userVos.get(new Random().nextInt(5)));
        questionnaireVo.setId(3l);
        questionnaireVo.setName("你周末想干啥");
        questionnaireVo.setContent("描述描述秒速描述描述秒速描述描述秒速描述描述秒速");
        questionnaireVo.setTotalNumber(200);
        questionnaireVo.setReward(50);
        questionnaireVo.setStartTime(new Timestamp(1533686400000l));//2018-8-8
        questionnaireVo.setEndTime(new Timestamp(1533686400000l));//2018-8-8
        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
        questionnaireVo.setStatus(1);
        questionnaireVo.setUserVo(mUserVo);
        questionnaireVos.add(questionnaireVo);
        Log.e("questionnaireVos", questionnaireVos.toString());

        RequestVo requestVo = new RequestVo();
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
        requestVos.add(requestVo);

        ReportVo reportVo = new ReportVo();
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
        reportVos.add(reportVo);

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
        coinVo.setWhiteBookUrl("http://www.bitcoin.org/bitcoin.pdf");
        coinVo.setBlockStationUrl("https://blockchain.info/");
        coinVo.setLocation("美国");
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setName("Rthereum");
        coinVo.setShortName("ETH");
        coinVo.setChineseName("以太坊");
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
        coinVo.setWhiteBookUrl("https://github.com/ethereum/wiki/wiki/%5BEnglish%5D-White-Paper");
        coinVo.setBlockStationUrl("https://etherscan.io/");
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setName("Ripple");
        coinVo.setShortName("XRP");
        coinVo.setChineseName("瑞波币");
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
        coinVo.setMarketValue(120107368754d);
        coinVo.setRank(3);
        coinVo.setWhiteBookUrl("https://ripple.com/files/ripple_consensus_whitepaper.pdf");
        coinVo.setBlockStationUrl("https://ripple.com/graph");
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setName("Litecoin");
        coinVo.setShortName("LTC");
        coinVo.setChineseName("莱特币");
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
        coinVo.setWhiteBookUrl("https://github.com/ethereum/wiki/wiki/%5BEnglish%5D-White-Paper");
        coinVo.setBlockStationUrl("http://explorer.litecoin.net/c");
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setName("柚子");
        coinVo.setShortName("EOS");
        coinVo.setChineseName("柚子");
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
        coinVo.setWhiteBookUrl("https://github.com/EOSIO/Documentation/blob/master/TechnicalWhitePaper.md");
        coinVo.setBlockStationUrl("https://etherscan.io/token/EOS");
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setName("Cardano");
        coinVo.setShortName("ADA");
        coinVo.setChineseName("艾达币");
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
        coinVo.setMarketValue(24500454906d);
        coinVo.setRank(6);
        coinVo.setWhiteBookUrl("https://www.cardanohub.org/zh/academic-papers-3/");
        coinVo.setBlockStationUrl("https://cardanoexplorer.com/");
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
        coinVo.setWhiteBookUrl("https://files.acrobat.com/a/preview/75fe0af9-d98b-4002-863c-138b43a131ef");
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
        coinVo.setWhiteBookUrl("https://fogcoin.io/documents/FogCoin-Whitepaper.pdf");
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
        coinVo.setWhiteBookUrl("https://theabyss.docsend.com/view/nff9r2c");
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
        coinVo.setWhiteBookUrl("https://www.eligma.io/pdf/eligma-white-paper_v1.1.pdf");
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
        coinVo.setIcoEndTime(new Timestamp(1534262400000l));//2018-8-15
        coinVo.setWhiteBookUrl("http://whitepaper.galaxy-esolutions.com/GES_Business_Deck_Full_Version_EN.pdf");
        icoCoinVos.add(coinVo);
        //airdrop coin
        coinVo = new CoinVo();
        coinVo.setShortName("ACT");
        coinVo.setPriceConvert("1.08CNY=0.1725USDT");
        coinVo.setPrice(1.08f);
        coinVo.setPrice2("CNY");
        coinVo.setPrice3(0.1725f);
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
        coinVo.setWhiteBookUrl("https://www.achain.com/Achain%20Whitepaper%202.0_CHS.pdf");
        coinVo.setBlockStationUrl("https://browser.achain.com/");
        coinVo.setTelegraphGroup("25695");
        airdropCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("SWTC");
        coinVo.setPriceConvert("0.0359CNY=0.0053USDT");
        coinVo.setPrice(0.0359f);
        coinVo.setPrice2("CNY");
        coinVo.setPrice3(0.0053f);
        coinVo.setPrice4("USDT");
        coinVo.setAirDropNum(100000);
        coinVo.setRange(-0.0576f);
        coinVo.setHigh24(0.0449);
        coinVo.setLow24(0.0349);
        coinVo.setVol24(254639);
        coinVo.setMarketValue(3585085560d);
        coinVo.setRank(657);
        coinVo.setTurnover(461580723);
        coinVo.setName("斯微特");
        coinVo.setLogoUrl("SWTC.png");
        coinVo.setBlockStationUrl("http://state.jingtum.com/");
        airdropCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("UGC");
        coinVo.setPriceConvert("0.1817CNY=0.0289USDT");
        coinVo.setPrice(0.1817f);
        coinVo.setPrice2("CNY");
        coinVo.setPrice3(0.0289f);
        coinVo.setPrice4("USDT");
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
        airdropCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setShortName("CMT");
        coinVo.setLogoUrl("CMT.png");
        coinVo.setPriceConvert("0.5018CNY=0.0797USDT");
        coinVo.setPrice(0.5018f);
        coinVo.setPrice2("CNY");
        coinVo.setPrice3(0.0797f);
        coinVo.setPrice4("USDT");
        coinVo.setAirDropNum(700);
        coinVo.setRange(-0.0025f);
        coinVo.setHigh24(0.5307);
        coinVo.setLow24(0.4898);
        coinVo.setVol24(79149472);
        coinVo.setMarketValue(351267755);
        coinVo.setRank(137);
        coinVo.setTurnover(700000000);
        coinVo.setName("Achain");
        coinVo.setWhiteBookUrl("https://cm.5miles.com/file/technical/Technical%20Whitepaper_zh-tw.pdf");
        airdropCoinVos.add(coinVo);
        optionalCoinVos1.add(currencyCoinVos.get(0));
        optionalCoinVos1.add(currencyCoinVos.get(1));
        optionalCoinVos2.add(icoCoinVos.get(0));
        optionalCoinVos2.add(icoCoinVos.get(1));
        optionalCoinVos3.add(airdropCoinVos.get(0));
        optionalCoinVos3.add(airdropCoinVos.get(1));


        long baseId = System.currentTimeMillis() / 1000;

        reportVo = new ReportVo();
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
