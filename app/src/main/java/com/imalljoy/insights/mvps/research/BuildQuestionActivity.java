package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.utils.ScreenUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/21.
 */

public class BuildQuestionActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.title1)
    EditText title1;
    @BindView(R.id.add_title_1)
    ImageView addTitle1;
    @BindView(R.id.subtract_title_1)
    ImageView subtractTitle1;
    @BindView(R.id.title1_option1_choose_multi)
    ImageView title1Option1ChooseMulti;
    @BindView(R.id.title1_option1_single)
    TextView title1Option1Single;
    @BindView(R.id.add_title1_option1)
    ImageView addTitle1Option1;
    @BindView(R.id.subtract_title1_option1)
    ImageView subtractTitle1Option1;
    @BindView(R.id.title1_option1_layout)
    LinearLayout title1Option1Layout;
    @BindView(R.id.title1_option2_choose_multi)
    ImageView title1Option2ChooseMulti;
    @BindView(R.id.title1_option2_single)
    TextView title1Option2Single;
    @BindView(R.id.add_title1_option2)
    ImageView addTitle1Option2;
    @BindView(R.id.subtract_title1_option2)
    ImageView subtractTitle1Option2;
    @BindView(R.id.title1_option2_layout)
    LinearLayout title1Option2Layout;
    @BindView(R.id.title1_option3_choose_multi)
    ImageView title1Option3ChooseMulti;
    @BindView(R.id.title1_option3_single)
    TextView title1Option3Single;
    @BindView(R.id.add_title1_option3)
    ImageView addTitle1Option3;
    @BindView(R.id.subtract_title1_option3)
    ImageView subtractTitle1Option3;
    @BindView(R.id.title1_option3_layout)
    LinearLayout title1Option3Layout;
    @BindView(R.id.title2)
    EditText title2;
    @BindView(R.id.add_title_2)
    ImageView addTitle2;
    @BindView(R.id.subtract_title_2)
    ImageView subtractTitle2;
    @BindView(R.id.title2_option1_choose_multi)
    ImageView title2Option1ChooseMulti;
    @BindView(R.id.title2_option1_single)
    TextView title2Option1Single;
    @BindView(R.id.add_title2_option1)
    ImageView addTitle2Option1;
    @BindView(R.id.subtract_title2_option1)
    ImageView subtractTitle2Option1;
    @BindView(R.id.title2_option1_layout)
    LinearLayout title2Option1Layout;
    @BindView(R.id.title2_option2_choose_multi)
    ImageView title2Option2ChooseMulti;
    @BindView(R.id.title2_option2_single)
    TextView title2Option2Single;
    @BindView(R.id.add_title2_option2)
    ImageView addTitle2Option2;
    @BindView(R.id.subtract_title2_option2)
    ImageView subtractTitle2Option2;
    @BindView(R.id.title2_option2_layout)
    LinearLayout title2Option2Layout;
    @BindView(R.id.title2_option3_choose_multi)
    ImageView title2Option3ChooseMulti;
    @BindView(R.id.title2_option3_single)
    TextView title2Option3Single;
    @BindView(R.id.add_title2_option3)
    ImageView addTitle2Option3;
    @BindView(R.id.subtract_title2_option3)
    ImageView subtractTitle2Option3;
    @BindView(R.id.title2_option3_layout)
    LinearLayout title2Option3Layout;
    @BindView(R.id.title3)
    EditText title3;
    @BindView(R.id.add_title_3)
    ImageView addTitle3;
    @BindView(R.id.subtract_title_3)
    ImageView subtractTitle3;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.title3_option1_choose_multi)
    ImageView title3Option1ChooseMulti;
    @BindView(R.id.title3_option1_single)
    TextView title3Option1Single;
    @BindView(R.id.add_title3_option1)
    ImageView addTitle3Option1;
    @BindView(R.id.subtract_title3_option1)
    ImageView subtractTitle3Option1;
    @BindView(R.id.title3_option1_layout)
    LinearLayout title3Option1Layout;
    @BindView(R.id.title3_option2_choose_multi)
    ImageView title3Option2ChooseMulti;
    @BindView(R.id.title3_option2_single)
    TextView title3Option2Single;
    @BindView(R.id.add_title3_option2)
    ImageView addTitle3Option2;
    @BindView(R.id.subtract_title3_option2)
    ImageView subtractTitle3Option2;
    @BindView(R.id.title3_option2_layout)
    LinearLayout title3Option2Layout;
    @BindView(R.id.title3_option3_choose_multi)
    ImageView title3Option3ChooseMulti;
    @BindView(R.id.title3_option3_single)
    TextView title3Option3Single;
    @BindView(R.id.add_title3_option3)
    ImageView addTitle3Option3;
    @BindView(R.id.subtract_title3_option3)
    ImageView subtractTitle3Option3;
    @BindView(R.id.title3_option3_layout)
    LinearLayout title3Option3Layout;
    @BindView(R.id.feedback)
    EditText feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_build_question);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("问卷");
        topBar.setRightView("保存", 0);
        topBar.top_bar_right_layout.setOnClickListener(this);
        feedback.setPadding(ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                hideSoftInputMethod();
                finish();
                break;
            case R.id.top_bar_right_layout:
                hideSoftInputMethod();
                finish();
                break;
        }
    }

    public static void goActivity(Context context) {
        Intent it = new Intent(context, BuildQuestionActivity.class);
        context.startActivity(it);

    }

    public void hideSoftInputMethod() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //获取键盘显示状态
        boolean isOpen = imm.isActive();
        if (isOpen) {
            imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        // 如果软键盘已经显示，则隐藏，反之则显示
        //imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        // 隐藏软键盘
        //imm.hideSoftInputFromWindow(view, InputMethodManager.HIDE_NOT_ALWAYS);
        // 强制显示软键盘
        //imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
        // 强制隐藏软键盘
        //imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
