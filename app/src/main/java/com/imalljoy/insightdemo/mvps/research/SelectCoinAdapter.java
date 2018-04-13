package com.imalljoy.insightdemo.mvps.research;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseRecyclerAdapter;
import com.imalljoy.insightdemo.entity.CoinVo;
import com.imalljoy.insightdemo.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/12.
 */

public class SelectCoinAdapter extends BaseRecyclerAdapter<CoinVo, SelectCoinAdapter.SelectCoinHolder> {
    public SelectCoinAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
        Log.e("selected","size=" + list.size());
    }

    @Override
    public SelectCoinAdapter.SelectCoinHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_currency, parent, false);
        return new SelectCoinAdapter.SelectCoinHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SelectCoinAdapter.SelectCoinHolder holder, final int position) {
        super.onBindViewHolder(holder, position);
        CoinVo coinVo = listData.get(position);
        /*holder.num.setText(position + 1 + "");
        holder.num.setVisibility(type == 0? View.VISIBLE:View.GONE);*/
//        Glide.with(context).load(coinVo.getLogoUrl()).error(R.mipmap.dog_logo).into(holder.logo);
        Glide.with(context).load(CommonUtils.getLogoIdFromString(coinVo.getLogoUrl())).error(R.mipmap.dog_logo).into(holder.logo);
        holder.nameShort.setText(coinVo.getShortName());
        holder.name.setText(coinVo.getName());
        holder.price.setText(CommonUtils.formatNumberWithCommaSplit(coinVo.getPrice()));
        holder.marketValue.setText(CommonUtils.formatNumberWithCommaSplit(coinVo.getMarketValue()));
        holder.roni.setText(String.valueOf(coinVo.getRoni()));
        holder.bsri.setText(String.valueOf(coinVo.getBsri()));
        float range = CommonUtils.MathRound(coinVo.getRange() * 100, 2);
        if (range >= 0) {
            holder.range.setText("+" + String.valueOf(range) + "%");
            holder.range.setBackgroundResource(R.drawable.stroke_solid_dd6e48);
        } else {
            holder.range.setText(range + "%");
            holder.range.setBackgroundResource(R.drawable.stroke_solid_5ab67d);
        }
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCustomClickListener != null) {
                    onCustomClickListener.onCustomClick(v, position);
                }
            }
        });
    }

    private OnCustomClickListener onCustomClickListener;

    public void setOnCustomClickListener(OnCustomClickListener onCustomClickListener) {
        this.onCustomClickListener = onCustomClickListener;
    }

    public interface OnCustomClickListener {
        public void onCustomClick(View view, int position);
    }

    class SelectCoinHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.num)
        TextView num;
        @BindView(R.id.logo)
        ImageView logo;
        @BindView(R.id.name_short)
        TextView nameShort;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.market_value)
        TextView marketValue;
        @BindView(R.id.roni)
        TextView roni;
        @BindView(R.id.bsri)
        TextView bsri;
        @BindView(R.id.range)
        TextView range;
        @BindView(R.id.root_view)
        LinearLayout rootView;

        public SelectCoinHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
