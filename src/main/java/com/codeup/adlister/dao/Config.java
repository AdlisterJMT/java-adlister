package com.codeup.adlister.dao;

public class Config {
    private String url;
    private String user;
    private String password;

    public String getUrl() {
        if(url == null){
            url = "jdbc:mysql://localhost/music_adlister_db?serverTimezone=UTC&useSSL=false";
        }
        return url;
    }
    public String getUser() {
        if(user == null){
            user = "codyTheDuck";
        }
        return user;
    }
    public String getPassword() {
        if(password == null){
            password = "cody";
        }
        return password;
    }

}


