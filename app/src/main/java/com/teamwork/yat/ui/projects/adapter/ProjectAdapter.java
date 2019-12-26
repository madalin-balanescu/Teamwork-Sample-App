package com.teamwork.yat.ui.projects.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teamwork.model.ui.projects.ProjectListItem;
import com.teamwork.yat.R;
import com.teamwork.yat.ui.projects.adapter.viewholders.ProjectHeaderViewHolder;
import com.teamwork.yat.ui.projects.adapter.viewholders.ProjectItemViewHolder;

import java.util.List;

public class ProjectAdapter<T> extends RecyclerView.Adapter {

    private final List<T> projectListItems;
    private final ItemRowClickListener itemRowClickListener;

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;


    public ProjectAdapter(List<T> projectListItem, ItemRowClickListener itemRowClickListener) {
        this.projectListItems = projectListItem;
        this.itemRowClickListener = itemRowClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                return new ProjectHeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_project_header, parent, false));
            case VIEW_TYPE_ITEM:
                return new ProjectItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_project_item, parent, false));
            default:
                throw new IllegalArgumentException("Invalid viewType");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProjectHeaderViewHolder) {
            ((ProjectHeaderViewHolder) holder).bindData((String) projectListItems.get(position));
        } else if (holder instanceof ProjectItemViewHolder) {
            ((ProjectItemViewHolder) holder).bindData((ProjectListItem) projectListItems.get(position), itemRowClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object object = projectListItems.get(position);
        if (object instanceof String) {
            return VIEW_TYPE_HEADER;
        } else if (object instanceof ProjectListItem) {
            return VIEW_TYPE_ITEM;
        } else {
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return projectListItems.size();
    }
}
