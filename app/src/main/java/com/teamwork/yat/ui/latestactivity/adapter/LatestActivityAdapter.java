package com.teamwork.yat.ui.latestactivity.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teamwork.model.ui.activity.LatestActivityListItem;
import com.teamwork.yat.R;
import com.teamwork.yat.ui.latestactivity.adapter.viewholders.LatestHeaderViewHolder;
import com.teamwork.yat.ui.latestactivity.adapter.viewholders.LatestItemViewHolder;

import java.util.List;

public class LatestActivityAdapter<T extends Object> extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    private List<T> latestActivityListItems;

    public LatestActivityAdapter(List<T> latestActivityListItems) {
        this.latestActivityListItems = latestActivityListItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                return new LatestHeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_activity_header, parent, false));
            case VIEW_TYPE_ITEM:
                return new LatestItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_activity_item, parent, false));
            default:
                throw new IllegalArgumentException("Invalid viewType");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LatestHeaderViewHolder) {
            ((LatestHeaderViewHolder) holder).bindData((String) latestActivityListItems.get(position));
        } else if (holder instanceof LatestItemViewHolder) {
            ((LatestItemViewHolder) holder).bindData((LatestActivityListItem) latestActivityListItems.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object object = latestActivityListItems.get(position);
        if (object instanceof String) {
            return VIEW_TYPE_HEADER;
        } else if (object instanceof LatestActivityListItem) {
            return VIEW_TYPE_ITEM;
        } else {
            return -1;
        }
    }


    @Override
    public int getItemCount() {
        return latestActivityListItems.size();
    }
}
