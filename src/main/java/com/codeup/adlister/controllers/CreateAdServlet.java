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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
        );


//Create a boolean logic for users input errors when creating an ad

        /**
         * Check to see if all of these are true?
         * 1) is the ad title empty?
         * 2) is the ad description empty?
         * 3) is the length of the title not valid?
         * 4) is the length of the description not valid?
         *
         *  If the ad has errors check each of the following...
         *
         *  1) If the ad title length is not valid; send error message for title length.
         *  2) If the ad description is not valid; send error message for description length.
         *  3) if the ad title is empty; send error message for empty title.
         *  4) if the ad description is empty; send error message for description title.
         *
         *  If any apply redirect user to the /ads/create.
         *
         *  If none of these apply retrieve the Dao Factory and insert the ad
         */

        boolean inputHasErrors = ad.getTitle().isEmpty()
                || ad.getDescription().isEmpty()
                || !Validation.adTitleLength(ad.getTitle())
                || !Validation.adDescriptionLength(ad.getDescription())
//                || password.isEmpty()
//                || (!password.equals(passwordConfirmation));
                ;
        if (inputHasErrors) {//check for the following

            if (!Validation.adTitleLength(ad.getTitle())) {

                request.getSession().setAttribute("titleError","Title length must be 1-50 characters.");
                //if the ad's title doesn't meet the length requirements send an error message to the user
                //there is an error about to set attribute (String, object)


            }

            if (!Validation.adDescriptionLength(ad.getDescription())) {

                request.setAttribute("descriptionError","Description length must be 1-100 characters.");

                //if the ad's description doesn't meet length requirements send an error message to user
                //this is being stored in the session that can be accessed by the jsp
            }

            if (ad.getTitle().isEmpty()) {

                request.setAttribute("emptyTitleError", "Title is empty");

                //if ad title is empty send an error message

            }

            if (ad.getDescription().isEmpty()) {

                request.setAttribute( "emptyDescriptionError", "Description is empty");

                //if ad description is empty send an error message
            }

            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
        } else {

            DaoFactory.getAdsDao().insert(ad);
            response.sendRedirect("/profile");
        }
    }
}