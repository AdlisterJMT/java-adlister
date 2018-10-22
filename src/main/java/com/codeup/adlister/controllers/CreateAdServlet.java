package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Validation;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );

        boolean inputHasErrors = ad.getTitle().isEmpty()
                || ad.getDescription().isEmpty()
                || !Validation.adTitleLength(ad.getTitle())
                || !Validation.adDescriptionLength(ad.getDescription())
//                || password.isEmpty()
//                || (!password.equals(passwordConfirmation));
                ;
        if (inputHasErrors) {//check for the following

            if (!Validation.adTitleLength(ad.getTitle())) {

                //request.getSession().setAttribute("Error: Title length");
                //if the ad's title doesn't meet the length requirements send an error message to the user


            }

            if (!Validation.adDescriptionLength(ad.getDescription())) {

                //request.getSession().setAttribute("Error in the description");

                //if the ad's description doesn't meet length requirements send an error message to user
                //this is being stored in the session that can be accessed by the jsp
            }

            if (ad.getTitle().isEmpty()) {

                //request.getSession().setAttribute("Error: Title is empty");

                //if ad title is empty send an error message

            }

            if (ad.getDescription().isEmpty()) {

                //request.getSession().setAttribute("Error: Description is empty");

                //if ad description is empty send an error message
            }

            response.sendRedirect("/ads/create");
            return;
        } else {

            DaoFactory.getAdsDao().insert(ad);
            response.sendRedirect("/profile");
        }
    }
}