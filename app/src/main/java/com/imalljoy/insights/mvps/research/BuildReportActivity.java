package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.bus.EditReturnData;
import com.imalljoy.insights.bus.JumpFragment;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.entity.ReportVo;
import com.imalljoy.insights.entity.RequestVo;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.utils.DateUtils;
import com.imalljoy.insights.utils.ScreenUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.sql.Timestamp;
import java.util.Date;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/18.
 */

public class BuildReportActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "BuildReportActivity";
    @BindView(R.id.top_bar)
    TopBarCommon mTopBar;
    @BindView(R.id.coin_name)
    TextView mCoinName;
    @BindView(R.id.coin_name_layout)
    LinearLayout mCoinNameLayout;
    @BindView(R.id.report_name)
    EditText mReportName;
    @BindView(R.id.report_name_layout)
    LinearLayout mReportNameLayout;
    @BindView(R.id.analyst_layout)
    LinearLayout mAnalystLayout;
    @BindView(R.id.analyst)
    TextView mAnalyst;
    @BindView(R.id.publish_time_layout)
    LinearLayout mPublishTimeLayout;
    @BindView(R.id.publish_time)
    TextView mPublishTime;
    @BindView(R.id.cost)
    EditText mCost;
    @BindView(R.id.grade_layout)
    LinearLayout mGradeLayout;
    @BindView(R.id.star_1)
    ImageView mStart1;
    @BindView(R.id.star_2)
    ImageView mStart2;
    @BindView(R.id.star_3)
    ImageView mStart3;
    @BindView(R.id.star_4)
    ImageView mStart4;
    @BindView(R.id.star_5)
    ImageView mStart5;
    @BindView(R.id.coin_rating)
    TextView mCoinRating;
    @BindView(R.id.coin_rating_layout)
    LinearLayout mCoinRatingLayout;
    @BindView(R.id.project)
    TextView mProject;
    @BindView(R.id.project_layout)
    LinearLayout mProjectLayout;
    @BindView(R.id.team)
    TextView mTeam;
    @BindView(R.id.team_layout)
    LinearLayout mTeamLayout;
    @BindView(R.id.technology)
    TextView mTechnology;
    @BindView(R.id.technology_layout)
    LinearLayout mTechnologyLayout;
    @BindView(R.id.business)
    TextView mBusiness;
    @BindView(R.id.business_layout)
    LinearLayout mBusinessLayout;
    @BindView(R.id.capital)
    TextView mCapital;
    @BindView(R.id.capital_layout)
    LinearLayout mCapitalLayout;
    @BindView(R.id.coin)
    TextView mCoin;
    @BindView(R.id.coin_layout)
    LinearLayout mCoinLayout;
    @BindView(R.id.law)
    TextView mLaw;
    @BindView(R.id.law_layout)
    LinearLayout mLawLayout;
    @BindView(R.id.influence)
    TextView mInfluence;
    @BindView(R.id.influence_layout)
    LinearLayout mInfluenceLayout;
    @BindView(R.id.userResearch)
    TextView mUserResearch;
    @BindView(R.id.userResearch_layout)
    LinearLayout mUserResearchLayout;
    @BindView(R.id.enterpriseInfo)
    TextView mEnterpriseInfo;
    @BindView(R.id.enterpriseInfo_layout)
    LinearLayout mEnterpriseInfoLayout;
    @BindView(R.id.content)
    EditText mContent;
    @BindView(R.id.btn_process)
    Button mBtnProcess;
    @BindView(R.id.coin_rating_img)
    ImageView mCoinRatingImg;
    @BindView(R.id.project_img)
    ImageView mProjectImg;
    @BindView(R.id.team_img)
    ImageView mTeamImg;
    @BindView(R.id.technology_img)
    ImageView mTechnologyImg;
    @BindView(R.id.business_img)
    ImageView mBusinessImg;
    @BindView(R.id.capital_img)
    ImageView mCapitalImg;
    @BindView(R.id.coin_img)
    ImageView mCoinImg;
    @BindView(R.id.law_img)
    ImageView mLawImg;
    @BindView(R.id.influence_img)
    ImageView mInfluenceImg;
    @BindView(R.id.platform_index_layout)
    LinearLayout mPlatformIndexLayout;
    @BindView(R.id.platform_index)
    TextView mPlatformIndex;
    @BindView(R.id.platform_index_img)
    ImageView mPlatformIndexImg;
    @BindView(R.id.userResearch_img)
    ImageView mUserResearchImg;
    @BindView(R.id.enterpriseInfo_img)
    ImageView mEnterpriseInfoImg;
    private RequestVo mRequestVo;
    private ReportVo mReportVo;
    private int mStatus; //0:新建报告 1:未购买报告 2:已购买报告

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_buildreport);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        mRequestVo = (RequestVo) getIntent().getSerializableExtra("request");
        mReportVo = (ReportVo) getIntent().getSerializableExtra("report");
        if(mReportVo == null){
            mReportVo = new ReportVo();
            mReportVo.setId(System.currentTimeMillis()/1000);
            mReportVo.setUser(ConstantData.mUserVo);
            mReportVo.setRequest(mRequestVo);
        }

        mStatus = getIntent().getIntExtra("status", 0);
        Log.e(TAG,"mstatus=" +mStatus);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mTopBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        mTopBar.top_bar_left_layout.setOnClickListener(this);
        mTopBar.top_bar_title_text.setText("报告");
        mContent.setPadding(ScreenUtils.dp2px(this,10),ScreenUtils.dp2px(this,10),ScreenUtils.dp2px(this,10),ScreenUtils.dp2px(this,10));
        if (mStatus == 0) {
            mTopBar.setRightView("发布", 0);
            mTopBar.top_bar_right_layout.setOnClickListener(this);
            mCoinRatingLayout.setOnClickListener(this);
            mBtnProcess.setVisibility(View.GONE);
            mAnalystLayout.setVisibility(View.GONE);
            mPublishTimeLayout.setVisibility(View.GONE);
            mGradeLayout.setVisibility(View.GONE);
            mPlatformIndexLayout.setVisibility(View.GONE);
        } else if (mStatus == 1) {
            mTopBar.setRightView(null, 0);
            mBtnProcess.setText("购买报告");
            mAnalystLayout.setVisibility(View.VISIBLE);
            mAnalystLayout.setOnClickListener(this);
            mAnalyst.setText(mReportVo.getUser().getName());
            mPublishTimeLayout.setVisibility(View.VISIBLE);
            mPublishTime.setText(DateUtils.dateToString(new Date(mReportVo.getPublishTime().getTime()),"yyyy-MM-dd HH:mm"));
            mGradeLayout.setVisibility(View.VISIBLE);
            mCoinRating.setVisibility(View.INVISIBLE);
            mCoinRatingImg.setImageResource(R.mipmap.disable);
            mPlatformIndexLayout.setVisibility(View.VISIBLE);
            mPlatformIndex.setVisibility(View.INVISIBLE);
            mPlatformIndexImg.setVisibility(View.VISIBLE);
            mCoinRatingImg.setImageResource(R.mipmap.disable);
            mCoinRating.setVisibility(View.INVISIBLE);
            mProjectImg.setImageResource(R.mipmap.disable);
            mProject.setVisibility(View.INVISIBLE);
            mTeamImg.setImageResource(R.mipmap.disable);
            mTeam.setVisibility(View.INVISIBLE);
            mTechnologyImg.setImageResource(R.mipmap.disable);
            mTechnology.setVisibility(View.INVISIBLE);
            mBusinessImg.setImageResource(R.mipmap.disable);
            mBusiness.setVisibility(View.INVISIBLE);
            mCapitalImg.setImageResource(R.mipmap.disable);
            mCapital.setVisibility(View.INVISIBLE);
            mCoinImg.setImageResource(R.mipmap.disable);
            mCoin.setVisibility(View.INVISIBLE);
            mLawImg.setImageResource(R.mipmap.disable);
            mLaw.setVisibility(View.INVISIBLE);
            mInfluenceImg.setImageResource(R.mipmap.disable);
            mInfluence.setVisibility(View.INVISIBLE);
            mUserResearchImg.setImageResource(R.mipmap.disable);
            mUserResearch.setVisibility(View.INVISIBLE);
            mEnterpriseInfoImg.setImageResource(R.mipmap.disable);
            mEnterpriseInfo.setVisibility(View.INVISIBLE);
            mContent.setText("***");
            mContent.setEnabled(false);
            mReportName.setEnabled(false);

        } else if (mStatus == 2) {
            mTopBar.setRightView(null, 0);
            mBtnProcess.setText("已购买");
            mBtnProcess.setBackgroundColor(Color.parseColor("#cccccc"));
            mContent.setEnabled(false);
            mReportName.setEnabled(false);
            mAnalystLayout.setVisibility(View.VISIBLE);
            mAnalystLayout.setOnClickListener(this);
            mAnalyst.setText(mReportVo.getUser().getName());
            mPublishTimeLayout.setVisibility(View.VISIBLE);
            mPublishTime.setText(DateUtils.dateToString(new Date(mReportVo.getPublishTime().getTime()),"yyyy-MM-dd HH:mm"));
            mCoinRatingLayout.setOnClickListener(this);
            mGradeLayout.setVisibility(View.VISIBLE);
            mPlatformIndexLayout.setVisibility(View.VISIBLE);
            mPlatformIndex.setVisibility(View.VISIBLE);
            mPlatformIndexImg.setVisibility(View.INVISIBLE);

        }
        mCoinName.setText(mReportVo.getRequest().getCoin().getName());
        mReportName.setText(mReportVo.getName());
        mCost.setText(mReportVo.getCost()+"");
        mCoinRating.setText(mReportVo.getCoinLevel());

        if (mReportVo.getGrade() <= 20) {
            mStart1.setImageResource(R.mipmap.icon_star_yes);
        } else if (mReportVo.getGrade() <= 40) {
            mStart1.setImageResource(R.mipmap.icon_star_yes);
            mStart2.setImageResource(R.mipmap.icon_star_yes);
        } else if (mReportVo.getGrade() <= 60) {
            mStart1.setImageResource(R.mipmap.icon_star_yes);
            mStart2.setImageResource(R.mipmap.icon_star_yes);
            mStart3.setImageResource(R.mipmap.icon_star_yes);
        } else if (mReportVo.getGrade() <= 80) {
            mStart1.setImageResource(R.mipmap.icon_star_yes);
            mStart2.setImageResource(R.mipmap.icon_star_yes);
            mStart3.setImageResource(R.mipmap.icon_star_yes);
            mStart4.setImageResource(R.mipmap.icon_star_yes);
        } else if (mReportVo.getGrade() <= 100) {
            mStart1.setImageResource(R.mipmap.icon_star_yes);
            mStart2.setImageResource(R.mipmap.icon_star_yes);
            mStart3.setImageResource(R.mipmap.icon_star_yes);
            mStart4.setImageResource(R.mipmap.icon_star_yes);
            mStart5.setImageResource(R.mipmap.icon_star_yes);
        }
        mCoinNameLayout.setOnClickListener(this);
        mCoinLayout.setOnClickListener(this);
        mProjectLayout.setOnClickListener(this);
        mTeamLayout.setOnClickListener(this);
        mTechnologyLayout.setOnClickListener(this);
        mBusinessLayout.setOnClickListener(this);
        mCapitalLayout.setOnClickListener(this);
        mCoinLayout.setOnClickListener(this);
        mLawLayout.setOnClickListener(this);
        mInfluenceLayout.setOnClickListener(this);
        mUserResearchLayout.setOnClickListener(this);
        mEnterpriseInfoLayout.setOnClickListener(this);
        mBtnProcess.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.coin_name_layout:
                BuildCoinInfoActivity.toActivityForResult(this, mReportVo.getRequest().getCoin(),mStatus,1);
                break;
            case R.id.coin_rating_layout:
                if (mStatus ==0 || mStatus ==2){
                    BuildCoinLevelActivity.toActivity(this, mCoinRating.getText().toString(), mStatus);
                }
                break;
            case R.id.project_layout:
                if(mStatus ==0){
                    EditType1Activity.toActivity(this,EditReturnData.PROJECT,"项目");
                }else if(mStatus ==2){
                    EditType1Activity.toActivity(this,-1,"项目");
                }
                break;
            case R.id.team_layout:
                if(mStatus ==0){
                    EditType1Activity.toActivity(this,EditReturnData.TEAM,"团队");
                }else if(mStatus ==2){
                    EditType1Activity.toActivity(this,-1,"团队");
                }
                break;
            case R.id.technology_layout:
                if(mStatus ==0){
                    EditType1Activity.toActivity(this,EditReturnData.TECHNOLOGY,"技术");
                }else if(mStatus ==2){
                    EditType1Activity.toActivity(this,-1,"技术");
                }
                break;
            case R.id.business_layout:
                if(mStatus ==0){
                    EditType1Activity.toActivity(this,EditReturnData.BUSINESS,"业务");
                }else if(mStatus ==2){
                    EditType1Activity.toActivity(this,-1,"业务");
                }
                break;
            case R.id.capital_layout:
                if(mStatus ==0){
                    EditType1Activity.toActivity(this,EditReturnData.CAPITAL,"资金");
                }else if(mStatus ==2){
                    EditType1Activity.toActivity(this,-1,"资金");
                }
                break;
            case R.id.coin_layout:
                if(mStatus ==0){
                    EditType1Activity.toActivity(this,EditReturnData.COIN,"代币");
                }else if(mStatus ==2){
                    EditType1Activity.toActivity(this,-1,"代币");
                }
                break;
            case R.id.law_layout:
                if(mStatus ==0){
                    EditType1Activity.toActivity(this,EditReturnData.LAW,"法律");
                }else if(mStatus ==2){
                    EditType1Activity.toActivity(this, -1,"法律");
                }

                break;
            case R.id.influence_layout:
                if(mStatus ==0){
                    EditType1Activity.toActivity(this,EditReturnData.INFLUENCE,"影响力");
                }else if(mStatus ==2){
                    EditType1Activity.toActivity(this,-1,"影响力");
                }
                break;
            case R.id.userResearch_layout:
                if(mStatus ==0 || mStatus ==2){
                    EnterpriseActivity.toActivity(this, 1,mStatus);
                }

                break;
            case R.id.enterpriseInfo_layout:
                if(mStatus ==0 || mStatus ==2){
                    EnterpriseActivity.toActivity(this, 0,mStatus);
                }
                break;
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.top_bar_right_layout:
                mReportVo.setContent(mContent.getText().toString());
                mReportVo.setStatus(1);
                mReportVo.setPublishTime(new Timestamp(System.currentTimeMillis()));
                ConstantData.reportVos.add(mReportVo);
                EventBus.getDefault().post(new JumpFragment(JumpFragment.Type.Research,1, true,true));
                finish();
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EditReturnData editReturnData){
        Log.e(TAG,editReturnData.toString());
        if(editReturnData.getFlag() == EditReturnData.COIN_RATING){

        }else if(editReturnData.getFlag() == EditReturnData.PROJECT){
            mReportVo.getRating().setProject(editReturnData.getScore());
            mReportVo.getRating().setProjectIntro(editReturnData.getScoreIntro());
            mProject.setText(editReturnData.getScore()+"");
        }else if(editReturnData.getFlag() == EditReturnData.TEAM){
            mReportVo.getRating().setTeam(editReturnData.getScore());
            mReportVo.getRating().setTeamIntro(editReturnData.getScoreIntro());
            mTeam.setText(editReturnData.getScore()+"");
        }else if(editReturnData.getFlag() == EditReturnData.TECHNOLOGY){
            mReportVo.getRating().setTechnology(editReturnData.getScore());
            mReportVo.getRating().setTechnologyIntro(editReturnData.getScoreIntro());
            mTechnology.setText(editReturnData.getScore()+"");
        }else if(editReturnData.getFlag() == EditReturnData.BUSINESS){
            mReportVo.getRating().setBusiness(editReturnData.getScore());
            mReportVo.getRating().setBusinessIntro(editReturnData.getScoreIntro());
            mBusiness.setText(editReturnData.getScore()+"");
        }else if(editReturnData.getFlag() == EditReturnData.CAPITAL){
            mReportVo.getRating().setCapital(editReturnData.getScore());
            mReportVo.getRating().setCapitalIntro(editReturnData.getScoreIntro());
            mCapital.setText(editReturnData.getScore()+"");
        }else if(editReturnData.getFlag() == EditReturnData.COIN){
            mReportVo.getRating().setCoin(editReturnData.getScore());
            mReportVo.getRating().setCoinIntro(editReturnData.getScoreIntro());
            mCoin.setText(editReturnData.getScore()+"");
        }else if(editReturnData.getFlag() == EditReturnData.LAW){
            mReportVo.getRating().setLaw(editReturnData.getScore());
            mReportVo.getRating().setLawIntro(editReturnData.getScoreIntro());
            mLaw.setText(editReturnData.getScore()+"");
        }else if(editReturnData.getFlag() == EditReturnData.INFLUENCE){
            mReportVo.getRating().setInfluence(editReturnData.getScore());
            mReportVo.getRating().setInfluenceIntro(editReturnData.getScoreIntro());
            mInfluence.setText(editReturnData.getScore()+"");
        }else if(editReturnData.getFlag() == EditReturnData.USERRESEARCH){
            mReportVo.getRating().setUserResearch(editReturnData.getScore());
            mReportVo.getRating().setUserResearchIntro(editReturnData.getScoreIntro());
            mUserResearch.setText(editReturnData.getScore()+"");
        }else if(editReturnData.getFlag() == EditReturnData.ENTERPRISEINFO){
            mReportVo.getRating().setEnterpriseInfo(editReturnData.getScore());
            mReportVo.getRating().setEnterpriseInfoIntro(editReturnData.getScoreIntro());
            mEnterpriseInfo.setText(editReturnData.getScore()+"");
        }else if(editReturnData.getFlag() == EditReturnData.EDIT_COIN_LEVEL){
            mReportVo.setCoinLevel(editReturnData.getScoreIntro());
            mCoinRating.setText(editReturnData.getScoreIntro());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode ==2){
            mReportVo.getRequest().setCoin((CoinVo) data.getSerializableExtra("coinVo"));
            mCoinName.setText(mReportVo.getRequest().getCoin().getName()+"");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    public static void toActivity(Context context, RequestVo requestVo, ReportVo reportVo, int status){
        Intent it = new Intent(context,BuildReportActivity.class);
        if(requestVo != null){
            it.putExtra("request", requestVo);
        }
        if(reportVo != null){
            it.putExtra("report", reportVo);
        }
        it.putExtra("status",status);
        context.startActivity(it);

    }
}
