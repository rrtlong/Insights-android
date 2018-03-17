package com.imalljoy.insights.mvps.research;

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

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;
import com.imalljoy.insights.common.ConstantData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/09.
 */

public class ReportFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.swiperRefreshLayout)
    SwipeRefreshLayout mSwiperRefreshLayout;
    Unbinder unbinder;
    private View mRootView;
    private ReportRecyclerAdapter mAdapter = null;

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
        initView();
        return mRootView;
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divider = new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.recyclerview_divide_type1));
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwiperRefreshLayout.setRefreshing(false);
            }
        },3000);
    }
}
