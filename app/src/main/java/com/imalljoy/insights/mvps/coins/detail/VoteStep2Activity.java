package com.imalljoy.insights.mvps.coins.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class VoteStep2Activity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.ten_min)
    TextView tenMin;
    @BindView(R.id.one_hour)
    TextView oneHour;
    @BindView(R.id.twelev_hour)
    TextView twelevHour;
    @BindView(R.id.twenty_four)
    TextView twentyFour;
    @BindView(R.id.seventy_two_hour)
    TextView seventyTwoHour;
    @BindView(R.id.up)
    TextView up;
    @BindView(R.id.down)
    TextView down;
    @BindView(R.id.desc)
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_vote_step2);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("投票");
        topBar.setRightView(null, 0);
        tenMin.setOnClickListener(this);
        oneHour.setOnClickListener(this);
        twelevHour.setOnClickListener(this);
        twentyFour.setOnClickListener(this);
        seventyTwoHour.setOnClickListener(this);
        up.setOnClickListener(this);
        down.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.ten_min:
                resetAllBackground();
                setBackground(tenMin,true);
                break;
            case R.id.one_hour:
                resetAllBackground();
                setBackground(oneHour,true);
                break;
            case R.id.twelev_hour:
                resetAllBackground();
                setBackground(twelevHour,true);
                break;
            case R.id.twenty_four:
                resetAllBackground();
                setBackground(twentyFour,true);
                break;
            case R.id.seventy_two_hour:
                resetAllBackground();
                setBackground(seventyTwoHour,true);
                break;
            case R.id.up:
                break;
            case R.id.down:
                break;
        }
    }

    public void resetAllBackground(){
        setBackground(tenMin, false);
        setBackground(oneHour, false);
        setBackground(twelevHour, false);
        setBackground(twentyFour, false);
        setBackground(seventyTwoHour, false);
    }

    public void setBackground(TextView tv, boolean isLight){
        tv.setBackground(isLight ? ContextCompat.getDrawable(this, R.drawable.stroke_solid_72d2d6):ContextCompat.getDrawable(this, R.drawable.stroke_solid_cccccc));
    }
    public static void toActivity(Context context) {
        Intent it = new Intent(context, VoteStep2Activity.class);
        context.startActivity(it);
    }
}
