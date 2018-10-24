package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProfileServlet {

    /*
    Steps needed. ask fellow for help. need figure out how to connect users_id to the button (Delete Profile) and
    use this servlet to delete the profile in questions.


    Test commit ignore this
     */

//    Connection is Java.SQL
    private Connection connection = null;

//    Config is dao.Config
    public DeleteProfileServlet (Config config){

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

            String query = "delete from users where id = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            //need to figure out how to get to the button


            preparedStmt.execute();


            //closes the connection
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

}
