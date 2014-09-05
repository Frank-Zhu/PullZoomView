package com.ecloud.pulltozoomview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_zoom_list_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PullToZoomListView listView = (PullToZoomListView) findViewById(R.id.listview);

        String[] adapterData = new String[]{"Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient"};

        listView.setAdapter(new ArrayAdapter<String>(PullToZoomListActivity.this, android.R.layout.simple_list_item_1, adapterData));
//        listView.getHeaderView().setImageResource(R.drawable.splash01);
//        listView.getHeaderView().setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
