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

        User user = new User(username, email, password);
        Password pw = new Password();


        /**
         * WORKING ON RENDERING THE FOLLOWING CODE TO THE REGISTER JSP
         * RIGHT NOW IT FUNCTIONS BUT DOES NOT SHOW THE ERROR, POSSIBLY BECAUSE IT REDIRECTS IMMEDIATELY
         */


        //Identify if the input has the following
        boolean inputHasErrors = username.isEmpty()
            || user.userExists(username)
            || email.isEmpty()
            || password.isEmpty()
            || pw.validate(password)
            || (!password.equals(passwordConfirmation));

        if (inputHasErrors) {
            if(username.isEmpty() || user.userExists(username)){
                System.out.println(user.getUsername());
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
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {

            // insert the new user
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/profile");
        }
    }
}
