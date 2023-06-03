package com.Akteon_.sharehelp.data;

public class MessageEntity {

    private String authorUid;
    private String text;

    public MessageEntity(String authorUid, String text) {
        this.authorUid = authorUid;
        this.text = text;
    }

    public String getAuthorUid() {
        return authorUid;
    }

    public String getText() {
        return text;
    }
}
