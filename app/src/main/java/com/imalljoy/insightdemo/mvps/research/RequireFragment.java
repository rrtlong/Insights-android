package com.imalljoy.insightdemo.mvps.research;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseFragment;
import com.imalljoy.insightdemo.bus.JumpFragment;
import com.imalljoy.insightdemo.common.ConstantData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/09.
 */

public class RequireFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.swiperRefreshLayout)
    SwipeRefreshLayout mSwiperRefreshLayout;
    Unbinder unbinder;
    private View mRootView;
    private RequireRecyclerAdapter mAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fra_require, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        initView();
        EventBus.getDefault().register(this);
        return mRootView;
    }

    @SuppressLint("ResourceAsColor")
    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divider = new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.recyclerview_divide_type1));
        mAdapter = new RequireRecyclerAdapter(this.getContext(), ConstantData.requestVos);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.addItemDecoration(divider);
        mRecyclerview.setAdapter(mAdapter);
        mSwiperRefreshLayout.setOnRefreshListener(this);
//        mSwiperRefreshLayout.setColorSchemeColors(android.R.color.holo_blue_bright, android.R.color.holo_green_light,  android.R.color.holo_orange_light,android.R.color.holo_purple android.R.color.holo_red_light);
        mSwiperRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this.getContext(), R.color.holo_blue_bright),
                ContextCompat.getColor(this.getContext(), R.color.holo_green_light),
                ContextCompat.getColor(this.getContext(), R.color.holo_orange_light),
                ContextCompat.getColor(this.getContext(), R.color.holo_purple),
                ContextCompat.getColor(this.getContext(), R.color.holo_red_light));
    }

    public static RequireFragment newInstance() {
        RequireFragment fragment = new RequireFragment();
        return fragment;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(JumpFragment jumpFragment) {
        if (jumpFragment.getType() == JumpFragment.Type.Research && jumpFragment.getIndex() == 2 && jumpFragment.isRefresh()) {
            mAdapter.setData(ConstantData.requestVos);
        } else if (jumpFragment.getType() == JumpFragment.Type.Research && jumpFragment.isRefresh()) {
            //针对于调研模块的刷新
            mAdapter.setData(ConstantData.requestVos);
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
                mAdapter.setData(ConstantData.requestVos);
            }
        }, 1500);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && mRootView != null) {
            mAdapter.setData(ConstantData.requestVos);
        }
    }
}
