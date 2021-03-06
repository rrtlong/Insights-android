package com.imalljoy.insightdemo.mvps.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseFragment;
import com.imalljoy.insightdemo.mvps.adapter.CommonFragmentAdapter;
import com.imalljoy.insightdemo.mvps.analyst.AnalystLiveFragment;
import com.imalljoy.insightdemo.mvps.analyst.AnalystQAFragment;
import com.imalljoy.insightdemo.mvps.analyst.AnalystRankFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/09.
 */

public class AnalystFragment extends BaseFragment {
    @BindView(R.id.tab_layout)
    SmartTabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
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
            mRootView = inflater.inflate(R.layout.fra_analyst, container, false);
            unbinder = ButterKnife.bind(this, mRootView);
            initView();
        }

        return mRootView;
    }

    private void initView() {
        tabLayout.setCustomTabView(R.layout.smartlayout_text_layout_coins, R.id.custom_text);

        mFragmentList.add(AnalystRankFragment.newInstance());
        mFragmentList.add(AnalystQAFragment.newInstance());
        mFragmentList.add(AnalystLiveFragment.newInstance());
        mFragmentTitleList.add(AnalystRankFragment.TITLE);
        mFragmentTitleList.add(AnalystQAFragment.TITLE);
        mFragmentTitleList.add(AnalystLiveFragment.TITLE);
        CommonFragmentAdapter adapter = new CommonFragmentAdapter(getChildFragmentManager(), mFragmentList, mFragmentTitleList);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(3);

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

