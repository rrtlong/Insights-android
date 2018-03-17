package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
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
    @BindView(R.id.coin_name)
    EditText mCoinName;
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
        initDate();


    }

    private void initDate() {
        Bundle bundle = getIntent().getExtras();
        mVo = (RequestVo) bundle.get("vo");
        mStatus = bundle.getInt("status", -1);
        if (mStatus == 0) {
            //新建一个请求
            initwithoutData();

        } else if (mStatus == 1) {
            //未接受
            initwithData("请求", "接受请求");

        } else if (mStatus == 1) {
            //已接收
            initwithData("请求", "已接受");
        } else if (mStatus == 2) {
            //已完成
            initwithData("请求", "已完成");
        } else if (mStatus == -1) {
            //获取不到status
        }

    }

    public void disableEdit() {
        mCoinName.setEnabled(false);
        mCoinName.setFocusable(false);
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
            if (mStatus == 2 || mStatus == 3) {
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
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mStartTimeLayout.setOnClickListener(this);
        mEndTimeLayout.setOnClickListener(this);
        mBtnProcess.setVisibility(View.GONE);
    }

    public static void toActivity(Context context, RequestVo vo, int status) {
        Intent it = new Intent(context, BuildRequestActivity.class);
        Bundle bundle = new Bundle();
        if (vo != null) {
            bundle.putSerializable("vo", vo);
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
                RequestVo vo = new RequestVo();
                CoinVo coin = new CoinVo();
                coin.setName(mCoinName.getText().toString());
                vo.setId((long) (ConstantData.requestVos.size() + 1));
                vo.setUser(ConstantData.userVos.get(0));
                vo.setCoin(coin);
                vo.setName(mRequireName.getText().toString());
                vo.setReward(Double.parseDouble(mReward.getText().toString().trim()));
                vo.setStartTime(new Timestamp(DateUtils.stringToDate(mStartTime.getText().toString(), "yyyy-MM-dd HH:mm").getTime()));
                vo.setEndTime(new Timestamp(DateUtils.stringToDate(mEndTime.getText().toString(), "yyyy-MM-dd HH:mm").getTime()));
                vo.setDemand(mIntro.getText().toString());
                ConstantData.requestVos.add(vo);
                EventBus.getDefault().post(new JumpFragment(JumpFragment.Type.Research, 2, true));
                finish();
                break;
            case R.id.btn_process:
                if (mStatus == 1) {
                    ConstantData.mUserVo.addRequest(mVo, false);
                    updateStatus(mVo.getId(), 1);
                    EventBus.getDefault().post(new JumpFragment(JumpFragment.Type.Research, 2, true));
                    finish();
                }
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

    public void hideSoftInputMethod() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //获取键盘显示状态
        boolean isOpen = imm.isActive();
        if (isOpen) {
            imm.hideSoftInputFromWindow(BuildRequestActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        // 如果软键盘已经显示，则隐藏，反之则显示
//        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
// 隐藏软键盘
//        imm.hideSoftInputFromWindow(view, InputMethodManager.HIDE_NOT_ALWAYS);
// 强制显示软键盘
//        imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
// 强制隐藏软键盘
//        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);


    }
}
