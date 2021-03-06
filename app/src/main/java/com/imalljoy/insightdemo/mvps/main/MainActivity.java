package com.imalljoy.insightdemo.mvps.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.ActivityLifeCycleEvent;
import com.imalljoy.insightdemo.base.BaseActivity;

import com.imalljoy.insightdemo.common.LocalData;
import com.imalljoy.insightdemo.data.http.Api;
import com.imalljoy.insightdemo.data.http.HttpUtil;
import com.imalljoy.insightdemo.data.http.ProgressSubscriber;
import com.imalljoy.insightdemo.entity.ReportVo;
import com.imalljoy.insightdemo.entity.Subject;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.view.SimpleLoadDialog;
import com.imalljoy.insightdemo.widgets.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import rx.Observable;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private FragmentTabHost mTabHost;
    private SimpleLoadDialog mSimpleLoadDialog;
    private Class<?> mTabFragmentArray[] = {ResearchFragment.class, CoinsFragment.class, AnalystFragment.class, NewsFragment.class, MineFragment.class};
    private int mTabTextArray[] = {R.string.research, R.string.coins, R.string.analyst, R.string.news, R.string.mine};
    private int mTabTagArray[] = {R.string.research_tag, R.string.coins_tag, R.string.analyst_tag, R.string.news_tag, R.string.mine_tag};
    private int mTabImageArray[] = {R.drawable.tab_main_research_selector, R.drawable.tab_main_coins_selector, R.drawable.tab_main_analyts_selector, R.drawable.tab_main_news_selector, R.drawable.tab_main_mine_selector};
    long mLatestPressBackTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        ButterKnife.bind(this);
        mSimpleLoadDialog = new SimpleLoadDialog(MainActivity.this, null, true);
        initTabHost();
        if (savedInstanceState != null) {
            this.mCurrentTabIndex = savedInstanceState.getInt("currentIndex", TAB_INDEX_RESEARCH);
            this.mTabHost.setCurrentTab(mCurrentTabIndex);
        }
    }

    private void initTabHost() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.container);
        int count = mTabFragmentArray.length;
        for (int i = 0; i < count; i++) {
            View tabView = getTabItemView(i);
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(mTabTagArray[i])).setIndicator(tabView);
            mTabHost.addTab(tabSpec, mTabFragmentArray[i], null);
        }
        TabWidget tabWidget = mTabHost.getTabWidget();
        tabWidget.setDividerDrawable(null);
        for (int i = 0; i < tabWidget.getChildCount(); i++) {
            tabWidget.getChildAt(i).setOnClickListener(new OnHomeClickListener(i));
        }
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.e("onTabChanged", "tabId=" + tabId);
            }
        });
    }

    private View getTabItemView(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_view_main_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        imageView.setImageResource(mTabImageArray[index]);
        textView.setText(mTabTextArray[index]);
        return view;
    }

    private static final int TAB_INDEX_RESEARCH = 0;
    private static final int TAB_INDEX_COINS = 1;
    private static final int TAB_INDEX_ANALYTS = 2;
    private static final int TAB_INDEX_NEWS = 3;
    private static final int TAB_INDEX_MINE = 4;
    private int mCurrentTabIndex = TAB_INDEX_RESEARCH;

    class OnHomeClickListener implements View.OnClickListener {
        private int tabId = 0;

        OnHomeClickListener(int tabId) {
            this.tabId = tabId;
        }

        @Override
        public void onClick(View v) {
            Log.e("onHomeClick", "tagId=" + tabId);
            switch (tabId) {
                case TAB_INDEX_RESEARCH:
                    break;
                case TAB_INDEX_COINS:
                    break;
                case TAB_INDEX_ANALYTS:
                    break;
                case TAB_INDEX_NEWS:
                    break;
                case TAB_INDEX_MINE:
                    break;
            }
            mTabHost.setCurrentTab(tabId);
            mCurrentTabIndex = tabId;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void click(View view) {


        Observable ob = Api.getDefault().getTopMovie(0, 100);
        HttpUtil.getInstance().toSubscribe(ob, new ProgressSubscriber<List<Subject>>(this) {

            @Override
            protected void _onNext(List<Subject> subjects) {
                String str = "";
                for (int i = 0; i < subjects.size(); i++) {
                    str += "电影名:" + subjects.get(i).getTitle() + "\n";
                }


            }

            @Override
            protected void _onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

            }
        }, "cachekey", ActivityLifeCycleEvent.DESTROY, lifecycleSubject, false, false);

    }

    public void test() {
        List<ReportVo> vos = new ArrayList<>();
        ReportVo vo = new ReportVo();
        vo.setCost(10.0);
        vos.add(vo);
        Log.e(TAG, "1 cost=" + vos.get(0).getCost() + "");
        vo.setCost(20.0);
        Log.e(TAG, "2 cost=" + vos.get(0).getCost() + "");
        LocalData.getInstance().setmReportVo(vo);
        Log.e(TAG, "3 cost" + LocalData.getInstance().getmReportVo().getCost());
        vo.setCost(30.0);
        Log.e(TAG, "4 cost" + LocalData.getInstance().getmReportVo().getCost());
        LocalData.getInstance().getmReportVo().setCost(40.0);
        Log.e(TAG, "5 cost=" + vo.getCost());
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - mLatestPressBackTime < 1500) {
            super.onBackPressed();
        } else {
            mLatestPressBackTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
        }

    }
}


