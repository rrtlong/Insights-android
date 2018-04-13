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

public class IndustryNewsFragment extends BaseFragment {
    public static String TITLE = "行业";
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
        newVo.setName("英国国家安全网络中心将加密货币盗取归为网络威胁范畴");
        newVo.setCover("new_cover5");
        vos.add(newVo);
        newVo = new NewVo();
        newVo.setName("中国银行前行长李礼辉：区块链在金融领域的规模化应用需要三年");
        newVo.setCover("new_cover6");
        vos.add(newVo);
        newVo = new NewVo();
        newVo.setName("李笑来：未来中国一定是区块链最大的市场");
        newVo.setCover("new_cover7");
        vos.add(newVo);
        return vos;
    }

    public static IndustryNewsFragment newInstance() {
        IndustryNewsFragment fragment = new IndustryNewsFragment();
        return fragment;
    }
}

