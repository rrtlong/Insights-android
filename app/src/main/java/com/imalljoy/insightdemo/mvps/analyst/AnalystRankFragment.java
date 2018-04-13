package com.imalljoy.insightdemo.mvps.analyst;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseFragment;
import com.imalljoy.insightdemo.mvps.adapter.CommonFragmentAdapter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 04/08.
 */

public class AnalystRankFragment extends BaseFragment {
    public static String TITLE = "排名";
//    @BindView(R.id.tab_layout)
    SmartTabLayout tabLayout;
//    @BindView(R.id.viewpager)
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
            mRootView = inflater.inflate(R.layout.fra_analyst_rank, container, false);
        }
        tabLayout = (SmartTabLayout) mRootView.findViewById(R.id.tab_layout);
        viewpager = (ViewPager) mRootView.findViewById(R.id.viewpager);
        unbinder = ButterKnife.bind(this, mRootView);
        initView();
        return mRootView;
    }

    private void initView() {
        tabLayout.setCustomTabView(R.layout.smartlayout_text_simple_rank, R.id.custom_text);

        mFragmentList.add(AnalystRankChildFragment.newFragment(AnalystRankChildFragment.LATEST));
        mFragmentList.add(AnalystRankChildFragment.newFragment(AnalystRankChildFragment.HOTTEST));
        mFragmentList.add(AnalystRankChildFragment.newFragment(AnalystRankChildFragment.BEST));
        mFragmentTitleList.add(AnalystRankChildFragment.LATEST_STR);
        mFragmentTitleList.add(AnalystRankChildFragment.HOTTEST_STR);
        mFragmentTitleList.add(AnalystRankChildFragment.BEST_STR);
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
        viewpager.setAdapter(null);
    }

    public static AnalystRankFragment newInstance() {
        AnalystRankFragment fragment = new AnalystRankFragment();
        return fragment;
    }

}

