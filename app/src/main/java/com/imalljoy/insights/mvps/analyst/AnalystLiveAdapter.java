package com.imalljoy.insights.mvps.analyst;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseRecyclerAdapter;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.entity.UserVo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/08.
 */

public class AnalystLiveAdapter extends BaseRecyclerAdapter<UserVo, AnalystLiveAdapter.AnalystLiveHolder> {



    public AnalystLiveAdapter(Context context, List<UserVo> list, int type) {
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
        if(position ==0){
            holder.content.setText("比特币走势分析");
        }else if(position ==1){
            holder.content.setText("ETH币上市进展");
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
