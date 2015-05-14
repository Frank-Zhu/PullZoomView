/*
 * Created by Krishan Patel.
 * Copyright (c) 2014. Rocko Labs Ltd. All Rights Reserved.
 */

package com.ecloud.pulltozoomview.demo.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerViewHeaderAdapter<V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {
    public static final int INT_TYPE_HEADER = 0;
    public static final int INT_TYPE_FOOTER = 1;

    public static class ExtraItem<V extends RecyclerView.ViewHolder> {
        public final int type;
        public final V view;

        public ExtraItem(int type, V view) {
            this.type = type;
            this.view = view;
        }

    }

    private View emptyView;

    private final Context context;
    private final List<ExtraItem> headers;
    private final List<ExtraItem> footers;

    public RecyclerViewHeaderAdapter(Context context) {
        this.context = context;
        this.headers = new ArrayList<ExtraItem>();
        this.footers = new ArrayList<ExtraItem>();
    }

    public Context getContext() {
        return context;
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
        emptyView.setVisibility(getCount() == 0 ? View.VISIBLE : View.GONE);
    }

    public abstract int getCount();

    @Override
    public final int getItemCount() {
        int count = headers.size();
        count += getCount();
        count += footers.size();

        if (emptyView != null)
            emptyView.setVisibility(getCount() == 0 ? View.VISIBLE : View.GONE);

        return count;
    }

    public ExtraItem addHeaderView(int type, V headerView) {
        ExtraItem item = new ExtraItem(type, headerView);
        addHeaderView(item);
        return item;
    }

    public void addHeaderView(ExtraItem headerView) {
        headers.add(headerView);
        notifyItemInserted(headers.size());
    }

    public void removeHeaderView(int type) {
        List<ExtraItem> indexesToRemove = new ArrayList<ExtraItem>();
        for (int i = 0; i < headers.size(); i++) {
            ExtraItem item = headers.get(i);
            if (item.type == type)
                indexesToRemove.add(item);
        }

        for (ExtraItem item : indexesToRemove) {
            int index = headers.indexOf(item);
            headers.remove(item);
            notifyItemRemoved(index);
        }
    }

    public void removeHeaderView(ExtraItem headerView) {
        int indexToRemove = headers.indexOf(headerView);
        if (indexToRemove >= 0) {
            headers.remove(indexToRemove);
            notifyItemRemoved(indexToRemove);
        }
    }

    public ExtraItem addFooterView(int type, V footerView) {
        ExtraItem item = new ExtraItem(type, footerView);
        addFooterView(item);
        return item;
    }

    public void addFooterView(ExtraItem footerView) {
        footers.add(footerView);
        notifyItemInserted(getItemCount());
    }

    public void removeFooterView(int type) {
        List<ExtraItem> indexesToRemove = new ArrayList<ExtraItem>();
        for (int i = 0; i < footers.size(); i++) {
            ExtraItem item = footers.get(i);
            if (item.type == type)
                indexesToRemove.add(item);
        }

        for (ExtraItem item : indexesToRemove) {
            int index = footers.indexOf(item);
            footers.remove(item);
            notifyItemRemoved(headers.size() + getCount() + index);
        }
    }

    public void removeFooterView(ExtraItem footerView) {
        int indexToRemove = footers.indexOf(footerView);
        if (indexToRemove >= 0) {
            footers.remove(indexToRemove);
            notifyItemRemoved(headers.size() + getCount() + indexToRemove);
        }
    }

    public int getViewType(int position) {
        return super.getItemViewType(position);
    }


    public ExtraItem getHeader(int mIntArgHeaderPos) {

        if (headers != null && headers.size() > mIntArgHeaderPos) {
            return headers.get(mIntArgHeaderPos);
        }
        return null;
    }

    @Override
    public final int getItemViewType(int position) {
        if (position < headers.size())
            return INT_TYPE_HEADER;
        else
            return INT_TYPE_FOOTER;
//        return getViewType(position - headers.size());
    }

    @Override
    public final V onCreateViewHolder(ViewGroup parent, int viewType) {
        for (ExtraItem<V> item : headers)
            if (viewType == item.type)
                return item.view;

        for (ExtraItem<V> item : footers)
            if (viewType == item.type)
                return item.view;

        return onCreateContentView(parent, viewType);
    }

    public abstract V onCreateContentView(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position >= headers.size() && (position - headers.size()) < getCount()) {
            //noinspection unchecked
            onBindView((V) holder, position - headers.size());
        } else {

            try {
                final StaggeredGridLayoutManager.LayoutParams lp =
                        (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
//
                lp.setFullSpan(true);
                ;

                holder.itemView.setLayoutParams(lp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void onBindView(V view, int position);

}