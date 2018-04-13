package com.imalljoy.insightdemo.common;

import com.imalljoy.insightdemo.entity.QuestionnaireVo;
import com.imalljoy.insightdemo.entity.ReportVo;

/**
 * Created by lijilong on 03/27.
 */

public class LocalData {
    private volatile static LocalData instance = null;

    private LocalData() {
    }

    public static LocalData getInstance() {
        if (instance == null) {
            synchronized (LocalData.class) {
                if (instance == null) {
                    instance = new LocalData();
                }
            }
        }
        return instance;
    }
    //正在操作的报告实体，存在这里，方便数据存取，跟新View
    private ReportVo mReportVo;
    //正在操作的问卷
    private QuestionnaireVo mQuestionnaireVo;

    public ReportVo getmReportVo() {
        return mReportVo;
    }

    public void setmReportVo(ReportVo mReportVo) {
        this.mReportVo = mReportVo;
    }

    public QuestionnaireVo getmQuestionnaireVo() {
        return mQuestionnaireVo;
    }

    public void setmQuestionnaireVo(QuestionnaireVo mQuestionnaireVo) {
        this.mQuestionnaireVo = mQuestionnaireVo;
    }
}
