package com.imalljoy.insights.mvps.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseFragment;
import com.imalljoy.insights.mvps.coins.detail.VoteStep1ListActivity;
import com.imalljoy.insights.mvps.mine.CertificationActivity;
import com.imalljoy.insights.mvps.mine.MessageExportActivity;
import com.imalljoy.insights.mvps.mine.MyReportsActivity;
import com.imalljoy.insights.mvps.mine.MyWalletActivity;
import com.imalljoy.insights.mvps.mine.QuestionnaireActivity;
import com.imalljoy.insights.mvps.mine.ResearchTaskActivity;
import com.imalljoy.insights.widgets.TopBarCommon;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lijilong on 03/09.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.certification_layout)
    LinearLayout certificationLayout;
    @BindView(R.id.questionnaire_layout)
    LinearLayout questionnaireLayout;
    @BindView(R.id.research_task_layout)
    LinearLayout researchTaskLayout;
    @BindView(R.id.message_export_layout)
    LinearLayout messageExportLayout;
    @BindView(R.id.mine_report)
    LinearLayout mineReport;
    @BindView(R.id.vote_layout)
    LinearLayout voteLayout;
    @BindView(R.id.wallet_layout)
    LinearLayout walletLayout;
    @BindView(R.id.root_view)
    LinearLayout rootView;
    Unbinder unbinder;
    private View mRootView;
    private TopBarCommon mTopBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        } else {
            mRootView = inflater.inflate(R.layout.fra_mine, container, false);
            mTopBar = (TopBarCommon) mRootView.findViewById(R.id.top_bar);
            mTopBar.setTitle("我的");
            mTopBar.setRightView(null, 0);
            initView();
        }
        unbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    private void initView() {
        certificationLayout.setOnClickListener(this);
        questionnaireLayout.setOnClickListener(this);
        researchTaskLayout.setOnClickListener(this);
        messageExportLayout.setOnClickListener(this);
        mineReport.setOnClickListener(this);
        voteLayout.setOnClickListener(this);
        walletLayout.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.certification_layout:
                CertificationActivity.toActivity(this.getContext());
                break;
            case R.id.questionnaire_layout:
                QuestionnaireActivity.toActivity(this.getContext());
                break;
            case R.id.research_task_layout:
                ResearchTaskActivity.toActivity(this.getContext());
                break;
            case R.id.message_export_layout:
                MessageExportActivity.toActivity(this.getContext());
                break;
            case R.id.mine_report:
                MyReportsActivity.toActivity(this.getContext());
                break;
            case R.id.vote_layout:
                VoteStep1ListActivity.toActivity(this.getContext());
                break;
            case R.id.wallet_layout:
                MyWalletActivity.toActivity(this.getContext());
                break;
        }
    }
}
