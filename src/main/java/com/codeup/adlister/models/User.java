package com.codeup.adlister.models;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.util.Password;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;

    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        setPassword(password);
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }

/**
 * Created userExists/emailExists in the User object model because the method could not be used in the validation class.
 * Using the method on the register servlet did not reach the validation class even though it was imported.
 * The reason is because we are creating a user object. If we want to get information on the user that is registering we
 * get that from the object, not just creating rules that apply
 */


//--------------------------------------------- Registration Validation ---------------------------------------------\\

        //method cannot be static because of the "this" instance of the specific property.
    public boolean userExists(String username) {
        this.username = username;
        User user = DaoFactory.getUsersDao().findByUsername(username);
        System.out.println(user);
        if(username != null) {
            return true;
        }else return false;
    }



    public boolean emailExists(String email){
        this.email = email;
        User user = DaoFactory.getUsersDao().findByEmail(email);
        System.out.println(user);
        if(user != null) {
            return true;
        } else return false;
    }

}
