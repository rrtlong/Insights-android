package com.imalljoy.insights.common;

import android.util.Log;

import com.imalljoy.insights.entity.PersonasVo;
import com.imalljoy.insights.entity.QuestionnaireVo;
import com.imalljoy.insights.entity.ReportVo;
import com.imalljoy.insights.entity.RequestVo;
import com.imalljoy.insights.entity.UserVo;

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
    public static UserVo mUserVo;

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
        questionnaireVos.add(questionnaireVo);

        questionnaireVo = new QuestionnaireVo();
        questionnaireVo.setUserVo(userVos.get(new Random().nextInt(5)));
        questionnaireVo.setId(2l);
        questionnaireVo.setName("你想从事什么职业");
        questionnaireVo.setContent("描述描述秒速描述描述秒速描述描述秒速描述描述秒速");
        questionnaireVo.setTotalNumber(50);
        questionnaireVo.setReward(50);
        questionnaireVo.setStartTime(new Timestamp(1521043200000l));//2018-3-15
        questionnaireVo.setEndTime(new Timestamp(1521216000000l));//2018-3-17
        questionnaireVo.setPersonas(new PersonasVo(21, 0, "上海"));
        questionnaireVos.add(questionnaireVo);

        questionnaireVo = new QuestionnaireVo();
        questionnaireVo.setUserVo(userVos.get(new Random().nextInt(5)));
        questionnaireVo.setId(3l);
        questionnaireVo.setName("你周末想干啥");
        questionnaireVo.setContent("描述描述秒速描述描述秒速描述描述秒速描述描述秒速");
        questionnaireVo.setTotalNumber(200);
        questionnaireVo.setReward(50);
        questionnaireVo.setStartTime(new Timestamp(1521216000000l));//2018-3-17
        questionnaireVo.setEndTime(new Timestamp(1521475200000l));//2018-2-20
        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
        questionnaireVos.add(questionnaireVo);
        Log.e("questionnaireVos",questionnaireVos.toString());

        RequestVo requestVo = new RequestVo();
        requestVo.setId(1l);
        requestVo.setUser(userVos.get(new Random().nextInt(5)));
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
        requestVo.setName("名称");
        requestVo.setPlatform(1);
        requestVo.setDemand("2天之内给出结果");
        requestVo.setReward(66);
        requestVo.setStatus(2);//已接受
        requestVo.setStartTime(new Timestamp(1508342400000l));//2017-10-19
        requestVo.setEndTime(new Timestamp(1508601600000l));//2017-10-22
        requestVos.add(requestVo);

        requestVo = new RequestVo();
        requestVo.setId(1l);
        requestVo.setUser(userVos.get(new Random().nextInt(5)));
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
        reportVo.setScore(100);
        reportVos.add(reportVo);

        reportVo = new ReportVo();
        reportVo.setId(2l);
        reportVo.setUser(userVos.get(new Random().nextInt(5)));
        reportVo.setName("名称");
        reportVo.setContent("内容内容内容内容内容内容内容内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(66);
        reportVo.setScore(80);
        reportVos.add(reportVo);

        reportVo = new ReportVo();
        reportVo.setId(3l);
        reportVo.setUser(userVos.get(new Random().nextInt(5)));
        reportVo.setName("名称");
        reportVo.setContent("内容内容内容内容内容内容内容内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(99);
        reportVo.setScore(60);
        reportVos.add(reportVo);

        reportVo = new ReportVo();
        reportVo.setId(4l);
        reportVo.setUser(userVos.get(new Random().nextInt(5)));
        reportVo.setName("名称");
        reportVo.setContent("内容内容内容内容内容内容内容内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(110);
        reportVo.setScore(40);
        reportVos.add(reportVo);

        reportVo = new ReportVo();
        reportVo.setId(5l);
        reportVo.setUser(userVos.get(new Random().nextInt(5)));
        reportVo.setName("名称");
        reportVo.setContent("内容内容内容内容内容内容内容内容");
        reportVo.setPublishTime(new Timestamp(1520843100000l));
        reportVo.setReward(33);
        reportVo.setScore(30);
        reportVos.add(reportVo);
    }

}
