package com.imalljoy.insights.mvps.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.entity.UserVo;
import com.imalljoy.insights.mvps.research.QuestionnaireRecyclerAdapter;
import com.imalljoy.insights.mvps.research.UserListAdapter;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class LaunchQuestionnaireActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    List<UserVo> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_launch_questinnaire);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("我发起的调查问卷");
        topBar.setRightView(null, 0);
        initView();
    }

    private void initView() {
        LinearLayoutManager linearManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearManager);
        recyclerview.addItemDecoration(divider);
        listData = getData();
        recyclerview.setAdapter(new LaunchQuestionnaireAdapter(this,listData,0));

    }



    public List<UserVo> getData() {
        List<UserVo> vos = new ArrayList<>();
        vos.add(ConstantData.mUserVo);
        vos.add(ConstantData.mUserVo);
        vos.add(ConstantData.mUserVo);
        vos.add(ConstantData.mUserVo);
        vos.add(ConstantData.mUserVo);
        vos.add(ConstantData.mUserVo);
        vos.add(ConstantData.mUserVo);
        vos.add(ConstantData.mUserVo);
        vos.add(ConstantData.mUserVo);
        vos.add(ConstantData.mUserVo);
        vos.add(ConstantData.mUserVo);
        return vos;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                finish();
                break;
        }
    }
    public static void toActivity(Context context){
        Intent it = new Intent(context, LaunchQuestionnaireActivity.class);
        context.startActivity(it);
    }

}
