package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.Config;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

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

    public void editAd (Ad ad){

//      String query created to edit the ad in question
        try {
            String editQuery = "UPDATE ads SET title = ?, description = ? WHERE id = ?";

            PreparedStatement statemt = connection.prepareStatement(editQuery,Statement.RETURN_GENERATED_KEYS);
            statemt.setLong(1,ad.getId());
            statemt.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Error deleting the ad.",e);
        }

    }

    protected void doPost(HttpServletResponse response, HttpServletRequest request) throws IOException {

        long adId = Long.parseLong(request.getParameter("adId"));
        Ad ad = DaoFactory.getAdsDao().findOne(adId).get(0);

        editAd(ad);

        response.sendRedirect("/profile");
    }





}
