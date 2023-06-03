package com.Akteon_.sharehelp.data;

import java.util.ArrayList;

public class UserEntity {

    private String username;
    private String email;
    private ArrayList<String> interests;
    private String character;
    public ArrayList<String> discussions;

    public UserEntity() {
        username = "";
        email = "";
        interests = new ArrayList<>();
        character = "";
        discussions = new ArrayList<>();
    };

    public UserEntity(String username, String email) {
        this.username = username;
        this.email = email;
        interests = new ArrayList<>();
        character = "";
        discussions = new ArrayList<>();

    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public String getCharacter() {
        return character;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
