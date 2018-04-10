package com.imalljoy.insights.mvps.coins.detail;

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
import com.imalljoy.insights.mvps.mine.EnterpriseExport2DetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailEnterpriseExposeAdapter extends BaseRecyclerAdapter<CoinVo, CoinDetailEnterpriseExposeAdapter.EnterpriseExposeHolder> {



    public CoinDetailEnterpriseExposeAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public EnterpriseExposeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_coin_detail_enterprise_expose, parent, false);
        return new EnterpriseExposeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EnterpriseExposeHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type ==0){
                    EnterpriseExposeDetailActivity.toActivity(context);
                }else{
                    EnterpriseExport2DetailActivity.toActivity(context);
                }
            }
        });
    }

    class EnterpriseExposeHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.publish_time)
        TextView publishTime;
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
        @BindView(R.id.more_icon)
        ImageView moreIcon;
        @BindView(R.id.root_view)
        LinearLayout rootView;
        public EnterpriseExposeHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
