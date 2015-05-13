package com.ecloud.pulltozoomview.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import com.ecloud.pulltozoomview.demo.recyclerview.RecyclerViewHeaderAdapter;

/**
 * Created by manishdeora on 13/05/15.
 */
public class PullToZoomRecyclerActivity extends ActionBarActivity {
    private PullToZoomRecyclerViewEx listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_pull_to_zoom_recycler_view);

        listView = (PullToZoomRecyclerViewEx) findViewById(R.id.recyclerview);


        RecyclerViewHeaderAdapter mAdapter = new RecyclerAdapterCustom(this);

//        manager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return adapter.isHeader(position) ? manager.getSpanCount() : 1;
//            }
//        });
        listView.setAdapterAndLayoutManager(mAdapter, new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        AbsListView.LayoutParams localObject = new AbsListView.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        listView.setHeaderLayoutParams(localObject);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.action_normal) {
            listView.setParallax(false);
            return true;
        } else if (id == R.id.action_parallax) {
            listView.setParallax(true);
            return true;
        } else if (id == R.id.action_show_head) {
            listView.setHideHeader(false);
            return true;
        } else if (id == R.id.action_hide_head) {
            listView.setHideHeader(true);
            return true;
        } else if (id == R.id.action_disable_zoom) {
            listView.setZoomEnabled(false);
            return true;
        } else if (id == R.id.action_enable_zoom) {
            listView.setZoomEnabled(true);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public class RecyclerAdapterCustom extends RecyclerViewHeaderAdapter<ViewHolderRecyclerPullToZoom> {
        final String[] adapterData = new String[]{"Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient"};

        public RecyclerAdapterCustom(Context context) {
            super(context);
        }

        @Override
        public int getCount() {
            return adapterData.length;
        }

        @Override
        public ViewHolderRecyclerPullToZoom onCreateContentView(ViewGroup parent, int viewType) {
            return new ViewHolderRecyclerPullToZoom(new TextView(getContext()));
        }

        @Override
        public void onBindView(ViewHolderRecyclerPullToZoom view, int position) {

            view.mtextview.setText(adapterData[position]);
        }
    }

    public static class ViewHolderRecyclerPullToZoom extends RecyclerView.ViewHolder {

        TextView mtextview;

        public ViewHolderRecyclerPullToZoom(View itemView) {
            super(itemView);

            mtextview = (TextView) itemView;
        }
    }
}