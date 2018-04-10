package com.imalljoy.insights.mvps.analyst;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.mvps.coins.detail.CoinDetailNewsAdapter;
import com.imalljoy.insights.mvps.news.CoinsNewsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 04/08.
 */

public class AnalystRankChildFragment extends BaseFragment {
    public static int LATEST = 0;
    public static int HOTTEST = 1;
    public static int BEST = 2;
    public static String LATEST_STR = "最新";
    public static String HOTTEST_STR = "最热";
    public static String BEST_STR = "最好";

    int mType;
    View mRootView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;
    AnalystRankAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.simple_recycler_layout, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        mType = getArguments().getInt("type", 0);
        initRecycler();
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initRecycler() {
        LinearLayoutManager linearManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divier = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        divier.setDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearManager);
        recyclerview.addItemDecoration(divier);
        mAdapter = new AnalystRankAdapter(this.getContext(), getListData(), 0);
        recyclerview.setAdapter(mAdapter);
    }


    public List<CoinVo> getListData() {
        List<CoinVo> vos = new ArrayList<>();
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        return vos;
    }

    public static AnalystRankChildFragment newFragment(int type) {
        AnalystRankChildFragment fragment = new AnalystRankChildFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }
}

