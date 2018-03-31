package com.imalljoy.insights.mvps.coins;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.mvps.adapter.CommonFragmentAdapter;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailCommentFragment;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailEnterpriseExposeFragment;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailIcoInfoFragment;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailIntroFragment;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailNewsFragment;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailTeamFragment;
import com.imalljoy.insights.mvps.research.ReportFragment;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/31.
 */

public class CurrencyCoinsDetailActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "CurrencyCoinsDetailActi";

    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.exchange_rate)
    TextView exchangeRate;
    @BindView(R.id.exchange)
    TextView exchange;
    @BindView(R.id.range)
    TextView range;
    @BindView(R.id.range_rate)
    TextView rangeRate;
    @BindView(R.id.high_24_title)
    TextView high24Title;
    @BindView(R.id.high_24)
    TextView high24;
    @BindView(R.id.market_value_title)
    TextView marketValueTitle;
    @BindView(R.id.market_value)
    TextView marketValue;
    @BindView(R.id.low_24_title)
    TextView low24Title;
    @BindView(R.id.low_24)
    TextView low24;
    @BindView(R.id.rank_title)
    TextView rankTitle;
    @BindView(R.id.rank)
    TextView rank;
    @BindView(R.id.vol_24_title)
    TextView vol24Title;
    @BindView(R.id.vol_24)
    TextView vol24;
    @BindView(R.id.turnover_title)
    TextView turnoverTitle;
    @BindView(R.id.turnover)
    TextView turnover;
    @BindView(R.id.top_layout)
    LinearLayout topLayout;
    @BindView(R.id.tab_layout)
    SmartTabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    CoinVo mVo;
    List<Fragment> mFragmentList;
    List<String> mFragmentTitleList;
    CommonFragmentAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_currency_coins_detail);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mVo = (CoinVo) getIntent().getSerializableExtra("coinVo");
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText(mVo.getName());
        topBar.setRightView(null, R.mipmap.icon_more_2);
        topBar.top_bar_right_layout.setOnClickListener(this);
        initViewPager();
    }

    public void initViewPager() {
        mFragmentList = new ArrayList<>();
        mFragmentTitleList = new ArrayList<>();
        mFragmentList.add(CoinDetailIntroFragment.newInstance());
        mFragmentList.add(CoinDetailTeamFragment.newInstance());
        mFragmentList.add(CoinDetailCommentFragment.newInstance());
        mFragmentList.add(ReportFragment.newInstance());
        mFragmentList.add(CoinDetailNewsFragment.newInstance());
        //交易所
        mFragmentList.add(CoinsChildFragment.newInstance(CoinsChildFragment.CURRENCY,1));
        //ICO信息
        mFragmentList.add(CoinDetailIcoInfoFragment.newInstance());

        mFragmentTitleList.add(CoinDetailIntroFragment.TITLE);
        mFragmentTitleList.add(CoinDetailTeamFragment.TITLE);
        mFragmentTitleList.add(CoinDetailCommentFragment.TITLE);
        mFragmentTitleList.add(ReportFragment.TITLE);
        mFragmentTitleList.add(CoinDetailNewsFragment.TITLE);
        mFragmentTitleList.add("交易所");
        mFragmentTitleList.add(CoinDetailIcoInfoFragment.TITLE);


        mAdapter = new CommonFragmentAdapter(getSupportFragmentManager(), mFragmentList, mFragmentTitleList);
        viewpager.setAdapter(mAdapter);
        tabLayout.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                LayoutInflater inflater = LayoutInflater.from(container.getContext());
                Resources res = container.getContext().getResources();
                View tab = inflater.inflate(R.layout.smartlayout_text_simple, container, false);
                TextView textView = (TextView) tab.findViewById(R.id.custom_text);
                switch (position) {
                    case 0:
                        textView.setText(adapter.getPageTitle(position));
                        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                        break;
                    case 1:
                        textView.setText(adapter.getPageTitle(position));
                        break;
                    case 2:
                        textView.setText(adapter.getPageTitle(position));
                        break;
                    case 3:
                        textView.setText(adapter.getPageTitle(position));
                        break;
                    case 4:
                        textView.setText(adapter.getPageTitle(position));
                        break;
                    case 5:
                        textView.setText(adapter.getPageTitle(position));
                        break;
                    case 6:
                        textView.setText(adapter.getPageTitle(position));
                        break;
                }
                return tab;
            }

        });

        tabLayout.setViewPager(viewpager);
        tabLayout.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {

            }
        });
        tabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LinearLayout titleRoot = ((LinearLayout) tabLayout.getChildAt(0));
                Log.e("onPageChange", "childCount=" + tabLayout.getChildCount() + " child.child.count=" + titleRoot.getChildCount());
                for (int i = 0; i < titleRoot.getChildCount(); i++) {
                    TextView tv = (TextView) titleRoot.getChildAt(i);
                    tv.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
                TextView chooseTv = (TextView) titleRoot.getChildAt(position);
                chooseTv.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewpager.setCurrentItem(0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                //返回
                finish();
                break;
            case R.id.top_bar_right_layout:
                //更多
                break;
        }
    }

    public static void toActivity(Context context, CoinVo vo) {
        Intent it = new Intent(context, CurrencyCoinsDetailActivity.class);
        it.putExtra("coinVo", vo);
        context.startActivity(it);
    }
}

