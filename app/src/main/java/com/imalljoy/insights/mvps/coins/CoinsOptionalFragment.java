package com.imalljoy.insights.mvps.coins;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/29.
 */

public class CoinsOptionalFragment extends BaseFragment implements View.OnClickListener{
    public static final String OPTIONAL_STR = "自选";
    @BindView(R.id.currency_sort_btn)
    LinearLayout currencySortBtn;
    @BindView(R.id.currency_top_layout)
    LinearLayout currencyTopLayout;
    @BindView(R.id.currency_recyclerview)
    RecyclerView currencyRecyclerview;
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
    @BindView(R.id.currency_layout)
    RelativeLayout currencyLayout;
    @BindView(R.id.ico_sort_btn)
    LinearLayout icoSortBtn;
    @BindView(R.id.ico_top_layout)
    LinearLayout icoTopLayout;
    @BindView(R.id.ico_recyclerview)
    RecyclerView icoRecyclerview;
    @BindView(R.id.ico_sort1)
    TextView icoSort1;
    @BindView(R.id.ico_sort2)
    TextView icoSort2;
    @BindView(R.id.ico_sort3)
    TextView icoSort3;
    @BindView(R.id.ico_sort4)
    TextView icoSort4;
    @BindView(R.id.ico_sort_layout)
    LinearLayout icoSortLayout;
    @BindView(R.id.ico_layout)
    RelativeLayout icoLayout;
    @BindView(R.id.airdrop_top_layout)
    LinearLayout airdropTopLayout;
    @BindView(R.id.airdrop_recyclerview)
    RecyclerView airdropRecyclerview;
    @BindView(R.id.airdrop_layout)
    LinearLayout airdropLayout;
    @BindView(R.id.optional_add)
    ImageView optionalAdd;
    @BindView(R.id.optional_add_layout)
    LinearLayout optionalAddLayout;
    Unbinder unbinder;
    private View mRootView;
    private CurrencyAdapter mCurrencyAdapter;
    private ICOAdapter mICOAdapter;
    private AirdropAdapter mAirdropAdapter;
    private List<CoinVo> mCurrencyData;
    private List<CoinVo> mICOData;
    private List<CoinVo> mAirdropData;
    private int mCurrencySortIndex = 0;
    private int mIcoSortIndex = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView != null) {
            if (mRootView.getParent() != null) {
                ViewGroup parent = (ViewGroup) mRootView.getParent();
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fra_coins_optional, container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        initView();
        return mRootView;
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divider = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.recyclerview_divide_type1));
        currencyRecyclerview.setLayoutManager(linearLayoutManager);
        currencyRecyclerview.addItemDecoration(divider);
        icoRecyclerview.setLayoutManager(new LinearLayoutManager(this.getContext()));
        icoRecyclerview.addItemDecoration(divider);
        airdropRecyclerview.setLayoutManager(new LinearLayoutManager(this.getContext()));
        airdropRecyclerview.addItemDecoration(divider);
        initData();
        currencyLayout.setVisibility(View.GONE);
        icoLayout.setVisibility(View.GONE);
        airdropLayout.setVisibility(View.GONE);
        if(mCurrencyData != null && mCurrencyData.size()>0){
            currencyLayout.setVisibility(View.VISIBLE);
            mCurrencyAdapter = new CurrencyAdapter(this.getContext(),mCurrencyData,0);
            currencyRecyclerview.setAdapter(mCurrencyAdapter);
            currencySortBtn.setOnClickListener(this);
            currencySort1.setOnClickListener(this);
            currencySort2.setOnClickListener(this);
            currencySort3.setOnClickListener(this);
            currencySort4.setOnClickListener(this);
        }
        if(mICOData != null && mICOData.size()>0){
            icoLayout.setVisibility(View.VISIBLE);
            mICOAdapter = new ICOAdapter(this.getContext(),mICOData,1);
            icoRecyclerview.setAdapter(mICOAdapter);
            icoSortBtn.setOnClickListener(this);
            icoSort1.setOnClickListener(this);
            icoSort2.setOnClickListener(this);
            icoSort3.setOnClickListener(this);
            icoSort4.setOnClickListener(this);
        }
        if(mAirdropData != null && mAirdropData.size()>0){
            airdropLayout.setVisibility(View.VISIBLE);
            mAirdropAdapter = new AirdropAdapter(this.getContext(), mAirdropData, 2);
            airdropRecyclerview.setAdapter(mAirdropAdapter);
        }
        optionalAdd.setOnClickListener(this);
    }

    private void initData() {
        mCurrencyData = ConstantData.optionalCoinVos1;
        mICOData = ConstantData.optionalCoinVos2;
        mAirdropData =ConstantData.optionalCoinVos3;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public static CoinsOptionalFragment newInstance() {
        CoinsOptionalFragment fragment = new CoinsOptionalFragment();
        return fragment;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.currency_sort_btn:
                setSelectSortView(true,mCurrencySortIndex);
                showOrHideSortLayout(currencySortLayout);
                break;
            case R.id.ico_sort_btn:
                setSelectSortView(false,mIcoSortIndex);
                showOrHideSortLayout(icoSortLayout);
                break;
            case R.id.currency_sort1:
                setSelectSortView(true,0);
                showOrHideSortLayout(currencySortLayout);
                mCurrencySortIndex = 0;
                break;
            case R.id.currency_sort2:
                setSelectSortView(true,1);
                showOrHideSortLayout(currencySortLayout);
                mCurrencySortIndex = 1;
                break;
            case R.id.currency_sort3:
                setSelectSortView(true,2);
                showOrHideSortLayout(currencySortLayout);
                mCurrencySortIndex = 2;
                break;
            case R.id.currency_sort4:
                setSelectSortView(true,3);
                showOrHideSortLayout(currencySortLayout);
                mCurrencySortIndex = 3;
                break;
            case R.id.ico_sort1:
                setSelectSortView(false,0);
                showOrHideSortLayout(icoSortLayout);
                mIcoSortIndex = 0;
                break;
            case R.id.ico_sort2:
                setSelectSortView(false,1);
                showOrHideSortLayout(icoSortLayout);
                mIcoSortIndex = 1;
                break;
            case R.id.ico_sort3:
                setSelectSortView(false,2);
                showOrHideSortLayout(icoSortLayout);
                mIcoSortIndex = 2;
                break;
            case R.id.ico_sort4:
                setSelectSortView(false,3);
                showOrHideSortLayout(icoSortLayout);
                mIcoSortIndex = 3;
                break;
            case R.id.optional_add:
                SearchCoinsActivity.toActivity(this.getContext());
                break;
        }
    }

    int sortLayoutStatus = 0;//0:隐藏状态/1:显示状态/2:正在动画状态

    public void showOrHideSortLayout(final LinearLayout sortLayout) {
        final int status = sortLayoutStatus;
        final int start = sortLayoutStatus == 0 ? 0 : ScreenUtils.dp2px(this.getContext(), 139);
        final int end = sortLayoutStatus == 0 ? ScreenUtils.dp2px(this.getContext(), 139) : 0;
        if (sortLayoutStatus == 2)
            return;
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

    public void setSelectSortView(boolean isCurrency,int index) {
        if(isCurrency){
            setTextViewRightDrawable(currencySort1, index == 0 ? true : false);
            setTextViewRightDrawable(currencySort2, index == 1 ? true : false);
            setTextViewRightDrawable(currencySort3, index == 2 ? true : false);
            setTextViewRightDrawable(currencySort4, index == 3 ? true : false);
        }else{
            setTextViewRightDrawable(icoSort1, index == 0 ? true : false);
            setTextViewRightDrawable(icoSort2, index == 1 ? true : false);
            setTextViewRightDrawable(icoSort3, index == 2 ? true : false);
            setTextViewRightDrawable(icoSort4, index == 3 ? true : false);
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
}
