package com.imalljoy.insights.mvps.analyst;

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
import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseRecyclerAdapter;
import com.imalljoy.insights.entity.CoinVo;
import com.imalljoy.insights.entity.UserVo;
import com.imalljoy.insights.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lijilong on 04/08.
 */

public class AnalystRankAdapter extends BaseRecyclerAdapter<UserVo, AnalystRankAdapter.AnalystRankHolder> {


    public AnalystRankAdapter(Context context, List<UserVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public AnalystRankHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_analyst_rank, parent, false);
        return new AnalystRankHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnalystRankHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        final UserVo vo = listData.get(position);
        Glide.with(context).load(CommonUtils.getHeadCoverFromString(vo.getHeadPic())).error(R.mipmap.default_head).into(holder.cover);
        holder.name.setText(vo.getName());
        holder.sex.setText(vo.getGender() ==0?"男":"女");
        if(vo.getAnalytsLevel() ==1){
            holder.certificationLevel.setText("I");
        }else if(vo.getAnalytsLevel() ==2){
            holder.certificationLevel.setText("II");
        }else if(vo.getAnalytsLevel() ==3){
            holder.certificationLevel.setText("III");
        }
        if(vo.getAnalytsStars() ==0){
            holder.start1.setImageResource(R.mipmap.icon_star);
            holder.start2.setImageResource(R.mipmap.icon_star);
            holder.start3.setImageResource(R.mipmap.icon_star);
            holder.start4.setImageResource(R.mipmap.icon_star);
            holder.start5.setImageResource(R.mipmap.icon_star);
        }else if(vo.getAnalytsStars() ==1){
            holder.start1.setImageResource(R.mipmap.icon_star_yes);
            holder.start2.setImageResource(R.mipmap.icon_star);
            holder.start3.setImageResource(R.mipmap.icon_star);
            holder.start4.setImageResource(R.mipmap.icon_star);
            holder.start5.setImageResource(R.mipmap.icon_star);
        }else if(vo.getAnalytsStars() ==2){
            holder.start1.setImageResource(R.mipmap.icon_star_yes);
            holder.start2.setImageResource(R.mipmap.icon_star_yes);
            holder.start3.setImageResource(R.mipmap.icon_star);
            holder.start4.setImageResource(R.mipmap.icon_star);
            holder.start5.setImageResource(R.mipmap.icon_star);
        }
        else if(vo.getAnalytsStars() ==3){
            holder.start1.setImageResource(R.mipmap.icon_star_yes);
            holder.start2.setImageResource(R.mipmap.icon_star_yes);
            holder.start3.setImageResource(R.mipmap.icon_star_yes);
            holder.start4.setImageResource(R.mipmap.icon_star);
            holder.start5.setImageResource(R.mipmap.icon_star);
        }
        else if(vo.getAnalytsStars() ==4){
            holder.start1.setImageResource(R.mipmap.icon_star_yes);
            holder.start2.setImageResource(R.mipmap.icon_star_yes);
            holder.start3.setImageResource(R.mipmap.icon_star_yes);
            holder.start4.setImageResource(R.mipmap.icon_star_yes);
            holder.start5.setImageResource(R.mipmap.icon_star);
        }
        else if(vo.getAnalytsStars() ==5){
            holder.start1.setImageResource(R.mipmap.icon_star_yes);
            holder.start2.setImageResource(R.mipmap.icon_star_yes);
            holder.start3.setImageResource(R.mipmap.icon_star_yes);
            holder.start4.setImageResource(R.mipmap.icon_star_yes);
            holder.start5.setImageResource(R.mipmap.icon_star_yes);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnalystInfoActivity.toActivity(context,vo);
            }
        });
    }

    class AnalystRankHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cover)
        ImageView cover;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.sex)
        TextView sex;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.certification_level)
        TextView certificationLevel;
        @BindView(R.id.start_1)
        ImageView start1;
        @BindView(R.id.start_2)
        ImageView start2;
        @BindView(R.id.start_3)
        ImageView start3;
        @BindView(R.id.start_4)
        ImageView start4;
        @BindView(R.id.start_5)
        ImageView start5;
        @BindView(R.id.root_view)
        LinearLayout rootView;

        public AnalystRankHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
