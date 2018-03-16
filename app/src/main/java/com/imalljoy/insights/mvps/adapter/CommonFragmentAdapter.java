package com.imalljoy.insights.mvps.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by lijilong on 03/09.
 */

public class CommonFragmentAdapter extends FragmentStatePagerAdapter {
    public static final String TAG = CommonFragmentAdapter.class.getSimpleName();
    List<Fragment> mFragmentList;
    List<String> mTitleList;

    public CommonFragmentAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList, List<String> titleList) {
        super(fragmentManager);
        mFragmentList = fragmentList;
        mTitleList = titleList;
    }

    public void setData(List<Fragment> fragmentList, List<String> titleList) {
        mFragmentList = fragmentList;
        mTitleList = titleList;
        this.notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {

    }
}