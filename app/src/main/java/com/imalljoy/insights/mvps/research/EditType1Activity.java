package com.imalljoy.insights.mvps.research;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.bus.EditReturnData;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.utils.ScreenUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import org.greenrobot.eventbus.EventBus;

import javax.net.ssl.ManagerFactoryParameters;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/18.
 */

public class EditType1Activity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.top_bar)
    TopBarCommon mTopBar;
    @BindView(R.id.score)
    EditText mScore;
    @BindView(R.id.score_intro)
    EditText mScoreIntro;
    private int mFlag = -1;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_edittype1);
        ButterKnife.bind(this);
        mFlag = getIntent().getIntExtra("flag", -1);
        mTitle = getIntent().getStringExtra("title");
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mTopBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        mTopBar.top_bar_left_layout.setOnClickListener(this);
        mTopBar.top_bar_title_text.setText(mTitle);
        mTopBar.setRightView(null, 0);
        mScore.requestFocus();
        mScoreIntro.setPadding(ScreenUtils.dp2px(this,10), ScreenUtils.dp2px(this,10), ScreenUtils.dp2px(this,10), ScreenUtils.dp2px(this,10));

        if(mFlag == -1){
            mScore.setEnabled(false);
            mScoreIntro.setEnabled(false);
        }
    }

    public static void toActivity(Context context, int flag, String title){
        Intent it = new Intent(context, EditType1Activity.class);
        it.putExtra("flag", flag);
        it.putExtra("title",title);
        context.startActivity(it);
    }

    @Override
    public void onBackPressed() {
        if(mFlag != -1){
            //是编辑页面,不是查看页面
            EventBus.getDefault().post(new EditReturnData(mFlag, Integer.parseInt(TextUtils.isEmpty(mScore.getText().toString().trim())? "0" : mScore.getText().toString()),mScoreIntro.getText().toString()));
        }
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                if(mFlag != -1){
                    //是编辑页面,不是查看页面
                    EventBus.getDefault().post(new EditReturnData(mFlag, Integer.parseInt(TextUtils.isEmpty(mScore.getText().toString().trim())? "0" : mScore.getText().toString()),mScoreIntro.getText().toString()));
                }
                finish();
                break;
        }
    }
}