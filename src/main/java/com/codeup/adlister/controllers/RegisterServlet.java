package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Validation;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * Create string variables to hold username, email, password, and password confirmation then get each parameter
         *
         */

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");


        /**
         * In order to call methods from the Password and User classes in the RegisterServlet class
         * We have to create a new instance of the Password Class
         */
        Password pw = new Password();


        /**
         * ERROR MESSAGES RENDER ON REGISTER PAGE, HOWEVER THE FIRST ERROR MESSAGE REMAINS AND THE PAGE DOESN'T CREATE THE NEW USER IN THE DATABASE.
         * TO FIX WE HAD TO MAKE SURE THE pw.validate(password) DID NOT VALIDATE (!pw.validate(password)) BY PRINTING OUT EACH LINE OF THE BOOLEAN LOGIC.
         *
         */

        /**
         * Create a boolean variable that gets the Users and searches for the specific name in the database;
         * if the name exists in the db the the username is not empty(null) and this is an error; the userExists
         * The inputHasErrors if the username is empty, or the userExists, or the email or password is empty, or
         * the password is not (!) validated or the password and the password confirmation do not match
         *
         */
        boolean userExists = DaoFactory.getUsersDao().findByUsername(username) != null;


        //Identify if the input has the following
        boolean inputHasErrors =
                username.isEmpty()
            || userExists
            || email.isEmpty()
            || password.isEmpty()
            || !pw.validate(password)
            || (!password.equals(passwordConfirmation));


        //Doing this first could have saved me two hours debugging -REMINDER SOUT OFTEN
        /**        System.out.println(username.isEmpty());
                System.out.println(userExists);
                System.out.println(email.isEmpty());
                System.out.println(password.isEmpty());
                System.out.println(!pw.validate(password));
                System.out.println((!password.equals(passwordConfirmation));
        */


        if (inputHasErrors) {
            if(username.isEmpty() || userExists){
                System.out.println(userExists);
                request.setAttribute("usernameError", "This field is either empty or username already exists" );
            }
            if(email.isEmpty()){
                request.setAttribute("emailError", "This field is empty" );
            }
            if(password.isEmpty() || !pw.validate(password)){
                request.setAttribute("passwordError", "This field does not meet the requirements");
            }
            if(!password.equals(passwordConfirmation)) {
                request.setAttribute("passwordConfirmationError", "Your password does not match");
            }
                System.out.println("It still thinks we have a problem.");
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {

            // insert the new user

            /**
             * 1) Create new user object with the username, email, and password
             * 2) Get the UsersDao to insert the new user
             * 3) Set the user variable as the attribute for the new user object  ON THE SESSION that is registering
             * 4) Redirect user (via the ViewProfileServlet) to the user's profile page
             */

            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        }
    }
}
