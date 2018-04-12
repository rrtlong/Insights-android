package com.imalljoy.insights.mvps.analyst;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseRecyclerAdapter;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.entity.QaVo;
import com.imalljoy.insights.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/08.
 */

public class AnalystQAAdapter extends BaseRecyclerAdapter<QaVo, AnalystQAAdapter.AnalystQAHolder> {


    public AnalystQAAdapter(Context context, List<QaVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public AnalystQAHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_analyst_qa, parent, false);
        return new AnalystQAHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnalystQAHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        QaVo vo = listData.get(position);
        Glide.with(context).load(CommonUtils.getHeadCoverFromString(vo.getLaunchUser().getHeadPic())).error(R.mipmap.default_head).into(holder.cover);
        holder.name.setText(vo.getLaunchUser().getName());
        holder.publishTime.setText(vo.getPublishTime());
        holder.question.setText(vo.getqContent());

        if(!vo.isAnser()){
            holder.noAnswerLayout.setVisibility(View.VISIBLE);
            holder.answeredLayout.setVisibility(View.GONE);
        }else{
            holder.noAnswerLayout.setVisibility(View.GONE);
            holder.answeredLayout.setVisibility(View.VISIBLE);
            holder.replyName.setText(vo.getReplyName()+":");
            holder.replyContent.setText(vo.getReplyContent());
        }
    }

    class AnalystQAHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cover)
        ImageView cover;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.publish_time)
        TextView publishTime;
        @BindView(R.id.follow)
        TextView follow;
        @BindView(R.id.question)
        TextView question;
        @BindView(R.id.reply_name)
        TextView replyName;
        @BindView(R.id.reply_content)
        TextView replyContent;
        @BindView(R.id.answered_layout)
        LinearLayout answeredLayout;
        @BindView(R.id.answer_text)
        TextView answerText;
        @BindView(R.id.no_answer_btn)
        LinearLayout noAnswerBtn;
        @BindView(R.id.no_answer_layout)
        RelativeLayout noAnswerLayout;
        public AnalystQAHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
