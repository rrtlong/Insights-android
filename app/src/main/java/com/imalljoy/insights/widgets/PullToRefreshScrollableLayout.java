package com.imalljoy.insights.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;

/**
 * Created by lijilong on 04/03.
 */

public class PullToRefreshScrollableLayout extends PullToRefreshBase<ScrollableLayout>{
    public PullToRefreshScrollableLayout(Context context) {
        super(context);
    }

    public PullToRefreshScrollableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshScrollableLayout(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshScrollableLayout(Context context, Mode mode, AnimationStyle style) {
        super(context, mode, style);
    }

    @Override
    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    @Override
    protected ScrollableLayout createRefreshableView(Context context, AttributeSet attrs) {
        ScrollableLayout linearLayout;

        linearLayout = new ScrollableLayout(context, attrs);

        linearLayout.setId(com.handmark.pulltorefresh.library.R.id.scrollablelayout);
        return linearLayout;
    }

    protected boolean isReadyForPullStart() {
        return getRefreshableView().getScrollY() == 0;
    }

    @Override
    protected boolean isReadyForPullEnd() {
        View scrollViewChild = getRefreshableView().getChildAt(0);
        if (null != scrollViewChild) {
            return getRefreshableView().getScrollY() >= (scrollViewChild.getHeight() - getHeight());
        }
        return false;
    }
}

