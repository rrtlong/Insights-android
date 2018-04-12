package com.imalljoy.insights.mvps.research;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.base.WebViewActivity;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.utils.DateUtils;
import com.imalljoy.insights.widgets.TopBar;
import com.imalljoy.insights.widgets.TopBarCommon;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/20.
 */

public class BuildCoinInfoActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.name_layout)
    LinearLayout nameLayout;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.logo_layout)
    LinearLayout logoLayout;
    @BindView(R.id.website)
    TextView website;
    @BindView(R.id.website_layout)
    LinearLayout websiteLayout;
    @BindView(R.id.ico_time)
    TextView icoTime;
    @BindView(R.id.ico_time_layout)
    LinearLayout icoTimeLayout;
    @BindView(R.id.online_exchange_time)
    TextView onlineExchangeTime;
    @BindView(R.id.online_exchange_time_layout)
    LinearLayout onlineExchangeTimeLayout;
    @BindView(R.id.online_exchange)
    TextView onlineExchange;
    @BindView(R.id.online_exchange_layout)
    LinearLayout onlineExchangeLayout;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.location_layout)
    LinearLayout locationLayout;
    @BindView(R.id.telegraph_group)
    EditText telegraphGroup;
    @BindView(R.id.telegraph_group_layout)
    LinearLayout telegraphGroupLayout;
    @BindView(R.id.twitter_fans)
    EditText twitterFans;
    @BindView(R.id.twitter_fans_layout)
    LinearLayout twitterFansLayout;
    CoinVo mCoinVo;
    int mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_build_coin_info);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mCoinVo = (CoinVo) getIntent().getSerializableExtra("coinVo");
        if (mCoinVo == null) {
            mCoinVo = new CoinVo();
        }
        mStatus = getIntent().getIntExtra("status", 0);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("数币");
        topBar.setRightView(null, 0);
        if (mStatus != 0) {
            //不准编辑,只能查看\
            name.setEnabled(false);
            website.setEnabled(false);
            onlineExchange.setEnabled(false);
            location.setEnabled(false);
            telegraphGroup.setEnabled(false);
            twitterFans.setEnabled(false);


        } else {
            //能编辑
            logoLayout.setOnClickListener(this);
            icoTimeLayout.setOnClickListener(this);
            onlineExchangeTimeLayout.setOnClickListener(this);
        }
        websiteLayout.setOnClickListener(this);
        telegraphGroupLayout.setOnClickListener(this);
        twitterFansLayout.setOnClickListener(this);

        name.setText(mCoinVo.getName());
        if (!TextUtils.isEmpty(mCoinVo.getLogoUrl())) {
            Glide.with(this).load(CommonUtils.getLogoIdFromString(mCoinVo.getLogoUrl())).error(R.mipmap.dog_logo).into(logo);
        }
        website.setText(mCoinVo.getWebsiteUrl());
        if (mCoinVo.getIcoTime() != null) {
            icoTime.setText(DateUtils.dateToString(new Date(mCoinVo.getIcoTime().getTime()), "yyyy年MM月dd日"));
        }
        if (mCoinVo.getOnlineExchangeTime() != null) {
            onlineExchangeTime.setText(DateUtils.dateToString(new Date(mCoinVo.getIcoTime().getTime()), "yyyy年MM月dd日"));
        }
        onlineExchange.setText(mCoinVo.getOnlineExchange());
        location.setText(mCoinVo.getLocation());
        telegraphGroup.setText(mCoinVo.getTelegraphGroup());
        twitterFans.setText(mCoinVo.getTwitterFans());
    }

    public static void toActivityForResult(Activity activity, CoinVo vo, int status, int requestCode) {
        //暂时该页面不能编辑，都用默认数据
        Intent it = new Intent(activity, BuildCoinInfoActivity.class);
        it.putExtra("coinVo", vo);
        it.putExtra("status", 1);
        activity.startActivityForResult(it, requestCode);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                save();
                finish();
                break;
            case R.id.logo_layout:
                break;
            case R.id.ico_time_layout:
                showTimePickerView(true);
                break;
            case R.id.online_exchange_time_layout:
                showTimePickerView(false);
                break;
            case R.id.website_layout:
                WebViewActivity.toActivity(this, "官网", mCoinVo != null ? mCoinVo.getWebsiteUrl() : null);
                break;
            case R.id.telegraph_group_layout:
                WebViewActivity.toActivity(this, "电报", mCoinVo != null ? mCoinVo.getTelegraphGroupUrl() : null);
                break;
            case R.id.twitter_fans_layout:
                WebViewActivity.toActivity(this, "推特", mCoinVo != null ? mCoinVo.getTwitterFanUrl() : null);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        save();
        super.onBackPressed();
    }

    public void save() {
        if (mCoinVo.getId() == 0l) {
            mCoinVo.setId(System.currentTimeMillis() / 1000);
        }
        mCoinVo.setName(name.getText().toString());
        mCoinVo.setWebsiteUrl(website.getText().toString());
        if (TextUtils.isEmpty(icoTime.getText().toString())) {
            mCoinVo.setIcoTime(null);
        } else {
            mCoinVo.setIcoTime(new Timestamp(DateUtils.stringToDate(icoTime.getText().toString(), "yyyy年MM月dd日").getTime()));
        }
        if (TextUtils.isEmpty(onlineExchangeTime.getText().toString())) {
            mCoinVo.setOnlineExchangeTime(null);
        } else {
            mCoinVo.setOnlineExchangeTime(new Timestamp(DateUtils.stringToDate(onlineExchangeTime.getText().toString(), "yyyy年MM月dd日").getTime()));
        }
        mCoinVo.setOnlineExchange(onlineExchange.getText().toString());
        mCoinVo.setLocation(location.getText().toString());
        mCoinVo.setTelegraphGroup(telegraphGroup.getText().toString());
        mCoinVo.setTwitterFans(twitterFans.getText().toString());
        Intent it = new Intent();
        it.putExtra("coinVo", mCoinVo);
        setResult(2, it);

    }

    private void showTimePickerView(final boolean isICO) {
        hideSoftInputMethod();
        final TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date, View v) {
                if (isICO) {
                    icoTime.setText(DateUtils.dateToString(date, "yyyy年MM月dd日"));
                } else {
                    onlineExchangeTime.setText(DateUtils.dateToString(date, "yyyy年MM月dd日"));
                }
            }
        }).setType(new boolean[]{true, true, true, true, true, false})
                .setContentSize(18)
                .setTitleText(isICO ? "设置ICO时间" : "设置上线交易时间")
                .setTitleSize(20)
                .setOutSideCancelable(true)
                .isDialog(false)
                .setLabel("年", "月", "日", "时", "分", "秒")
                .build();

        String lastTime = "";
        if (isICO) {
            lastTime = icoTime.getText().toString();
        } else {
            lastTime = onlineExchangeTime.getText().toString();
        }
        if (TextUtils.isEmpty(lastTime)) {
            pvTime.setDate(Calendar.getInstance());
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DateUtils.stringToDate(lastTime, "yyyy年MM月dd日"));
            pvTime.setDate(calendar);
        }
        pvTime.show();
    }

    public void hideSoftInputMethod() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //获取键盘显示状态
        boolean isOpen = imm.isActive();
        if (isOpen) {
            imm.hideSoftInputFromWindow(BuildCoinInfoActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
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
