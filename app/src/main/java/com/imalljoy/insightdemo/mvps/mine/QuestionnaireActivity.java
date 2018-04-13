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

public class QuestionnaireActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.launch_layout)
    LinearLayout launchLayout;
    @BindView(R.id.accept_layout)
    LinearLayout acceptLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_questionnaire);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.setRightView(null, 0);
        topBar.top_bar_title_text.setText("调查问卷");
        launchLayout.setOnClickListener(this);
        acceptLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.launch_layout:
                LaunchQuestionnaireActivity.toActivity(this);
                break;
            case R.id.accept_layout:
                AcceptQuestionnaireActivity.toActivity(this);
                break;
        }
    }
    public static void toActivity(Context context){
        Intent it = new Intent(context, QuestionnaireActivity.class);
        context.startActivity(it);
    }
}
