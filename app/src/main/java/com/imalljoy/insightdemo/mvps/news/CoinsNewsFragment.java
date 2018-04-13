package com.imalljoy.insightdemo.mvps.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseFragment;
import com.imalljoy.insightdemo.entity.NewVo;
import com.imalljoy.insightdemo.mvps.coins.detail.CoinDetailNewsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 04/08.
 */

public class CoinsNewsFragment extends BaseFragment {
    public static String TITLE = "数币";
    View mRootView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;
    CoinDetailNewsAdapter mAdapter;

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
        mAdapter = new CoinDetailNewsAdapter(this.getContext(), getListData(), 0);
        recyclerview.setAdapter(mAdapter);
    }

    public List<NewVo> getListData() {
        List<NewVo> vos = new ArrayList<>();
        NewVo newVo = new NewVo();
        newVo.setName("比特币闪电网络实现兼容数字资产，彩色币技术成关键");
        newVo.setCover("new_cover1");
        vos.add(newVo);
        newVo = new NewVo();
        newVo.setName("Ubitquity采用比特币区块链保护房地产产权");
        newVo.setCover("new_cover2");
        vos.add(newVo);
        newVo = new NewVo();
        newVo.setName("火币袁煜明：我们现在处于区块链经济的1776年");
        newVo.setCover("new_cover3");
        vos.add(newVo);
        newVo = new NewVo();
        newVo.setName("去中心化数据库：传统IT与区块链的未来融合形式");
        newVo.setCover("new_cover4");
        vos.add(newVo);
        return vos;
    }
    public static CoinsNewsFragment newInstance(){
        CoinsNewsFragment fragment = new CoinsNewsFragment();
        return fragment;
    }
}
