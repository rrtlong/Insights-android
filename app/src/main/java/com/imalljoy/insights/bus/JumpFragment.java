package com.imalljoy.insights.bus;

/**
 * Created by lijilong on 03/17.
 * 总线通知Viewpager,Framelayout等多选项卡页面跳转
 */

public class JumpFragment {
    private Type type;
    private int index;
    private boolean isRefresh =false;

    public JumpFragment(Type type, int index, boolean isRefresh) {
        this.type = type;
        this.index = index;
        this.isRefresh = isRefresh;
    }

    public Type getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    //多选项卡组件类型枚举
    public enum Type {
        Research    //调研页多选项卡(ResearchFragment)
    }

}
