package com.ecloud.pulltozoomview.demo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.ecloud.pulltozoomview.PullToZoomListView;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2014/9/4  17:11.
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2014/9/4        ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class PullToZoomListActivity extends ActionBarActivity {

    private PullToZoomListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_list_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (PullToZoomListView) findViewById(R.id.listview);

        String[] adapterData = new String[]{"Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient"};

        listView.setAdapter(new ArrayAdapter<String>(PullToZoomListActivity.this, android.R.layout.simple_list_item_1, adapterData));
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
        }else if (id == R.id.action_show_head) {
            listView.showHeadView();
            return true;
        } else if (id == R.id.action_hide_head) {
            listView.hideHeadView();
            return true;
        }else if (id == R.id.action_disable_zoom) {
            listView.setEnableZoom(false);
            return true;
        } else if (id == R.id.action_enable_zoom) {
            listView.setEnableZoom(true);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
