package com.imalljoy.insights.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.imalljoy.insights.R;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.mvps.coins.CurrencyAdapter;
import com.imalljoy.insights.mvps.research.SelectCoinAdapter;
import com.imalljoy.insights.utils.ScreenUtils;

import java.util.List;

/**
 * Created by lijilong on 03/16.
 */

public class CustomPopupWindow extends PopupWindow {

    public CustomPopupWindow() {
    }

    public void createAddPopup(Context context, View.OnClickListener onClickListener) {
        View view = LayoutInflater.from(context).inflate(R.layout.popup_add, null);
        LinearLayout requestLayout = (LinearLayout) view.findViewById(R.id.request_layout);
        LinearLayout questionnaireLayout = (LinearLayout) view.findViewById(R.id.questionnaire_layout);
        View topTriangle = view.findViewById(R.id.top_triangle);
        view.setOnClickListener(onClickListener);
        requestLayout.setOnClickListener(onClickListener);
        questionnaireLayout.setOnClickListener(onClickListener);
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
//        this.setWidth(ScreenUtils.getScreenWidth(mContext));
//        this.setHeight(ScreenUtils.getScreenHeight(mContext) + ScreenUtils.getStatusHeight(mContext));
//        this.setBackgroundDrawable(new BitmapDrawable());
        //设置状态栏也包括
        this.setClippingEnabled(false);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.addPopupAnim);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) topTriangle.getLayoutParams();
        params.topMargin = ScreenUtils.dp2px(context, 50) + ScreenUtils.getStatusHeight(context);
        topTriangle.setLayoutParams(params);
    }

    public void createCoinMorePopup(Context context, View.OnClickListener onClickListener) {
        View view = LayoutInflater.from(context).inflate(R.layout.popup_coin_more, null);
        LinearLayout optionalLayout = (LinearLayout) view.findViewById(R.id.optional_layout);
        LinearLayout voteLayout = (LinearLayout) view.findViewById(R.id.vote_layout);
        View topTriangle = view.findViewById(R.id.top_triangle);
        view.setOnClickListener(onClickListener);
        optionalLayout.setOnClickListener(onClickListener);
        voteLayout.setOnClickListener(onClickListener);
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置状态栏也包括
        this.setClippingEnabled(false);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.addPopupAnim);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) topTriangle.getLayoutParams();
        params.topMargin = ScreenUtils.dp2px(context, 50) + ScreenUtils.getStatusHeight(context);
        topTriangle.setLayoutParams(params);
    }

    public void createCoinSelectedPopup(Context context, List<CoinVo> list, final SelectCoinAdapter.OnCustomClickListener selectedListener, View.OnClickListener onClickListener) {
        View view = LayoutInflater.from(context).inflate(R.layout.popup_recyclerview, null);
        view.setOnClickListener(onClickListener);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divider = new DividerItemDecoration(context, LinearLayoutManager.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(context, R.drawable.recyclerview_divide_type1));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(divider);
        SelectCoinAdapter adapter = new SelectCoinAdapter(context, list, 0);
        adapter.setOnCustomClickListener(selectedListener);
        recyclerView.setAdapter(adapter);
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置状态栏也包括
        this.setClippingEnabled(false);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.bottomIntoPopupAnim);
    }
}
