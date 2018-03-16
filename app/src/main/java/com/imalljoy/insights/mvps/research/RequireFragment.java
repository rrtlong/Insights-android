package com.imalljoy.insights.mvps.research;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;

/**
 * Created by lijilong on 03/09.
 */

public class RequireFragment extends BaseFragment {
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fra_require, container, false);
        }
        return mRootView;
    }

    public static RequireFragment newInstance(){
        RequireFragment fragment = new RequireFragment();
        return fragment;
    }
}
