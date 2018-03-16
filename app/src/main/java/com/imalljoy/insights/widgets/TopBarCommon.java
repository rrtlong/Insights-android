package com.imalljoy.insights.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.imalljoy.insights.R;

/**
 * Created by lijilong on 03/09.
 */

public class TopBarCommon extends TopBar {
    public ImageView top_bar_back_image;
    public ImageView top_bar_right_image;
    public TextView top_bar_right_text;

    public TopBarCommon(Context context) {
        this(context, null);
    }

    public TopBarCommon(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopBarCommon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @Override
    protected void init() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mRootView = layoutInflater.inflate(R.layout.top_bar_common, null);
        addView(this.mRootView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.top_bar_main_layout = (ViewGroup) mRootView.findViewById(R.id.top_bar_main_layout);
        this.top_bar_left_layout = (ViewGroup) mRootView.findViewById(R.id.top_bar_left_layout);
        this.top_bar_back_image = (ImageView) mRootView.findViewById(R.id.top_bar_back_image);
        this.top_bar_title_text = (TextView) mRootView.findViewById(R.id.top_bar_title_text);
        this.top_bar_right_layout = (ViewGroup) mRootView.findViewById(R.id.top_bar_right_layout);
        this.top_bar_right_image = (ImageView) mRootView.findViewById(R.id.top_bar_right_image);
        this.top_bar_right_text = (TextView) mRootView.findViewById(R.id.top_bar_right_text);

    }

    public void setRightView(String rightTxt, int imgId) {
        if (rightTxt != null) {
            this.top_bar_right_text.setText(rightTxt);
            this.top_bar_right_text.setVisibility(VISIBLE);
            this.top_bar_right_image.setVisibility(GONE);
        } else if (imgId != 0) {
            this.top_bar_right_text.setVisibility(GONE);
            this.top_bar_right_image.setImageResource(imgId);
            this.top_bar_right_image.setVisibility(VISIBLE);
        }else if(imgId == 0){
            this.top_bar_right_text.setVisibility(INVISIBLE);
            this.top_bar_right_image.setVisibility(INVISIBLE);
        }
    }
}
