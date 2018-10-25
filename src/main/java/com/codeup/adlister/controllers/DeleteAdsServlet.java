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

@WebServlet(name = "controllers.DeleteProfileServlet", urlPatterns = "/deleteAd")
public class DeleteAdsServlet extends HttpServlet {

    //    Creates a new instance of Config
    Config config = new Config();

    private String ConfigUrl = config.getUrl();
    private String username = config.getUser();
    private String password = config.getPassword();


    private Connection connection = null;

    public DeleteAdsServlet() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassword());

        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!",e);
        }
    }


//    Possible goal to move method to DOA
    public void deleteAds(Ad ad) {

        try {
            //This block of code sets the query for the mySQL database and deletes any ads associated to the user.
            String deleteAds = "delete from ads where id = ?";

            //Makes the connection to the database
            PreparedStatement statemt = connection.prepareStatement(deleteAds,Statement.RETURN_GENERATED_KEYS);
            statemt.setLong(1,ad.getId());
            statemt.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException("Error deleting the ad.",e);
        }

    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        /**
         * Creates a user object var, that takes the session request and gets the attribute for the user
         * Cast the request as a user object to maintain compatibility.
         */


        long adId = Long.parseLong(request.getParameter("adId"));
        Ad ad = DaoFactory.getAdsDao().findOne(adId);

        //Runs the method deleteUser
        deleteAds(ad);

        //Invalidates the current session

        //Once the user has been deleted, this will redirect to the index/home page
        response.sendRedirect("/profile");


    }
}
