package com.imalljoy.insights.bus;

/**
 * Created by lijilong on 03/27.
 */

public class RefreshView {
    //新建报告的调查问卷，通知问卷列表跟新数据，报告页面跟新数据
    public static int REFRESH_REPORT_FROM_QUESTIONNAIRE = 0;
    private int flag;

    public RefreshView(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
