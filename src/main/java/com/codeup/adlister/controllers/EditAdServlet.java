package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "EditAdServlet", urlPatterns = "/editAd")
public class EditAdServlet extends HttpServlet {


    //    Creates a new instance of Config
    Config config = new Config();

    private String ConfigUrl = config.getUrl();
    private String username = config.getUser();
    private String password = config.getPassword();

    private Connection connection = null;

    public EditAdServlet() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassword());


        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!",e);

        }
    }

    public void editAd (User user){

//        String query created to edit the ad in question
        String editAd = "";


    }





}
