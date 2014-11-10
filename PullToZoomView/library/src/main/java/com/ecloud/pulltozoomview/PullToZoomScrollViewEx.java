package com.ecloud.pulltozoomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2014/11/10  14:25.
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2014/11/10        ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class PullToZoomScrollViewEx extends PullToZoomBase<ScrollView> {

    public PullToZoomScrollViewEx(Context context) {
        this(context, null);
    }

    public PullToZoomScrollViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void pullHeaderToZoom(int newScrollValue) {

    }

    @Override
    public void setHeaderView(View headerView) {

    }

    @Override
    public void setZoomView(View zoomView) {

    }

    @Override
    protected ScrollView createRootView(Context context, AttributeSet attrs) {
        return new ScrollView(context, attrs);
    }

    @Override
    protected void smoothScrollToTop() {

    }

    @Override
    protected boolean isReadyForPullStart() {
        return mRootView.getScrollY() == 0;
    }

    @Override
    public void handleStyledAttributes(TypedArray a) {

    }
}
