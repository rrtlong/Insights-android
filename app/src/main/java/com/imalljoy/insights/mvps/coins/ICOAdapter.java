package com.imalljoy.insights.mvps.coins;

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
 * Created by lijilong on 03/22.
 */

public class ICOAdapter extends BaseRecyclerAdapter<CoinVo, ICOAdapter.ICOHolder> {
    public ICOAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public ICOHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_ico, parent, false);
        return new ICOHolder(itemView);
    }

    class ICOHolder extends RecyclerView.ViewHolder {

        public ICOHolder(View itemView) {
            super(itemView);
        }
    }
}
