package com.codeup.adlister.dao;


import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Validation{

            //REGISTRATION VALIDATION

//Does the username exist upon registration? Yes/No;
    //if username exists in the database return true otherwise false
    /**
     * 1) Create a public static boolean method that returns a true/false
     * 2) The method takes a string variable as a parameter
     * 3) Access the Dao Factory's getUsersDao method and use the username through the findByUsername method
     *    and assign it to a user object
     * 4) if the user is not null then the username does exist, otherwise it doesn't
     *
     */

    public static boolean userExists(String username) {
        User user = DaoFactory.getUsersDao().findByUsername(username);
        System.out.println(user);
        if(user != null) {
            return true;
        }else return false;
    }

//Does the email exist upon registration? Yes/No;
    //if email exists in the database return true otherwise false

    /**
     * In order to use this method you have to create the findByEmail method in the Users Dao and place it in the User
     * interface also
     *
     * 1) Create a public static boolean method that returns a true/false
     * 2) The method takes a string variable as a parameter
     * 3) Access the Dao Factory's getUsersDao method and use the email through the findByEmail method
     *    and assign it to a user object
     * 4) if the user is not null then the user's email does exist, otherwise it doesn't
     *
     */
    public static boolean emailExists(String email){
        User user = DaoFactory.getUsersDao().findByEmail(email);
        System.out.println(user);
        if(user != null) {
            return true;
        } else return false;
    }

//Does the password have the minimum length of characters (8)? Yes/No

    public static boolean validPasswordLength(String password){
        if(password.length() >= 8) {
            return true;
        }else return false;
    }



    //AD CREATION VALIDATION









}
