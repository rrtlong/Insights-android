package com.imalljoy.insightdemo.mvps.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insightdemo.R;
import com.imalljoy.insightdemo.base.BaseRecyclerAdapter;
import com.imalljoy.insightdemo.entity.UserVo;

import java.util.List;

/**
 * Created by lijilong on 04/04.
 */

public class AcceptQuestionnaireAdapter extends BaseRecyclerAdapter<UserVo, AcceptQuestionnaireAdapter.UserHolder> {
    public AcceptQuestionnaireAdapter(Context context, List<UserVo> list, int type) {
        super(context, list, type);
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item_userlist_2, parent, false);
        return new UserHolder(itemView);
    }

    class UserHolder extends RecyclerView.ViewHolder {

        public UserHolder(View itemView) {
            super(itemView);
        }
    }
}
