package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseActivity;
import com.imalljoy.insights.common.LocalData;
import com.imalljoy.insights.entity.QuestionnaireVo;
import com.imalljoy.insights.entity.UserVo;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.widgets.TopBarCommon;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/20.
 */

public class UserListActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "UserListActivity";
    @BindView(R.id.top_bar)
    TopBarCommon topBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    int mType;//0:企业问询 1:用户调研
    QuestionnaireVo mVo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_userlist);
        ButterKnife.bind(this);
        CommonUtils.tryShowStatusBar(this, R.color.colorPrimary);
        mType = getIntent().getIntExtra("type", 0);
        mVo = (QuestionnaireVo) getIntent().getSerializableExtra("questionnaireVo");
        topBar.top_bar_left_layout.setVisibility(View.VISIBLE);
        topBar.top_bar_left_layout.setOnClickListener(this);
        topBar.top_bar_title_text.setText(mType == 0 ? "企业问询" : "用户调研");
        topBar.setRightView(null, 0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recyclerview_divide_type1));
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.addItemDecoration(divider);
        recyclerview.setAdapter(new UserListAdapter(this, mVo.getAnswerUserList(), mType));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_bar_left_layout:
                finish();
                break;
        }
    }

    public List<UserVo> getData() {
        List<UserVo> vos = new ArrayList<>();
        UserVo userVo = new UserVo();
        userVo.setUserId(1l);
        userVo.setName("刘一");
        userVo.setHeadPic("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1711359766,3731166763&fm=111&gp=0.jpg");
        userVo.setGender(1);
        vos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(2l);
        userVo.setName("陈二");
        userVo.setHeadPic("http://5b0988e595225.cdn.sohucs.com/images/20180316/4e8447f23a1f480993f73811a7dea77b.jpeg");
        userVo.setGender(0);
        vos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(3l);
        userVo.setName("张三");
        userVo.setHeadPic("http://www.qqxoo.com/uploads/allimg/180315/144H61548-5.jpg");
        userVo.setGender(1);
        vos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(4l);
        userVo.setName("李四");
        userVo.setHeadPic("http://img0.imgtn.bdimg.com/it/u=4016867486,3765799418&fm=11&gp=0.jpg");
        userVo.setGender(0);
        vos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(5l);
        userVo.setName("王五");
        userVo.setHeadPic("http://pic.qqtn.com/up/2018-3/15211045617076231.jpg");
        userVo.setGender(1);
        vos.add(userVo);

        userVo.setUserId(6l);
        userVo.setName("赵六");
        userVo.setHeadPic("http://img1.imgtn.bdimg.com/it/u=2414298304,855041301&fm=27&gp=0.jpg");
        userVo.setGender(1);
        vos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(7l);
        userVo.setName("田七");
        userVo.setHeadPic("http://img5.imgtn.bdimg.com/it/u=3725804236,4096944947&fm=200&gp=0.jpg");
        userVo.setGender(0);
        vos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(8l);
        userVo.setName("亢八");
        userVo.setHeadPic("http://img1.imgtn.bdimg.com/it/u=2540925636,694787107&fm=27&gp=0.jpg");
        userVo.setGender(1);
        vos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(9l);
        userVo.setName("周九");
        userVo.setHeadPic("http://img5.imgtn.bdimg.com/it/u=2823973462,569293285&fm=200&gp=0.jpg");
        userVo.setGender(0);
        vos.add(userVo);

        userVo = new UserVo();
        userVo.setUserId(10l);
        userVo.setName("吴十");
        userVo.setHeadPic("http://img5.imgtn.bdimg.com/it/u=2137791684,3832002675&fm=27&gp=0.jpg");
        userVo.setGender(1);
        vos.add(userVo);
        return vos;
    }

    public static void toActivity(Context context, int type, QuestionnaireVo questionnaireVo){
        Intent it = new Intent(context, UserListActivity.class);
        it.putExtra("type",type);
        it.putExtra("questionnaireVo",questionnaireVo);
        context.startActivity(it);
    }
}
