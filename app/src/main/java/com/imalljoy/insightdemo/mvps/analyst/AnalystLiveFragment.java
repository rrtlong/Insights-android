package com.imalljoy.insightdemo.mvps.analyst;

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
import com.imalljoy.insightdemo.entity.LiveVo;
import com.imalljoy.insightdemo.entity.UserVo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 04/08.
 */

public class AnalystLiveFragment extends BaseFragment {
    public static String TITLE = "直播";
    View mRootView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;
    AnalystLiveAdapter mAdapter;

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
        mAdapter = new AnalystLiveAdapter(this.getContext(), getListData(), 0);
        recyclerview.setAdapter(mAdapter);
    }


    public List<LiveVo> getListData() {
        List<LiveVo> vos = new ArrayList<>();
        LiveVo vo = new LiveVo();
        UserVo userVo = new UserVo();
        userVo.setName("断肠人");
        userVo.setHeadPic("head9");
        vo.setUserVo(userVo);
        vo.setTitle("比特币走势分析");
        vo.setEndTime(new Timestamp(1523894400000l));//2018-4-17
        vos.add(vo);
        vo = new LiveVo();
        userVo = new UserVo();
        userVo.setName("在天涯");
        userVo.setHeadPic("head10");
        vo.setUserVo(userVo);
        vo.setTitle("ETH币近况");
        vo.setEndTime(new Timestamp(1523635200000l));//2018-4-14
        vos.add(vo);
        return vos;
    }

    public static AnalystLiveFragment newInstance() {
        AnalystLiveFragment fragment = new AnalystLiveFragment();
        return fragment;
    }
}



