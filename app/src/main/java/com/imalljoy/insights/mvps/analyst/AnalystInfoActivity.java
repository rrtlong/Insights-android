package com.imalljoy.insights.mvps.analyst;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.common.ConstantData;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.entity.ReportVo;
import com.imalljoy.insights.entity.UserVo;
import com.imalljoy.insights.mvps.research.ReportRecyclerAdapter;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/08.
 */

public class AnalystInfoActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.cover)
    ImageView cover;
    @BindView(R.id.cover_layout)
    LinearLayout coverLayout;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.name_layout)
    LinearLayout nameLayout;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.sex_layout)
    LinearLayout sexLayout;
    @BindView(R.id.certification_level)
    TextView certificationLevel;
    @BindView(R.id.certification_level_layout)
    LinearLayout certificationLevelLayout;
    @BindView(R.id.star_1)
    ImageView star1;
    @BindView(R.id.star_2)
    ImageView star2;
    @BindView(R.id.star_3)
    ImageView star3;
    @BindView(R.id.star_4)
    ImageView star4;
    @BindView(R.id.star_5)
    ImageView star5;
    @BindView(R.id.rate_layout)
    LinearLayout rateLayout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    ReportRecyclerAdapter mAdapter;
    UserVo mVo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_analyst_info);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this,R.color.colorPrimary);
        mVo = (UserVo) getIntent().getSerializableExtra("userVo");
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.setTitle("分析师的名字");
        topBar.setRightView(null,0);
        initDataToView();
        initRecycler();
    }

    private void initDataToView() {
        if(mVo != null){
            Glide.with(this).load(CommonUtils.getHeadCoverFromString(mVo.getHeadPic())).error(R.mipmap.default_head).into(cover);
            name.setText(mVo.getName());
            sex.setText(mVo.getGender() ==0?"男":"女");
            if(mVo.getAnalytsLevel() ==1){
                certificationLevel.setText("I");
            }else if(mVo.getAnalytsLevel() ==2){
                certificationLevel.setText("II");
            }else if(mVo.getAnalytsLevel() ==3){
                certificationLevel.setText("III");
            }
            if(mVo.getAnalytsStars() ==0){
                star1.setImageResource(R.mipmap.icon_star);
                star2.setImageResource(R.mipmap.icon_star);
                star3.setImageResource(R.mipmap.icon_star);
                star4.setImageResource(R.mipmap.icon_star);
                star5.setImageResource(R.mipmap.icon_star);
            }else if(mVo.getAnalytsStars() ==1){
                star1.setImageResource(R.mipmap.icon_star_yes);
                star2.setImageResource(R.mipmap.icon_star);
                star3.setImageResource(R.mipmap.icon_star);
                star4.setImageResource(R.mipmap.icon_star);
                star5.setImageResource(R.mipmap.icon_star);
            }else if(mVo.getAnalytsStars() ==2){
                star1.setImageResource(R.mipmap.icon_star_yes);
                star2.setImageResource(R.mipmap.icon_star_yes);
                star3.setImageResource(R.mipmap.icon_star);
                star4.setImageResource(R.mipmap.icon_star);
                star5.setImageResource(R.mipmap.icon_star);
            }
            else if(mVo.getAnalytsStars() ==3){
                star1.setImageResource(R.mipmap.icon_star_yes);
                star2.setImageResource(R.mipmap.icon_star_yes);
                star3.setImageResource(R.mipmap.icon_star_yes);
                star4.setImageResource(R.mipmap.icon_star);
                star5.setImageResource(R.mipmap.icon_star);
            }
            else if(mVo.getAnalytsStars() ==4){
                star1.setImageResource(R.mipmap.icon_star_yes);
                star2.setImageResource(R.mipmap.icon_star_yes);
                star3.setImageResource(R.mipmap.icon_star_yes);
                star4.setImageResource(R.mipmap.icon_star_yes);
                star5.setImageResource(R.mipmap.icon_star);
            }
            else if(mVo.getAnalytsStars() ==5){
                star1.setImageResource(R.mipmap.icon_star_yes);
                star2.setImageResource(R.mipmap.icon_star_yes);
                star3.setImageResource(R.mipmap.icon_star_yes);
                star4.setImageResource(R.mipmap.icon_star_yes);
                star5.setImageResource(R.mipmap.icon_star_yes);
            }

        }
    }

    private void initRecycler() {
        LinearLayoutManager linearManager = new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        linearManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divier = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divier.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearManager);
        recyclerview.addItemDecoration(divier);
        mAdapter = new ReportRecyclerAdapter(this, ConstantData.reportVos);
        recyclerview.setAdapter(mAdapter);
    }


    public static void toActivity(Context context, UserVo userVo) {
        Intent it = new Intent(context, AnalystInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("userVo",userVo);
        it.putExtras(bundle);
        context.startActivity(it);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_left_layout:
                finish();
                break;
        }
    }
}
