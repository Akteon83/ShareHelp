package com.Akteon_.sharehelp.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DiscussionEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public final int authorId;
    public String topic;
    public String problem;
    public String tag;
    public int likes;

    public DiscussionEntity(String topic, int authorId, String tag, String description) {
        this.topic = topic;
        this.authorId = authorId;
        this.tag = tag;
        this.problem = description;
    }
}
