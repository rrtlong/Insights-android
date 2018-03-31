package com.imalljoy.insights.mvps.main;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;
import com.imalljoy.insights.mvps.adapter.CommonFragmentAdapter;
import com.imalljoy.insights.mvps.coins.CoinsChildFragment;
import com.imalljoy.insights.mvps.coins.CoinsOptionalFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/09.
 */

public class CoinsFragment extends BaseFragment {
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
            mRootView = inflater.inflate(R.layout.fra_coins, container, false);

        }
        unbinder = ButterKnife.bind(this, mRootView);
        initView();

        return mRootView;
    }

    private void initView() {
        tabLayout.setCustomTabView(R.layout.smartlayout_text_layout_coins, R.id.custom_text);


        mFragmentList.add(CoinsOptionalFragment.newInstance());
        mFragmentList.add(CoinsChildFragment.newInstance(CoinsChildFragment.CURRENCY,0));
        mFragmentList.add(CoinsChildFragment.newInstance(CoinsChildFragment.ICO,0));
        mFragmentList.add(CoinsChildFragment.newInstance(CoinsChildFragment.AIRDROP,0));
        mFragmentTitleList.add(CoinsOptionalFragment.OPTIONAL_STR);
        mFragmentTitleList.add(CoinsChildFragment.CURRENCY_Str);
        mFragmentTitleList.add(CoinsChildFragment.ICO_Str);
        mFragmentTitleList.add(CoinsChildFragment.AIRDROP_Str);
        CommonFragmentAdapter adapter = new CommonFragmentAdapter(getChildFragmentManager(),mFragmentList, mFragmentTitleList);
        viewpager.setAdapter(adapter);
        tabLayout.setViewPager(viewpager);
        tabLayout.setOnTabClickListener(new SmartTabLayout.OnTabClickListener(){

            @Override
            public void onTabClicked(int position) {

            }
        });
        tabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

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
