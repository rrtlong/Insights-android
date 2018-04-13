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
import com.imalljoy.insightdemo.entity.NewRateVo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 04/08.
 */

public class RateNewsFragment extends BaseFragment {
    public static String TITLE = "评级";
    View mRootView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;
    RateNewsAdapter mAdapter;

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
        mAdapter = new RateNewsAdapter(this.getContext(), getListData(), 0);
        recyclerview.setAdapter(mAdapter);
    }


    public List<NewRateVo> getListData() {
        List<NewRateVo> vos = new ArrayList<>();
        NewRateVo vo = new NewRateVo();
        vo.setName("李显东");
        vo.setCover("head1");
        vo.setTitle("项目评测丨深脑链（DBC）评级");
        vo.setPublishTime(new Timestamp(1520092800000l));//2018-3-4
        vos.add(vo);
        vo = new NewRateVo();
        vo.setName("陈斯利");
        vo.setCover("head2");
        vo.setTitle("项目评测丨SHIVOM - 全球区块链 评级");
        vo.setPublishTime(new Timestamp(1522598400000l));//2018-04-02
        vos.add(vo);
        vo = new NewRateVo();
        vo.setName("链世界");
        vo.setCover("head3");
        vo.setTitle("项目评测丨Mira项目 评级");
        vo.setPublishTime(new Timestamp(1522598400000l));//2018-04-02
        vos.add(vo);
        return vos;
    }

    public static RateNewsFragment newInstance() {
        RateNewsFragment fragment = new RateNewsFragment();
        return fragment;
    }
}
