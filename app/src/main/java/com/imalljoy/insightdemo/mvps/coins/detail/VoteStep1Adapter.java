package com.imalljoy.insightdemo.mvps.coins.detail;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseRecyclerAdapter;
import com.imalljoy.insightdemo.entity.CoinVo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/04.
 */

public class VoteStep1Adapter extends BaseRecyclerAdapter<CoinVo, VoteStep1Adapter.VoteListHolder> {

    public VoteStep1Adapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public VoteListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_votestep1, parent, false);
        return new VoteListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VoteListHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (position % 2 == 0) {
            holder.reward.setTextColor(ContextCompat.getColor(context, R.color.c_dd6e48));
        } else {
            holder.reward.setTextColor(ContextCompat.getColor(context, R.color.c_5ab67d));
        }
        if(type ==0){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    VoteStep2Activity.toActivity(context);
                }
            });
        }

    }

    class VoteListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.logo)
        ImageView logo;
        @BindView(R.id.name_short)
        TextView nameShort;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.reward)
        TextView reward;
        @BindView(R.id.root_view)
        LinearLayout rootView;

        public VoteListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
