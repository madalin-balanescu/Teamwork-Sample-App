package com.teamwork.yat.ui.latestactivity.adapter.viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teamwork.yat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LatestHeaderViewHolder extends RecyclerView.ViewHolder  {

    @BindView(R.id.tvName)
    TextView mTvName;

    public LatestHeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(String title) {
        if (title != null && !title.isEmpty()) {
            mTvName.setText(title);
        }
    }
}
