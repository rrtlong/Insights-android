package com.imalljoy.insightdemo.mvps.coins.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseRecyclerAdapter;
import com.imalljoy.insightdemo.entity.NewVo;
import com.imalljoy.insightdemo.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailNewsAdapter extends BaseRecyclerAdapter<NewVo, CoinDetailNewsAdapter.NewsHolder> {


    public CoinDetailNewsAdapter(Context context, List<NewVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_coin_detail_news, parent, false);
        return new NewsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        NewVo vo = listData.get(position);
        holder.title.setText(vo.getName());
        holder.cover.setImageResource(CommonUtils.getNewCoverFromString(vo.getCover()));
    }

    class NewsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.publish_time)
        TextView publishTime;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.readers)
        TextView readers;
        @BindView(R.id.cover)
        ImageView cover;
        public NewsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
