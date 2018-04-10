package com.imalljoy.insights.mvps.coins;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseRecyclerAdapter;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.utils.CommonUtils;
import com.imalljoy.insights.utils.DateUtils;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/29.
 */

public class AirdropAdapter extends BaseRecyclerAdapter<CoinVo, AirdropAdapter.AirdropHolder> {


    public AirdropAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public AirdropHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_airdrop, parent, false);
        return new AirdropHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AirdropHolder holder, final int position) {
        super.onBindViewHolder(holder, position);
        CoinVo vo = listData.get(position);
        Glide.with(context).load(vo.getLogoUrl()).error(R.mipmap.dog_logo).placeholder(R.mipmap.dog_logo).into(holder.logo);
        holder.nameShort.setText(vo.getShortName());
        holder.name.setText(vo.getName());
//        if (DateUtils.isBefore(vo.getIcoEndTime().getTime(), new Date().getTime())) {
//            holder.status.setText("已结束");
//        } else if (DateUtils.isBefore(new Date().getTime(), vo.getIcoTime().getTime())) {
//            holder.status.setText("距开始" + DateUtils.differentDaysByMillisecond(new Date().getTime(), vo.getIcoTime().getTime()) + "天");
//        } else if (DateUtils.isBefore(vo.getIcoTime().getTime(), new Date().getTime()) && DateUtils.isBefore(new Date().getTime(), vo.getIcoEndTime().getTime())) {
//            holder.status.setText("距结束" + DateUtils.differentDaysByMillisecond(new Date().getTime(), vo.getIcoEndTime().getTime()) + "天");
//        } else {
//            holder.status.setText("");
//        }
//        if (position == getItemCount() - 1) {
//            holder.price.setText("未上市");
//        } else {
//            holder.price.setText(String.valueOf(vo.getPrice()));
//        }
        holder.status.setText("正在进行中");
        holder.price.setText(CommonUtils.formatNumberWithCommaSplit(vo.getPrice()));
        holder.num.setText(vo.getAirDropNum() + "个");
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IcoCoinsDetailActivity.toActivity(context, listData.get(position));
            }
        });
    }

    class AirdropHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.logo)
        ImageView logo;
        @BindView(R.id.name_short)
        TextView nameShort;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.num)
        TextView num;
        @BindView(R.id.root_view)
        LinearLayout rootView;

        public AirdropHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
