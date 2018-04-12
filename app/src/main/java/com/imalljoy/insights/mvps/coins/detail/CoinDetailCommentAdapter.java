package com.imalljoy.insights.mvps.coins.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseRecyclerAdapter;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.entity.CommentVo;
import com.imalljoy.insights.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailCommentAdapter extends BaseRecyclerAdapter<CommentVo, CoinDetailCommentAdapter.CommentHolder> {


    public CoinDetailCommentAdapter(Context context, List<CommentVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_coin_detail_comment, parent, false);
        return new CommentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        CommentVo vo = listData.get(position);
        Glide.with(context).load(CommonUtils.getHeadCoverFromString(vo.getLaunchUser().getHeadPic())).error(R.mipmap.default_head).into(holder.cover);
        holder.name.setText(vo.getReplyName());
        holder.publishTime.setText(vo.getPublishTime());
        holder.content.setText(vo.getContent());
        holder.replyName.setText(vo.getReplyName()+":");
        holder.replayContent.setText(vo.getReplyContent());
    }

    class CommentHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cover)
        ImageView cover;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.publish_time)
        TextView publishTime;
        @BindView(R.id.comment_icon)
        ImageView commentIcon;
        @BindView(R.id.like_num)
        TextView likeNum;
        @BindView(R.id.like_icon)
        ImageView likeIcon;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.reply_name)
        TextView replyName;
        @BindView(R.id.replay_content)
        TextView replayContent;
        @BindView(R.id.more_comment_layout)
        LinearLayout moreCommentLayout;

        public CommentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
