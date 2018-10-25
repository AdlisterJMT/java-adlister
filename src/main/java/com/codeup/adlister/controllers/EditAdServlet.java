package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.Config;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(name = "EditAdServlet", urlPatterns = "/editAd")
public class EditAdServlet extends HttpServlet {
    //add doGet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long adId = Long.parseLong(request.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().findOne(adId);

        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/editAd.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Ad ad = ( Ad ) DaoFactory.getAdsDao().findOne(Long.parseLong(request.getParameter("id")));
        ad.setTitle(request.getParameter("title"));
        ad.setDescription(request.getParameter("description"));
        DaoFactory.getAdsDao().editAd(ad);



        response.sendRedirect("/profile");
    }
}
