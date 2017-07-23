package com.robinhood.librarysample.data;


import com.robinhood.librarysample.base.model.Model;

public class User extends Model {
    int id;
    String login;
    String avatarUrl;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "avatarUrl='" + avatarUrl + '\'' +
                ", login='" + login + '\'' +
                ", id=" + id +
                '}';
    }
}
