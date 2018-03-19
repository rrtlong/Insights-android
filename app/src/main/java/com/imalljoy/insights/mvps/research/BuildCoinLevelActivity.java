package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.bus.EditReturnData;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBar;
import com.imalljoy.insights.widgets.TopBarCommon;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/19.
 */

public class BuildCoinLevelActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.add)
    RelativeLayout add;
    @BindView(R.id.subtract)
    RelativeLayout subtract;
    @BindView(R.id.on_exchangeA)
    LinearLayout onExchangeA;
    @BindView(R.id.on_exchangeB)
    LinearLayout onExchangeB;
    @BindView(R.id.on_exchangeC)
    LinearLayout onExchangeC;
    @BindView(R.id.on_exchangeD)
    LinearLayout onExchangeD;
    @BindView(R.id.no_exchangeA)
    LinearLayout noExchangeA;
    @BindView(R.id.no_exchangeB)
    LinearLayout noExchangeB;
    @BindView(R.id.no_exchangeC)
    LinearLayout noExchangeC;
    @BindView(R.id.no_exchangeD)
    LinearLayout noExchangeD;
    @BindView(R.id.no_exchangeE)
    LinearLayout noExchangeE;
    @BindView(R.id.coin_level)
    TextView mCoinLevel;
    int mStatus; //0:编辑 1:查看

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_build_coin_level);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("评级");
        topBar.setRightView(null, 0);
        mCoinLevel.setText(getIntent().getStringExtra("level"));
        mStatus = getIntent().getIntExtra("status", 0);
        if (mStatus == 0) {
            add.setOnClickListener(this);
            subtract.setOnClickListener(this);
            onExchangeA.setOnClickListener(this);
            onExchangeB.setOnClickListener(this);
            onExchangeC.setOnClickListener(this);
            onExchangeD.setOnClickListener(this);
            noExchangeA.setOnClickListener(this);
            noExchangeB.setOnClickListener(this);
            noExchangeC.setOnClickListener(this);
            noExchangeD.setOnClickListener(this);
            noExchangeE.setOnClickListener(this);
        }
        SpannableString ss = new SpannableString("点击下方级别条目,再点击+或-(A+,A,A-)");
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(9,true);
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mCoinLevel.setHint(ss);


    }

    @Override
    public void onClick(View v) {
        String level = null;
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                EventBus.getDefault().post(new EditReturnData(EditReturnData.EDIT_COIN_LEVEL,-1,mCoinLevel.getText().toString()));
                finish();
                break;
            case R.id.add:
                level = mCoinLevel.getText().toString();
                if(!TextUtils.isEmpty(level)&&level.length()>0){
                    if(level.length() ==1){
                        mCoinLevel.setText(level+"+");
                    }else{
                        mCoinLevel.setText(level.substring(0,1) + "+");
                    }
                }
                break;
            case R.id.subtract:
                level = mCoinLevel.getText().toString();
                if(!TextUtils.isEmpty(level)&&level.length()>0){
                    if(level.length() ==1){
                        mCoinLevel.setText(level+"-");
                    }else{
                        mCoinLevel.setText(level.substring(0,1) + "-");
                    }
                }
                break;
            case R.id.on_exchangeA:
                mCoinLevel.setText("A");
                break;
            case R.id.on_exchangeB:
                mCoinLevel.setText("B");
                break;
            case R.id.on_exchangeC:
                mCoinLevel.setText("C");
                break;
            case R.id.on_exchangeD:
                mCoinLevel.setText("D");
                break;
            case R.id.no_exchangeA:
                mCoinLevel.setText("A");
                break;
            case R.id.no_exchangeB:
                mCoinLevel.setText("B");
                break;
            case R.id.no_exchangeC:
                mCoinLevel.setText("C");
                break;
            case R.id.no_exchangeD:
                mCoinLevel.setText("D");
                break;
            case R.id.no_exchangeE:
                mCoinLevel.setText("E");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EventBus.getDefault().post(new EditReturnData(EditReturnData.EDIT_COIN_LEVEL,-1,mCoinLevel.getText().toString()));
    }
    public static void toActivity(Context context, String level, int status){
        Intent it = new Intent(context, BuildCoinLevelActivity.class);
        it.putExtra("level",level+"");
        it.putExtra("status",status);
        context.startActivity(it);
    }
}
