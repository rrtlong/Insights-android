package com.imalljoy.insightdemo.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lijilong on 03/22.
 */

public class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected Context context;
    protected int type;
    protected List<T> listData;
    public OnClickListener onClickListener;

    public BaseRecyclerAdapter(Context context, List<T> list, int type) {
        this.context = context;
        this.listData = list;
        this.type = type;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        Log.e("count",listData.size()+"");
        return listData == null ? 0 : listData.size();
    }

    public void addData(T vo) {
        if (listData != null) {
            listData.add(vo);
            notifyDataSetChanged();
        }
    }

    public void setData(List<T> list) {
        if (list != null) {
            listData = list;
            notifyDataSetChanged();
        }

    }
    public interface OnClickListener{
        public void onClick(View view,int position);
    }

    public void setOnClickListener(OnClickListener listener){
        this.onClickListener = listener;
    }

}
