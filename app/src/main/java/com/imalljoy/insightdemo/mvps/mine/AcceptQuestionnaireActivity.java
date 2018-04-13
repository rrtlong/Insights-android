package com.imalljoy.insightdemo.mvps.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseActivity;
import com.imalljoy.insightdemo.common.ConstantData;
import com.imalljoy.insightdemo.entity.PersonasVo;
import com.imalljoy.insightdemo.entity.QuestionnaireVo;
import com.imalljoy.insightdemo.mvps.research.EnterpriseAdapter;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.widgets.TopBarCommon;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class AcceptQuestionnaireActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    List<QuestionnaireVo> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_accept_questionnaire);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("我做过的调查问卷");
        topBar.setRightView(null, 0);
        initView();

    }

    private void initView() {
        LinearLayoutManager linearManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearManager);
        recyclerview.addItemDecoration(divider);
        listData = getData();
        //展示已答问卷列表，点进去直接显示答题结果
        recyclerview.setAdapter(new EnterpriseAdapter(this, ConstantData.questionnaireVos,0,1));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                finish();
                break;
        }
    }
    public static void toActivity(Context context){
        Intent it = new Intent(context, AcceptQuestionnaireActivity.class);
        context.startActivity(it);
    }

    public List<QuestionnaireVo> getData() {
        List<QuestionnaireVo> vos = new ArrayList<>();
        long baseId = System.currentTimeMillis() / 1000;
        QuestionnaireVo questionnaireVo = new QuestionnaireVo();
        questionnaireVo.setId(baseId);
        questionnaireVo.setName("你最爱吃什么");
        questionnaireVo.setContent("问卷调查一内容");
        questionnaireVo.setTotalNumber(100);
        questionnaireVo.setReward(100);
        questionnaireVo.setStartTime(new Timestamp(1508342400000l));//2017-10-19
        questionnaireVo.setEndTime(new Timestamp(1508601600000l));//2017-10-22
        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
        questionnaireVo.setStatus(4);
        questionnaireVo.setUserVo(ConstantData.mUserVo);
        vos.add(questionnaireVo);

        questionnaireVo = new QuestionnaireVo();
        questionnaireVo.setId(baseId + 1);
        questionnaireVo.setName("你想从事什么职业");
        questionnaireVo.setContent("问卷调查二内容");
        questionnaireVo.setTotalNumber(50);
        questionnaireVo.setReward(50);
        questionnaireVo.setStartTime(new Timestamp(1521043200000l));//2018-3-15
        questionnaireVo.setEndTime(new Timestamp(1533686400000l));//2018-8-8
        questionnaireVo.setPersonas(new PersonasVo(21, 0, "上海"));
        questionnaireVo.setStatus(4);
        questionnaireVo.setUserVo(ConstantData.mUserVo);
        vos.add(questionnaireVo);

        questionnaireVo = new QuestionnaireVo();
        questionnaireVo.setId(baseId + 2);
        questionnaireVo.setName("周末一般做什么");
        questionnaireVo.setContent("问卷调查三内容");
        questionnaireVo.setTotalNumber(200);
        questionnaireVo.setReward(50);
        questionnaireVo.setStartTime(new Timestamp(1533686400000l));//2018-8-8
        questionnaireVo.setEndTime(new Timestamp(1533686400000l));//2018-8-8
        questionnaireVo.setPersonas(new PersonasVo(24, 1, "北京"));
        questionnaireVo.setStatus(4);
        questionnaireVo.setUserVo(ConstantData.mUserVo);
        vos.add(questionnaireVo);
        return vos;
    }
}
