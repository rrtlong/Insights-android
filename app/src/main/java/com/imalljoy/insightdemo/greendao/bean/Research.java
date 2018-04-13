package com.imalljoy.insightdemo.greendao.bean;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by lijilong on 03/08.
 */

public class Research {
    private long id;    //唯一id
    private String title;  //问卷标题
    private String describe;  //问卷描述
    private long initiatorId;  //发起人id
    private String initiatorCompany;  //发起人公司
    private String initiatorHeadPic;  //发起人头像
    private double initiatorReward;  //发起人设置INB奖励
    private String initiatorRequire;  //发起人调研要求
    private Timestamp initiatorValidateFrom;  //发起人设置有效期开始时间
    private Timestamp initiatorValidateTo;  //发起人设置有效期开始时间
    private long analystId;     //分析师Id
    private String analystName;  //分析师昵称
    private String analystHeadPic;  //分析师头像
    private String ananysGetReward;  //分析师完成后得到的INB奖励
    private String analysSetReward;  //分析师设置答卷INB奖励
    private List<Question> questions; //分析师设置的问题
    private Timestamp analysSetValidateFrom;  //分析师设置答卷有效期开始时间
    private Timestamp analysSetValidateTo;  //分析师设置答卷有效期结束时间
    private int respondentType;  //答卷人类型,答卷人画像
    private String investorGetReward;  //投资者填写发布问卷后获得的INB;
    private String initiatorGetScore;  //分析师得到企业打的分数
    private double initiatorGetExtraReward;  //分析师得到额外的奖励INB;
    private int requestionnaireType;  //形式,问卷,投票
    private String result;
    private String analysicReport;  //分析报告,分析师手写
    private int reportRate;  //分析报告评级
    private Timestamp createTime;  //创建时间
    private Timestamp updateTime;  //更新时间

}
