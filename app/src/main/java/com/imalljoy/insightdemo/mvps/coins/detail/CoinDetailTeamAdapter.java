package com.imalljoy.insightdemo.mvps.coins.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseRecyclerAdapter;
import com.imalljoy.insightdemo.entity.UserVo;
import com.imalljoy.insightdemo.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 03/30.
 */

public class CoinDetailTeamAdapter extends BaseRecyclerAdapter<UserVo, CoinDetailTeamAdapter.TeamHolder> {


    public CoinDetailTeamAdapter(Context context, List<UserVo> list, int type) {
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
        UserVo vo = listData.get(position);
        holder.name.setText(vo.getName());
        Glide.with(context).load(CommonUtils.getHeadCoverFromString(vo.getHeadPic())).error(R.mipmap.default_head).into(holder.cover);
        holder.professional.setText(vo.getExtraInfo());
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
        @BindView(R.id.cover)
        ImageView cover;
        @BindView(R.id.professional)
        TextView professional;

        public TeamHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
