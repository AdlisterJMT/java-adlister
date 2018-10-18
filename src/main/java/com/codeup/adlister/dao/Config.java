package com.codeup.adlister.dao;

public class Config {
    private String url  =  "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    private String user = "user1";
    private String password = "password123";


    public Config() {
    }

    public String getUrl() {
        return url;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
}