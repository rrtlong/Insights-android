package com.imalljoy.insights.common;

import android.util.Log;

import com.imalljoy.insights.entity.PersonasVo;
import com.imalljoy.insights.entity.QuestionnaireVo;
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
    }

}
