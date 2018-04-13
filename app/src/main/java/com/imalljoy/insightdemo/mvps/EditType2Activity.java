package com.imalljoy.insightdemo.mvps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseActivity;
import com.imalljoy.insightdemo.utils.CommonUtils;
import com.imalljoy.insightdemo.widgets.TopBarCommon;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/26.
 */

public class EditType2Activity extends BaseActivity implements View.OnClickListener {
    public static int REQUEST_NAME_CODE = 0;
    public static int REQUEST_REWARD_CODE = 1;
    public static int REPORT_NAME_CODE = 3;
    public static int REPORT_COST_CODE = 4;
    public static int BUILD_QUESTIONNAIRE_NAME_CODE = 5;
    public static int BUILD_QUESTIONNAIRE_TOTALNUM_CODE = 6;
    public static int BUILD_QUESTIONNAIRE_REWARD_CODE = 7;
    public static int BUILD_QUESTIONNAIRE_AGE_CODE = 8;
    public static int BUILD_QUESTIONNAIRE_LOCATION_CODE = 9;

    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.edit)
    EditText edit;
    private int mResultCode;
    private String mTitle;
    private String mOriginalValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_edit_type2);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mTitle = getIntent().getStringExtra("title");
        mResultCode = getIntent().getIntExtra("resultCode", 0);
        mOriginalValue = getIntent().getStringExtra("originalValue");
        topBar.setLeftView("取消", 0);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText(mTitle);
        topBar.setRightView("保存", 0);
        topBar.top_bar_right_layout.setOnClickListener(this);
        edit.setText(mOriginalValue);
        edit.setSelection(edit.getText().toString().length());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
            case R.id.top_bar_right_layout:
                finishEdit();
                break;
        }
    }

    public void finishEdit() {
        Intent it = getIntent();
        it.putExtra("value", edit.getText().toString());
        setResult(mResultCode, it);
        finish();
    }

    public static void toActivityForResult(Activity activity, String title, String originalValue, int requestCode, int resultCode) {
        Intent it = new Intent(activity, EditType2Activity.class);
        it.putExtra("resultCode", resultCode);
        it.putExtra("title", title);
        it.putExtra("originalValue", originalValue);
        activity.startActivityForResult(it, requestCode);
    }

}
