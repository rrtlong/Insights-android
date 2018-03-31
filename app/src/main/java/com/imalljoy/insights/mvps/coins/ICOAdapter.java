package com.imalljoy.insights.mvps.coins;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
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

    @Override
    public void onBindViewHolder(ICOHolder holder, final int position) {
        super.onBindViewHolder(holder, position);
        CoinVo vo = listData.get(position);
        Glide.with(context).load(vo.getLogoUrl()).error(R.mipmap.dog_logo).placeholder(R.mipmap.dog_logo).into(holder.logo);
        holder.nameShort.setText(vo.getShortName());
        holder.name.setText(vo.getName());
        if(vo.getType() == 1){
            //新上，显示距开始还有多少天
            int days = DateUtils.differentDaysByMillisecond(new Date().getTime(), vo.getIcoTime().getTime());
            if(days >=0){
                holder.status.setText("距开始还有" + days +"天");
            }
        }else if(vo.getType() ==2){
            //即将，显示距开始还有多少天
            int days = DateUtils.differentDaysByMillisecond(new Date().getTime(), vo.getIcoTime().getTime());
            if(days >=0){
                holder.status.setText("距开始还有" + days +"天");
            }
        }else if(vo.getType() ==3){
            //正在进行
            int days = DateUtils.differentDaysByMillisecond(new Date().getTime(),vo.getIcoEndTime().getTime());
            if(days >=0){
                holder.status.setText("距结束还有" + days +"天");
            }
        }else if(vo.getType() == 4){
            holder.status.setText("已结束");
        }else{
            holder.status.setText("");
        }
        holder.roni.setText(vo.getRoni()+"");
        holder.level.setText(vo.getLevel());
        holder.level.setTextColor(ContextCompat.getColor(context,CommonUtils.getColorResourceFromStrg(vo.getLevel())));
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IcoCoinsDetailActivity.toActivity(context,listData.get(position));
            }
        });
    }

    class ICOHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.logo)
        ImageView logo;
        @BindView(R.id.name_short)
        TextView nameShort;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.roni)
        TextView roni;
        @BindView(R.id.level)
        TextView level;
        @BindView(R.id.root_view)
        LinearLayout rootView;
        public ICOHolder(View itemView) {
            super(itemView);
            this.rootView = (LinearLayout) itemView;
            ButterKnife.bind(this, itemView);
        }
    }
}
