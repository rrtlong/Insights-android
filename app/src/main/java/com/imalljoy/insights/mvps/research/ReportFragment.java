package com.imalljoy.insights.mvps.research;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;
import com.imalljoy.insights.bus.JumpFragment;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.common.LocalData;
import com.imalljoy.insights.entity.ReportVo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/09.
 */

public class ReportFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    private static final String TAG = "ReportFragment";
    public static String TITLE = "报告";
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.swiperRefreshLayout)
    SwipeRefreshLayout mSwiperRefreshLayout;
    Unbinder unbinder;
    private View mRootView;
    private ReportRecyclerAdapter mAdapter = null;
    private List<ReportVo> mReportVos = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fra_report, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        EventBus.getDefault().register(this);
        initView();
        return mRootView;
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divider = new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.recyclerview_divide_type1));
        mReportVos = ConstantData.reportVos;
        mAdapter = new ReportRecyclerAdapter(this.getContext(), ConstantData.reportVos);
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.addItemDecoration(divider);
        mRecyclerview.setAdapter(mAdapter);
        mSwiperRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this.getContext(),R.color.holo_blue_bright),
                ContextCompat.getColor(this.getContext(),R.color.holo_green_light),
                ContextCompat.getColor(this.getContext(),R.color.holo_orange_light),
                ContextCompat.getColor(this.getContext(),R.color.holo_purple),
                ContextCompat.getColor(this.getContext(),R.color.holo_red_light));
        mSwiperRefreshLayout.setOnRefreshListener(this);

    }

    public static ReportFragment newInstance() {
        ReportFragment fragment = new ReportFragment();
        return fragment;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(JumpFragment jumpFragment){
        //针对于ReportFragment刷新
        if(jumpFragment.getType() == JumpFragment.Type.Research && jumpFragment.getIndex() ==1 && jumpFragment.isRefresh()){
            mAdapter.setData(ConstantData.reportVos);
        }else if(jumpFragment.getType() == JumpFragment.Type.Research && jumpFragment.isRefresh()){
            //针对于调研模块的刷新
            mAdapter.setData(ConstantData.reportVos);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwiperRefreshLayout.setRefreshing(false);
                mAdapter.setData(ConstantData.reportVos);
            }
        },1500);
    }
}
