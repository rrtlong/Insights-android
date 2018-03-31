package com.imalljoy.insights.mvps.coins.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailIntroFragment extends BaseFragment {
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
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    public static CoinDetailIntroFragment newInstance(){
        CoinDetailIntroFragment fragment = new CoinDetailIntroFragment();
        return fragment;
    }
}
