package com.imalljoy.insights.mvps.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;
import com.imalljoy.insights.mvps.adapter.CommonFragmentAdapter;
import com.imalljoy.insights.mvps.coins.CoinsChildFragment;
import com.imalljoy.insights.mvps.coins.CoinsOptionalFragment;
import com.imalljoy.insights.mvps.news.CoinsNewsFragment;
import com.imalljoy.insights.mvps.news.IndustryNewsFragment;
import com.imalljoy.insights.mvps.news.RateNewsFragment;
import com.imalljoy.insights.widgets.TopBarCommon;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/09.
 */

public class NewsFragment extends BaseFragment {
    @BindView(R.id.tab_layout)
    SmartTabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.root_view)
    LinearLayout rootView;
    Unbinder unbinder;
    private View mRootView;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mFragmentTitleList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fra_news, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        initView();
        return mRootView;
    }

    private void initView() {
        tabLayout.setCustomTabView(R.layout.smartlayout_text_layout_coins, R.id.custom_text);

        mFragmentList.add(CoinsNewsFragment.newInstance());
        mFragmentList.add(IndustryNewsFragment.newInstance());
        mFragmentList.add(RateNewsFragment.newInstance());
        mFragmentTitleList.add(CoinsNewsFragment.TITLE);
        mFragmentTitleList.add(IndustryNewsFragment.TITLE);
        mFragmentTitleList.add(RateNewsFragment.TITLE);
        CommonFragmentAdapter adapter = new CommonFragmentAdapter(getChildFragmentManager(), mFragmentList, mFragmentTitleList);
        viewpager.setAdapter(adapter);
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

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
