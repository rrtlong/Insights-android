package com.imalljoy.insights.mvps.coins;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;
import com.imalljoy.insights.entity.CoinVo;

import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/22.
 */

public class CoinsChildFragment extends BaseFragment {
    public final static int OPTIONAL = 0;//自选
    public final static int CURRENCY = 1;//币种
    public final static int ICO = 2;//ICO
    private int mType;
    public final static String OPTIONAL_Str = "自选";
    public final static String CURRENCY_Str = "币市";
    public final static String ICO_Str = "ICO";
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;
    @BindView(R.id.optional_top_layout)
    LinearLayout optionalTopLayout;
    @BindView(R.id.currency_top_layout)
    LinearLayout currencyTopLayout;
    @BindView(R.id.ICO_top_layout)
    LinearLayout ICOTopLayout;
    @BindView(R.id.optional_add)
    ImageView optionalAdd;
    @BindView(R.id.optional_add_layout)
    LinearLayout optionalAddLayout;
    private View mRootView = null;
    OptionalAdapter mOptionalAdapter;
    CurrencyAdapter mCurrencyAdapter;
    ICOAdapter mICOAdapter;

    private static final String TAG = "CoinsChildFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            if (mRootView.getParent() != null) {
                ViewGroup parent = (ViewGroup) mRootView.getParent();
                parent.removeView(mRootView);
            }

        }else {
            mRootView = inflater.inflate(R.layout.fra_coins_child, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        mType = getArguments().getInt("type", 0);
        Log.e(TAG,"type=" + mType);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divider = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.addItemDecoration(divider);
        if (mType == 0) {
            optionalTopLayout.setVisibility(View.VISIBLE);
            optionalAddLayout.setVisibility(View.VISIBLE);
            currencyTopLayout.setVisibility(View.GONE);
            ICOTopLayout.setVisibility(View.GONE);
            mOptionalAdapter = new OptionalAdapter(this.getContext(), getData(), 0);
            recyclerview.setAdapter(mOptionalAdapter);
        } else if (mType == 1) {
            optionalTopLayout.setVisibility(View.GONE);
            optionalAddLayout.setVisibility(View.GONE);
            currencyTopLayout.setVisibility(View.VISIBLE);
            ICOTopLayout.setVisibility(View.GONE);
            mCurrencyAdapter = new CurrencyAdapter(this.getContext(), getData(), 1);
            recyclerview.setAdapter(mCurrencyAdapter);
        } else if (mType == 2) {
            optionalTopLayout.setVisibility(View.GONE);
            optionalAddLayout.setVisibility(View.GONE);
            currencyTopLayout.setVisibility(View.GONE);
            ICOTopLayout.setVisibility(View.VISIBLE);
            mICOAdapter = new ICOAdapter(this.getContext(), getData(), 2);
            recyclerview.setAdapter(mICOAdapter);
        }


        return mRootView;

    }

    public List<CoinVo> getData() {
        List<CoinVo> vos = new ArrayList<>();
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        vos.add(new CoinVo());
        return vos;
    }

    public static CoinsChildFragment newInstance(int type) {
        CoinsChildFragment fragment = new CoinsChildFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
