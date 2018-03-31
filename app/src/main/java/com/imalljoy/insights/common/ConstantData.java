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

import java.sql.Timestamp;
import java.util.ArrayList;
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

    public static UserVo mUserVo;
    public static int requestRequestCode = 0;
    public static int reportRequestCode = 1;
    public static int buildQuestionnaireRequestCode = 2;

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
        Log.e("userVos" , userVos.toString());

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
        Log.e("questionnaireVos",questionnaireVos.toString());

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
        reportVo.setName("名称");
        reportVo.setContent("内容内容内容内容内容内容内容内容");
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
        reportVo.setName("名称");
        reportVo.setContent("内容内容内容内容内容内容内容内容");
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
        reportVo.setName("名称");
        reportVo.setContent("内容内容内容内容内容内容内容内容");
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
        reportVo.setName("名称");
        reportVo.setContent("内容内容内容内容内容内容内容内容");
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
        reportVo.setName("名称");
        reportVo.setContent("内容内容内容内容内容内容内容内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(33);
        reportVo.setGrade(30);
        requestVo = new RequestVo();
        requestVo.setName("请求名");
        requestVo.setCoin(coinVo);
        reportVo.setRequest(requestVo);
        reportVo.setStatus(1);
        reportVos.add(reportVo);

        coinVo = new CoinVo();
        coinVo.setId(1l);
        coinVo.setType(5);//币市
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setName("Bitcoin");
        coinVo.setShortName("BTC");
        coinVo.setPrice(51921.47f);
        coinVo.setExchangeRate(530.19f);
        coinVo.setForCoin("USDT");
        coinVo.setRange(0.06334f);
        currencyCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(2l);
        coinVo.setType(5);//币市
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setName("Ethereum");
        coinVo.setShortName("ETH");
        coinVo.setPrice(51921.47f);
        coinVo.setExchangeRate(530.19f);
        coinVo.setForCoin("USDT");
        coinVo.setRange(-0.06326f);
        currencyCoinVos.add(coinVo);

        //new Timestamp(1519056000000l));//2018-2-20
        //new Timestamp(1521907200000l));//2018-3-25
        //new Timestamp(1524585600000l));//2018-4-25
        //new Timestamp(1527177600000l));//2015-5-25
        coinVo = new CoinVo();
        coinVo.setId(3l);
        coinVo.setType(1);//新上
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("新上A");
        coinVo.setName("新上a");
        coinVo.setIcoTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setRoni(100);
        coinVo.setLevel("A");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(4l);
        coinVo.setType(1);//新上
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("新上B");
        coinVo.setName("新上b");
        coinVo.setIcoTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setRoni(90);
        coinVo.setLevel("B");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(5l);
        coinVo.setType(1);//新上
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("新上C");
        coinVo.setName("新上c");
        coinVo.setIcoTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setRoni(80);
        coinVo.setLevel("C");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(6l);
        coinVo.setType(2);//即将ico
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("即将ICOA");
        coinVo.setName("即将ICOa");
        coinVo.setIcoTime(new Timestamp(1524585600000l));//2018-4-25
        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setRoni(100);
        coinVo.setLevel("A");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(7l);
        coinVo.setType(2);//即将ico
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("即将ICOB");
        coinVo.setName("即将ICOb");
        coinVo.setIcoTime(new Timestamp(1524585600000l));//2018-4-25
        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setRoni(90);
        coinVo.setLevel("B");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(8l);
        coinVo.setType(2);//即将ico
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("即将ICOC");
        coinVo.setName("即将ICOc");
        coinVo.setIcoTime(new Timestamp(1524585600000l));//2018-4-25
        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setRoni(80);
        coinVo.setLevel("C");
        icoCoinVos.add(coinVo);

        coinVo = new CoinVo();
        coinVo.setId(9l);
        coinVo.setType(3);//正在ico
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("正在ICOA");
        coinVo.setName("正在ICOa");
        coinVo.setIcoTime(new Timestamp(1521907200000l));//2018-3-25
        coinVo.setIcoEndTime(new Timestamp(1524585600000l));//2015-4-25
        coinVo.setRoni(100);
        coinVo.setLevel("A");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(10l);
        coinVo.setType(3);//正在ico
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("正在ICOB");
        coinVo.setName("正在ICOb");
        coinVo.setIcoTime(new Timestamp(1521907200000l));//2018-3-25
        coinVo.setIcoEndTime(new Timestamp(1524585600000l));//2015-4-25
        coinVo.setRoni(90);
        coinVo.setLevel("B");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(11l);
        coinVo.setType(3);//正在ico
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("正在ICOC");
        coinVo.setName("正在ICOc");
        coinVo.setIcoTime(new Timestamp(1521907200000l));//2018-3-25
        coinVo.setIcoEndTime(new Timestamp(1524585600000l));//2015-4-25
        coinVo.setRoni(80);
        coinVo.setLevel("C");
        icoCoinVos.add(coinVo);

        coinVo = new CoinVo();
        coinVo.setId(12l);
        coinVo.setType(4);//ICO结束
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("ICO结束A");
        coinVo.setName("ICO结束a");
        coinVo.setIcoTime(new Timestamp(1519056000000l));//2015-2-20
        coinVo.setIcoEndTime(new Timestamp(1521907200000l));//2018-3-25
        coinVo.setRoni(100);
        coinVo.setLevel("A");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(13l);
        coinVo.setType(4);//ICO结束
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("ICO结束B");
        coinVo.setName("ICO结束b");
        coinVo.setIcoTime(new Timestamp(1519056000000l));//2015-2-20
        coinVo.setIcoEndTime(new Timestamp(1521907200000l));//2018-3-25
        coinVo.setRoni(90);
        coinVo.setLevel("B");
        icoCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(14l);
        coinVo.setType(4);//ICO结束
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("ICO结束C");
        coinVo.setName("ICO结束c");
        coinVo.setIcoTime(new Timestamp(1519056000000l));//2015-2-20
        coinVo.setIcoEndTime(new Timestamp(1521907200000l));//2018-3-25
        coinVo.setRoni(80);
        coinVo.setLevel("C");
        icoCoinVos.add(coinVo);

        coinVo = new CoinVo();
        coinVo.setId(15l);
        coinVo.setType(0);//空投 未开始
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("空投A");
        coinVo.setName("空投a");
        coinVo.setIcoTime(new Timestamp(1524585600000l));//2018-4-25
        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setPrice(51921.47f);
        coinVo.setAirDropNum(1000);
        airdropCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(16l);
        coinVo.setType(0);//空投 已开始，没结束
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("空投B");
        coinVo.setName("空投b");
        coinVo.setIcoTime(new Timestamp(1521907200000l));//2018-3-25
        coinVo.setIcoEndTime(new Timestamp(1527177600000l));//2015-5-25
        coinVo.setPrice(61232.21f);
        coinVo.setAirDropNum(80);
        airdropCoinVos.add(coinVo);
        coinVo = new CoinVo();
        coinVo.setId(17l);
        coinVo.setType(0);//空投 已结束
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
        coinVo.setShortName("空投C");
        coinVo.setName("空投c");
        coinVo.setIcoTime(new Timestamp(1519056000000l));//2015-2-20
        coinVo.setIcoEndTime(new Timestamp(1521907200000l));//2018-3-25
        coinVo.setPrice(42126.89f);
        coinVo.setAirDropNum(500);
        airdropCoinVos.add(coinVo);

        optionalCoinVos1.add(currencyCoinVos.get(0));
        optionalCoinVos1.add(currencyCoinVos.get(1));
        optionalCoinVos2.add(icoCoinVos.get(0));
        optionalCoinVos2.add(icoCoinVos.get(1));
        optionalCoinVos3.add(airdropCoinVos.get(0));
        optionalCoinVos3.add(airdropCoinVos.get(1));

    }

    /**
     * 跟新请求中的报告数据
     * @param requestId
     * @param reportVo
     * @return
     */
    public static boolean updateRequest(Long requestId, ReportVo reportVo){
        for(int i=0;i<ConstantData.requestVos.size();i++){
            if(ConstantData.requestVos.get(i).getId().equals(requestId)){
                ConstantData.requestVos.get(i).setReportVo(reportVo);
                return true;
            }
        }
        return false;
    }

    public static boolean updateRequestStatus(Long id, int status){
        for (int i = 0; i < ConstantData.requestVos.size(); i++) {
            if (ConstantData.requestVos.get(i).getId().equals(id)) {
                ConstantData.requestVos.get(i).setStatus(status);
                return true;
            }
        }
        return false;
    }

    public static boolean updateReportStatus(long id, int status){
        for(int i=0; i< ConstantData.reportVos.size(); i++){
            if(ConstantData.reportVos.get(i).getId() == id){
                ConstantData.reportVos.get(i).setStatus(status);
                return true;
            }
        }
        return false;
    }

    /**
     * 答完卷后，跟新questionnaireVos，以及reportVo中的问卷
     * @param vo
     * @return
     */
    public static boolean updateQuestionnaireVo(QuestionnaireVo vo){
        Log.e("updateQuestionnaireVo","vo.getId=" + vo.getId() + ",vo.getReportId=" + vo.getReportId());
        for (int i = 0; i < ConstantData.questionnaireVos.size(); i++) {
            Log.e("updateQuestionnaireVo", "i=" + i + " vo.getId=" + questionnaireVos.get(i).getId());
            if (vo.getId() == (ConstantData.questionnaireVos.get(i).getId())) {
                ConstantData.questionnaireVos.set(i,vo);

                //跟新requestVos
                for(int x=0;x<requestVos.size(); x++){
                    //请求处于没完成状态，并且报告有暂存
                    if(requestVos.get(x).getStatus() == 2 && requestVos.get(x).getReportVo() != null &&requestVos.get(x).getReportVo().getId() == vo.getReportId()){
                        if(vo.getType() ==0){

                        }else if(vo.getType() ==1){
                            for(int y=0; y<requestVos.get(x).getReportVo().getUserResearchList().size();y++){
                                if(requestVos.get(x).getReportVo().getUserResearchList().get(y).getId() == vo.getId()){
                                    requestVos.get(x).getReportVo().getUserResearchList().get(y).getAnswerUserList().add(vo.getAnswerUserList().get(vo.getAnswerUserList().size()-1));
                                    Log.e("updateQuestionnaireVo","report is not publish");
                                    return true;
                                }
                            }
                        }
                    }
                }

                //跟新reportVos
                for(int j=0; j<ConstantData.reportVos.size(); j++){
                    Log.e("updateQuestionnaireVo","j=" + j + " reportId=" + reportVos.get(j).getId());
                    if(ConstantData.reportVos.get(j).getId() == vo.getReportId()){
                        if (vo.getType() == 0){
                            //企业问询


                        }else if(vo.getType() ==1) {
                            //用户调研
                            for(int z=0; z<ConstantData.reportVos.get(j).getUserResearchList().size();z++){
                                Log.e("updateQuestionnaireVo","z=" + z + " questionnaireId=" + reportVos.get(j).getUserResearchList().get(z).getId());
                                if(vo.getId() == ConstantData.reportVos.get(j).getUserResearchList().get(z).getId()){
                                    Log.e("updateQuestionnaireVo","vo.getAnserUserList.size" + vo.getAnswerUserList().size());
                                    ConstantData.reportVos.get(j).getUserResearchList().get(z).getAnswerUserList().add(vo.getAnswerUserList().get(vo.getAnswerUserList().size()-1));
                                    Log.e("updateQuestionnaireVo","report is publish");
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

}
