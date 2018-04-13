package com.imalljoy.insightdemo.bus;

/**
 * Created by lijilong on 03/17.
 * 总线通知Viewpager,Framelayout等多选项卡页面跳转
 */

public class JumpFragment {
    private Type type;
    private int index;
    private boolean isRefresh =false;
    private boolean isJump = true;

    public JumpFragment(Type type, int index, boolean isRefresh,boolean isJump) {
        this.type = type;
        this.index = index;
        this.isRefresh = isRefresh;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    public void setRefresh(boolean refresh) {
        isRefresh = refresh;
    }

    public boolean isJump() {
        return isJump;
    }

    public void setJump(boolean jump) {
        isJump = jump;
    }

    //多选项卡组件类型枚举
    public enum Type {
        Research    //调研页多选项卡(ResearchFragment)
    }

}
