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

public class CurrencyAdapter extends BaseRecyclerAdapter<CoinVo, CurrencyAdapter.CurrencyHolder> {

    public CurrencyAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public CurrencyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_currency, parent, false);
        return new CurrencyHolder(itemView);
    }

    class CurrencyHolder extends RecyclerView.ViewHolder{

        public CurrencyHolder(View itemView) {
            super(itemView);
        }
    }
}
