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

public class CoinDetailNewsAdapter extends BaseRecyclerAdapter<CoinVo, CoinDetailNewsAdapter.NewsHolder> {
    public CoinDetailNewsAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_coin_detail_news, parent, false);
        return new NewsHolder(itemView);
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        public NewsHolder(View itemView) {
            super(itemView);
        }
    }
}
