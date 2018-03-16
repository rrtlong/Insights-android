package com.imalljoy.insights.mvps.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;
import com.imalljoy.insights.widgets.TopBarCommon;

/**
 * Created by lijilong on 03/09.
 */

public class NewsFragment extends BaseFragment {
    private View mRootView;
    private TopBarCommon mTopBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mRootView != null){
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if(parent != null){
                parent.removeView(mRootView);
            }
        }else{
            mRootView = inflater.inflate(R.layout.fra_news, container, false);
            mTopBar = (TopBarCommon) mRootView.findViewById(R.id.top_bar);
            mTopBar.setTitle("新闻");
            mTopBar.setRightView(null, 0);
        }
        return mRootView;
    }
}
