package com.imalljoy.insights.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.imalljoy.insights.R;

/**
 * Created by lijilong on 03/31.
 */

public class TopBarSearch extends TopBar {
    public ImageView top_bar_back_image;
    public TextView cancel;
    public EditText edit;

    public TopBarSearch(Context context) {
        this(context, null);
    }

    public TopBarSearch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopBarSearch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @Override
    protected void init() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mRootView = layoutInflater.inflate(R.layout.top_bar_search, null);
        addView(this.mRootView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        this.status_bar = this.mRootView.findViewById(R.id.status_bar);
        this.top_bar_line = this.mRootView.findViewById(R.id.top_bar_line);
        this.top_bar_main_layout = (ViewGroup) this.mRootView.findViewById(R.id.top_bar_main_layout);

        this.top_bar_title_layout = (ViewGroup) this.mRootView.findViewById(R.id.top_bar_title_layout);
        this.top_bar_left_layout = (ViewGroup) this.mRootView.findViewById(R.id.top_bar_left_layout);
        this.top_bar_right_layout = (ViewGroup) this.mRootView.findViewById(R.id.top_bar_right_layout);

        this.top_bar_title_text = (TextView) this.mRootView.findViewById(R.id.top_bar_title_text);

        this.cancel = (TextView) this.mRootView.findViewById(R.id.top_bar_cancel);
        this.edit = (EditText) this.mRootView.findViewById(R.id.top_bar_edit);
        setClickable(true);
    }
}
