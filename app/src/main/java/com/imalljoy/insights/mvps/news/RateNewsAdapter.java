package com.imalljoy.insights.mvps.news;

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
 * Created by lijilong on 04/08.
 */

public class RateNewsAdapter extends BaseRecyclerAdapter<CoinVo, RateNewsAdapter.RateNewsHolder> {
    public RateNewsAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public RateNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_rate_news, parent, false);
        return new RateNewsHolder(itemView);
    }

    class RateNewsHolder extends RecyclerView.ViewHolder {

        public RateNewsHolder(View itemView) {
            super(itemView);
        }
    }
}
