package com.imalljoy.insights.mvps.coins.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseRecyclerAdapter;
import com.imalljoy.insights.entity.CoinVo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailTeamAdapter extends BaseRecyclerAdapter<CoinVo, CoinDetailTeamAdapter.TeamHolder> {


    public CoinDetailTeamAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_coin_detail_team, parent, false);
        return new TeamHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamHolder holder, final int position) {
        super.onBindViewHolder(holder, position);
//        if(onClickListener != null){
//            holder.rootView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onClickListener.onClick(v,position);
//                }
//            });
//        }
        holder.rootView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TeamDetailActivity.toActivity(context);
            }
        });
    }

    class TeamHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.root_view)
        LinearLayout rootView;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.professional)
        TextView professional;

        public TeamHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
