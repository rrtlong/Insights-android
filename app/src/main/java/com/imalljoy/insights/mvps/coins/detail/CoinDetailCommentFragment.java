package com.imalljoy.insights.mvps.coins.detail;

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
import com.imalljoy.insights.entity.CommentVo;
import com.imalljoy.insights.entity.QaVo;
import com.imalljoy.insights.entity.UserVo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailCommentFragment extends BaseFragment {
    public static String TITLE = "评论";
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private View mRootView;
    private Unbinder unbinder;
    private List<CoinVo> mListData;
    private CoinDetailCommentAdapter mAdapter;


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

    private void initRecycler() {
        LinearLayoutManager linearManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divier = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        divier.setDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearManager);
        recyclerview.addItemDecoration(divier);
        mAdapter = new CoinDetailCommentAdapter(this.getContext(), getListData(), 0);
        recyclerview.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public List<CommentVo> getListData() {
        List<CommentVo> vos = new ArrayList<>();
        CommentVo vo = new CommentVo();
        UserVo userVo = new UserVo();
        vo.setContent("这暴涨暴跌过程没人能承受的你买的币这么便宜，我现在买不是等于接你的盘嘛 我在等着瀑布 抓住！！！！");
        vo.setReplyContent("学习一下，支持 大部分是真的 总之波动幅度大是最好的好处 全球市场，无庄家操控。");
        vo.setReplyName("古道");
        vo.setPublishTime("3分钟前");
        userVo.setName("斜阳");
        userVo.setHeadPic("head6");
        vo.setLaunchUser(userVo);
        vos.add(vo);
        vo = new CommentVo();
        userVo = new UserVo();
        vo.setContent("只有比特币等主流币站稳，山寨币才会有炒作过程。");
        vo.setReplyContent("比特币涨，山寨币跌；比特币跌，山寨币暴跌先看平台，什么平台上这个圈钱币了？");
        vo.setReplyName("西风");
        vo.setPublishTime("9分钟前");
        userVo.setName("西门");
        userVo.setHeadPic("head7");
        vo.setLaunchUser(userVo);
        vos.add(vo);
        vo = new CommentVo();
        userVo = new UserVo();
        vo.setContent("要投资永远是以BTC为代表的主流币");
        vo.setReplyContent("要赌博就随便最近看哪种保币种下架的项目不知道靠谱不");
        vo.setReplyName("瘦马");
        vo.setPublishTime("一个小时前");
        userVo.setName("吹雪");
        userVo.setHeadPic("head3");
        vo.setLaunchUser(userVo);
        vos.add(vo);

        return vos;
    }

    public static CoinDetailCommentFragment newInstance() {
        CoinDetailCommentFragment fragment = new CoinDetailCommentFragment();
        return fragment;
    }
}
