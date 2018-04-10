package com.imalljoy.insights.mvps.coins;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.mvps.adapter.CommonFragmentAdapter;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailCommentFragment;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailIcoInfoFragment;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailIntroFragment;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailNewsFragment;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailTeamFragment;
import com.imalljoy.insights.mvps.coins.detail.VoteStep1ListActivity;
import com.imalljoy.insights.mvps.research.ReportFragment;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.CustomPopupWindow;
import com.imalljoy.insights.widgets.ObservableScrollView;
import com.imalljoy.insights.widgets.PullToRefreshScrollableLayout;
import com.imalljoy.insights.widgets.TopBarCommon;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/31.
 */

public class CurrencyCoinsDetailActivity extends BaseActivity implements View.OnClickListener, ObservableScrollView.ScrollViewListener {
    private static final String TAG = "CurrencyCoinsDetailActi";


    @BindView(R.id.tab_layout)
    SmartTabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.pull_refresh_scrollable)
    PullToRefreshScrollableLayout pullToRefreshScrollableLayout;
    @BindView(R.id.root_view)
    LinearLayout rootView;

    CoinVo mVo;
    List<Fragment> mFragmentList;
    List<String> mFragmentTitleList;
    CommonFragmentAdapter mAdapter;
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.price3)
    TextView price3;
    @BindView(R.id.price4)
    TextView price4;
    @BindView(R.id.range)
    TextView range;
    @BindView(R.id.range_value)
    TextView rangeValue;
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
    @BindView(R.id.pager_container)
    FrameLayout pagerContainer;

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
        pullToRefreshScrollableLayout.setMode(PullToRefreshBase.Mode.DISABLED);
        initView();

        initViewPager();
    }

    private void initView() {
        price.setText(CommonUtils.formatNumberWithCommaSplit(mVo.getPrice()));
        price3.setText("=" +CommonUtils.formatNumberWithCommaSplit(mVo.getPrice3()));
        price4.setText(mVo.getPrice4());
        float rate = CommonUtils.MathRound(mVo.getRange() * 100, 2);
        if (rate >= 0) {
            range.setText("+" + String.valueOf(rate) + "%");
        } else {
            range.setText(rate + "%");
        }
        rangeValue.setText(CommonUtils.formatNumberWithCommaSplit(mVo.getMarketValue()*mVo.getRange()));
        high24.setText(CommonUtils.formatNumberWithCommaSplit(mVo.getHigh24()));
        low24.setText(CommonUtils.formatNumberWithCommaSplit(mVo.getLow24()));
        vol24.setText(CommonUtils.formatNumberWithCommaSplit(mVo.getVol24()) + "("+mVo.getPrice2()+")");
        marketValue.setText(CommonUtils.formatNumberWithCommaSplit(mVo.getMarketValue()));
        rank.setText("#"+mVo.getRank());
        turnover.setText(CommonUtils.formatNumberWithCommaSplit(mVo.getTurnover()) +"M");
    }

    public void initViewPager() {
        mFragmentList = new ArrayList<>();
        mFragmentTitleList = new ArrayList<>();
        CoinDetailIntroFragment intro = CoinDetailIntroFragment.newInstance(mVo);
        intro.setScrollListener(this);
//        mFragmentList.add(CoinDetailIntroFragment.newInstance());
        mFragmentList.add(intro);
        mFragmentList.add(CoinDetailTeamFragment.newInstance());
        mFragmentList.add(CoinDetailCommentFragment.newInstance());
        mFragmentList.add(ReportFragment.newInstance());
        mFragmentList.add(CoinDetailNewsFragment.newInstance());
        //交易所
        mFragmentList.add(CoinsChildFragment.newInstance(CoinsChildFragment.CURRENCY, 1));
        //ICO信息
        mFragmentList.add(CoinDetailIcoInfoFragment.newInstance(mVo));

        mFragmentTitleList.add(CoinDetailIntroFragment.TITLE);
        mFragmentTitleList.add(CoinDetailTeamFragment.TITLE);
        mFragmentTitleList.add(CoinDetailCommentFragment.TITLE);
        mFragmentTitleList.add(ReportFragment.TITLE);
        mFragmentTitleList.add(CoinDetailNewsFragment.TITLE);
        mFragmentTitleList.add("交易所");
        mFragmentTitleList.add(CoinDetailIcoInfoFragment.TITLE);


        mAdapter = new CommonFragmentAdapter(getSupportFragmentManager(), mFragmentList, mFragmentTitleList);
        viewpager.setAdapter(mAdapter);
        tabLayout.setCustomTabView(R.layout.smartlayout_text_simple, R.id.custom_text);
//        tabLayout.setCustomTabView(new SmartTabLayout.TabProvider() {
//            @Override
//            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
//                LayoutInflater inflater = LayoutInflater.from(container.getContext());
//                Resources res = container.getContext().getResources();
//                View tab = inflater.inflate(R.layout.smartlayout_text_simple, container, false);
//                TextView textView = (TextView) tab.findViewById(R.id.custom_text);
//                switch (position) {
//                    case 0:
//                        textView.setText(adapter.getPageTitle(position));
//                        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
//                        break;
//                    case 1:
//                        textView.setText(adapter.getPageTitle(position));
//                        break;
//                    case 2:
//                        textView.setText(adapter.getPageTitle(position));
//                        break;
//                    case 3:
//                        textView.setText(adapter.getPageTitle(position));
//                        break;
//                    case 4:
//                        textView.setText(adapter.getPageTitle(position));
//                        break;
//                    case 5:
//                        textView.setText(adapter.getPageTitle(position));
//                        break;
//                    case 6:
//                        textView.setText(adapter.getPageTitle(position));
//                        break;
//                }
//                return tab;
//            }
//
//        });

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

    CustomPopupWindow popupWindow = null;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                //返回
                finish();
                break;
            case R.id.top_bar_right_layout:
                //更多
                if (popupWindow == null) {
                    popupWindow = new CustomPopupWindow();
                    popupWindow.createCoinMorePopup(this, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            switch (v.getId()) {
                                case R.id.optional_layout:
                                    popupWindow.dismiss();
                                    break;
                                case R.id.vote_layout:
                                    popupWindow.dismiss();
                                    VoteStep1ListActivity.toActivity(CurrencyCoinsDetailActivity.this, 0);
                                    break;
                            }
                        }
                    });
                }
                popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);
                break;
        }
    }

    public static void toActivity(Context context, CoinVo vo) {
        Intent it = new Intent(context, CurrencyCoinsDetailActivity.class);
        it.putExtra("coinVo", vo);
        context.startActivity(it);
    }

    @Override
    public void onScroll(int x, int y, int oldX, int oldY) {
//        scrollView.scrollTo(x,y);
        Log.e(TAG, "x=" + x + ",oldX=" + oldX + "y=" + y + ",oldY=" + oldY);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewpager.getLayoutParams();
        params.height = params.height + y;
        viewpager.setLayoutParams(params);
        viewpager.requestLayout();
    }
}

