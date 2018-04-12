package com.imalljoy.insights.mvps.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.entity.RequestVo;
import com.imalljoy.insights.entity.UserVo;
import com.imalljoy.insights.mvps.research.RequireRecyclerAdapter;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class AcceptResearchActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    List<RequestVo> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_accept_research);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("我接受的的调研");
        topBar.setRightView(null, 0);
        initView();
    }

    private void initView() {
        LinearLayoutManager linearManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearManager);
        recyclerview.addItemDecoration(divider);
        listData = getData();
        recyclerview.setAdapter(new RequireRecyclerAdapter(this, ConstantData.requestVos));

    }

    public List<RequestVo> getData() {
        List<RequestVo> vos = new ArrayList<>();
        long baseId = System.currentTimeMillis() / 1000;
        CoinVo coinVo = new CoinVo();
        coinVo.setId(1l);
        coinVo.setName("比特币");
        coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");

        RequestVo requestVo = new RequestVo();
        requestVo.setId(baseId);
        requestVo.setUser(ConstantData.userVos.get(new Random().nextInt(5)));
        requestVo.setCoin(coinVo);
        requestVo.setName("请求四");
        requestVo.setPlatform(0);
        requestVo.setReward(33);
        requestVo.setStatus(2);//已接受
        requestVo.setDemand("要求被调查者都是年轻人");
        requestVo.setStartTime(new Timestamp(1508342400000l));//2017-10-19
        requestVo.setEndTime(new Timestamp(1508601600000l));//2017-10-22
        vos.add(requestVo);

        requestVo = new RequestVo();
        requestVo.setId(baseId + 1);
        requestVo.setUser(ConstantData.userVos.get(new Random().nextInt(5)));
        requestVo.setCoin(coinVo);
        requestVo.setName("请求五");
        requestVo.setPlatform(1);
        requestVo.setDemand("2天之内给出结果");
        requestVo.setReward(66);
        requestVo.setStatus(2);//已接受
        requestVo.setStartTime(new Timestamp(1508342400000l));//2017-10-19
        requestVo.setEndTime(new Timestamp(1508601600000l));//2017-10-22
        vos.add(requestVo);

        requestVo = new RequestVo();
        requestVo.setId(baseId + 2);
        requestVo.setUser(ConstantData.userVos.get(new Random().nextInt(5)));
        requestVo.setCoin(coinVo);
        requestVo.setName("请求六");
        requestVo.setPlatform(0);
        requestVo.setDemand("调查要详细");
        requestVo.setReward(99);
        requestVo.setStatus(2);//已接受
        requestVo.setStartTime(new Timestamp(1508342400000l));//2017-10-19
        requestVo.setEndTime(new Timestamp(1508601600000l));//2017-10-22
        vos.add(requestVo);

        return vos;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
        }
    }

    public static void toActivity(Context context) {
        Intent it = new Intent(context, AcceptResearchActivity.class);
        context.startActivity(it);
    }

}