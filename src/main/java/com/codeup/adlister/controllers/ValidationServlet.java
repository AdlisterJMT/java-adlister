package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Config;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "controllers.ValidationServlet", urlPatterns = "/ads/create")
public class ValidationServlet extends HttpServlet{

    //created a new instance of config class; possibly need to create a ValidationDAO class instead

    private static Config config = new Config();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

//This servlet will be used to validate ad information created by user to input into the music_adlister_db

/**
 * Config class allows access to mysql, possibly need to replace this section;
 * although it has some validation I think the more appropriate example would be the mysqlAdsDao class.
 * A validation class in this way would provide the ability to make methods that can be called on the validation servlet.
 */

//        PrintWriter out = response.getWriter();
//        String connectionURL = "jdbc:mysql://192.168.10.59/messagepaging";
//        Connection connection=null;
//        ResultSet rs;
//        String userName=new String("");
//        String passwrd=new String("");
//        response.setContentType("text/html");
//        try {
//            // Load the database driver
//            Class.forName("com.mysql.jdbc.Driver");
//            // Get a Connection to the database
//            connection = DriverManager.getConnection(connectionURL, "root", "root");
//            //Add the data into the database
//            String sql = "select user,password from User";
//            Statement s = connection.createStatement();
//            s.executeQuery (sql);
//            rs = s.getResultSet();
//            while (rs.next ()){
//                userName=rs.getString("user");
//                passwrd=rs.getString("password");
//            }
//            rs.close ();
//            s.close ();
//        }catch(Exception e){
//            System.out.println("Exception is ;"+e);
//        }
//        if(userName.equals(request.getParameter("user"))
//                && passwrd.equals(request.getParameter("pass"))){
//            out.println("User is Valid");
//        }
//        else{
//            out.println("You are not a Valid User");
//        }
    }
}  