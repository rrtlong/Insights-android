package com.imalljoy.insightdemo.mvps.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseActivity;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.widgets.TopBarCommon;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class EnterpriseExport2DetailActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.develop_layout)
    LinearLayout developLayout;
    @BindView(R.id.promotion_layout)
    LinearLayout promotionLayout;
    @BindView(R.id.operation_layout)
    LinearLayout operationLayout;
    @BindView(R.id.finance_layout)
    LinearLayout financeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_enterprise_export2_detail);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.setTitle("企业披露");
        topBar.setRightView(null, 0);
        developLayout.setOnClickListener(this);
        promotionLayout.setOnClickListener(this);
        operationLayout.setOnClickListener(this);
        financeLayout.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.develop_layout:
                break;
            case R.id.promotion_layout:
                break;
            case R.id.operation_layout:
                break;
            case R.id.finance_layout:
                break;
        }
    }

    public static void toActivity(Context context) {
        Intent it = new Intent(context, EnterpriseExport2DetailActivity.class);
        context.startActivity(it);
    }
}
