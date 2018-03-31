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

public class CoinDetailCommentAdapter extends BaseRecyclerAdapter<CoinVo,CoinDetailCommentAdapter.CommentHolder>{

    public CoinDetailCommentAdapter(Context context, List<CoinVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_coin_detail_comment, parent, false);
        return new CommentHolder(itemView);
    }

    class CommentHolder extends RecyclerView.ViewHolder{

        public CommentHolder(View itemView) {
            super(itemView);
        }
    }
}
