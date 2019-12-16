package com.teamwork.yat.ui.latestactivity.adapter.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.squareup.picasso.Picasso;
import com.teamwork.model.ui.activity.LatestActivityListItem;
import com.teamwork.yat.R;
import com.teamwork.yat.ui.utils.CircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LatestItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivUserAvatar)
    ImageView mIvUserAvatar;

    @BindView(R.id.tvActivityType)
    TextView mTvActivityType;

    @BindView(R.id.tvDescription)
    TextView mTvDescription;

    @BindView(R.id.tvDateTime)
    TextView mTvTadeTime;

    public LatestItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(LatestActivityListItem latestActivityListItem) {
        if (latestActivityListItem.getActivityType() != null && !latestActivityListItem.getActivityType().isEmpty()) {
            mTvActivityType.setText(latestActivityListItem.getActivityType());
        }

        if (latestActivityListItem.getDescription() != null && !latestActivityListItem.getDescription().isEmpty()) {
            mTvDescription.setText(latestActivityListItem.getDescription());
        }

        if (latestActivityListItem.getDateTime() != null) {
            mTvTadeTime.setText(TimeAgo.using(latestActivityListItem.getDateTime()));
        }

        if (latestActivityListItem.getUserAvatar() != null && !latestActivityListItem.getUserAvatar().isEmpty()) {
            Picasso.get().load(latestActivityListItem.getUserAvatar())
                    .fit()
                    .transform(new CircleTransform())
                    .placeholder(itemView.getResources().getDrawable(R.drawable.ic_profile))
                    .into(mIvUserAvatar);
        }else{
            mIvUserAvatar.setImageResource(R.drawable.ic_profile_black);
        }
    }
}
