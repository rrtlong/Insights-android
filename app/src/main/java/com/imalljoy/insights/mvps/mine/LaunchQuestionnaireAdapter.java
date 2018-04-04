package com.imalljoy.insights.mvps.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insights.R;
import com.imalljoy.insights.base.BaseRecyclerAdapter;
import com.imalljoy.insights.entity.UserVo;

import java.util.List;

/**
 * Created by lijilong on 04/04.
 */

public class LaunchQuestionnaireAdapter extends BaseRecyclerAdapter<UserVo, LaunchQuestionnaireAdapter.UserHolder> {
    public LaunchQuestionnaireAdapter(Context context, List<UserVo> list, int type) {
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
