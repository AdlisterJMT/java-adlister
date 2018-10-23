package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    //TO EXPLAIN EXPRESSION LANGUAGE USAGE (LOGIN SERVLET TO PROFILE JSP)

        // 1) In the doPost we create string variables that get the parameter from the request

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2) we create a user object and use the DaoFactory's getUserDao method to find the username

        User user = DaoFactory.getUsersDao().findByUsername(username);

        // 3) If the user object doesn't have a username/password (null) then the
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        boolean validAttempt = Password.check(password, user.getPassword());

        //if the user is valid

        if (validAttempt) {

            //retrieve the session and set the user object as the a string variable "user"

            request.getSession().setAttribute("user", user);

            //and redirect the session to the profile page


            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
