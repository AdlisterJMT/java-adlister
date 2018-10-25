package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving single ads.", e);
        }
    }
    @Override
    public Ad findOne(long id) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM ads where id = ?");
            //bind the '?' parameters with a specific value by using their indexes:
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            rs.next(); //move to the first row of result set
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving one ad.", e);
        }
    }

    @Override
    public Ad editAd(Ad ad){

//      String query created to edit the ad in question
        try {
            String editQuery = "UPDATE ads SET title = ?, description = ? WHERE id = ?";

            PreparedStatement statemt = connection.prepareStatement(editQuery,Statement.RETURN_GENERATED_KEYS);
            statemt.setString(1, ad.getTitle());
            statemt.setString(2, ad.getDescription());
            statemt.setLong(3,ad.getId());

            statemt.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Error modifing the ad.",e);
        }
        return ad;
    }

    public List<Ad> some(String searchTerm) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?");
            stmt.setString(1, '%' + searchTerm + '%');
            stmt.setString(2, '%' + searchTerm + '%');
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving your requested ad.", e);
        }
    }

//    public List<Ad> some(String searchTerm){
//        return ad;
//    }

    public List<Ad> findAllAdsUserId(Long user_id) {
        try {
            String findAd = "select * from ads where user_id = ?";

            PreparedStatement stmt = connection.prepareStatement(findAd);
            stmt.setLong(1, user_id);

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding ads by this username", e);
        }
    }

//    Trying to move deleteAds to Doa, need to figure out how write return in the method. - Michael

//    public  deleteAds(Ad ad) {
//
//        try {
//            //This block of code sets the query for the mySQL database and deletes any ads associated to the user.
//            String deleteAds = "delete from ads where id = ?";
//
//            //Makes the connection to the database
//            PreparedStatement statemt = connection.prepareStatement(deleteAds,Statement.RETURN_GENERATED_KEYS);
//            statemt.setLong(1,ad.getId());
//            statemt.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException("Error deleting the ad.",e);
//        }
//
//    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

}
