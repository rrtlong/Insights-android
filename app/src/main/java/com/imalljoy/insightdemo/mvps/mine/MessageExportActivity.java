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

public class MessageExportActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.news_layout)
    LinearLayout newsLayout;
    @BindView(R.id.enterprise_layout)
    LinearLayout enterpriseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_message_export);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.setTitle("调研任务");
        topBar.setRightView(null, 0);
        newsLayout.setOnClickListener(this);
        enterpriseLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.news_layout:
                NewsMessageExportActivity.toActivity(this);
                break;
            case R.id.enterprise_layout:
                EnterpriseMessageExportActivity.toActivity(this);
                break;
        }
    }
    public static void toActivity(Context context){
        Intent it = new Intent(context, MessageExportActivity.class);
        context.startActivity(it);
    }
}

