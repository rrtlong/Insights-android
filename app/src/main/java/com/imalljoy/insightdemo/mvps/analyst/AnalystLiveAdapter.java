package com.imalljoy.insightdemo.mvps.analyst;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseRecyclerAdapter;
import com.imalljoy.insightdemo.entity.LiveVo;
import com.imalljoy.insightdemo.utils.CommonUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/08.
 */

public class AnalystLiveAdapter extends BaseRecyclerAdapter<LiveVo, AnalystLiveAdapter.AnalystLiveHolder> {


    public AnalystLiveAdapter(Context context, List<LiveVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public AnalystLiveHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_analyst_live, parent, false);
        return new AnalystLiveHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnalystLiveHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        LiveVo vo = listData.get(position);
        Glide.with(context).load(CommonUtils.getHeadCoverFromString(vo.getUserVo().getHeadPic())).error(R.mipmap.default_head).into(holder.cover);
        holder.name.setText(vo.getUserVo().getName());
        holder.content.setText(vo.getTitle());
        if (vo.getEndTime() != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            holder.endTime.setText(df.format(new Date(vo.getEndTime().getTime())));
        }
    }

    class AnalystLiveHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cover)
        ImageView cover;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.start_time)
        TextView startTime;
        @BindView(R.id.end_time)
        TextView endTime;

        public AnalystLiveHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
