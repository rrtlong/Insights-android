package com.imalljoy.insights.mvps.research;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.greendao.bean.Question;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/09.
 */

public class QuestionnaireFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.swiperRefreshLayout)
    SwipeRefreshLayout mSwiperRefreshLayout;
    Unbinder unbinder;
    private View mRootView;
    private QuestionnaireRecyclerAdapter mAdapter = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fra_questionnaire, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        initView();
        return mRootView;
    }

    @SuppressLint("ResourceAsColor")
    private void initView() {
        mAdapter = new QuestionnaireRecyclerAdapter(this.getContext(), ConstantData.questionnaireVos);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divider = new DividerItemDecoration(this.getContext(), LinearLayoutManager.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.recyclerview_divide_type1));
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.addItemDecoration(divider);
        mRecyclerview.setAdapter(mAdapter);
        //mSwiperRefreshLayout.setColorSchemeColors(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        mSwiperRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this.getContext(),R.color.holo_blue_bright),
                ContextCompat.getColor(this.getContext(),R.color.holo_green_light),
                ContextCompat.getColor(this.getContext(),R.color.holo_orange_light),
                ContextCompat.getColor(this.getContext(),R.color.holo_purple),
                ContextCompat.getColor(this.getContext(),R.color.holo_red_light));
        mSwiperRefreshLayout.setOnRefreshListener(this);



    }

    public static QuestionnaireFragment newInstance() {
        QuestionnaireFragment fragment = new QuestionnaireFragment();
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
        }, 2000);
    }
}
