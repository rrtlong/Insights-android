package com.imalljoy.insights.mvps.research;

import android.app.Activity;
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
import com.imalljoy.insights.bus.RefreshView;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.common.LocalData;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.entity.RateVo;
import com.imalljoy.insights.entity.ReportVo;
import com.imalljoy.insights.entity.RequestVo;
import com.imalljoy.insights.mvps.EditType2Activity;
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
    TextView mReportName;
    @BindView(R.id.report_name_layout)
    LinearLayout mReportNameLayout;
    @BindView(R.id.report_name_more)
    ImageView mReportNameMore;
    @BindView(R.id.analyst_layout)
    LinearLayout mAnalystLayout;
    @BindView(R.id.analyst)
    TextView mAnalyst;
    @BindView(R.id.publish_time_layout)
    LinearLayout mPublishTimeLayout;
    @BindView(R.id.publish_time)
    TextView mPublishTime;
    @BindView(R.id.cost_layout)
    LinearLayout mCostLayout;
    @BindView(R.id.cost)
    TextView mCost;
    @BindView(R.id.cost_more)
    ImageView mCostMore;
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
    @BindView(R.id.coin_cost)
    TextView mCoinCost;
    @BindView(R.id.coin_cost_layout)
    LinearLayout mCoinCostLayout;
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
    @BindView(R.id.coin_cost_img)
    ImageView mCoinCostImg;
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
    private int mEnterEnterpriseActType = 0; //0:点击了企业问询 1：点击了用户调研
    private boolean mIsFromMyReport = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_buildreport);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        mRequestVo = (RequestVo) getIntent().getSerializableExtra("request");
        mReportVo = (ReportVo) getIntent().getSerializableExtra("report");
        mIsFromMyReport = getIntent().getBooleanExtra("isFromMyReport",false);
        if (mReportVo == null) {
            Log.e(TAG, "1");
            if (mRequestVo == null) {
                mRequestVo = new RequestVo();
                mRequestVo.setId(System.currentTimeMillis() / 1000);
                CoinVo coinVo = new CoinVo();
                coinVo.setId(1l);
                coinVo.setName("比特币");
                coinVo.setLogoUrl("http://www.taopic.com/uploads/allimg/140325/318762-14032514002339.jpg");
                mRequestVo.setCoin(coinVo);
                mRequestVo.setUser(ConstantData.mUserVo);//设置分析师信息
            }
            //请求里面存放报告数据，是由于撰写报告没有发布，为了保存临时状态
            mReportVo = mRequestVo.getReportVo();
            if (mReportVo == null) {
                Log.e(TAG, "2");
                mReportVo = new ReportVo();
                mReportVo.setId(System.currentTimeMillis() / 1000);
                mReportVo.setUser(ConstantData.mUserVo);
                mReportVo.setRequest(mRequestVo);
            }

        }
        mStatus = getIntent().getIntExtra("status", 0);
        Log.e(TAG, "mstatus=" + mStatus);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mTopBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        mTopBar.top_bar_left_layout.setOnClickListener(this);
        mTopBar.top_bar_title_text.setText("报告");
        mContent.setPadding(ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10));
        updateStatus(mStatus);
        initListener();


    }

    public void updateStatus(int status) {
        mStatus = status;
        if (mStatus == 0) {
            mTopBar.setRightView("发布", 0);
            mTopBar.top_bar_right_layout.setOnClickListener(this);
            mCoinRatingLayout.setOnClickListener(this);
            mBtnProcess.setVisibility(View.GONE);
            mAnalystLayout.setVisibility(View.GONE);
            mPublishTimeLayout.setVisibility(View.GONE);
            mGradeLayout.setVisibility(View.GONE);
            mPlatformIndexLayout.setVisibility(View.GONE);
            mReportNameLayout.setOnClickListener(this);
            mCostLayout.setOnClickListener(this);
            showOrHideMoreImg(true);
        } else if (mStatus == 1) {
            mTopBar.setRightView(null, 0);
            mTopBar.top_bar_title_text.setText(mReportVo.getName() + "");
            mBtnProcess.setText("购买报告");
            isBuyLayout(false);
            showOrHideMoreImg(false);
        } else if (mStatus == 2) {
            mTopBar.setRightView(null, 0);
            mTopBar.top_bar_title_text.setText(mReportVo.getName() + "");
            mBtnProcess.setText("已购买");
            mBtnProcess.setBackgroundColor(Color.parseColor("#cccccc"));
            mAnalystLayout.setOnClickListener(this);
            mCoinRatingLayout.setOnClickListener(this);
            isBuyLayout(true);
            showOrHideMoreImg(false);
        }
        mCoinName.setText(mReportVo.getRequest().getCoin().getName());
        mReportName.setText(mReportVo.getName());
        mCost.setText(mReportVo.getCost() + "");
        if (mReportVo.getGrade() == 0) {

        } else if (mReportVo.getGrade() <= 20) {
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
        mCoinRating.setText(mReportVo.getCoinLevel());
        if (mReportVo.getRating() == null) {
            RateVo rateVo = new RateVo();
            rateVo.setProject(60);
            rateVo.setTeam(60);
            rateVo.setTechnology(60);
            rateVo.setBusiness(60);
            rateVo.setCapital(60);
            rateVo.setCoin(60);
            rateVo.setLaw(60);
            rateVo.setInfluence(60);
            rateVo.setUserResearch(60);
            rateVo.setEnterpriseInfo(60);
            mReportVo.setRating(rateVo);
        }
        mProject.setText(String.valueOf(mReportVo.getRating().getProject()));
        mTeam.setText(String.valueOf(mReportVo.getRating().getTeam()));
        mTechnology.setText(String.valueOf(mReportVo.getRating().getTechnology()));
        mBusiness.setText(String.valueOf(mReportVo.getRating().getBusiness()));
        mCapital.setText(String.valueOf(mReportVo.getRating().getCapital()));
        mCoinCost.setText(String.valueOf(mReportVo.getRating().getCoin()));
        mLaw.setText(String.valueOf(mReportVo.getRating().getLaw()));
        mInfluence.setText(String.valueOf(mReportVo.getRating().getInfluence()));
        mUserResearch.setText(String.valueOf(mReportVo.getRating().getUserResearch()));
        mEnterpriseInfo.setText(String.valueOf(mReportVo.getRating().getEnterpriseInfo()));


    }

    //如果没有购买报告，一些数据不让用户看见
    public void isBuyLayout(Boolean isBuy) {
        mAnalystLayout.setVisibility(View.VISIBLE);
        mAnalystLayout.setOnClickListener(this);
        mAnalyst.setText(mReportVo.getUser().getName());
        mPublishTimeLayout.setVisibility(View.VISIBLE);
        mPublishTime.setText(DateUtils.dateToString(new Date(mReportVo.getPublishTime().getTime()), "yyyy-MM-dd HH:mm"));
        mGradeLayout.setVisibility(View.VISIBLE);
        mCoinRatingImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mCoinRating.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mProjectImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mProject.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mTeamImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mTeam.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mTechnologyImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mTechnology.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mBusinessImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mBusiness.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mCapitalImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mCapital.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mCoinCostImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mCoinCost.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mLawImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mLaw.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mInfluenceImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mInfluence.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mUserResearchImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mUserResearch.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mEnterpriseInfoImg.setImageResource(isBuy ? R.mipmap.more : R.mipmap.disable);
        mEnterpriseInfo.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mPlatformIndexLayout.setVisibility(View.VISIBLE);
        mPlatformIndex.setVisibility(isBuy ? View.VISIBLE : View.INVISIBLE);
        mPlatformIndexImg.setVisibility(isBuy ? View.INVISIBLE : View.VISIBLE);
        mContent.setText(isBuy ? mReportVo.getContent() : "***");
    }

    public void initListener() {
        mCoinNameLayout.setOnClickListener(this);
        mCoinCostLayout.setOnClickListener(this);
        mProjectLayout.setOnClickListener(this);
        mTeamLayout.setOnClickListener(this);
        mTechnologyLayout.setOnClickListener(this);
        mBusinessLayout.setOnClickListener(this);
        mCapitalLayout.setOnClickListener(this);
        mCoinCostLayout.setOnClickListener(this);
        mLawLayout.setOnClickListener(this);
        mInfluenceLayout.setOnClickListener(this);
        mUserResearchLayout.setOnClickListener(this);
        mEnterpriseInfoLayout.setOnClickListener(this);
        mBtnProcess.setOnClickListener(this);
    }

    /**
     * 能编辑时就将更多图片“》”显示出来，不能编辑时就影藏掉
     *
     * @param isShow
     */
    public void showOrHideMoreImg(boolean isShow) {
        mReportNameMore.setVisibility(isShow ? View.VISIBLE : View.GONE);
        mCostMore.setVisibility(isShow ? View.VISIBLE : View.GONE);
        mContent.setEnabled(isShow ? true : false);
    }


    @Override
    public void onClick(View v) {
        Log.e(TAG, "onclick 1");
        switch (v.getId()) {
            case R.id.coin_name_layout:
                BuildCoinInfoActivity.toActivityForResult(this, mReportVo.getRequest().getCoin(), mStatus, 1);
                break;
            case R.id.report_name_layout:
                if (mStatus == 0) {
                    EditType2Activity.toActivityForResult(this, "名称", mReportName.getText().toString(), ConstantData.reportRequestCode, EditType2Activity.REPORT_NAME_CODE);
                }
                break;
            case R.id.cost_layout:
                if (mStatus == 0) {
                    EditType2Activity.toActivityForResult(this, "花费", mCost.getText().toString(), ConstantData.reportRequestCode, EditType2Activity.REPORT_COST_CODE);
                }
                break;
            case R.id.coin_rating_layout:
                if (mStatus == 0 || mStatus == 2) {
                    BuildCoinLevelActivity.toActivity(this, mCoinRating.getText().toString(), mStatus);
                }
                break;
            case R.id.project_layout:
                if (mStatus == 0) {
                    EditType1Activity.toActivity(this, EditReturnData.PROJECT, "项目", mReportVo.getRating().getProject(), mReportVo.getRating().getProjectIntro());
                } else if (mStatus == 2) {
                    EditType1Activity.toActivity(this, -1, "项目", mReportVo.getRating().getProject(), mReportVo.getRating().getProjectIntro());
                }
                break;
            case R.id.team_layout:
                if (mStatus == 0) {
                    EditType1Activity.toActivity(this, EditReturnData.TEAM, "团队", mReportVo.getRating().getTeam(), mReportVo.getRating().getTeamIntro());
                } else if (mStatus == 2) {
                    EditType1Activity.toActivity(this, -1, "团队", mReportVo.getRating().getTeam(), mReportVo.getRating().getTeamIntro());
                }
                break;
            case R.id.technology_layout:
                if (mStatus == 0) {
                    EditType1Activity.toActivity(this, EditReturnData.TECHNOLOGY, "技术", mReportVo.getRating().getTechnology(), mReportVo.getRating().getTechnologyIntro());
                } else if (mStatus == 2) {
                    EditType1Activity.toActivity(this, -1, "技术", mReportVo.getRating().getTechnology(), mReportVo.getRating().getTechnologyIntro());
                }
                break;
            case R.id.business_layout:
                if (mStatus == 0) {
                    EditType1Activity.toActivity(this, EditReturnData.BUSINESS, "业务", mReportVo.getRating().getBusiness(), mReportVo.getRating().getBusinessIntro());
                } else if (mStatus == 2) {
                    EditType1Activity.toActivity(this, -1, "业务", mReportVo.getRating().getBusiness(), mReportVo.getRating().getBusinessIntro());
                }
                break;
            case R.id.capital_layout:
                if (mStatus == 0) {
                    EditType1Activity.toActivity(this, EditReturnData.CAPITAL, "资金", mReportVo.getRating().getCapital(), mReportVo.getRating().getCapitalIntro());
                } else if (mStatus == 2) {
                    EditType1Activity.toActivity(this, -1, "资金", mReportVo.getRating().getCapital(), mReportVo.getRating().getCapitalIntro());
                }
                break;
            case R.id.coin_cost_layout:
                if (mStatus == 0) {
                    EditType1Activity.toActivity(this, EditReturnData.COIN_COST, "花费", mReportVo.getRating().getCoin(), mReportVo.getRating().getCoinIntro());
                } else if (mStatus == 2) {
                    EditType1Activity.toActivity(this, -1, "花费", mReportVo.getRating().getCoin(), mReportVo.getRating().getCoinIntro());
                }
                break;
            case R.id.law_layout:
                if (mStatus == 0) {
                    EditType1Activity.toActivity(this, EditReturnData.LAW, "法律", mReportVo.getRating().getLaw(), mReportVo.getRating().getLawIntro());
                } else if (mStatus == 2) {
                    EditType1Activity.toActivity(this, -1, "法律", mReportVo.getRating().getLaw(), mReportVo.getRating().getLawIntro());
                }

                break;
            case R.id.influence_layout:
                if (mStatus == 0) {
                    EditType1Activity.toActivity(this, EditReturnData.INFLUENCE, "影响力", mReportVo.getRating().getInfluence(), mReportVo.getRating().getInfluenceIntro());
                } else if (mStatus == 2) {
                    EditType1Activity.toActivity(this, -1, "影响力", mReportVo.getRating().getInfluence(), mReportVo.getRating().getInfluenceIntro());
                }
                break;
            case R.id.userResearch_layout:
                if (mStatus == 0 || mStatus == 2) {
                    LocalData.getInstance().setmReportVo(mReportVo);
                    EnterpriseActivity.toActivity(this, 1, mStatus);
                    mEnterEnterpriseActType = 1;
                }

                break;
            case R.id.enterpriseInfo_layout:
                if (mStatus == 0 || mStatus == 2) {
                    LocalData.getInstance().setmReportVo(mReportVo);
                    EnterpriseActivity.toActivity(this, 0, mStatus);
                    mEnterEnterpriseActType = 0;
                }
                break;
            case R.id.top_bar_left_layout:
                mReportVo.setContent(mContent.getText().toString());
                ConstantData.updateRequest(mRequestVo.getId(), mReportVo);
                finish();
                break;
            case R.id.top_bar_right_layout:
                mReportVo.setContent(mContent.getText().toString());
                mReportVo.setStatus(1);
                mReportVo.setPublishTime(new Timestamp(System.currentTimeMillis()));
                mReportVo.setRequest(mRequestVo);
                ConstantData.reportVos.add(mReportVo);
                EventBus.getDefault().post(new JumpFragment(JumpFragment.Type.Research, 1, true, true));
                //跟新请求状态为已完成
                ConstantData.updateRequestStatus(mRequestVo.getId(), 3);
                //发布的报告添加到用户数据中
                ConstantData.addReportToUser(mReportVo);
                finish();
                if(mIsFromMyReport){
                    ConstantData.myReports.add(mReportVo);
                }
                break;
            case R.id.btn_process:
                if (mStatus == 1) {
                    ConstantData.updateReportStatus(mReportVo.getId(), 2);
                    updateStatus(2);
                    //购买的报告添加到用户数据中
                    ConstantData.addReportToUser(mReportVo);
                }
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EditReturnData editReturnData) {
        Log.e(TAG, editReturnData.toString());
        if (mReportVo.getRating() == null) {
            mReportVo.setRating(new RateVo());
        }
        if (editReturnData.getFlag() == EditReturnData.COIN_RATING) {

        } else if (editReturnData.getFlag() == EditReturnData.PROJECT) {
            mReportVo.getRating().setProject(editReturnData.getScore());
            mReportVo.getRating().setProjectIntro(editReturnData.getScoreIntro());
            mProject.setText(editReturnData.getScore() + "");
        } else if (editReturnData.getFlag() == EditReturnData.TEAM) {
            mReportVo.getRating().setTeam(editReturnData.getScore());
            mReportVo.getRating().setTeamIntro(editReturnData.getScoreIntro());
            mTeam.setText(editReturnData.getScore() + "");
        } else if (editReturnData.getFlag() == EditReturnData.TECHNOLOGY) {
            mReportVo.getRating().setTechnology(editReturnData.getScore());
            mReportVo.getRating().setTechnologyIntro(editReturnData.getScoreIntro());
            mTechnology.setText(editReturnData.getScore() + "");
        } else if (editReturnData.getFlag() == EditReturnData.BUSINESS) {
            mReportVo.getRating().setBusiness(editReturnData.getScore());
            mReportVo.getRating().setBusinessIntro(editReturnData.getScoreIntro());
            mBusiness.setText(editReturnData.getScore() + "");
        } else if (editReturnData.getFlag() == EditReturnData.CAPITAL) {
            mReportVo.getRating().setCapital(editReturnData.getScore());
            mReportVo.getRating().setCapitalIntro(editReturnData.getScoreIntro());
            mCapital.setText(editReturnData.getScore() + "");
        } else if (editReturnData.getFlag() == EditReturnData.COIN_COST) {
            mReportVo.getRating().setCoin(editReturnData.getScore());
            mReportVo.getRating().setCoinIntro(editReturnData.getScoreIntro());
            mCoinCost.setText(editReturnData.getScore() + "");
        } else if (editReturnData.getFlag() == EditReturnData.LAW) {
            mReportVo.getRating().setLaw(editReturnData.getScore());
            mReportVo.getRating().setLawIntro(editReturnData.getScoreIntro());
            mLaw.setText(editReturnData.getScore() + "");
        } else if (editReturnData.getFlag() == EditReturnData.INFLUENCE) {
            mReportVo.getRating().setInfluence(editReturnData.getScore());
            mReportVo.getRating().setInfluenceIntro(editReturnData.getScoreIntro());
            mInfluence.setText(editReturnData.getScore() + "");
        } else if (editReturnData.getFlag() == EditReturnData.USERRESEARCH) {
            mReportVo.getRating().setUserResearch(editReturnData.getScore());
            mReportVo.getRating().setUserResearchIntro(editReturnData.getScoreIntro());
            mUserResearch.setText(editReturnData.getScore() + "");
        } else if (editReturnData.getFlag() == EditReturnData.ENTERPRISEINFO) {
            mReportVo.getRating().setEnterpriseInfo(editReturnData.getScore());
            mReportVo.getRating().setEnterpriseInfoIntro(editReturnData.getScoreIntro());
            mEnterpriseInfo.setText(editReturnData.getScore() + "");
        } else if (editReturnData.getFlag() == EditReturnData.EDIT_COIN_LEVEL) {
            mReportVo.setCoinLevel(editReturnData.getScoreIntro());
            mCoinRating.setText(editReturnData.getScoreIntro());
        }
    }

    @Subscribe
    public void onEvent(RefreshView refreshView) {
        if (mStatus == 0 && refreshView.getFlag() == RefreshView.REFRESH_REPORT_FROM_QUESTIONNAIRE) {
            if (mStatus == 0) {
                if (mEnterEnterpriseActType == 0) {
//                    mReportVo.getEnterpriseInfoList().add(LocalData.getInstance().getmQuestionnaireVo());
                } else if (mEnterEnterpriseActType == 1) {
//                    mReportVo.getUserResearchList().add(LocalData.getInstance().getmQuestionnaireVo());
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantData.reportRequestCode && resultCode == 2) {
            mReportVo.getRequest().setCoin((CoinVo) data.getSerializableExtra("coinVo"));
            mCoinName.setText(mReportVo.getRequest().getCoin().getName() + "");
        } else if (requestCode == ConstantData.reportRequestCode && resultCode == EditType2Activity.REPORT_NAME_CODE && data != null) {
            String value = data.getStringExtra("value");
            mReportName.setText(value + "");
            mReportVo.setName(value);
        } else if (requestCode == ConstantData.reportRequestCode && resultCode == EditType2Activity.REPORT_COST_CODE && data != null) {
            String value = data.getStringExtra("value");
            boolean right = true;
            double valueDouble = 0.0;
            try {
                valueDouble = Double.parseDouble(value);
            } catch (Exception e) {
                right = false;
            }
            if (right) {
                mReportVo.setCost(valueDouble);
            }
            mCost.setText(mReportVo.getCost() + "");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public static void toActivity(Context context, RequestVo requestVo, ReportVo reportVo, int status) {
        Intent it = new Intent(context, BuildReportActivity.class);
        if (requestVo != null) {
            it.putExtra("request", requestVo);
        }
        if (reportVo != null) {
            it.putExtra("report", reportVo);
        }
        it.putExtra("status", status);
        context.startActivity(it);

    }
    public static void toActivityForMyreport(Context context, int status,boolean isFromMyReport) {
        Intent it = new Intent(context, BuildReportActivity.class);
        it.putExtra("status", status);
        it.putExtra("isFromMyReport",isFromMyReport);
        context.startActivity(it);

    }
}
