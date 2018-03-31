package com.imalljoy.insights.mvps.coins;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.utils.ScreenUtils;
import com.imalljoy.insights.widgets.TopBarSearch;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/31.
 */

public class SearchCoinsActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.top_bar)
    TopBarSearch topBar;
    @BindView(R.id.search_history)
    TextView searchHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_search_coins);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        topBar.cancel.setOnClickListener(this);
        topBar.edit.setPadding(ScreenUtils.dp2px(this,10),0,0,0);
        Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.icon_search_white);
        drawable.setBounds(0,0,ScreenUtils.dp2px(this,12),ScreenUtils.dp2px(this,12));
        topBar.edit.setCompoundDrawables(drawable,null,null,null);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_bar_cancel:
                finish();
                break;
        }
    }

    public static void toActivity(Context context){
        Intent it = new Intent(context, SearchCoinsActivity.class);
        context.startActivity(it);
    }
}
