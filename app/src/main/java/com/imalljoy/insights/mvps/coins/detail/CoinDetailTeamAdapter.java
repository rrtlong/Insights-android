package com.imalljoy.insights.mvps.coins.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseRecyclerAdapter;
import com.imalljoy.insights.entity.CoinVo;

import java.util.List;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailTeamAdapter extends BaseRecyclerAdapter<CoinVo,CoinDetailTeamAdapter.TeamHolder> {

    public CoinDetailTeamAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_coin_detail_team, parent, false);
        return new TeamHolder(view);
    }

    class TeamHolder extends RecyclerView.ViewHolder{

        public TeamHolder(View itemView) {
            super(itemView);
        }
    }
}
