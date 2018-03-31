package com.imalljoy.insights.mvps.coins.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/31.
 */

public class CoinDetailIcoInfoFragment extends BaseFragment{
    public static String TITLE = "ICO信息";
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
            mRootView = inflater.inflate(R.layout.fra_coins_detail_icoinfo, container, false);
        }
        return mRootView;
    }


    public static CoinDetailIcoInfoFragment newInstance(){
      CoinDetailIcoInfoFragment fragment = new CoinDetailIcoInfoFragment();
        return fragment;
    }
}
