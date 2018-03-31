package com.imalljoy.insights.mvps.coins.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;
import com.imalljoy.insights.base.GridDivider;
import com.imalljoy.insights.entity.CoinVo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailTeamFragment extends BaseFragment {
    public static  String TITLE = "团队";
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    CoinDetailTeamAdapter mAdapter;
    Unbinder unbinder;
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.simple_recycler_layout_padding, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        initRecycler();
        return mRootView;
    }

    private void initRecycler() {
        GridLayoutManager gridManager = new GridLayoutManager(this.getContext(),4,GridLayoutManager.VERTICAL, false);
        GridDivider divider = new GridDivider(this.getContext(),1, ContextCompat.getDrawable(this.getContext(), R.drawable.recyclerview_divide_type1));
        mAdapter = new CoinDetailTeamAdapter(this.getContext(), getListData(),0);
        recyclerview.setLayoutManager(gridManager);
        recyclerview.addItemDecoration(divider);
        recyclerview.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
        vos.add(new CoinVo());
        return vos;
    }

    public static CoinDetailTeamFragment newInstance(){
        CoinDetailTeamFragment fragment = new CoinDetailTeamFragment();
        return fragment;
    }
}
