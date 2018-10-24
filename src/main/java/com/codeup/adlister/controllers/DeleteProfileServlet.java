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
@WebServlet(name = "controllers.DeleteProfileServlet", urlPatterns = "/deleteProfile")
public class DeleteProfileServlet extends HttpServlet {


//    Creates a new instance of Config
    Config config = new Config();

    private  String ConfigUrl = config.getUrl();
    private String username = config.getUser();
    private String password = config.getPassword();




    private Connection connection = null;


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
            String deleteAds ="delete from ads where user_id = ?";
            PreparedStatement statemt = connection.prepareStatement(deleteAds, Statement.RETURN_GENERATED_KEYS);
            statemt.setLong(1, user.getId());
            statemt.executeUpdate();


            String insertQuery = "delete from users where id = ?";
                PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                stmt.setLong(1, user.getId());
//                stmt.setString(2, ad.getTitle());
//                stmt.setString(3, ad.getDescription());
                stmt.executeUpdate();


//                ResultSet rs = stmt.getGeneratedKeys();
//                rs.next();
//                return rs.getLong(1);
            } catch (SQLException e) {
                throw new RuntimeException("Error creating a new ad.", e);
            }





    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {

        User user = (User) request.getSession().getAttribute("user");





        deleteUser(user);

        request.getSession().invalidate();

        response.sendRedirect("/");


//    Connection is Java.SQL





    }
}
