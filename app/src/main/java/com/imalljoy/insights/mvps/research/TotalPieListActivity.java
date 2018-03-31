package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PermissionInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.entity.QuestionnaireVo;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/21.
 */

public class TotalPieListActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "TotalPieListActivity";
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.pie_view1)
    PieChart pieView1;
    @BindView(R.id.pie_view2)
    PieChart pieView2;
    @BindView(R.id.pie_view3)
    PieChart pieView3;
    @BindView(R.id.pie_view4)
    PieChart pieView4;
    @BindView(R.id.pie_view5)
    PieChart pieView5;
    @BindView(R.id.pie_view6)
    PieChart pieView6;
    @BindView(R.id.pie_view7)
    PieChart pieView7;
    @BindView(R.id.pie_view8)
    PieChart pieView8;
    @BindView(R.id.pie_view9)
    PieChart pieView9;
    @BindView(R.id.pie_view10)
    PieChart pieView10;
    @BindView(R.id.pie_view11)
    PieChart pieView11;
    @BindView(R.id.pie_view12)
    PieChart pieView12;


    private int mType = 0;
    private QuestionnaireVo mQuestionnaireVo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_total_pielist);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mType = getIntent().getIntExtra("type",0);
        mQuestionnaireVo = (QuestionnaireVo) getIntent().getSerializableExtra("questionnaireVo");
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText("问卷");
        topBar.setRightView("查看详情", 0);
        topBar.top_bar_right_layout.setOnClickListener(this);
        initView();

    }

    private void initView() {
        initPieChart(pieView1);
        initPieChart(pieView2);
        initPieChart(pieView3);
        initPieChart(pieView4);
        initPieChart(pieView5);
        initPieChart(pieView6);
        initPieChart(pieView7);
        initPieChart(pieView8);
        initPieChart(pieView9);
        initPieChart(pieView10);
        initPieChart(pieView11);
        initPieChart(pieView12);
    }

    public void initPieChart(PieChart pieChart) {
        // 设置 pieChart 图表基本属性
        pieChart.setUsePercentValues(false);            //使用百分比显示
        pieChart.getDescription().setEnabled(false);    //设置pieChart图表的描述
        pieChart.setBackgroundColor(Color.WHITE);      //设置pieChart图表背景色
        pieChart.setExtraOffsets(0, 0, 0, 0);        //设置pieChart图表上下左右的偏移，类似于外边距
        pieChart.setDragDecelerationFrictionCoef(0.95f);//设置pieChart图表转动阻力摩擦系数[0,1]
        pieChart.setRotationAngle(0);                   //设置pieChart图表起始角度
        pieChart.setRotationEnabled(true);              //设置pieChart图表是否可以手动旋转
        pieChart.setHighlightPerTapEnabled(true);       //设置piecahrt图表点击Item高亮是否可用
        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);// 设置pieChart图表展示动画效果
        pieChart.setTransparentCircleColor(Color.WHITE);

        // 设置 pieChart 图表Item文本属性
        pieChart.setDrawEntryLabels(true);              //设置pieChart是否只显示饼图上百分比不显示文字（true：下面属性才有效果）
        pieChart.setEntryLabelColor(Color.WHITE);       //设置pieChart图表文本字体颜色
//        pieChart.setEntryLabelTypeface(mTfRegular);     //设置pieChart图表文本字体样式
        pieChart.setEntryLabelTextSize(10f);            //设置pieChart图表文本字体大小


        pieChart.setDrawHoleEnabled(false);
        pieChart.setDrawCenterText(false);
        Legend l = pieChart.getLegend();
        l.setEnabled(false);
        l.setTextColor(Color.WHITE);
        l.setTextSize(2f);
        l.setFormSize(10f);


        ArrayList<PieEntry> pieEntryList = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(ContextCompat.getColor(this, R.color.c_ffd55c));
        colors.add(ContextCompat.getColor(this, R.color.c_ff6d3b));
        colors.add(ContextCompat.getColor(this, R.color.c_2b4457));
        //饼图实体
        PieEntry purplus = new PieEntry(10, "葡萄");
        PieEntry apple = new PieEntry(40, "苹果");
        PieEntry balance = new PieEntry(60, "香蕉");
        pieEntryList.add(purplus);
        pieEntryList.add(apple);
        pieEntryList.add(balance);
        //饼状图数据集
        PieDataSet pieDataSet = new PieDataSet(pieEntryList, null);
        pieDataSet.setSliceSpace(3f);           //设置饼状Item之间的间隙
        pieDataSet.setSelectionShift(10f);      //设置饼状Item被选中时变化的距离
        pieDataSet.setColors(colors);           //为DataSet中的数据匹配上颜色集(饼图Item颜色)
        //最终数据 PieData
        PieData pieData = new PieData(pieDataSet);
        pieData.setDrawValues(true);            //设置是否显示数据实体(百分比，true:以下属性才有意义)
        pieData.setValueTextColor(Color.BLUE);  //设置所有DataSet内数据实体（百分比）的文本颜色
        pieData.setValueTextSize(12f);          //设置所有DataSet内数据实体（百分比）的文本字体大小
//        pieData.setValueTypeface(mTfLight);     //设置所有DataSet内数据实体（百分比）的文本字体样式
        pieData.setValueFormatter(new PercentFormatter());//设置所有DataSet内数据实体（百分比）的文本字体格式

        pieChart.setData(pieData);
        pieChart.highlightValues(null);
        pieChart.invalidate();                    //将图表重绘以显示设置的属性和数据

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.top_bar_right_layout:
                UserListActivity.toActivity(this, mType,mQuestionnaireVo);
                break;
        }
    }

    public static void toActivity(Context context, int type, QuestionnaireVo questionnaireVo) {
        Intent it = new Intent(context, TotalPieListActivity.class);
        it.putExtra("type",type);
        it.putExtra("questionnaireVo",questionnaireVo);
        context.startActivity(it);
    }
}
