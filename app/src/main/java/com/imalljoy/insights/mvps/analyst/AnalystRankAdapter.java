package com.imalljoy.insights.mvps.analyst;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseRecyclerAdapter;
import com.imalljoy.insights.entity.CoinVo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/08.
 */

public class AnalystRankAdapter extends BaseRecyclerAdapter<CoinVo, AnalystRankAdapter.AnalystRankHolder> {


    public AnalystRankAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public AnalystRankHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_analyst_rank, parent, false);
        return new AnalystRankHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnalystRankHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnalystInfoActivity.toActivity(context);
            }
        });
    }

    class AnalystRankHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cover)
        ImageView cover;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.certification_level)
        TextView certificationLevel;
        @BindView(R.id.start_1)
        ImageView start1;
        @BindView(R.id.start_2)
        ImageView start2;
        @BindView(R.id.start_3)
        ImageView start3;
        @BindView(R.id.start_4)
        ImageView start4;
        @BindView(R.id.start_5)
        ImageView start5;
        @BindView(R.id.root_view)
        LinearLayout rootView;

        public AnalystRankHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
