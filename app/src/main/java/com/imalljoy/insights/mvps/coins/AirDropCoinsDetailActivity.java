package com.imalljoy.insights.mvps.coins;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/11.
 */

public class AirDropCoinsDetailActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.intro)
    TextView intro;
    CoinVo mVo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_airdrop_coins_detail);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mVo = (CoinVo) getIntent().getSerializableExtra("coinVo");
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.setTitle("详情");
        topBar.setRightView("币详情", 0);
        topBar.top_bar_right_layout.setOnClickListener(this);
        intro.setText(mVo.getIntro());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.top_bar_right_layout:
                IcoCoinsDetailActivity.toActivity(this, mVo);
                break;
        }
    }

    public static void toActivity(Context context, CoinVo coinVo) {
        Intent it = new Intent(context, AirDropCoinsDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("coinVo", coinVo);
        it.putExtras(bundle);
        context.startActivity(it);
    }
}
