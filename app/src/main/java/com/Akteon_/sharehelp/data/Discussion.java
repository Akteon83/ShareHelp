package com.Akteon_.sharehelp.data;

import com.Akteon_.sharehelp.data.User;

import java.util.HashSet;

public class Discussion {

    public String title;
    public final User author;
    public HashSet<String> tags;
    public String description;

    public Discussion(String title, User author, HashSet<String> tags, String description) {
        this.title = title;
        this.author = author;
        this.tags = tags;
        this.description = description;
    }
}
