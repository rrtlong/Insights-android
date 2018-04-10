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
import com.imalljoy.insights.entity.UserVo;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailEnterpriseExposeAdapter;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailNewsAdapter;
import com.imalljoy.insights.mvps.research.EnterpriseAdapter;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class EnterpriseMessageExportActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    List<CoinVo> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_enterprise_message_export);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("企业披露");
        topBar.setRightView("添加", 0);
        initView();
    }

    private void initView() {
        LinearLayoutManager linearManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearManager);
        recyclerview.addItemDecoration(divider);
        listData = getData();
        recyclerview.setAdapter(new CoinDetailEnterpriseExposeAdapter(this,listData,1));

    }



    public List<CoinVo> getData() {
        List<CoinVo> vos = new ArrayList<>();
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        return vos;
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
        Intent it = new Intent(context, EnterpriseMessageExportActivity.class);
        context.startActivity(it);
    }

}