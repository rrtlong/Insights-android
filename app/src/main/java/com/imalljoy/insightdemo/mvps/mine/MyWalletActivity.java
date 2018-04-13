package com.imalljoy.insightdemo.mvps.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseActivity;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.widgets.TopBarCommon;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class MyWalletActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.property_layout)
    LinearLayout propertyLayout;
    @BindView(R.id.recharge_layout)
    LinearLayout rechargeLayout;
    @BindView(R.id.transfer_layout)
    LinearLayout transferLayout;
    @BindView(R.id.collection_layout)
    LinearLayout collectionLayout;
    @BindView(R.id.extract_coin_layout)
    LinearLayout extractCoinLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_my_wallet);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.setTitle("我的钱包");
        topBar.setRightView(null, 0);
        propertyLayout.setOnClickListener(this);
        rechargeLayout.setOnClickListener(this);
        transferLayout.setOnClickListener(this);
        collectionLayout.setOnClickListener(this);
        extractCoinLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.property_layout:
                break;
            case R.id.recharge_layout:
                break;
            case R.id.collection_layout:
                break;
            case R.id.extract_coin_layout:
                break;
        }
    }

    public static void toActivity(Context context) {
        Intent it = new Intent(context, MyWalletActivity.class);
        context.startActivity(it);
    }
}
