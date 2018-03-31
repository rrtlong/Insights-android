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
 * Created by lijilong on 03/30.
 */

public class IcoCoinsDetailActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.exchange_rate)
    TextView exchangeRate;
    @BindView(R.id.for_coin)
    TextView forCoin;
    @BindView(R.id.soft_cap)
    TextView softCap;
    @BindView(R.id.hard_cap)
    TextView hardCap;
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
    CommonFragmentAdapter mAdapter;
    List<Fragment> mFragmentList;
    List<String> mFragmentTitleList;
    CoinVo mVo;

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
        initViewPager();
    }

    public void initViewPager(){
        mFragmentList = new ArrayList<>();
        mFragmentTitleList = new ArrayList<>();
        mFragmentList.add(CoinDetailIntroFragment.newInstance());
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
        mAdapter = new CommonFragmentAdapter(getSupportFragmentManager(), mFragmentList,mFragmentTitleList);
        viewpager.setAdapter(mAdapter);
        tabLayout.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                LayoutInflater inflater = LayoutInflater.from(container.getContext());
                Resources res = container.getContext().getResources();
                View tab = inflater.inflate(R.layout.smartlayout_text_simple, container, false);
                TextView textView = (TextView) tab.findViewById(R.id.custom_text);
                switch (position){
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
                LinearLayout titleRoot = ((LinearLayout)tabLayout.getChildAt(0));
                Log.e("onPageChange","childCount=" + tabLayout.getChildCount() + " child.child.count=" + titleRoot.getChildCount());
                for(int i=0; i<titleRoot.getChildCount(); i++){
                    TextView tv = (TextView)titleRoot.getChildAt(i);
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
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                //返回
                finish();
                break;
            case R.id.top_bar_right_layout:
                //更多
                break;
        }
    }

    public static void toActivity(Context context,CoinVo vo){
        Intent it = new Intent(context, IcoCoinsDetailActivity.class);
        it.putExtra("coinVo",vo);
        context.startActivity(it);
    }
}
