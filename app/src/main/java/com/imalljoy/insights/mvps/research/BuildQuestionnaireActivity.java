package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.bumptech.glide.Glide;
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.bus.JumpFragment;
import com.imalljoy.insights.bus.RefreshView;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.common.LocalData;
import com.imalljoy.insights.entity.PersonasVo;
import com.imalljoy.insights.entity.QuestionnaireVo;
import com.imalljoy.insights.entity.UserVo;
import com.imalljoy.insights.mvps.EditType2Activity;
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
    TextView name;
    @BindView(R.id.name_layout)
    LinearLayout nameLayout;
    @BindView(R.id.total_number)
    TextView totalNumber;
    @BindView(R.id.total_number_layout)
    LinearLayout totalNumberLayout;
    @BindView(R.id.reward)
    TextView reward;
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
    TextView age;
    @BindView(R.id.age_layout)
    LinearLayout ageLayout;
    @BindView(R.id.location)
    TextView location;
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
    @BindView(R.id.name_more)
    ImageView nameMore;
    @BindView(R.id.total_number_more)
    ImageView totalNumberMore;
    @BindView(R.id.reward_more)
    ImageView rewardMore;
    @BindView(R.id.age_more)
    ImageView ageMore;
    @BindView(R.id.location_more)
    ImageView locationMore;
    private int mStatus;  //0:新建问卷/1:参与问卷/2:已完成问卷
    private int mType;   //0:针对企业问询的问卷 1:针对用户调研的问卷
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
        mType = getIntent().getIntExtra("type",-1);

        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        updateStatusView(mStatus);


    }

    public void updateStatusView(int status) {
        mStatus = status;
        Log.e(TAG, "mstatus=" + mStatus);
        if (mStatus == 0) {
            //新建
            mVo = new QuestionnaireVo();
            mVo.setId(System.currentTimeMillis() / 1000);
            mVo.setUserVo(ConstantData.mUserVo);
            mVo.setStatus(0);
            mVo.setPersonas(new PersonasVo());
            topBar.top_bar_title_text.setText("发起问卷");
            topBar.setRightView("发布", 0);
            topBar.top_bar_right_layout.setOnClickListener(this);
            analystLayout.setVisibility(View.GONE);
            finishNumberLayout.setVisibility(View.GONE);
            btnProcess.setVisibility(View.GONE);
            startTimeLayout.setOnClickListener(this);
            endTimeLayout.setOnClickListener(this);
            questionsLayout.setOnClickListener(this);
            showOrHideMoreImg(true);

        } else if (mStatus == 1) {
            //参与问卷
            topBar.top_bar_title_text.setText(mVo.getName() + "");
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
            showOrHideMoreImg(false);

        } else if (mStatus == 2) {
            //已完成
            topBar.top_bar_title_text.setText(mVo.getName() + "");
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
            showOrHideMoreImg(false);

        }
        if (mStatus != 0) {
            if(mVo.getUserVo() != null){
                UserVo userVo = mVo.getUserVo();
                analyst.setText(userVo.getName());
                Glide.with(this).load(userVo.getHeadPic()).into(analystImg);
            }

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
        checkActivityBeforeOrEnd();

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
            case R.id.name_layout:
                EditType2Activity.toActivityForResult(this, "名称", mVo.getName(),ConstantData.buildQuestionnaireRequestCode,EditType2Activity.BUILD_QUESTIONNAIRE_NAME_CODE);
                break;
            case R.id.total_number_layout:
                EditType2Activity.toActivityForResult(this, "总份数", String.valueOf(mVo.getTotalNumber()),ConstantData.buildQuestionnaireRequestCode,EditType2Activity.BUILD_QUESTIONNAIRE_TOTALNUM_CODE);
                break;
            case R.id.reward_layout:
                EditType2Activity.toActivityForResult(this, "奖励", String.valueOf(mVo.getReward()),ConstantData.buildQuestionnaireRequestCode, EditType2Activity.BUILD_QUESTIONNAIRE_REWARD_CODE);
                break;
            case R.id.age_layout:
                EditType2Activity.toActivityForResult(this, "年纪", String.valueOf(mVo.getPersonas().getAge()),ConstantData.buildQuestionnaireRequestCode,EditType2Activity.BUILD_QUESTIONNAIRE_AGE_CODE);
                break;
            case R.id.location_layout:
                EditType2Activity.toActivityForResult(this, "地域", String.valueOf(mVo.getPersonas().getArea()),ConstantData.buildQuestionnaireRequestCode,EditType2Activity.BUILD_QUESTIONNAIRE_LOCATION_CODE);
                break;
            case R.id.start_time_layout:
                showTimePickerView(true);
                break;
            case R.id.end_time_layout:
                showTimePickerView(false);
                break;
            case R.id.questions_layout:
                BuildQuestionActivity.toActivity(this,mStatus);
                break;
            case R.id.btn_process:
                //参与调查
                if (mStatus == 1) {
                    BuildQuestionActivity.toActivityForResult(this, mStatus,0, ConstantData.buildQuestionnaireRequestCode);
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
        mVo.setUserVo(ConstantData.mUserVo);
        mVo.setReportId(LocalData.getInstance().getmReportVo().getId());
        mVo.setType(mType);
        ConstantData.questionnaireVos.add(mVo);
        LocalData.getInstance().setmQuestionnaireVo(mVo);
        //通知刷新问卷页
        EventBus.getDefault().post(new JumpFragment(JumpFragment.Type.Research, 0, true, false));
        //通知刷新上一页，上上页
        EventBus.getDefault().post(new RefreshView(RefreshView.REFRESH_REPORT_FROM_QUESTIONNAIRE));
        //将发布的问卷添加的用户数据中
        ConstantData.mUserVo.getQuestionnaires().add(mVo);
        finish();

    }

    public void updateQuestionnaire(QuestionnaireVo data) {

        for (int i = 0; i < ConstantData.questionnaireVos.size(); i++) {
            if (data.getId() == (ConstantData.questionnaireVos.get(i).getId())) {
                ConstantData.questionnaireVos.get(i).setStatus(data.getStatus());
                break;
            }
        }
    }

    private void showTimePickerView(final boolean isStartTime) {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ConstantData.buildQuestionnaireRequestCode && mStatus ==0 && data != null){
            String value = data.getStringExtra("value");
            int valueInt = 0;
            double valueDouble = 0.0;
            boolean right = true;
            if(resultCode == EditType2Activity.BUILD_QUESTIONNAIRE_NAME_CODE){
                mVo.setName(value);
                name.setText(value+"");
            }else if(resultCode == EditType2Activity.BUILD_QUESTIONNAIRE_TOTALNUM_CODE){
                try{
                    valueInt = Integer.parseInt(value);
                }catch(Exception e){
                    right = false;
                }
                if(right){
                    mVo.setTotalNumber(valueInt);
                    totalNumber.setText(mVo.getTotalNumber()+"");
                }
            }else if(resultCode == EditType2Activity.BUILD_QUESTIONNAIRE_REWARD_CODE){
                try{
                    valueDouble = Double.parseDouble(value);
                }catch(Exception e){
                    right = false;
                }
                if(right){
                    mVo.setReward(valueDouble);
                    reward.setText(mVo.getReward()+"");
                }

            }else if(resultCode == EditType2Activity.BUILD_QUESTIONNAIRE_AGE_CODE){
                try{
                    valueInt = Integer.parseInt(value);
                }catch(Exception e){
                    right = false;
                }
                if(right){
                    mVo.getPersonas().setAge(valueInt);
                    age.setText(mVo.getPersonas().getAge()+"");
                }
            }else if(resultCode == EditType2Activity.BUILD_QUESTIONNAIRE_LOCATION_CODE){
                mVo.getPersonas().setArea(value);
                location.setText(value);
            }
        }else if (requestCode == ConstantData.buildQuestionnaireRequestCode && resultCode == BuildQuestionActivity.ANSWER_QUESTION){
            //完成答题
            updateStatusView(2);
            mVo.setStatus(2);
            mVo.getAnswerUserList().add(ConstantData.mUserVo);
            ConstantData.updateQuestionnaireVo(mVo);
            EventBus.getDefault().post(new JumpFragment(JumpFragment.Type.Research, -1, true, false));
            //将完成问卷数据添加到用户数据中
            ConstantData.mUserVo.getAcceptQuestionnaires().add(mVo);
        }
        Log.e(TAG,"requestCode=" + requestCode + ", resultCode=" +resultCode);
    }

    /**
     * 能编辑时就将更多图片“》”显示出来，不能编辑时就影藏掉
     *
     * @param isShow
     */
    public void showOrHideMoreImg(boolean isShow) {
        nameMore.setVisibility(isShow ? View.VISIBLE : View.GONE);
        totalNumberMore.setVisibility(isShow ? View.VISIBLE : View.GONE);
        rewardMore.setVisibility(isShow ? View.VISIBLE : View.GONE);
        ageMore.setVisibility(isShow ? View.VISIBLE : View.GONE);
        locationMore.setVisibility(isShow ? View.VISIBLE : View.GONE);
        nameLayout.setOnClickListener(isShow ? this:null);
        totalNumberLayout.setOnClickListener(isShow ? this:null);
        rewardLayout.setOnClickListener(isShow ? this:null);
        ageLayout.setOnClickListener(isShow ? this:null);
        locationLayout.setOnClickListener(isShow ? this:null);
    }


    public static void toActivity(Context context, QuestionnaireVo questionnaireVo, int status,int type) {
        Intent it = new Intent(context, BuildQuestionnaireActivity.class);
        it.putExtra("questionnaireVo", questionnaireVo);
        it.putExtra("status", status);
        it.putExtra("type",type);
        context.startActivity(it);
    }

    //当活动未开始或则已结束时，禁用下方按钮
    public void checkActivityBeforeOrEnd(){
        if(mVo != null){
        if (mVo.getStatus() == 2) {
        //已完成

    }else if (mVo.getStartTime().getTime() <= System.currentTimeMillis() && System.currentTimeMillis() < mVo.getEndTime().getTime()) {
        //在活动期

    } else if (System.currentTimeMillis() < mVo.getStartTime().getTime()) {
        //活动未开始
       btnProcess.setOnClickListener(null);
            btnProcess.setBackgroundColor(ContextCompat.getColor(this, R.color.cccccc));
    } else if (mVo.getEndTime().getTime() <= System.currentTimeMillis()) {
        //活动已结束
            btnProcess.setOnClickListener(null);
            btnProcess.setBackgroundColor(ContextCompat.getColor(this, R.color.cccccc));
    }
        }

    }


}
