package com.imalljoy.insights.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.imalljoy.insights.R;
import com.imalljoy.insights.utils.ScreenUtils;

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
}
