package com.Akteon_.sharehelp.data;

public class DiscussionEntity {

    public String authorUid;
    public String topic;
    public String problem;
    public String tag;
    public int likes;

    public DiscussionEntity() {
        authorUid = "";
        topic = "";
        problem = "";
        tag = "";
    }

    public DiscussionEntity(String topic, String authorUid, String tag, String problem) {
        this.topic = topic;
        this.authorUid = authorUid;
        this.tag = tag;
        this.problem = problem;
        likes = 0;
    }

    public String getAuthorUid() {
        return authorUid;
    }

    public String getTopic() {
        return topic;
    }

    public String getProblem() {
        return problem;
    }

    public String getTag() {
        return tag;
    }

    public int getLikes() {
        return likes;
    }
}
