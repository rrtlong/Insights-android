package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insights.R;
import com.imalljoy.insights.entity.UserVo;

import java.util.List;

import javax.sql.ConnectionPoolDataSource;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/20.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    List<UserVo> listData;
    Context mContext;
    int mStatus;

    public UserListAdapter(Context context, List<UserVo> listData, int status) {
        this.mContext = context;
        this.listData = listData;
        this.mStatus = status;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_userlist, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserVo vo = listData.get(position);
        if (!TextUtils.isEmpty(vo.getHeadPic())) {
            Glide.with(mContext).load(vo.getHeadPic()).into(holder.headPic);
        }
        holder.name.setText(vo.getName());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            AnswerListActivity.toActivity(mContext);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData == null ? 0 : listData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.root_view)
        ConstraintLayout rootView;
        @BindView(R.id.head_pic)
        ImageView headPic;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.answer_time)
        TextView answerTime;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
