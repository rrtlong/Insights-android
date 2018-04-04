package com.imalljoy.insights.mvps.coins.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBar;
import com.imalljoy.insights.widgets.TopBarCommon;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class VoteStep1ListActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "VoteStep1ListActivity";
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    List<CoinVo> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_recycler_layout_with_topbar);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("投票");
        topBar.setRightView(null, 0);
        listData = getData();
        LinearLayoutManager linearManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearManager);
        recyclerview.addItemDecoration(divider);
        recyclerview.setAdapter(new VoteStep1Adapter(this, listData, 0));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                finish();
                break;
        }
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
        vos.add(new CoinVo());
        vos.add(new CoinVo());

        return vos;
    }
    public static void toActivity(Context context){
        Intent it = new Intent(context, VoteStep1ListActivity.class);
        context.startActivity(it);
    }
}
