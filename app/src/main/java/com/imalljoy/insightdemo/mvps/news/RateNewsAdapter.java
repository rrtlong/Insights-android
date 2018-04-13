package com.imalljoy.insightdemo.mvps.news;

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
import com.imalljoy.insightdemo.entity.NewRateVo;
import com.imalljoy.insightdemo.utils.CommonUtils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/08.
 */

public class RateNewsAdapter extends BaseRecyclerAdapter<NewRateVo, RateNewsAdapter.RateNewsHolder> {


    public RateNewsAdapter(Context context, List<NewRateVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public RateNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_rate_news, parent, false);
        return new RateNewsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RateNewsHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        NewRateVo vo = listData.get(position);
        Glide.with(context).load(CommonUtils.getHeadCoverFromString(vo.getCover())).error(R.mipmap.default_head).into(holder.cover);
        holder.name.setText(vo.getName());
        holder.title.setText(vo.getTitle());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if(vo.getPublishTime() != null){
            holder.publishTime.setText(format.format(new Date(vo.getPublishTime().getTime())));
        }
    }

    class RateNewsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cover)
        ImageView cover;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.publish_time)
        TextView publishTime;
        public RateNewsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
