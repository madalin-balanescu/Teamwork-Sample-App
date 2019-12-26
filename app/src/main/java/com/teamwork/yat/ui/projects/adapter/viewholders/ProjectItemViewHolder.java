package com.teamwork.yat.ui.projects.adapter.viewholders;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.squareup.picasso.Picasso;
import com.teamwork.model.response.projects.Tag;
import com.teamwork.model.ui.projects.ProjectListItem;
import com.teamwork.yat.R;
import com.teamwork.yat.ui.projects.adapter.ItemRowClickListener;
import com.teamwork.yat.ui.utils.CircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProjectItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvName)
    TextView mTvName;

    @BindView(R.id.tvCompanyName)
    TextView mTvCompanyName;

    @BindView(R.id.ivUserAvatar)
    ImageView mIvUserAvatar;

    @BindView(R.id.layUserAvatars)
    LinearLayout mLayUserAvatars;

    @BindView(R.id.tvDescription)
    TextView mTvDescription;

    @BindView(R.id.cgTags)
    ChipGroup mCgTags;

    @OnClick(R.id.layCurrent)
    void cardView() {
        if (itemRowClickListener != null && projectListItem != null) {
            itemRowClickListener.projectItemSelected(projectListItem.getName());
        }
    }
    private ItemRowClickListener itemRowClickListener;
    private ProjectListItem projectListItem;

    private final String[] usersAvatars = {"https://s3.amazonaws.com/TWFiles/349705/userAvatar/tf_C21F3016-CD19-C60F-E82B23120C506FEE.Tac_the_Psychotic_Cat.jpg",
            "https://s3.amazonaws.com/TWFiles/349705/userAvatar/tf_60D05E04-FB67-7583-F8AD89B08240F134.181295_551377581579663_1606496645_n.jpg",
            "https://s3.amazonaws.com/TWFiles/349705/userAvatar/twia_4c1367ef2d41f1e590fe3819470ec7a9.png/1fe9b480baf5002dce4d26ec5ba2239f.png"};

    public ProjectItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(ProjectListItem projectListItem, ItemRowClickListener itemRowClickListener) {
        this.itemRowClickListener = itemRowClickListener;
        this.projectListItem = projectListItem;

        setTexts(projectListItem);
        loadImages();
        loadTags(projectListItem);
    }


    private void setTexts(ProjectListItem projectListItem) {
        if (projectListItem.getName() != null && !projectListItem.getName().isEmpty()) {
            mTvName.setText(projectListItem.getName());
        }

        if (projectListItem.getCompanyName() != null && !projectListItem.getCompanyName().isEmpty()) {
            mTvCompanyName.setText(projectListItem.getCompanyName());
        }

        if (projectListItem.getDescription() != null && !projectListItem.getDescription().isEmpty()) {
            mTvDescription.setText(projectListItem.getDescription());
        }
    }

    private void loadImages() {
        Picasso.get().load("https://s3.amazonaws.com/TWFiles/349705/userAvatar/tf_C21F3016-CD19-C60F-E82B23120C506FEE.Tac_the_Psychotic_Cat.jpg")
                .fit()
                .transform(new CircleTransform())
                .into(mIvUserAvatar);

        loadUsersAvatars();

    }

    private void loadTags(ProjectListItem projectListItem) {
        if (projectListItem.getTags() != null && !projectListItem.getTags().isEmpty()) {
            for (Tag tag : projectListItem.getTags()) {
                Chip chip = new Chip(itemView.getContext());
                chip.setText(tag.getName());
                chip.setTextColor(Color.WHITE);
                chip.setCloseIconVisible(true);

                if (tag.getColor() != null && !tag.getColor().isEmpty()) {
                    int color = Color.parseColor(tag.getColor());
                    chip.setChipBackgroundColor(ColorStateList.valueOf(color));
                } else {
                    int color = Color.DKGRAY;
                    chip.setChipBackgroundColor(ColorStateList.valueOf(color));
                }
                mCgTags.addView(chip);
            }
        }
    }

    private void loadUsersAvatars() {

        for (int i = 0; i < usersAvatars.length; i++) {
            ImageView ivAvatar = new ImageView(itemView.getContext());
            ivAvatar.setId(i);
            ivAvatar.setTag(i);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, itemView.getResources().getDimensionPixelOffset(R.dimen.users_avatar_margins), 0);

            ivAvatar.setLayoutParams(layoutParams);

            mLayUserAvatars.addView(ivAvatar);

            Picasso.get().load(usersAvatars[i])
                    .resize(itemView.getResources().getDimensionPixelOffset(R.dimen.other_avatar_size), itemView.getResources().getDimensionPixelOffset(R.dimen.other_avatar_size))
                    .transform(new CircleTransform())
                    .into(ivAvatar);
        }

    }
}
