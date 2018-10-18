package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String queryString = "SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(queryString);
            statement.setString(1, username);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            rs.next();
            return createUserFromResult(rs);
        }catch (SQLException e){
            throw new RuntimeException("Error, could not fnd username" + username + " .", e);
        } catch (RuntimeException e){
            throw new RuntimeException("Error, could not fnd username" + username + " .", e);
        }
    }

    @Override
    public Long insert(User user) {
        String queryString = "INSERT INTO users( username, email, password) VALUES (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        }catch (SQLException e){
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    private User createUserFromResult(ResultSet rs){
       User user = new User();
       try {
            user = new User(rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
        } catch (SQLException e){
           throw new RuntimeException("Error creating new user.", e);
       }
        return user;
    }
}
