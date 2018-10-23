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
        request.setAttribute("loginError", request.getSession().getAttribute("loginError"));
        request.getSession().removeAttribute("loginError");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        System.out.println(user);
        String loginErrorMessage = "Username or Password do not match";


/*        Check the username to make sure it exists. If it does not, redirect to the login.jsp and display the error
          if it does, move forward and check the password
*/
        if (user == null) {
            request.getSession().setAttribute("loginError", loginErrorMessage);

            response.sendRedirect("/login");
            return;
        } else {

            /*
            Check to make sure the password matches what is in the database. If it does move on to the profile page

             */
            boolean validAttempt = Password.check(password, user.getPassword());
            if (!validAttempt) {
                request.getSession().setAttribute("loginError",loginErrorMessage);
                response.sendRedirect("/login");
                return;
            } else {
                request.getSession().setAttribute("user",user);
                response.sendRedirect("/profile");
            }
        }






//        request.setAttribute("LoginError", loginErrorMessage);
//
//
//        if (validAttempt) {

//        } else {
//
//            response.sendRedirect("/login");
//        }
    }
}

