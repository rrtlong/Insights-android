package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.bus.JumpFragment;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.entity.RequestVo;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.utils.DateUtils;
import com.imalljoy.insights.utils.ScreenUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import org.greenrobot.eventbus.EventBus;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/17.
 */

public class BuildRequestActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon mTopBar;
    @BindView(R.id.coin_name_layout)
    RelativeLayout mCoinNameLayout;
    @BindView(R.id.coin_logo)
    ImageView mCoinLogo;
    @BindView(R.id.coin_name)
    TextView mCoinName;
    @BindView(R.id.require_name)
    EditText mRequireName;
    @BindView(R.id.reward)
    EditText mReward;
    @BindView(R.id.start_time_layout)
    RelativeLayout mStartTimeLayout;
    @BindView(R.id.start_time)
    TextView mStartTime;
    @BindView(R.id.end_time_layout)
    RelativeLayout mEndTimeLayout;
    @BindView(R.id.end_time_text)
    TextView endTimeText;
    @BindView(R.id.end_time)
    TextView mEndTime;
    @BindView(R.id.intro)
    EditText mIntro;
    @BindView(R.id.btn_process)
    Button mBtnProcess;
    RequestVo mVo = null;
    private int mStatus = 0;//0:新建;1未接受;2已接收,3已完成

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_buildrequest);
        ButterKnife.bind(this);
        mIntro.setPadding(ScreenUtils.sp2px(this, 10), ScreenUtils.sp2px(this, 10), ScreenUtils.sp2px(this, 10), ScreenUtils.sp2px(this, 10));
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        initDate();


    }

    private void initDate() {
        Bundle bundle = getIntent().getExtras();
        mVo = (RequestVo) getIntent().getSerializableExtra("vo");
        mStatus = bundle.getInt("status", 0);
        if (mStatus == 0) {
            //新建一个请求
            initwithoutData();

        } else if (mStatus == 1) {
            //未接受
            initwithData("请求", "接受请求");

        } else if (mStatus == 2) {
            //已接收
            initwithData("请求", "撰写报告");
        } else if (mStatus == 3) {
            //已完成
            initwithData("请求", "已完成");
        }
        mCoinNameLayout.setOnClickListener(this);
        if(mVo == null){
            mVo = new RequestVo();
            mVo.setId(System.currentTimeMillis()/1000);
        }

    }

    public void disableEdit() {
        mRequireName.setEnabled(false);
        mRequireName.setFocusable(false);
        mReward.setEnabled(false);
        mReward.setFocusable(false);
        mIntro.setEnabled(false);
        mIntro.setFocusable(false);
    }

    public void initwithData(String title, String buttonText) {
        mTopBar.top_bar_title_text.setText(title);
        mTopBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        mTopBar.top_bar_left_layout.setOnClickListener(this);
        mTopBar.setRightView(null, 0);
        disableEdit();
        if (mVo != null) {
            mCoinName.setText(mVo.getCoin() == null ? "比特币" : mVo.getCoin().getName());
            mRequireName.setText(mVo.getName());
            mReward.setText(mVo.getReward() + "");
            mStartTime.setText(DateUtils.dateToString(new Date(mVo.getStartTime().getTime()), "yyyy-MM-dd :HH:mm"));
            mEndTime.setText(DateUtils.dateToString(new Date(mVo.getEndTime().getTime()), "yyyy-MM-dd :HH:mm"));
            mIntro.setText(mVo.getDemand());
            mBtnProcess.setText(buttonText);
            mBtnProcess.setVisibility(View.VISIBLE);
            if (mStatus == 1 || mStatus == 2) {
                //接受请求,撰写报告
                mBtnProcess.setOnClickListener(this);
            } else if (mStatus == 3) {
                mBtnProcess.setBackgroundColor(Color.parseColor("#cccccc"));
                mBtnProcess.setEnabled(false);
            } else {
                mBtnProcess.setOnClickListener(this);
            }

        }
    }

    public void initwithoutData() {
        mTopBar.top_bar_title_text.setText("发布请求");
        mTopBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        mTopBar.top_bar_left_layout.setOnClickListener(this);
        mTopBar.setRightView("发布", 0);
        mTopBar.top_bar_right_layout.setOnClickListener(this);
        mStartTimeLayout.setOnClickListener(this);
        mEndTimeLayout.setOnClickListener(this);
        mBtnProcess.setVisibility(View.GONE);
    }

    public static void toActivity(Context context, RequestVo vo, int status) {
        Intent it = new Intent(context, BuildRequestActivity.class);
        Bundle bundle = new Bundle();
        if (vo != null) {
            it.putExtra("vo", vo);
        }
        bundle.putInt("status", status);
        it.putExtras(bundle);
        context.startActivity(it);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.start_time_layout:
                showTimePickerView(true);
                break;
            case R.id.end_time_layout:
                showTimePickerView(false);
                break;
            case R.id.top_bar_right_layout:
                CoinVo coin = null;
                if(mVo.getCoin() == null){
                    coin = new CoinVo();
                }else {
                    coin = mVo.getCoin();
                }
                coin.setName(mCoinName.getText().toString());
                mVo.setId((long) (ConstantData.requestVos.size() + 1));
                mVo.setStatus(1);
                mVo.setUser(ConstantData.userVos.get(0));
                mVo.setCoin(coin);
                mVo.setName(mRequireName.getText().toString());
                mVo.setReward(Double.parseDouble(mReward.getText().toString().trim()));
                mVo.setStartTime(new Timestamp(DateUtils.stringToDate(mStartTime.getText().toString(), "yyyy-MM-dd HH:mm").getTime()));
                mVo.setEndTime(new Timestamp(DateUtils.stringToDate(mEndTime.getText().toString(), "yyyy-MM-dd HH:mm").getTime()));
                mVo.setDemand(mIntro.getText().toString());
                ConstantData.requestVos.add(mVo);
                EventBus.getDefault().post(new JumpFragment(JumpFragment.Type.Research, 2, true, true));
                finish();
                break;
            case R.id.btn_process:
                if (mStatus == 1) {
                    //接受请求
                    ConstantData.mUserVo.addRequest(mVo, false);
                    updateStatus(mVo.getId(), 2);
                    EventBus.getDefault().post(new JumpFragment(JumpFragment.Type.Research, 2, true, true));
                    finish();
                } else if (mStatus == 2) {
                    //撰写报告
                    BuildReportActivity.toActivity(this, mVo, null, 0);
                    updateStatus(mVo.getId(), 3);
                    finish();
                } else if (mStatus == 3) {
                    //已完成
                }
                break;
            case R.id.coin_name_layout:
                if (mVo == null) {
                    mVo = new RequestVo();
                }
                BuildCoinInfoActivity.toActivityForResult(this, mVo.getCoin(), mStatus, 0);
                break;
        }
    }

    public void updateStatus(long id, int status) {
        for (int i = 0; i < ConstantData.requestVos.size(); i++) {
            if (ConstantData.requestVos.get(i).getId() == id) {
                ConstantData.requestVos.get(i).setStatus(status);
            }
        }
    }

    private void showTimePickerView(final boolean isStartTime) {
        hideSoftInputMethod();
        final TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date, View v) {
                if (isStartTime) {
                    mStartTime.setText(DateUtils.dateToString(date, "yyyy-MM-dd HH:mm"));
                } else {
                    mEndTime.setText(DateUtils.dateToString(date, "yyyy-MM-dd HH:mm"));
                }
            }
        }).setType(new boolean[]{true, true, true, true, true, false})
                .setContentSize(18)
                .setTitleText(isStartTime ? "设置开始时间" : "设置结束时间")
                .setTitleSize(20)
                .setOutSideCancelable(true)
                .isDialog(false)
                .setLabel("年", "月", "日", "时", "分", "秒")
                .build();

        String lastTime = "";
        if (isStartTime) {
            lastTime = mStartTime.getText().toString();
        } else {
            lastTime = mEndTime.getText().toString();
        }
        if (TextUtils.isEmpty(lastTime)) {
            pvTime.setDate(Calendar.getInstance());
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DateUtils.stringToDate(lastTime, "yyyy-MM-dd HH:mm"));
            pvTime.setDate(calendar);
        }

        pvTime.show();
    }

    private static final String TAG = "BuildRequestActivity";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == 2) {
            CoinVo coinVo = (CoinVo) data.getSerializableExtra("coinVo");
            mVo.setCoin(null);
            mVo.setCoin(coinVo);
            mCoinName.setText(mVo.getCoin().getName());
            if (!TextUtils.isEmpty(mVo.getCoin().getLogoUrl())) {
                Glide.with(this).load(mVo.getCoin().getLogoUrl()).into(mCoinLogo);
            }
        }
    }

    public void hideSoftInputMethod() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //获取键盘显示状态
        boolean isOpen = imm.isActive();
        if (isOpen) {
            imm.hideSoftInputFromWindow(BuildRequestActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        // 如果软键盘已经显示，则隐藏，反之则显示
        //imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        // 隐藏软键盘
        //imm.hideSoftInputFromWindow(view, InputMethodManager.HIDE_NOT_ALWAYS);
        // 强制显示软键盘
        //imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
        // 强制隐藏软键盘
        //imm.hideSoftInputFromWindow(view.getWindowToken(), 0);


    }
}
