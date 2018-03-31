package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.bus.RefreshView;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.common.LocalData;
import com.imalljoy.insights.entity.QuestionnaireVo;
import com.imalljoy.insights.entity.ReportVo;
import com.imalljoy.insights.greendao.bean.Question;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBar;
import com.imalljoy.insights.widgets.TopBarCommon;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/20.
 */

public class EnterpriseActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private int mType;   //0:企业问询界面 1:用户调研界面
    private int mStatus; //0:能编辑;1:只能查看
    private ReportVo mReportVo;
    private EnterpriseAdapter mAdapter;
    private static final String TAG = "EnterpriseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_enterprise_and_userresearch);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mType = getIntent().getIntExtra("type", 0);
        mStatus = getIntent().getIntExtra("status", 0);
        mReportVo = LocalData.getInstance().getmReportVo();
        Log.e(TAG,"mReport=" + (mReportVo == null));
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText(mType == 0 ? "企业问询" : "用户调研");
        if (mStatus == 0) {
            topBar.setRightView(mType == 0 ? "发起问询" : "发起问卷", 0);
        } else {
            topBar.setRightView(null, 0);
        }
        topBar.top_bar_right_layout.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.addItemDecoration(divider);

        mAdapter = new EnterpriseAdapter(this, mType ==0 ?
                mReportVo == null ? new ArrayList<QuestionnaireVo>() : mReportVo.getEnterpriseInfoList()  :
                mReportVo == null ? new ArrayList<QuestionnaireVo>() : mReportVo.getUserResearchList(),
                mType, mStatus);
        recyclerview.setAdapter(mAdapter);


    }
    public void refreshData(){
        mReportVo = LocalData.getInstance().getmReportVo();
        mAdapter.setData(mType ==0 ? mReportVo.getEnterpriseInfoList() : mReportVo.getUserResearchList());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.top_bar_right_layout:
                BuildQuestionnaireActivity.toActivity(this, null, mStatus,mType);
                break;
        }
    }

    public List<QuestionnaireVo> getData() {
        List<QuestionnaireVo> vos = new ArrayList<>();
        QuestionnaireVo vo = new QuestionnaireVo();
        vo.setId(1l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1520611200000l));//2018-3-10
        vo.setEndTime(new Timestamp(1525881600000l));//2018-5-10
        vo.setStatus(0);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(2l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1525881600000l));//2018-5-10
        vo.setEndTime(new Timestamp(1526140800000l));//2018-5-13
        vo.setStatus(0);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(3l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1520524800000l));//2018-3-9
        vo.setEndTime(new Timestamp(1520611200000l));//2018-3-10
        vo.setStatus(0);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(4l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1520524800000l));//2018-3-9
        vo.setEndTime(new Timestamp(1520611200000l));//2018-3-10
        vo.setStatus(3);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(5l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1520611200000l));//2018-3-10
        vo.setEndTime(new Timestamp(1525881600000l));//2018-5-10
        vo.setStatus(0);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(6l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1525881600000l));//2018-5-10
        vo.setEndTime(new Timestamp(1526140800000l));//2018-5-13
        vo.setStatus(0);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(7l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1520524800000l));//2018-3-9
        vo.setEndTime(new Timestamp(1520611200000l));//2018-3-10
        vo.setStatus(0);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(8l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1520524800000l));//2018-3-9
        vo.setEndTime(new Timestamp(1520611200000l));//2018-3-10
        vo.setStatus(3);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(9l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1520611200000l));//2018-3-10
        vo.setEndTime(new Timestamp(1525881600000l));//2018-5-10
        vo.setStatus(0);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(10l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1525881600000l));//2018-5-10
        vo.setEndTime(new Timestamp(1526140800000l));//2018-5-13
        vo.setStatus(0);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(11l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1520524800000l));//2018-3-9
        vo.setEndTime(new Timestamp(1520611200000l));//2018-3-10
        vo.setStatus(0);
        vos.add(vo);

        vo = new QuestionnaireVo();
        vo.setId(12l);
        vo.setUserVo(ConstantData.userVos.get(new Random().nextInt(5)));
        vo.setName("名称");
        vo.setContent("描述描述描述描述");
        vo.setReward(33);
        vo.setTotalNumber(200);
        vo.setFinishedNumber(100);
        vo.setStartTime(new Timestamp(1520524800000l));//2018-3-9
        vo.setEndTime(new Timestamp(1520611200000l));//2018-3-10
        vo.setStatus(3);
        vos.add(vo);
        return vos;
    }

    @Subscribe
    public void onEvent(RefreshView refreshView){
        Log.e(TAG,"onEvent refreshView");
        if(refreshView.getFlag() == RefreshView.REFRESH_REPORT_FROM_QUESTIONNAIRE){
            if(mStatus ==0){
                if(mType ==0){
                    LocalData.getInstance().getmReportVo().getEnterpriseInfoList().add(LocalData.getInstance().getmQuestionnaireVo());
                }else if(mType ==1){
                    Log.e(TAG,"userResearchSize"+ LocalData.getInstance().getmReportVo().getUserResearchList().size());
                    LocalData.getInstance().getmReportVo().getUserResearchList().add(LocalData.getInstance().getmQuestionnaireVo());
                    Log.e(TAG,"userResearchSize"+ LocalData.getInstance().getmReportVo().getUserResearchList().size());
                }
                refreshData();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public static void toActivity(Context context, int type, int status) {
        Intent it = new Intent(context, EnterpriseActivity.class);
        it.putExtra("type", type);
        it.putExtra("status", status);
        context.startActivity(it);
    }
}
