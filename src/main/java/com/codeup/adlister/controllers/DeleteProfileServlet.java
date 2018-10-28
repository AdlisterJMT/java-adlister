package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet(name = "DeleteProfileServlet", urlPatterns = "/deleteProfile")
public class DeleteProfileServlet extends HttpServlet {


    //    Creates a new instance of Config
    Config config = new Config();

    private String ConfigUrl = config.getUrl();
    private String username = config.getUser();
    private String password = config.getPassword();


    private Connection connection = null;


    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        /**
         * Creates a user object var, that takes the session request and gets the attribute for the user
         * Cast the request as a user object to maintain compatibility.
         **/

        User user = (User) request.getSession().getAttribute("user");


        //Runs the method deleteUser
        deleteUser(user);

        //Invalidates the current session
        request.getSession().invalidate();

        //Once the user has been deleted, this will redirect to the index/home page
        response.sendRedirect("/");


    }

    public DeleteProfileServlet() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassword());

        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!",e);
        }
    }


    public void deleteUser(User user) {


        try {
            //This block of code sets the query for the mySQL database and deletes any ads associated to the user.
            String deleteAds = "delete from ads where user_id = ?";

            //Makes the connection to the database
            PreparedStatement statemt = connection.prepareStatement(deleteAds,Statement.RETURN_GENERATED_KEYS);
            statemt.setLong(1,user.getId());
            statemt.executeUpdate();

            //Sets the query for teh mySQL database and deletes the user that is logged in.
            String insertQuery = "delete from users where id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1,user.getId());

            stmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.",e);
        }


    }
}
