package com.ecloud.pulltozoomview.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ecloud.pulltozoomview.PullToZoomScrollView;
import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2014/9/4  17:30.
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2014/9/4        ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class PullToZoomScrollActivity extends ActionBarActivity {

    private PullToZoomScrollViewEx scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_scroll_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        scrollView = (PullToZoomScrollViewEx) findViewById(R.id.scroll_view);
        scrollView.getRootView().findViewById(R.id.tv_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zhuwenwu", "onClick -->");
            }
        });
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.scroll_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
//        else if (id == R.id.action_settings) {
//            loadViewForCode();
//            return true;
//        }
        else if (id == R.id.action_normal) {
            scrollView.setParallax(false);
            return true;
        } else if (id == R.id.action_parallax) {
            scrollView.setParallax(true);
            return true;
        } else if (id == R.id.action_show_head) {
//            scrollView.showHeaderView();
            scrollView.setHideHeader(false);
            return true;
        } else if (id == R.id.action_hide_head) {
//            scrollView.hideHeaderView();
            scrollView.setHideHeader(true);
            return true;
        } else if (id == R.id.action_disable_zoom) {
//            scrollView.setEnableZoom(false);
            scrollView.setZoomEnabled(false);
            return true;
        } else if (id == R.id.action_enable_zoom) {
//            scrollView.setEnableZoom(true);
            scrollView.setZoomEnabled(true);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadViewForCode() {
        PullToZoomScrollView scrollView = (PullToZoomScrollView) findViewById(R.id.scroll_view);
        View headView = LayoutInflater.from(this).inflate(R.layout.profile_head_view, null, false);
        View zoomView = LayoutInflater.from(this).inflate(R.layout.profile_zoom_view, null, false);
        View contentView = LayoutInflater.from(this).inflate(R.layout.profile_content_view, null, false);
        scrollView.setHeaderContainer(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setContentContainerView(contentView);
    }
}
