package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.bus.JumpFragment;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.entity.PersonasVo;
import com.imalljoy.insights.entity.QuestionnaireVo;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.utils.DateUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import org.greenrobot.eventbus.EventBus;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/20.
 */

public class BuildQuestionnaireActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.name_layout)
    LinearLayout nameLayout;
    @BindView(R.id.total_number)
    EditText totalNumber;
    @BindView(R.id.total_number_layout)
    LinearLayout totalNumberLayout;
    @BindView(R.id.reward)
    EditText reward;
    @BindView(R.id.reward_layout)
    LinearLayout rewardLayout;
    @BindView(R.id.start_time)
    TextView startTime;
    @BindView(R.id.start_time_layout)
    LinearLayout startTimeLayout;
    @BindView(R.id.end_time)
    TextView endTime;
    @BindView(R.id.end_time_layout)
    LinearLayout endTimeLayout;
    @BindView(R.id.questions)
    TextView questions;
    @BindView(R.id.questions_layout)
    LinearLayout questionsLayout;
    @BindView(R.id.gender)
    TextView gender;
    @BindView(R.id.gender_layout)
    LinearLayout genderLayout;
    @BindView(R.id.age)
    EditText age;
    @BindView(R.id.age_layout)
    LinearLayout ageLayout;
    @BindView(R.id.location)
    EditText location;
    @BindView(R.id.location_layout)
    LinearLayout locationLayout;
    @BindView(R.id.root_view)
    LinearLayout rootView;
    @BindView(R.id.btn_process)
    Button btnProcess;
    @BindView(R.id.analyst_img)
    ImageView analystImg;
    @BindView(R.id.analyst)
    TextView analyst;
    @BindView(R.id.analyst_layout)
    LinearLayout analystLayout;
    @BindView(R.id.finish_number)
    TextView finishNumber;
    @BindView(R.id.finish_number_layout)
    LinearLayout finishNumberLayout;
    @BindView(R.id.select_personas)
    TextView selectPersonas;
    private int mStatus;  //0:新建问卷/1:参与问卷/2:已完成问卷
    private QuestionnaireVo mVo;
    private static final String TAG = "BuildQuestionnaireActiv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate()");
        setContentView(R.layout.act_build_questionnaire);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mStatus = getIntent().getIntExtra("status", 0);
        mVo = (QuestionnaireVo) getIntent().getSerializableExtra("questionnaireVo");
        topBar.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        updateStatus(mStatus);


    }

    public void updateStatus(int status) {
        mStatus = status;
        Log.e(TAG, "mstatus=" + mStatus);
        if (mStatus == 0) {
            //新建
            mVo = new QuestionnaireVo();
            mVo.setId(System.currentTimeMillis() / 1000);
            mVo.setUserVo(ConstantData.mUserVo);
            mVo.setStatus(0);
            topBar.top_bar_title_text.setText("发起问卷");
            topBar.setRightView("发布", 0);
            topBar.top_bar_right_layout.setOnClickListener(this);
            analystLayout.setVisibility(View.GONE);
            finishNumberLayout.setVisibility(View.GONE);
            btnProcess.setVisibility(View.GONE);
            startTimeLayout.setOnClickListener(this);
            endTimeLayout.setOnClickListener(this);
            questionsLayout.setOnClickListener(this);

        } else if (mStatus == 1) {
            //参与问卷
            topBar.top_bar_title_text.setText("问卷");
            topBar.setRightView(null, 0);
            btnProcess.setVisibility(View.VISIBLE);
            btnProcess.setText("参与调查");
            btnProcess.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
            btnProcess.setOnClickListener(this);
            questionsLayout.setOnClickListener(this);
            selectPersonas.setVisibility(View.GONE);
            genderLayout.setVisibility(View.GONE);
            ageLayout.setVisibility(View.GONE);
            locationLayout.setVisibility(View.GONE);
            analystLayout.setVisibility(View.VISIBLE);
            finishNumberLayout.setVisibility(View.VISIBLE);
            btnProcess.setVisibility(View.VISIBLE);
            topBar.top_bar_right_layout.setOnClickListener(null);
            startTimeLayout.setOnClickListener(null);
            endTimeLayout.setOnClickListener(null);

        } else if (mStatus == 2) {
            //已完成
            topBar.top_bar_title_text.setText("问卷");
            topBar.setRightView(null, 0);
            btnProcess.setVisibility(View.VISIBLE);
            btnProcess.setText("已完成");
            btnProcess.setBackgroundColor(ContextCompat.getColor(this, R.color.cccccc));
            questionsLayout.setOnClickListener(this);
            selectPersonas.setVisibility(View.GONE);
            genderLayout.setVisibility(View.GONE);
            ageLayout.setVisibility(View.GONE);
            locationLayout.setVisibility(View.GONE);
            analystLayout.setVisibility(View.VISIBLE);
            finishNumberLayout.setVisibility(View.VISIBLE);
            btnProcess.setVisibility(View.VISIBLE);
            topBar.top_bar_right_layout.setOnClickListener(null);
            startTimeLayout.setOnClickListener(null);
            endTimeLayout.setOnClickListener(null);

        }
        if (mStatus != 0) {
            name.setText(mVo.getName());
            name.setEnabled(false);
            totalNumber.setText(mVo.getTotalNumber() + "");
            totalNumber.setEnabled(false);
            reward.setText(mVo.getReward() + "");
            reward.setEnabled(false);
            questions.setText(mVo.getQuestions() == null ? "12个" : mVo.getQuestions().size() + "个");
            gender.setText(mVo.getPersonas() == null ? "未设置" : mVo.getPersonas().getGender() == 0 ? "男" : "女");
            age.setText(mVo.getPersonas() == null ? "未设置" : mVo.getPersonas().getAge() + "");
            location.setText(mVo.getPersonas() == null ? "未设置" : mVo.getPersonas().getArea() + "");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.top_bar_right_layout:
                save();
                break;
            case R.id.start_time_layout:
                showTimePickerView(true);
                break;
            case R.id.end_time_layout:
                showTimePickerView(false);
                break;
            case R.id.questions_layout:
                BuildQuestionActivity.goActivity(this);
                break;
            case R.id.btn_process:
                //参与调查
                if (mStatus == 1) {
                    updateStatus(2);
                    mVo.setStatus(2);
                    updateQuestionnaire(mVo);
                }
                break;
        }
    }

    private void save() {
        mVo.setName(name.getText().toString());
        mVo.setTotalNumber(TextUtils.isEmpty(totalNumber.getText().toString()) ? 0 : Integer.parseInt(totalNumber.getText().toString()));
        mVo.setReward(TextUtils.isEmpty(reward.getText().toString()) ? 0.0 : Double.parseDouble(reward.getText().toString()));
        mVo.setStartTime(TextUtils.isEmpty(startTime.getText().toString()) ? null : new Timestamp(DateUtils.stringToDate(startTime.getText().toString(), "yyyy-MM-dd").getTime()));
        mVo.setEndTime(TextUtils.isEmpty(endTime.getText().toString()) ? null : new Timestamp(DateUtils.stringToDate(endTime.getText().toString(), "yyyy-MM-dd").getTime()));
        PersonasVo personasVo = new PersonasVo();
        personasVo.setGender("男".equals(gender.getText().toString()) ? 0 : 1);
        personasVo.setAge(TextUtils.isEmpty(age.getText().toString()) ? 0 : Integer.parseInt(age.getText().toString()));
        personasVo.setArea(location.getText().toString());
        mVo.setPersonas(personasVo);
        mVo.setStatus(1);
        ConstantData.questionnaireVos.add(mVo);
        EventBus.getDefault().post(new JumpFragment(JumpFragment.Type.Research,0,true,false));
        updateStatus(1);

    }

    public void updateQuestionnaire(QuestionnaireVo data) {

        for (int i = 0; i < ConstantData.questionnaireVos.size(); i++) {
            if (data.getId() == ConstantData.questionnaireVos.get(i).getId()) {
                ConstantData.questionnaireVos.get(i).setStatus(data.getStatus());
                break;
            }
        }
    }

    private void showTimePickerView(final boolean isStartTime) {
        hideSoftInputMethod();
        final TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date, View v) {
                if (isStartTime) {
                    startTime.setText(DateUtils.dateToString(date, "yyyy-MM-dd"));
                } else {
                    endTime.setText(DateUtils.dateToString(date, "yyyy-MM-dd"));
                }
            }
        }).setType(new boolean[]{true, true, true, false, false, false})
                .setContentSize(18)
                .setTitleText(isStartTime ? "设置开始时间" : "设置结束时间")
                .setTitleSize(20)
                .setOutSideCancelable(true)
                .isDialog(false)
                .setLabel("年", "月", "日", "时", "分", "秒")
                .build();

        String lastTime = "";
        if (isStartTime) {
            lastTime = startTime.getText().toString();
        } else {
            lastTime = endTime.getText().toString();
        }
        if (TextUtils.isEmpty(lastTime)) {
            pvTime.setDate(Calendar.getInstance());
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DateUtils.stringToDate(lastTime, "yyyy-MM-dd"));
            pvTime.setDate(calendar);
        }

        pvTime.show();
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

    public static void toActivity(Context context, QuestionnaireVo questionnaireVo, int status) {
        Intent it = new Intent(context, BuildQuestionnaireActivity.class);
        it.putExtra("questionnaireVo", questionnaireVo);
        it.putExtra("status", status);
        context.startActivity(it);
    }
}
