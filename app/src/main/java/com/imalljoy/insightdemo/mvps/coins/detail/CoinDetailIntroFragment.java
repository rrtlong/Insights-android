package com.imalljoy.insightdemo.mvps.coins.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseFragment;
import com.imalljoy.insightdemo.base.WebViewActivity;
import com.imalljoy.insightdemo.entity.CoinVo;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.widgets.ObservableScrollView;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailIntroFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "CoinDetailIntroFragment";
    public static String TITLE = "介绍";
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
    @BindView(R.id.whitebook_layout)
    LinearLayout whitebookLayout;
    @BindView(R.id.block_station_layout)
    LinearLayout blockStationLayout;
    @BindView(R.id.ico_time)
    TextView icoTime;
    @BindView(R.id.ico_time_layout)
    LinearLayout icoTimeLayout;
    @BindView(R.id.online_exchange_time)
    TextView onlineExchangeTime;
    @BindView(R.id.online_exchange_time_layout)
    LinearLayout onlineExchangeTimeLayout;
    @BindView(R.id.telegraph_group)
    TextView telegraphGroup;
    @BindView(R.id.telegraph_group_layout)
    LinearLayout telegraphGroupLayout;
    @BindView(R.id.online_exchange)
    TextView onlineExchange;
    @BindView(R.id.online_exchange_layout)
    LinearLayout onlineExchangeLayout;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.location_layout)
    LinearLayout locationLayout;
    @BindView(R.id.twitter_fans)
    TextView twitterFans;
    @BindView(R.id.twitter_fans_layout)
    LinearLayout twitterFansLayout;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.intro)
    TextView intro;
    @BindView(R.id.feature)
    TextView feature;
    @BindView(R.id.feature_intro)
    TextView featureIntro;
    Unbinder unbinder;
    private View mRootView;
    private ObservableScrollView.ScrollViewListener parentInteface;
    private CoinVo mVo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fra_coin_detail_intro, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        websiteLayout.setOnClickListener(this);
        whitebookLayout.setOnClickListener(this);
        blockStationLayout.setOnClickListener(this);
        telegraphGroupLayout.setOnClickListener(this);
        twitterFansLayout.setOnClickListener(this);

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mVo = (CoinVo) getArguments().getSerializable("coinVo");
        initView();
    }

    private void initView() {
        if (mVo != null) {
            name.setText(mVo.getName());
            Glide.with(this).load(CommonUtils.getLogoIdFromString(mVo.getLogoUrl())).error(R.mipmap.dog_logo).into(logo);
            onlineExchange.setText(mVo.getOnlineExchange());
            SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
            if(mVo.getIcoTime() != null){
                icoTime.setText(sf.format(mVo.getIcoTime()));
            }
            if(mVo.getOnlineExchangeTime() != null){
                onlineExchangeTime.setText(sf.format(mVo.getOnlineExchangeTime()));
            }

            location.setText(mVo.getLocation());
            website.setText(mVo.getWebsiteUrl());
            location.setText(mVo.getLocation());
            telegraphGroup.setText(mVo.getTelegraphGroup() ==null? "":mVo.getTelegraphGroup() + "人");
            twitterFans.setText(mVo.getTwitterFans() == null ? "":mVo.getTwitterFans() + "人");
            intro.setText(mVo.getIntro());
            title.setText(mVo.getName());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public static CoinDetailIntroFragment newInstance(CoinVo coinVo) {
        CoinDetailIntroFragment fragment = new CoinDetailIntroFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("coinVo", coinVo);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setScrollListener(ObservableScrollView.ScrollViewListener scrollListener) {
        this.parentInteface = scrollListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.website_layout:
                WebViewActivity.toActivity(getContext(), "官网", mVo != null ? mVo.getWebsiteUrl() : "https://www.egcchain.com/");
                break;
            case R.id.whitebook_layout:
                WebViewActivity.toActivity(getContext(), "白皮书", mVo != null ? mVo.getWhiteBookUrl() : "http://7xqn4j.com1.z0.glb.clouddn.com/Engine%20V2.2.3%20-%20Chinese%20Version.pdf");
                break;
            case R.id.block_station_layout:
                WebViewActivity.toActivity(getContext(),"区块站", mVo != null? mVo.getBlockStationUrl(): null);
//                FileDownloadManager.startDownloadFile("http://7xqn4j.com1.z0.glb.clouddn.com/Engine%20V2.2.3%20-%20Chinese%20Version.pdf");
                break;
            case R.id.telegraph_group_layout:
                WebViewActivity.toActivity(getContext(), "电报", mVo != null ? mVo.getTelegraphGroupUrl() : "https://t.me/joinchat/IEbn1knC_iMb2cX16Dut3A");
                break;
            case R.id.twitter_fans_layout:
                WebViewActivity.toActivity(getContext(), "推特", mVo != null ? mVo.getTwitterFanUrl() : "https://twitter.com/enginechainegcc");
                break;
        }
    }
}
