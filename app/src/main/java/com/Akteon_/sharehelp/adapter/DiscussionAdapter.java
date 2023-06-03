package com.Akteon_.sharehelp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Akteon_.sharehelp.R;
import com.Akteon_.sharehelp.data.DiscussionEntity;


public class DiscussionAdapter extends RecyclerView.Adapter<DiscussionAdapter.DiscussionViewHolder> {

    private final LayoutInflater inflater;
    private final DiscussionEntity[] discussions;

    public DiscussionAdapter(LayoutInflater inflater, DiscussionEntity[] discussions) {
        this.inflater = inflater;
        this.discussions = discussions;
    }

    @NonNull
    @Override
    public DiscussionAdapter.DiscussionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_discussion, parent, false);
        return new DiscussionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscussionAdapter.DiscussionViewHolder holder, int position) {
        DiscussionEntity discussion = discussions[position];
        holder.discussionTopic.setText(discussion.getTopic());
        switch (discussion.getTag()) {
            case "sports": holder.tagPicture.setImageResource(R.drawable.svgrepo_sports);
                break;
            case "games": holder.tagPicture.setImageResource(R.drawable.svgrepo_games);
                break;
            case "music": holder.tagPicture.setImageResource(R.drawable.svgrepo_music);
                break;
            case "programming": holder.tagPicture.setImageResource(R.drawable.svgrepo_programming);
                break;
            case "travelling": holder.tagPicture.setImageResource(R.drawable.svgrepo_travelling);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return discussions.length;
    }

    class DiscussionViewHolder extends RecyclerView.ViewHolder {
        final ImageView tagPicture;
        final TextView discussionTopic;

        public DiscussionViewHolder(@NonNull View itemView) {
            super(itemView);
            tagPicture = itemView.findViewById(R.id.tag_picture);
            discussionTopic = itemView.findViewById(R.id.discussion_topic);
        }
    }
}
