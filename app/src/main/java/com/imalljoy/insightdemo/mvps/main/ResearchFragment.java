package com.imalljoy.insightdemo.mvps.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseFragment;
import com.imalljoy.insightdemo.bus.JumpFragment;
import com.imalljoy.insightdemo.mvps.adapter.CommonFragmentAdapter;
import com.imalljoy.insightdemo.mvps.research.BuildRequestActivity;
import com.imalljoy.insightdemo.mvps.research.QuestionnaireFragment;
import com.imalljoy.insightdemo.mvps.research.ReportFragment;
import com.imalljoy.insightdemo.mvps.research.RequireFragment;
import com.imalljoy.insightdemo.widgets.CustomPopupWindow;
import com.imalljoy.insightdemo.widgets.TopBarCommon;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijilong on 03/09.
 */

public class ResearchFragment extends BaseFragment {
    TopBarCommon mTopBar;
    SmartTabLayout mTabLayout;
    ViewPager mViewpager;
    private View mRootView;

    private CommonFragmentAdapter mCommonFragmentAdapter = null;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mFragmentTitleList = new ArrayList<>();
    private QuestionnaireFragment mQuestionnaireFragment = null;
    private ReportFragment mReportFragment = null;
    private RequireFragment mRequireFragment = null;

    private CustomPopupWindow mPopupWindow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fra_research, container, false);
            initTopBar();
            initFragmentPager();
        }
        EventBus.getDefault().register(this);

        return mRootView;
    }

    private void initTopBar() {
        mTopBar = (TopBarCommon) mRootView.findViewById(R.id.top_bar);
        mTabLayout = (SmartTabLayout) mRootView.findViewById(R.id.tab_layout);
        mViewpager = (ViewPager) mRootView.findViewById(R.id.viewpager);
        mTopBar = (TopBarCommon) mRootView.findViewById(R.id.top_bar);
        mTopBar.setTitle("调研");
        mTopBar.setRightView(null, R.mipmap.icon_add);
        mTopBar.top_bar_left_layout.setVisibility(View.INVISIBLE);
        mTopBar.top_bar_right_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (mPopupWindow == null) {
                    mPopupWindow = new CustomPopupWindow();
                    mPopupWindow.createAddPopup(ResearchFragment.this.getContext(), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            switch (v.getId()) {
                                case R.id.request_layout:
                                    BuildRequestActivity.toActivity(ResearchFragment.this.getActivity(), null, 0);
                                    mPopupWindow.dismiss();
                                    break;
                                case R.id.questionnaire_layout:
                                  //  BuildQuestionnaireActivity.toActivity(ResearchFragment.this.getContext(), null, 0,-1);
                                    //mPopupWindow.dismiss();
                                    break;
                                case R.id.root_view:
                                    mPopupWindow.dismiss();
                                    break;
                            }
                        }
                    });

                }
                if(!mPopupWindow.isShowing()){
                    Log.e("pop","show");
                    mPopupWindow.showAtLocation(mRootView, Gravity.CENTER,0,0);
                }


            }
        });
    }

    private void initFragmentPager() {
        if (mQuestionnaireFragment != null)
            return;
        mQuestionnaireFragment = QuestionnaireFragment.newInstance();
        mReportFragment = ReportFragment.newInstance();
        mRequireFragment = RequireFragment.newInstance();
        mFragmentList.add(mQuestionnaireFragment);
        mFragmentList.add(mReportFragment);
        mFragmentList.add(mRequireFragment);
        mFragmentTitleList.add("问卷");
        mFragmentTitleList.add("报告");
        mFragmentTitleList.add("请求");
        mCommonFragmentAdapter = new CommonFragmentAdapter(getChildFragmentManager(), mFragmentList, mFragmentTitleList);
        mViewpager.setAdapter(mCommonFragmentAdapter);
        mTabLayout.setCustomTabView(R.layout.smartlayout_text_layout, R.id.custom_text);
        mTabLayout.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {

            }
        });
        mTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        mTabLayout.setViewPager(mViewpager);


    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(JumpFragment jumpFragment){
        if(jumpFragment.getType() == JumpFragment.Type.Research && jumpFragment.isJump()){
            mViewpager.setCurrentItem(jumpFragment.getIndex());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
