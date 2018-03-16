package com.imalljoy.insights.mvps.research;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insights.R;
import com.imalljoy.insights.entity.QuestionnaireVo;
import com.imalljoy.insights.greendao.bean.Question;
import com.imalljoy.insights.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/10.
 */

public class QuestionnaireRecyclerAdapter extends RecyclerView.Adapter<QuestionnaireRecyclerAdapter.ViewHolder> {
    List<QuestionnaireVo> listData = null;
    Context mContext = null;

    QuestionnaireRecyclerAdapter(Context context, List<QuestionnaireVo> listData) {
        mContext = context;
        this.listData = new ArrayList<>();
        this.listData = listData;
    }

    public void addData(QuestionnaireVo vo) {
        if (listData != null) {
            listData.add(vo);
            notifyDataSetChanged();
        }
    }

    public void setData(List<QuestionnaireVo> list) {
        if (list != null && list.size() > 0) {
            listData.clear();
            listData = list;
            notifyDataSetChanged();
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_questionnaire, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        QuestionnaireVo vo = listData.get(position);
        Glide.with(mContext).load(vo.getUserVo().getHeadPic()).into(holder.headPic);
        holder.name.setText(vo.getName());
        holder.intro.setText(vo.getContent());
        holder.reward.setText("INB: " + vo.getReward() + "");
        holder.surplus.setText("剩余数量" + (vo.getTotalNumber() - vo.getFinishedNumber()));
        if (vo.getStartTime().getTime() <= System.currentTimeMillis() && System.currentTimeMillis() < vo.getEndTime().getTime()) {
            //在活动期
            holder.startTime.setText(DateUtils.dateToString(new Date(vo.getStartTime().getTime()), DateUtils.DatePattern.ONLY_DAY));
            holder.endTime.setText(DateUtils.dateToString(new Date(vo.getEndTime().getTime()), DateUtils.DatePattern.ONLY_DAY));
            holder.startTime.setTextColor(Color.parseColor("#72d2d6"));
            holder.endTime.setTextColor(Color.parseColor("#72d2d6"));
        } else if (System.currentTimeMillis() < vo.getStartTime().getTime()) {
            //活动未开始
            holder.startTime.setText(DateUtils.dateToString(new Date(vo.getStartTime().getTime()), DateUtils.DatePattern.ONLY_DAY));
            holder.endTime.setText("活动未开始");
            holder.startTime.setTextColor(Color.parseColor("#7b7b7b"));
            holder.endTime.setTextColor(Color.parseColor("#7b7b7b"));
        } else if (vo.getEndTime().getTime() <= System.currentTimeMillis()) {
            //活动已结束
            holder.startTime.setText(DateUtils.dateToString(new Date(vo.getStartTime().getTime()), DateUtils.DatePattern.ONLY_DAY));
            holder.endTime.setText("活动已结束");
            holder.startTime.setTextColor(Color.parseColor("#cccccc"));
            holder.endTime.setTextColor(Color.parseColor("#cccccc"));
        }
        Log.e("time","startTime=" +vo.getStartTime().getTime() + ",system.time=" + System.currentTimeMillis() + ",endTime=" +vo.getEndTime().getTime());

    }

    @Override
    public int getItemCount() {
        return listData == null ? 0 : listData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.head_pic)
        ImageView headPic;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.intro)
        TextView intro;
        @BindView(R.id.reward)
        TextView reward;
        @BindView(R.id.surplus)
        TextView surplus;
        @BindView(R.id.start_time)
        TextView startTime;
        @BindView(R.id.end_time)
        TextView endTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
