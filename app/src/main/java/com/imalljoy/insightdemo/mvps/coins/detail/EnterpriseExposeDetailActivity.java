package com.imalljoy.insightdemo.mvps.coins.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseActivity;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.widgets.TopBarCommon;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/30.
 */

public class EnterpriseExposeDetailActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.develop)
    TextView develop;
    @BindView(R.id.promotion)
    TextView promotion;
    @BindView(R.id.operation)
    TextView operation;
    @BindView(R.id.finance)
    TextView finance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_enterprise_expose_detail);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("2018年3月工作汇报");
        topBar.setRightView(null, 0);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                //返回
                finish();
                break;
        }

    }
    public static void toActivity(Context context){
        Intent it = new Intent(context, EnterpriseExposeDetailActivity.class);
        context.startActivity(it);
    }
}
