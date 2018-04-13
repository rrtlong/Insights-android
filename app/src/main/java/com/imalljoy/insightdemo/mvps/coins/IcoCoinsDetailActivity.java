package com.imalljoy.insightdemo.mvps.coins;

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
import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseActivity;
import com.imalljoy.insightdemo.entity.CoinVo;
import com.imalljoy.insightdemo.mvps.adapter.CommonFragmentAdapter;
import com.imalljoy.insightdemo.mvps.coins.detail.CoinDetailCommentFragment;
import com.imalljoy.insightdemo.mvps.coins.detail.CoinDetailEnterpriseExposeFragment;
import com.imalljoy.insightdemo.mvps.coins.detail.CoinDetailIntroFragment;
import com.imalljoy.insightdemo.mvps.coins.detail.CoinDetailNewsFragment;
import com.imalljoy.insightdemo.mvps.coins.detail.CoinDetailTeamFragment;
import com.imalljoy.insightdemo.mvps.coins.detail.VoteStep2Activity;
import com.imalljoy.insightdemo.mvps.research.ReportFragment;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.widgets.CustomPopupWindow;
import com.imalljoy.insightdemo.widgets.PullToRefreshScrollableLayout;
import com.imalljoy.insightdemo.widgets.TopBarCommon;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/30.
 */

public class IcoCoinsDetailActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.root_view)
    LinearLayout rootView;
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.for_coin)
    TextView forCoin;
    @BindView(R.id.soft_cap)
    TextView softCap;
    @BindView(R.id.hard_cap)
    TextView hardCap;
    @BindView(R.id.roi)
    TextView roi;
    @BindView(R.id.ico_market_value)
    TextView marketValue;
    @BindView(R.id.start_time)
    TextView startTime;
    @BindView(R.id.end_time)
    TextView endTime;
    @BindView(R.id.status)
    TextView status;
    @BindView(R.id.tab_layout)
    SmartTabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.pull_refresh_scrollable)
    PullToRefreshScrollableLayout pullToRefreshScrollableLayout;
    CommonFragmentAdapter mAdapter;
    List<Fragment> mFragmentList;
    List<String> mFragmentTitleList;
    CoinVo mVo;
    @BindView(R.id.private_price)
    TextView privatePrice;
    @BindView(R.id.pre_ico_price)
    TextView preIcoPrice;
    @BindView(R.id.pager_container)
    FrameLayout pagerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_ico_coins_detail);
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
        if (mVo != null) {
            price.setText(mVo.getPriceConvert());
            forCoin.setText(mVo.getForCoin());
            softCap.setText(mVo.getSoftcap());
            hardCap.setText(mVo.getHardcap());
            roi.setText(CommonUtils.formatNumberWithCommaSplit(mVo.getRoni()));
            marketValue.setText(mVo.getIcoMarketValue());
            privatePrice.setText(mVo.getPrivatePrice());
            preIcoPrice.setText(mVo.getPreIcoPrice());
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日:HH:mm:ss");
            startTime.setText(mVo.getIcoTime() != null ? format.format(new Date(mVo.getIcoTime().getTime())) : "");
            endTime.setText(mVo.getIcoEndTime() != null ? format.format(new Date(mVo.getIcoEndTime().getTime())) : "");
            //0:空投   1:新上  2:即将ico  3:正在ico  4:ico结束 5：币市
            switch (mVo.getType()) {
                case 0:
                    status.setText("空投");
                    break;
                case 1:
                    status.setText("新上");
                    break;
                case 2:
                    status.setText("即将ICO");
                    break;
                case 3:
                    status.setText("正在ICO");
                    break;
                case 4:
                    status.setText("ICO结束");
                    break;
                case 5:
                    status.setText("币市");
                    break;
            }
        }
    }

    public void initViewPager() {
        mFragmentList = new ArrayList<>();
        mFragmentTitleList = new ArrayList<>();
        mFragmentList.add(CoinDetailIntroFragment.newInstance(mVo));
        mFragmentList.add(CoinDetailTeamFragment.newInstance());
        mFragmentList.add(CoinDetailCommentFragment.newInstance());
        mFragmentList.add(ReportFragment.newInstance());
        mFragmentList.add(CoinDetailNewsFragment.newInstance());
        mFragmentList.add(CoinDetailEnterpriseExposeFragment.newInstance());
        mFragmentTitleList.add(CoinDetailIntroFragment.TITLE);
        mFragmentTitleList.add(CoinDetailTeamFragment.TITLE);
        mFragmentTitleList.add(CoinDetailCommentFragment.TITLE);
        mFragmentTitleList.add(ReportFragment.TITLE);
        mFragmentTitleList.add(CoinDetailNewsFragment.TITLE);
        mFragmentTitleList.add(CoinDetailEnterpriseExposeFragment.TITLE);
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
//                switch (position){
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
//                                    VoteStep1ListActivity.toActivity(IcoCoinsDetailActivity.this,0);
                                    VoteStep2Activity.toActivity(IcoCoinsDetailActivity.this);
                                    break;
                                case R.id.root_view:
                                    popupWindow.dismiss();
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
        Intent it = new Intent(context, IcoCoinsDetailActivity.class);
        it.putExtra("coinVo", vo);
        context.startActivity(it);
    }
}
