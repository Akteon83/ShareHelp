package com.Akteon_.sharehelp.data;

import java.util.ArrayList;

public class UserEntity {

    private String username;
    private String email;
    private ArrayList<String> interests;
    private String character;

    public UserEntity(){}

    public UserEntity(String username, String email) {
        this.username = username;
        this.email = email;
        character = "";
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
}
