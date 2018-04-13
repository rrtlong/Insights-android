package com.imalljoy.insightdemo.mvps.research;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseActivity;
import com.imalljoy.insightdemo.entity.QuestionVo;
import com.imalljoy.insightdemo.entity.QuestionnaireVo;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.utils.ScreenUtils;
import com.imalljoy.insightdemo.widgets.TopBarCommon;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/21.
 */

public class BuildQuestionActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "BuildQuestionActivity";
    public static int ANSWER_QUESTION = 10;
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    private int mStatus; //0:表示编辑问卷入口；其他为查看问卷或则答卷
    private int mFlag; //0:表示答题，优先级高于status，在问卷页面有查看问题，或则答题，此时问卷status都为1，不足以区分是答题还是查看问题
    private LinearLayout mContainer;
    private QuestionnaireVo mVo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStatus = getIntent().getIntExtra("status", 0);
        mFlag = getIntent().getIntExtra("flag", -1);
        mVo = (QuestionnaireVo) getIntent().getSerializableExtra("questionnaireVo");
        setContentView(mStatus == 0 ? R.layout.act_build_question : R.layout.act_build_question_disable);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("问卷");
        if (mStatus == 0) {
            //用户编辑问题页面
            topBar.setRightView("保存", 0);
            topBar.top_bar_right_layout.setOnClickListener(this);
            ((EditText) findViewById(R.id.feedback)).setPadding(ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10));
        } else if (mFlag == -1) {
            //仅仅用于查看问卷列表
            topBar.setRightView(null, 0);
            EditText editText = (EditText) findViewById(R.id.feedback);
            editText.setPadding(ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10));
            editText.setEnabled(false);
        } else if (mFlag == 0) {
            //用于答题页面
            topBar.setRightView("提交", 0);
            topBar.top_bar_right_layout.setOnClickListener(this);
            ((EditText) findViewById(R.id.feedback)).setPadding(ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10));
        }
        initDataToView();


    }

    private void initDataToView() {
        if (mStatus != 0) {
            mContainer = (LinearLayout) findViewById(R.id.container_layout);
            if (mVo != null && mVo.getQuestions() != null && mVo.getQuestions().size()>0) {
                View titleLayout,optionLayout,splitLineView;
                TextView title,option;
                for (QuestionVo questionVo : mVo.getQuestions()) {
                    titleLayout = LayoutInflater.from(this).inflate(R.layout.layout_question_title,mContainer, false);
                    title = (TextView) titleLayout.findViewById(R.id.title);
                    title.setText(questionVo.getName());
                    mContainer.addView(titleLayout);
                    for (String str : questionVo.getOptions()) {
                        optionLayout = LayoutInflater.from(this).inflate(R.layout.layout_question_option, mContainer, false);
                        option = (TextView) optionLayout.findViewById(R.id.option);
                        option.setText(str);
                        mContainer.addView(optionLayout);
                    }
                    splitLineView = LayoutInflater.from(this).inflate(R.layout.layout_splitline_5_f1f1f1,mContainer, false);
                    mContainer.addView(splitLineView);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                if (mStatus == 0) {
                    hideSoftInputMethod();
                }
                finish();
                break;
            case R.id.top_bar_right_layout:
                if (mStatus == 0) {
                    hideSoftInputMethod();
                }
                if (mFlag == 0) {
                    finishForAnswer();
                } else {
                    finish();
                }
                break;
        }
    }

    public void finishForAnswer() {
        Log.e(TAG, "finishForAnswer");
        Intent it = getIntent();
        setResult(ANSWER_QUESTION, it);
        finish();
    }

    public static void toActivity(Context context, int status, QuestionnaireVo vo) {
        Intent it = new Intent(context, BuildQuestionActivity.class);
        it.putExtra("status", status);
        Bundle bundle = new Bundle();
        bundle.putSerializable("questionnaireVo", vo);
        it.putExtras(bundle);
        context.startActivity(it);
    }

    public static void toActivityForResult(Activity activity, int status, int flag, int requestCode, QuestionnaireVo vo) {
        Intent it = new Intent(activity, BuildQuestionActivity.class);
        it.putExtra("status", status);
        it.putExtra("flag", flag);
        Bundle bundle = new Bundle();
        bundle.putSerializable("questionnaireVo", vo);
        it.putExtras(bundle);
        activity.startActivityForResult(it, requestCode);
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
