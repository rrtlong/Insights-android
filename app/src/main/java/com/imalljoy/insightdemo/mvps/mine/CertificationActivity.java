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

public class CertificationActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.enterprise_layout)
    LinearLayout enterpriseLayout;
    @BindView(R.id.analyst_layout)
    LinearLayout analystLayout;
    @BindView(R.id.media_layout)
    LinearLayout mediaLayout;
    @BindView(R.id.investor_layout)
    LinearLayout investorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_certification);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("认证");
        topBar.setRightView(null, 0);
        enterpriseLayout.setOnClickListener(this);
        analystLayout.setOnClickListener(this);
        mediaLayout.setOnClickListener(this);
        investorLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.enterprise_layout:
                break;
            case R.id.analyst_layout:
                break;
            case R.id.media_layout:
                break;
            case R.id.investor_layout:
                break;
        }
    }

    public static void toActivity(Context context){
        Intent it = new Intent(context, CertificationActivity.class);
        context.startActivity(it);
    }
}
