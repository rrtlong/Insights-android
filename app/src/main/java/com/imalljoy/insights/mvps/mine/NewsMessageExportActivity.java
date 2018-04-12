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
import com.imalljoy.insights.entity.NewVo;
import com.imalljoy.insights.entity.UserVo;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailNewsAdapter;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class NewsMessageExportActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    List<CoinVo> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_news_message_export);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("新闻披露");
        topBar.setRightView("添加", 0);
        initView();
    }

    private void initView() {
        LinearLayoutManager linearManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearManager);
        recyclerview.addItemDecoration(divider);
        recyclerview.setAdapter(new CoinDetailNewsAdapter(this,getListData(),0));

    }



    public List<NewVo> getListData() {
        List<NewVo> vos = new ArrayList<>();
        NewVo newVo = new NewVo();
        newVo.setName("比特币闪电网络实现兼容数字资产，彩色币技术成关键");
        newVo.setCover("new_cover1");
        vos.add(newVo);
        newVo = new NewVo();
        newVo.setName("Ubitquity采用比特币区块链保护房地产产权");
        newVo.setCover("new_cover2");
        vos.add(newVo);
        newVo = new NewVo();
        newVo.setName("火币袁煜明：我们现在处于区块链经济的1776年");
        newVo.setCover("new_cover3");
        vos.add(newVo);
        newVo = new NewVo();
        newVo.setName("去中心化数据库：传统IT与区块链的未来融合形式");
        newVo.setCover("new_cover4");
        vos.add(newVo);
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
        Intent it = new Intent(context, NewsMessageExportActivity.class);
        context.startActivity(it);
    }
}

