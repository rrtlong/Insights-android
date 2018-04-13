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
import com.imalljoy.insightdemo.entity.QaVo;
import com.imalljoy.insightdemo.entity.UserVo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 04/08.
 */

public class AnalystQAFragment extends BaseFragment {
    public static String TITLE = "问答";
    View mRootView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;
    AnalystQAAdapter mAdapter;

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
        mAdapter = new AnalystQAAdapter(this.getContext(), getListData(), 0);
        recyclerview.setAdapter(mAdapter);
    }


    public List<QaVo> getListData() {
        List<QaVo> vos = new ArrayList<>();
        QaVo vo = new QaVo();
        UserVo userVo = new UserVo();
        vo.setqContent("现在能不能免费弄到比特币？");
        vo.setReplyContent("有个CPU币，一台I7电脑，一天估计能挖0.002BTC");
        vo.setReplyName("枯藤");
        vo.setAnser(true);
        vo.setPublishTime("3分钟前");
        userVo.setName("斜阳");
        userVo.setHeadPic("head1");
        vo.setLaunchUser(userVo);
        vos.add(vo);
        vo = new QaVo();
        userVo = new UserVo();
        vo.setqContent("求助：哪个交易平台安全？");
        vo.setReplyContent("P网，K网,BITTREX,3家那个平台安全，有监管，不怕跑路，即使被盗币了，也有准备金可以赔偿的");
        vo.setReplyName("老树");
        vo.setAnser(true);
        vo.setPublishTime("9分钟前");
        userVo.setName("西门");
        userVo.setHeadPic("head2");
        vo.setLaunchUser(userVo);
        vos.add(vo);
        vo = new QaVo();
        userVo = new UserVo();
        vo.setqContent("有哪些币值得投资");
        vo.setReplyContent("目前来看比特、莱特、狗狗和达事币四强最有价值，只是现在数字货币有跌的趋势，不食适合进货，如果你不怕赔的话，或者很有钞票，那可以把资金分成100份以上，过一段时间（至少以天为单位）入一批，这就是很多人都推崇的定投法理财" + "另外声明：买基金只要时间够长这个方法肯定赚，但是数字货币会不会再涨不能保证，有可能比特币跌到只有几分钱后就涨不上去了，而基金是对应股票，最多再等几年的牛市套现就肯定赚");
        vo.setReplyName("昏鸦");
        vo.setAnser(true);
        vo.setPublishTime("一个小时前");
        userVo.setName("吹雪");
        userVo.setHeadPic("head3");
        vo.setLaunchUser(userVo);
        vos.add(vo);
        vo = new QaVo();
        userVo = new UserVo();
        vo.setqContent("比特币成为全球流通的货币概率大吗？");
        vo.setReplyContent("比特币取代现在的货币意味着什么？意味着全世界的财富都是由比特币标的的，你握有的比特币越多那么你占有的世界财富也就越多，而人民币美元全不过是废纸而已。你会用全世界的财富去换废纸么？所以真正相信比特币会成为货币的根本不可能卖出只可能买入。");
        vo.setReplyName("小桥");
        vo.setAnser(true);
        vo.setPublishTime("3小时前");
        userVo.setName("败求");
        userVo.setHeadPic("head4");
        vo.setLaunchUser(userVo);
        vos.add(vo);
        vo = new QaVo();
        userVo = new UserVo();
        vo.setqContent("怎么学习区块链？");
        vo.setReplyContent("先学比特币， 再学区块链。 编程就用python够了。");
        vo.setReplyName("流水");
        vo.setPublishTime("6小时前");
        vo.setAnser(true);
        userVo.setName("孤独");
        userVo.setHeadPic("head5");
        vo.setLaunchUser(userVo);
        vos.add(vo);
        vo = new QaVo();
        userVo = new UserVo();
        vo.setqContent("学习区块链难吗？");
        vo.setReplyContent("");
        vo.setReplyName("人家");
        vo.setAnser(false);
        vo.setPublishTime("一天前");
        userVo.setName("懒羊羊");
        userVo.setHeadPic("head6");
        vo.setLaunchUser(userVo);
        vos.add(vo);
        return vos;
    }

    public static AnalystQAFragment newInstance() {
        AnalystQAFragment fragment = new AnalystQAFragment();
        return fragment;
    }
}


