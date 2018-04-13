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
import com.imalljoy.insightdemo.entity.ReportVo;
import com.imalljoy.insightdemo.mvps.research.BuildReportActivity;
import com.imalljoy.insightdemo.mvps.research.ReportRecyclerAdapter;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.widgets.TopBarCommon;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class MyReportsActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MyReportsActivity";
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    List<ReportVo> listData;
    private List<ReportVo> data;
    private ReportRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_my_reports);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.setTitle("我的报告");
        topBar.setRightView("撰写报告", 0);
        topBar.top_bar_right_layout.setOnClickListener(this);
        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        listData = getData();
        mAdapter = new ReportRecyclerAdapter(this, ConstantData.reportVos);
        recyclerview.setAdapter(mAdapter);
    }

    private void initView() {
        LinearLayoutManager linearManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearManager);
        recyclerview.addItemDecoration(divider);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.top_bar_right_layout:
                BuildReportActivity.toActivityForMyreport(this,0,true);
                break;
        }
    }

    public static void toActivity(Context context) {
        Intent it = new Intent(context, MyReportsActivity.class);
        context.startActivity(it);
    }

    public List<ReportVo> getData() {

        return ConstantData.myReports;
    }
}
