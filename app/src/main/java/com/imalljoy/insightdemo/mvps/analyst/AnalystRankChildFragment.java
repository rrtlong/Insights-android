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
import com.imalljoy.insightdemo.entity.UserVo;

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
    List<UserVo> listData;

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


    public List<UserVo> getListData() {
        List<UserVo> vos = new ArrayList<>();
        UserVo vo;
        if(mType ==0) {
            vo = new UserVo();
            vo.setName("黄晓霞");
            vo.setHeadPic("head1");
            vo.setGender(1);
            vo.setAnalytsLevel(1);
            vo.setAnalytsStars(3);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("李清");
            vo.setHeadPic("head2");
            vo.setGender(0);
            vo.setAnalytsLevel(2);
            vo.setAnalytsStars(2);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("Chris Wong");
            vo.setHeadPic("head3");
            vo.setGender(0);
            vo.setAnalytsLevel(2);
            vo.setAnalytsStars(5);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("王合喜");
            vo.setHeadPic("head4");
            vo.setGender(0);
            vo.setAnalytsLevel(1);
            vo.setAnalytsStars(4);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("张青峰 ");
            vo.setHeadPic("head5");
            vo.setGender(0);
            vo.setAnalytsLevel(2);
            vo.setAnalytsStars(2);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("宋玉");
            vo.setHeadPic("head6");
            vo.setGender(1);
            vo.setAnalytsLevel(1);
            vo.setAnalytsStars(3);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("孙福泉");
            vo.setHeadPic("head7");
            vo.setGender(0);
            vo.setAnalytsLevel(1);
            vo.setAnalytsStars(4);
            vos.add(vo);
            vo.setName("王杰");
            vo.setHeadPic("head8");
            vo.setGender(1);
            vo.setAnalytsLevel(2);
            vo.setAnalytsStars(2);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("邹晓倩 ");
            vo.setHeadPic("head9");
            vo.setGender(1);
            vo.setAnalytsLevel(2);
            vo.setAnalytsStars(3);
            vos.add(vo);
        }else if(mType ==1){
            vo = new UserVo();
            vo.setName("张萌 ");
            vo.setHeadPic("head10");
            vo.setGender(1);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(4);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("李奥 ");
            vo.setHeadPic("head9");
            vo.setGender(0);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(5);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("孙伟亮");
            vo.setHeadPic("head8");
            vo.setGender(0);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(5);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("陈潇");
            vo.setHeadPic("head7");
            vo.setGender(0);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(4);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("李健");
            vo.setHeadPic("head6");
            vo.setGender(0);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(4);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("曲美玲");
            vo.setHeadPic("head5");
            vo.setGender(1);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(3);
            vos.add(vo);
        }else {
            vo = new UserVo();
            vo.setName("jack chen");
            vo.setHeadPic("head4");
            vo.setGender(0);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(5);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("张东");
            vo.setHeadPic("head3");
            vo.setGender(0);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(5);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("吴晓庆");
            vo.setHeadPic("head2");
            vo.setGender(0);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(3);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("李志祥");
            vo.setHeadPic("head1");
            vo.setGender(0);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(5);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("张健 ");
            vo.setHeadPic("head10");
            vo.setGender(0);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(5);
            vos.add(vo);
            vo = new UserVo();
            vo.setName("刘佳慧");
            vo.setHeadPic("head9");
            vo.setGender(1);
            vo.setAnalytsLevel(3);
            vo.setAnalytsStars(5);
            vos.add(vo);
        }



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

