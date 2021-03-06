package com.imalljoy.insightdemo.mvps.research;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.entity.ReportVo;
import com.imalljoy.insightdemo.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/17.
 */

public class ReportRecyclerAdapter extends RecyclerView.Adapter<ReportRecyclerAdapter.ViewHolder> {
    List<ReportVo> listData = null;
    Context mContext = null;

    public ReportRecyclerAdapter(Context context, List<ReportVo> listData) {
        mContext = context;
        this.listData = new ArrayList<>();
        this.listData = listData;
    }

    public void addData(ReportVo vo) {
        if (listData != null) {
            listData.add(vo);
            notifyDataSetChanged();
        }
    }

    public void setData(List<ReportVo> list) {
        if (list != null && list.size() > 0) {
            listData = list;
            notifyDataSetChanged();
        }

    }

    @Override
    public ReportRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_report, parent, false);
        return new ReportRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReportRecyclerAdapter.ViewHolder holder, final int position) {
        ReportVo vo = listData.get(position);
        //数币logo
        if(vo.getRequest().getCoin() != null){
            Glide.with(mContext).load(vo.getRequest().getCoin().getLogoUrl()).error(R.mipmap.dog_logo).into(holder.headPic);
        }else{
            Glide.with(mContext).load(R.mipmap.dog_logo).error(R.mipmap.dog_logo).into(holder.headPic);
        }
        holder.name.setText(vo.getName() == null? "我的报告":vo.getName());
        holder.content.setText(vo.getContent());
        if(vo.getPublishTime() != null){
            holder.publishTime.setText(DateUtils.dateToString(new Date(vo.getPublishTime().getTime()), "yyyy年MM月dd日 HH:mm"));
        }else{
            holder.publishTime.setText("1970年1月1日");
        }
        holder.reward.setText("INB: " + vo.getCost() + "");
        if (vo.getEvalLevel() == 0) {

        } else if (vo.getEvalLevel() == 1) {
            holder.star1.setImageResource(R.mipmap.icon_star_yes);
        } else if (vo.getEvalLevel() ==2) {
            holder.star1.setImageResource(R.mipmap.icon_star_yes);
            holder.star2.setImageResource(R.mipmap.icon_star_yes);
        } else if (vo.getEvalLevel() ==3) {
            holder.star1.setImageResource(R.mipmap.icon_star_yes);
            holder.star2.setImageResource(R.mipmap.icon_star_yes);
            holder.star3.setImageResource(R.mipmap.icon_star_yes);
        } else if (vo.getEvalLevel() ==4) {
            holder.star1.setImageResource(R.mipmap.icon_star_yes);
            holder.star2.setImageResource(R.mipmap.icon_star_yes);
            holder.star3.setImageResource(R.mipmap.icon_star_yes);
            holder.star4.setImageResource(R.mipmap.icon_star_yes);
        } else if (vo.getEvalLevel() ==5) {
            holder.star1.setImageResource(R.mipmap.icon_star_yes);
            holder.star2.setImageResource(R.mipmap.icon_star_yes);
            holder.star3.setImageResource(R.mipmap.icon_star_yes);
            holder.star4.setImageResource(R.mipmap.icon_star_yes);
            holder.star5.setImageResource(R.mipmap.icon_star_yes);
        }
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuildReportActivity.toActivity(mContext, listData.get(position).getRequest(), listData.get(position), listData.get(position).getStatus());
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
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.reward)
        TextView reward;
        @BindView(R.id.publish_time)
        TextView publishTime;
        @BindView(R.id.star_1)
        ImageView star1;
        @BindView(R.id.star_2)
        ImageView star2;
        @BindView(R.id.star_3)
        ImageView star3;
        @BindView(R.id.star_4)
        ImageView star4;
        @BindView(R.id.star_5)
        ImageView star5;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
