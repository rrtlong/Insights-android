package com.imalljoy.insightdemo.mvps.coins.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseFragment;
import com.imalljoy.insightdemo.base.BaseRecyclerAdapter;
import com.imalljoy.insightdemo.base.GridDivider;
import com.imalljoy.insightdemo.entity.UserVo;
import com.imalljoy.insightdemo.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailTeamFragment extends BaseFragment {
    private static final String TAG = "CoinDetailTeamFragment";
    public static  String TITLE = "团队";
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.tip_info)
    TextView tipInfo;
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
        mAdapter.setOnClickListener(new BaseRecyclerAdapter.OnClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.e(TAG,"view position " + view.getTop() + " " + view.getLeft() );
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tipInfo.getLayoutParams();
                params.topMargin = view.getTop() + ScreenUtils.dp2px(view.getContext(),7);
                if((position+1)%4 ==0){
                    params.leftMargin = view.getLeft() - ScreenUtils.dp2px(view.getContext(),67) + (view.getWidth()-ScreenUtils.dp2px(view.getContext(),57))/2;
                }else{
                    params.leftMargin = view.getLeft() + ScreenUtils.dp2px(view.getContext(),57) + (view.getWidth()-ScreenUtils.dp2px(view.getContext(),57))/2;
                }

                tipInfo.requestLayout();
                tipInfo.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public List<UserVo> getListData() {
        List<UserVo> vos = new ArrayList<>();
        UserVo vo = new UserVo();
        vo.setName("张晓晓");
        vo.setHeadPic("head1");
        vo.setExtraInfo("挖矿研究师");
        vos.add(vo);
        vo = new UserVo();
        vo.setName("张贵");
        vo.setHeadPic("head2");
        vo.setExtraInfo("挖矿研究师");
        vos.add(vo);
        vo = new UserVo();
        vo.setName("张望");
        vo.setHeadPic("head3");
        vo.setExtraInfo("挖矿研究师");
        vos.add(vo);
        vo = new UserVo();
        vo.setName("王天");
        vo.setHeadPic("head4");
        vo.setExtraInfo("算法专家");
        vos.add(vo);
        vo = new UserVo();
        vo.setName("王德");
        vo.setHeadPic("head8");
        vo.setExtraInfo("算法专家");
        vos.add(vo);
        vo = new UserVo();
        vo.setName("赵东");
        vo.setHeadPic("head7");
        vo.setExtraInfo("挖矿研究师");
        vos.add(vo);
        vo = new UserVo();
        vo.setName("李瑞");
        vo.setHeadPic("head6");
        vo.setExtraInfo("挖矿研究师");
        vos.add(vo);
        vo = new UserVo();
        vo.setName("李笑");
        vo.setHeadPic("head5");
        vo.setExtraInfo("挖矿研究师");
        vos.add(vo);
        vo = new UserVo();
        vo.setName("李阳");
        vo.setHeadPic("head4");
        vo.setExtraInfo("挖矿研究师");
        vos.add(vo);
        vo = new UserVo();
        vo.setName("李国福");
        vo.setHeadPic("head3");
        vo.setExtraInfo("挖矿研究师");
        vos.add(vo);
        return vos;
    }

    public static CoinDetailTeamFragment newInstance(){
        CoinDetailTeamFragment fragment = new CoinDetailTeamFragment();
        return fragment;
    }
}
