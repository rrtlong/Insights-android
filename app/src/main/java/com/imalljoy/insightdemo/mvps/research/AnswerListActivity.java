package com.imalljoy.insightdemo.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseActivity;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.widgets.TopBarCommon;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/26.
 */

public class AnswerListActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_answer_list);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("回答结果");
        topBar.setRightView(null, 0);
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
        Intent it = new Intent(context, AnswerListActivity.class);
        context.startActivity(it);
    }
}
