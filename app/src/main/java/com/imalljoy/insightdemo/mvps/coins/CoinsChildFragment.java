package com.imalljoy.insightdemo.mvps.coins;

import android.animation.Animator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseFragment;
import com.imalljoy.insightdemo.common.ConstantData;
import com.imalljoy.insightdemo.entity.CoinVo;
import com.imalljoy.insightdemo.utils.ScreenUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/22.
 */

public class CoinsChildFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "CoinsChildFragment";
    public final static int CURRENCY = 0;//币种
    public final static int ICO = 1;//ICO
    public final static int AIRDROP = 2;//空投
    public final static String CURRENCY_Str = "币市";
    public final static String ICO_Str = "ICO";
    public final static String AIRDROP_Str = "空投";
    @BindView(R.id.currency_sort_btn)
    LinearLayout currencySortBtn;
    @BindView(R.id.currency_price)
    TextView currencyPrice;
    @BindView(R.id.currency_price_layout)
    LinearLayout currencyPriceLayout;
    @BindView(R.id.currency_roni)
    TextView currencyRoni;
    @BindView(R.id.currency_roni_layout)
    LinearLayout currencyRoniLayout;
    @BindView(R.id.currency_bsri)
    TextView currencyBsri;
    @BindView(R.id.currency_bsri_layout)
    LinearLayout currencyBsriLayout;
    @BindView(R.id.currency_range)
    TextView currencyRange;
    @BindView(R.id.currency_range_layout)
    LinearLayout currencyRangeLayout;
    @BindView(R.id.currency_top_layout)
    LinearLayout currencyTopLayout;
    @BindView(R.id.ico_sort_btn)
    LinearLayout icoSortBtn;
    @BindView(R.id.ico_roni)
    TextView icoRoni;
    @BindView(R.id.ico_roni_layout)
    LinearLayout icoRoniLayout;
    @BindView(R.id.ico_level)
    TextView icoLevel;
    @BindView(R.id.ico_level_layout)
    LinearLayout icoLevelLayout;
    @BindView(R.id.ico_top_layout)
    LinearLayout icoTopLayout;
    @BindView(R.id.airdrop_top_layout)
    LinearLayout airdropTopLayout;
    @BindView(R.id.top_layout)
    RelativeLayout topLayout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.currency_sort1)
    TextView currencySort1;
    @BindView(R.id.currency_sort2)
    TextView currencySort2;
    @BindView(R.id.currency_sort3)
    TextView currencySort3;
    @BindView(R.id.currency_sort4)
    TextView currencySort4;
    @BindView(R.id.currency_sort_layout)
    LinearLayout currencySortLayout;
    @BindView(R.id.ico_sort1)
    TextView icoSort1;
    @BindView(R.id.ico_sort2)
    TextView icoSort2;
    @BindView(R.id.ico_sort3)
    TextView icoSort3;
    @BindView(R.id.ico_sort4)
    TextView icoSort4;
    @BindView(R.id.ico_sort5)
    TextView icoSort5;
    @BindView(R.id.ico_sort_layout)
    LinearLayout icoSortLayout;


    private Unbinder unbinder;
    private int mType;
    private int mFlag;//用于复用币市Fragment标记
    private View mRootView = null;
    CurrencyAdapter mCurrencyAdapter;
    ICOAdapter mICOAdapter;
    AirdropAdapter mAirdropAdapter;
    List<CoinVo> mListData;
    int currencyPriceStatus = 1;//0:无序 1：降序 2：升序
    int currencyRoniStatus =0;
    int currencyBsriStatus =0;
    int currencyRangeStatus = 0;
    int icoRoniStatus = 1;
    int icoBsriStatus = 0;
    int icoLevelStatus = 0;

    private int mSortIndex = 0; //0:全部 1：2:3:4：

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            if (mRootView.getParent() != null) {
                ViewGroup parent = (ViewGroup) mRootView.getParent();
                parent.removeView(mRootView);
            }

        } else {
            mRootView = inflater.inflate(R.layout.fra_coins_child, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        mType = getArguments().getInt("type", 0);
        mFlag = getArguments().getInt("flag", 0);
        Log.e(TAG, "type=" + mType);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divider = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.addItemDecoration(divider);
        if (mType == CURRENCY) {
            if (mFlag == 0) {
                currencyTopLayout.setVisibility(View.VISIBLE);
            } else {
                topLayout.setVisibility(View.GONE);
            }
            icoTopLayout.setVisibility(View.GONE);
            airdropTopLayout.setVisibility(View.GONE);
            currencySortBtn.setOnClickListener(this);
            currencySort1.setOnClickListener(this);
            currencySort2.setOnClickListener(this);
            currencySort3.setOnClickListener(this);
            currencySort4.setOnClickListener(this);
            currencyPriceLayout.setOnClickListener(this);
            currencyRoniLayout.setOnClickListener(this);
            currencyBsriLayout.setOnClickListener(this);
            currencyRangeLayout.setOnClickListener(this);
            resetAllSortIconDrawable(true);
            setSortIconDrawable(currencyPrice, 1);
            mCurrencyAdapter = new CurrencyAdapter(this.getContext(), ConstantData.getCurrencysBySort(ConstantData.currencyCoinVos, 1, true), mFlag);
            recyclerview.setAdapter(mCurrencyAdapter);
        } else if (mType == ICO) {
            currencyTopLayout.setVisibility(View.GONE);
            icoTopLayout.setVisibility(View.VISIBLE);
            airdropTopLayout.setVisibility(View.GONE);
            icoSortBtn.setOnClickListener(this);
            icoSort1.setOnClickListener(this);
            icoSort2.setOnClickListener(this);
            icoSort3.setOnClickListener(this);
            icoSort4.setOnClickListener(this);
            icoSort5.setOnClickListener(this);
            icoRoniLayout.setOnClickListener(this);
            icoLevelLayout.setOnClickListener(this);
            mICOAdapter = new ICOAdapter(this.getContext(), getData(), 0);
            recyclerview.setAdapter(mICOAdapter);
            resetAllSortIconDrawable(false);
            setSortIconDrawable(icoRoni, 1);
            mICOAdapter.setData(ConstantData.getIcoCoinsBySort(ConstantData.icoCoinVos, 0, true));
        } else if (mType == AIRDROP) {
            currencyTopLayout.setVisibility(View.GONE);
            icoTopLayout.setVisibility(View.GONE);
            airdropTopLayout.setVisibility(View.VISIBLE);
            mAirdropAdapter = new AirdropAdapter(this.getContext(), getData(), 0);
            recyclerview.setAdapter(mAirdropAdapter);
        }


        return mRootView;

    }

    public List<CoinVo> getData() {
        if (mType == CURRENCY) {
            mListData = ConstantData.currencyCoinVos;
        } else if (mType == ICO) {
            mListData = ConstantData.icoCoinVos;
        } else if (mType == AIRDROP) {
            mListData = ConstantData.airdropCoinVos;
        }
        return mListData;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ico_sort_btn:
                Log.e(TAG, "optional_sort_btn");
                setSelectSortView(false, mSortIndex);
                showOrHideSortLayout(icoSortLayout);
                break;
            case R.id.ico_sort1:
                setSelectSortView(false, 0);
                showOrHideSortLayout(icoSortLayout);
                mSortIndex = 0;
                mListData = ConstantData.icoCoinVos;
                resetAllSortIconDrawable(false);
                mICOAdapter.setData(mListData);
                break;
            case R.id.ico_sort2:
                setSelectSortView(false, 1);
                showOrHideSortLayout(icoSortLayout);
                mSortIndex = 1;
                mListData = ConstantData.getIcoCoinsByStatus(ConstantData.icoCoinVos, 1);
                mICOAdapter.setData(mListData);
                break;
            case R.id.ico_sort3:
                setSelectSortView(false, 2);
                showOrHideSortLayout(icoSortLayout);
                mSortIndex = 2;
                mListData = ConstantData.getIcoCoinsByStatus(ConstantData.icoCoinVos, 2);
                mICOAdapter.setData(mListData);
                break;
            case R.id.ico_sort4:
                setSelectSortView(false, 3);
                showOrHideSortLayout(icoSortLayout);
                mSortIndex = 3;
                mListData = ConstantData.getIcoCoinsByStatus(ConstantData.icoCoinVos, 3);
                mICOAdapter.setData(mListData);
                break;
            case R.id.ico_sort5:
                setSelectSortView(false, 4);
                showOrHideSortLayout(icoSortLayout);
                mSortIndex = 4;
                mListData = ConstantData.getIcoCoinsByStatus(ConstantData.icoCoinVos, 4);
                mICOAdapter.setData(mListData);
                break;
            case R.id.currency_price_layout:
                resetAllSortIconDrawable(true);
                currencyPriceStatus = getSortStatus(currencyPriceStatus);
                setSortIconDrawable(currencyPrice, currencyPriceStatus);
                mCurrencyAdapter.setData(ConstantData.getCurrencysBySort(ConstantData.currencyCoinVos, 1, currencyPriceStatus == 1 ? true : false));
                break;
            case R.id.currency_roni_layout:
                resetAllSortIconDrawable(true);
                currencyRoniStatus = getSortStatus(currencyRoniStatus);
                setSortIconDrawable(currencyRoni, currencyRoniStatus);
                mCurrencyAdapter.setData(ConstantData.getCurrencysBySort(ConstantData.currencyCoinVos,3, currencyRoniStatus ==1));
                break;
            case R.id.currency_bsri_layout:
                resetAllSortIconDrawable(true);
                currencyBsriStatus = getSortStatus(currencyBsriStatus);
                setSortIconDrawable(currencyBsri, currencyBsriStatus);
                mCurrencyAdapter.setData(ConstantData.getCurrencysBySort(ConstantData.currencyCoinVos,4, currencyBsriStatus ==1));
                break;
            case R.id.currency_range_layout:
                resetAllSortIconDrawable(true);
                currencyRangeStatus = getSortStatus(currencyRangeStatus);
                setSortIconDrawable(currencyRange, currencyRangeStatus);
                mCurrencyAdapter.setData(ConstantData.getCurrencysBySort(ConstantData.currencyCoinVos, 2, currencyRangeStatus == 1 ? true : false));
                break;
            case R.id.ico_roni_layout:
                resetAllSortIconDrawable(false);
                icoRoniStatus = getSortStatus(icoRoniStatus);
                setSortIconDrawable(icoRoni, icoRoniStatus);
                mICOAdapter.setData(ConstantData.getIcoCoinsBySort(mListData, 0, icoRoniStatus == 1 ? true : false));
                break;
            case R.id.ico_level_layout:
                resetAllSortIconDrawable(false);
                icoLevelStatus = getSortStatus(icoLevelStatus);
                setSortIconDrawable(icoLevel, icoLevelStatus);
                mICOAdapter.setData(ConstantData.getIcoCoinsBySort(mListData, 2, icoLevelStatus == 1 ? true : false));
                break;
        }
    }

    int sortLayoutStatus = 0;//0:隐藏状态/1:显示状态/2:正在动画状态

    public void showOrHideSortLayout(final LinearLayout sortLayout) {
        final int status = sortLayoutStatus;
        final int start = sortLayoutStatus == 0 ? 0 : ScreenUtils.dp2px(this.getContext(), 174);
        final int end = sortLayoutStatus == 0 ? ScreenUtils.dp2px(this.getContext(), 174) : 0;
        if (sortLayoutStatus == 2)
            return;
        Log.e(TAG, "1");
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            IntEvaluator ie = new IntEvaluator();

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animateValue = (float) animation.getAnimatedValue();
                float fraction = animateValue / 200;
                sortLayout.getLayoutParams().height = ie.evaluate(fraction, start, end);
                sortLayout.requestLayout();
            }
        });
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.setDuration(100);
        valueAnimator.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                sortLayoutStatus = 2;//在动画中
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                sortLayoutStatus = (status == 0 ? 1 : 0);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                sortLayoutStatus = (status == 0 ? 0 : 1);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();
    }

    public void setSelectSortView(boolean isCurrency, int index) {
        if (isCurrency) {
            setTextViewRightDrawable(currencySort1, index == 0 ? true : false);
            setTextViewRightDrawable(currencySort2, index == 1 ? true : false);
            setTextViewRightDrawable(currencySort3, index == 2 ? true : false);
            setTextViewRightDrawable(currencySort4, index == 3 ? true : false);
        } else {
            setTextViewRightDrawable(icoSort1, index == 0 ? true : false);
            setTextViewRightDrawable(icoSort2, index == 1 ? true : false);
            setTextViewRightDrawable(icoSort3, index == 2 ? true : false);
            setTextViewRightDrawable(icoSort4, index == 3 ? true : false);
            setTextViewRightDrawable(icoSort5, index == 4 ? true : false);
        }
    }

    /**
     * 设置TextView的右边图片显示与否
     *
     * @param textView
     * @param hasDrawable
     */
    public void setTextViewRightDrawable(TextView textView, boolean hasDrawable) {
        if (hasDrawable) {
            Drawable drawable = ContextCompat.getDrawable(this.getContext(), R.mipmap.icon_sort_dui);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
        } else {
            textView.setCompoundDrawables(null, null, null, null);
        }

    }

    public int getSortStatus(int status) {
        if (status == 0) {
            return 1;
        } else if (status == 1) {
            return 2;
        } else if (status == 2) {
            return 1;
        }
        return 0;
    }

    public void resetAllSortIconDrawable(boolean isCurrency) {
        if (isCurrency) {
            setSortIconDrawable(currencyPrice, 0);
            setSortIconDrawable(currencyRoni, 0);
            setSortIconDrawable(currencyBsri, 0);
            setSortIconDrawable(currencyRange, 0);
        } else {
            setSortIconDrawable(icoRoni, 0);
            setSortIconDrawable(icoLevel, 0);
        }
    }

    public void setSortIconDrawable(TextView textView, int status) {
        Drawable drawable = null;
        if (status == 0) {
            drawable = ContextCompat.getDrawable(this.getContext(), R.mipmap.icon_sort_no);
        } else if (status == 1) {
            drawable = ContextCompat.getDrawable(this.getContext(), R.mipmap.icon_sort_down);
        } else if (status == 2) {
            drawable = ContextCompat.getDrawable(this.getContext(), R.mipmap.icon_sort_up);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, null, drawable, null);
    }

    public static CoinsChildFragment newInstance(int type, int flag) {
        CoinsChildFragment fragment = new CoinsChildFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        bundle.putInt("flag", flag);
        fragment.setArguments(bundle);
        return fragment;

    }
}
