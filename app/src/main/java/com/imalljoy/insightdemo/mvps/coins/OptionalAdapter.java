package com.imalljoy.insightdemo.mvps.coins;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseRecyclerAdapter;
import com.imalljoy.insightdemo.entity.CoinVo;

import java.util.List;

/**
 * Created by lijilong on 03/22.
 */

public class OptionalAdapter extends BaseRecyclerAdapter<CoinVo, OptionalAdapter.OptionalHolder> {
    public OptionalAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public OptionalHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_optional, parent, false);
        return new OptionalHolder(itemView);
    }

    class OptionalHolder extends RecyclerView.ViewHolder {
        OptionalHolder(View itemView) {
            super(itemView);
        }
    }
}
