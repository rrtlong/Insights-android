package com.imalljoy.insightdemo.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/**
 * Created by lijilong on 04/02.
 */

public class ObservableScrollView extends ScrollView {
    private int downY;
    private int mTouchSlop;
    public ObservableScrollView(Context context) {
        this(context,null);

    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }


    /**
     * 重写的onScrollChanged方法监听坐标
     * 这个监听在源码中没有写成回调的样子，
     * 只是写成了方法的样子，由于修饰这个方法的修饰符是protected，
     * （protected只能在本类，子类，同一包中调用），
     * 所以拿到ScrollView对象后在无法activity中调用此方法，
     * 所以只能重写后，子类中自动调用，
     * 所以要想在activity调用，
     * 就要写回调，
     * 上面就是我写的回调
     * 在Android源码中这种写法很多，在很多控件中都有
     */
    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
       // super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScroll(x, y, oldx, oldy);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downY = (int) e.getRawY();
                Log.e("downy","y=" +downY);
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) e.getRawY();
                Log.e("moveY","delty0=" + (moveY -downY));
                if (Math.abs(moveY - downY) > mTouchSlop) {
                    Log.e("moveY","delty1=" + (moveY -downY));
                    if (scrollViewListener != null) {
                        Log.e("moveY","delty=" + (moveY -downY));
                        scrollViewListener.onScroll(0, (moveY-downY), 0, downY);
                    }
                    return true;
                }
                break;
        }
        return false;
    }


    public interface ScrollViewListener {
        void onScroll(int x, int y, int oldX, int oldY);
    }

    private ScrollViewListener scrollViewListener;

    public void setOnScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

}
